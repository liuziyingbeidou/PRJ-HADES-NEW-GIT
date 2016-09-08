package com.zjs.mapper.busi;

import com.zjs.dto.WoDto;

/**
  * 工作单相关方法封装Mapper
  * Company: ZJS 
  * @author Zhaoyafang
  * @date 2016年7月23日 下午3:01:54
 */
public interface WoBusiMapper {
	/**
	 * 根据工作单号查询工作单信息
	 * @param woCode
	 * @return
	 * @throws Exception
	 */
	public WoDto selectWo(String woCode) throws Exception;
	
	
}
