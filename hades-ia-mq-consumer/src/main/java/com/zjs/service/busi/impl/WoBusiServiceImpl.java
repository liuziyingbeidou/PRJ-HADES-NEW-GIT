package com.zjs.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjs.dto.WoDto;
import com.zjs.mapper.busi.WoBusiMapper;
import com.zjs.service.busi.WoBusiService;

/**
  * 工作单相关方法封装
  * Company: ZJS 
  * @author Zhaoyafang
  * @date 2016年7月23日 下午3:04:16
 */
@Service
public class WoBusiServiceImpl implements WoBusiService{
	
	@Autowired
	private WoBusiMapper woBusiDao;
	
	/**
	 * 根据工作单号查询工作单信息
	 * 
	 * @param woCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public WoDto selectWo(String woCode) throws Exception {
		return woBusiDao.selectWo(woCode);
	}
		
}
