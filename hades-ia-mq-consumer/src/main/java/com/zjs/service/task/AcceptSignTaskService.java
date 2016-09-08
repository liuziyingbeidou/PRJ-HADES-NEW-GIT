package com.zjs.service.task;

import com.zjs.dto.SignMqParam;

/**
  * 生成签收数据任务service
  * Company: ZJS 
  * @author Zhaoyafang
  * @date 2016年7月23日 下午2:43:53
 */
public interface AcceptSignTaskService {
	/**
	 * 向签收任务表插入数据
	 * 
	 * @param signMqParam
	 * @return
	 * @throws Exception
	 */
	public boolean insertSignWorkerTask(SignMqParam signMqParam) throws Exception;
}
