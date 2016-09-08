package com.zjs.mapper.task;

import java.util.List;

import com.zjs.dto.SignWorkerTask;

/**
 * Description:签收任务表
 * 
 * @version 1.0
 * @since 1.0
 * @author zhaoyafang
 * @time 2015-03-23 下午3:18:23
 */
public interface AcceptSignTaskMapper {

	/**
	 * 插入 派送费任务表数据 
	 * 
	 * @param signWorkerTask
	 * @return
	 * @throws Exception
	 */
	public int insertSignWorkerTaskDelr(SignWorkerTask signWorkerTask) throws Exception;
	/**
	 * 插入省到省中转费任务表数据
	 * @param signWorkerTask
	 * @return
	 * @throws Exception
	 */
	public int insertSignWorkerTaskProv(SignWorkerTask signWorkerTask) throws Exception;
	/**
	 * 插入新操作费任务表数据
	 * @param signWorkerTask
	 * @return
	 * @throws Exception
	 */
	public int insertSignWorkerTaskOper(SignWorkerTask signWorkerTask) throws Exception;
	/**
	 * 插入运输费任务表数据
	 * @param signWorkerTask
	 * @return
	 * @throws Exception
	 */
	public int insertSignWorkerTaskTrans(SignWorkerTask signWorkerTask) throws Exception;
	/**
	 * 查询派费任务表
	 * @param signWorkerTask
	 * @return
	 * @throws Exception
	 */
	public List<SignWorkerTask> selectSignWorkerTaskDelrCount(String refId) throws Exception;
	/**
	 * 查询省到省中转费任务表
	 * @param signWorkerTask
	 * @return
	 * @throws Exception
	 */
	public List<SignWorkerTask> selectSignWorkerTaskProvCount(String refId) throws Exception;
	/**
	 * 查询新操作费任务表
	 * @param signWorkerTask
	 * @return
	 * @throws Exception
	 */
	public List<SignWorkerTask> selectSignWorkerTaskOperCount(String refId) throws Exception;
	/**
	 * 查询运输费任务表
	 * @param signWorkerTask
	 * @return
	 * @throws Exception
	 */
	public List<SignWorkerTask> selectSignWorkerTaskTransCount(String refId) throws Exception;

}
