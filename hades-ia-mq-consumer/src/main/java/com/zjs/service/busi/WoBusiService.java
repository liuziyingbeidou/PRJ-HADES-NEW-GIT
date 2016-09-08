package com.zjs.service.busi;

import com.zjs.dto.WoDto;

/**
  * 工作单相关方法的封装
  * Company: ZJS 
  * @author Zhaoyafang
  * @date 2016年7月23日 下午2:57:08
 */
public interface WoBusiService {
	/**
	 * 根据工作单号查询工作单信息
	 * 
	 * @param woCode
	 * @return	
	 * @throws Exception
	 */
	public WoDto selectWo(String woCode) throws Exception;
		
			
}
