package com.zjs.service.task.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.zjs.constants.BosConstant;
import com.zjs.constants.TaskStateConstant;
import com.zjs.constants.TaskTypeConstant;
import com.zjs.dto.SignMqParam;
import com.zjs.dto.SignTaskParam;
import com.zjs.dto.SignWorkerTask;
import com.zjs.dto.WoDto;
import com.zjs.mapper.task.AcceptSignTaskMapper;
import com.zjs.service.busi.WoBusiService;
import com.zjs.service.task.AcceptSignTaskService;
import com.zjs.util.DateUtil;
import com.zjs.util.StringUtil;
/**
  * 生成签收数据任务service实现
  * 类描述：生成签收任务数据 正常签收、异常签收、返货签收调用本接口时，任务属性传入的参数为【1 - 新增】，在任务表中记录任务类型为【1 – 新增任务】，
  * 关联单号为工作单号 取消签收调用本接口时，任务属性传入的参数为【2- 删除】，在任务表中记录任务类型为【2 – 删除任务】， 关联单号为工作单号
  * Company: ZJS 
  * @author Zhaoyafang
  * @date 2016年7月23日 下午2:45:42
 */
@Service
public class AcceptSignTaskServiceImpl implements AcceptSignTaskService {
	
	@Autowired
	WoBusiService woBusiService;

	@Autowired
	AcceptSignTaskMapper acceptSignTaskMapper;
	
	Logger logger = LoggerFactory.getLogger(AcceptSignTaskServiceImpl.class);

	/**
	 * 生成签收任务
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, timeout = 5, rollbackFor = Exception.class)
	public boolean insertSignWorkerTask(SignMqParam signMqParam)
			throws Exception {
		
		SignTaskParam signTaskParam = setSignTaskParam(signMqParam);
		
		String woCode = signTaskParam.getWoCode();
		WoDto woDto = woBusiService.selectWo(woCode);
		if(null == woDto){
			logger.info("mq生成签收任务：工作单号【" + woCode + "不存在或已作废，无法生成签收任务……");
			return true;
		}
		
		String woType = woDto.getfWoType().toString();
		signTaskParam.setWoType(woType);
		String signWorkerParam = JSON.toJSONString(signTaskParam);
		
		try {
			// 派送费
			int taskType = TaskTypeConstant.TASK_SIGN_TASK_IA;
			boolean delrIsSuccess = insertSignWorkerTask(woCode, signWorkerParam, taskType);
			if(delrIsSuccess)
				logger.info("mq生成签收任务：工作单号【" + woCode + "】生成派送费任务成功！");
			
			// 省到省中转费
			int provTaskType = TaskTypeConstant.TASK_SIGN_TASK_IA_MIDTRANSFEE_PROV;
			boolean provIsSuccess = insertSignWorkerTask(woCode, signWorkerParam, provTaskType);
			if(provIsSuccess)
				logger.info("mq生成签收任务：工作单号【" + woCode + "】生成省到省中转费任务成功！");
			
			// 新操作费
			int operTaskType = TaskTypeConstant.TASK_SIGN_TASK_IA_OPERFEE_NEW;
			boolean newOperFeeIsSuccess = insertSignWorkerTask(woCode, signWorkerParam, operTaskType);
			if(newOperFeeIsSuccess)
				logger.info("mq生成签收任务：工作单号【" + woCode + "】生成新操作费任务成功！");
			
			// 运输费
			int transTaskType = TaskTypeConstant.TASK_SIGN_TASK_IA_TRANS;
			boolean transIsSuccess = insertSignWorkerTask(woCode, signWorkerParam, transTaskType);
			if(transIsSuccess)
				logger.info("mq生成签收任务：工作单号【" + woCode + "】生成运输费任务成功！");
		} catch (Exception e) {
			// oracle违反唯一约束异常处理
			if (StringUtil.isNotNull(e.getMessage()) && e.getMessage().contains("ORA-00001")) {
				return true;
			} else {
				logger.error("refid:" + woCode + "插入签收任务表异常", e);
				return false;
			}
		}
		
		return true;
	}
	/**
	 * 设置签收任务dto
	 * @param signMqParam
	 * @return
	 */
	private SignTaskParam setSignTaskParam(SignMqParam signMqParam){
		
		SignTaskParam signTaskParam = new SignTaskParam();
		
		signTaskParam.setWoCode(signMqParam.getWbCode());
		
		if(BosConstant.DR_NOMAL.toString().equals(signMqParam.getDr())){
			signTaskParam.setTaksProp(TaskTypeConstant.TASK_SIGN_TASKPROP_ADD);
		}else {
			signTaskParam.setTaksProp(TaskTypeConstant.TASK_SIGN_TASKPROP_DEL);
		}
		
		signTaskParam.setSignTime(signMqParam.getTsigntime());
		signTaskParam.setSignType(StringUtil.isBlank(signMqParam.getFsigntype()) ? "" : signMqParam.getFsigntype());
		
		return signTaskParam;
	}
	/**
     * 插入签收任务表数据
     *
     * @param woCode          :工作单号
     * @param signWorkerParam :签收任务参数
     * @return
     * @throws Exception
     */
    private boolean insertSignWorkerTask(String woCode, String signWorkerParam, int taskType) throws Exception {

        String hostIp = StringUtil.getLocalIP();
        String uuid = StringUtil.getUUID();
        SignTaskParam param = JSON.parseObject(signWorkerParam, SignTaskParam.class);
        SignWorkerTask task = new SignWorkerTask();
        Date exeTime = DateUtil.fromatDates(new Date());
        task.setRefId(woCode);
        task.setTaskType(taskType);
        task.setTaskData(signWorkerParam);
        task.setStatus(TaskStateConstant.TASK_WIATIMG);
        task.setTaskExeCount(0);
        task.setExeInstanceIp(hostIp + "$" + uuid);
        task.setCreateTime(DateUtil.getString2Date(param.getSignTime()));
        task.setExeTime(exeTime);
        Integer count = this.exeInsertSignWorkerTask(task);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * @param task 插入数据参数
     * @return
     * @throws Exception
     */
    private int exeInsertSignWorkerTask(SignWorkerTask task) throws Exception{
        Integer taskType = task.getTaskType();
        int result = 0;
        
        //内部核算
        if (taskType == TaskTypeConstant.TASK_SIGN_TASK_IA) {
        	// 防重处理，如果任务表中已经有相同的数据就不插入
        	int delrCount = verifyRepeatData(task);
        	if(0 >= delrCount){
                result = acceptSignTaskMapper.insertSignWorkerTaskDelr(task);
        	}else {
				result = 1;
			}
            //省到省中转费
        }  else if (taskType == TaskTypeConstant.TASK_SIGN_TASK_IA_MIDTRANSFEE_PROV) {
        	// 防重处理，如果任务表中已经有相同的数据就不插入
        	int provCount = verifyRepeatData(task);
        	if(0 >= provCount){
                result = acceptSignTaskMapper.insertSignWorkerTaskProv(task);
        	}else {
				result = 1;
			}
            //新操作费
        } else if (taskType == TaskTypeConstant.TASK_SIGN_TASK_IA_OPERFEE_NEW){
        	// 防重处理，如果任务表中已经有相同的数据就不插入
        	int operCount = verifyRepeatData(task);
        	if(0 >= operCount){
                result = acceptSignTaskMapper.insertSignWorkerTaskOper(task);
        	}else {
				result = 1;
			}
            // 运输费
        } else {
        	// 防重处理，如果任务表中已经有相同的数据就不插入
        	int transCount = verifyRepeatData(task);
        	if(0 >= transCount){
                result = acceptSignTaskMapper.insertSignWorkerTaskTrans(task);
        	}else {
				result = 1;
			}            	
        }
     
    return result;
    }
    /**
     * 验证重复数据
     * @return
     * @throws Exception
     */
    private int verifyRepeatData(SignWorkerTask task) throws Exception{
    	int result = 0;
    	String refId = task.getRefId();
    	Integer taskType = task.getTaskType();
    	// 接收的mq数据
    	SignTaskParam mqSignTaskParam = JSON.parseObject(task.getTaskData(), SignTaskParam.class);
    	String mqSignTime = mqSignTaskParam.getSignTime();
    	String mqTaksProp = mqSignTaskParam.getTaksProp();
    	
    	List<SignWorkerTask> signWorkerTasks = selectWorkerTaskData(refId, taskType);
    	
    	if(null == signWorkerTasks || 0 >= signWorkerTasks.size()){
    		return result;
    	}
    	
    	for (SignWorkerTask signTask : signWorkerTasks) {
    		// 任务表数据
        	SignTaskParam workerSignTaskParam = JSON.parseObject(signTask.getTaskData(), SignTaskParam.class);
        	String workerSignTime = workerSignTaskParam.getSignTime();
        	String workerTaksProp = workerSignTaskParam.getTaksProp();
        	String workerWoCode = workerSignTaskParam.getWoCode();
    		
			if(workerWoCode.equals(refId) && workerSignTime.equals(mqSignTime) 
					&& workerTaksProp.equals(mqTaksProp)){
				
				result ++;
			}
		}
    	return result;
    }
    /**
     * 根据refId查询任务表信息
     * @param refId
     * @param taskType
     * @return
     * @throws Exception
     */
    private List<SignWorkerTask> selectWorkerTaskData(String refId,Integer taskType) throws Exception{
    	
    	List<SignWorkerTask> signWorkerTasks = new ArrayList<SignWorkerTask>();
    	
    	switch (taskType) {
		case TaskTypeConstant.TASK_SIGN_TASK_IA:
			signWorkerTasks = acceptSignTaskMapper.selectSignWorkerTaskDelrCount(refId);
			break;
		case TaskTypeConstant.TASK_SIGN_TASK_IA_MIDTRANSFEE_PROV:
			signWorkerTasks = acceptSignTaskMapper.selectSignWorkerTaskProvCount(refId);
			break;
        case TaskTypeConstant.TASK_SIGN_TASK_IA_OPERFEE_NEW:
			signWorkerTasks = acceptSignTaskMapper.selectSignWorkerTaskOperCount(refId);
			break;
        case TaskTypeConstant.TASK_SIGN_TASK_IA_TRANS:
			signWorkerTasks = acceptSignTaskMapper.selectSignWorkerTaskTransCount(refId);
			break;
		default:
			break;
		}
    	
    	return signWorkerTasks;
    }
}
