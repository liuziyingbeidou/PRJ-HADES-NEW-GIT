package com.zjs.dto;

/**
 * 生成签收数据任务表bean
 * 
 * @author ZhaoYaFang
 * 
 */
public class SignTaskParam {

	private String woCode;

	private String taksProp;

	private String signTime;

	private String woType;

	private String signType;

	public String getTaksProp() {
		return taksProp;
	}

	public void setTaksProp(String taksProp) {
		this.taksProp = taksProp;
	}

	public String getWoType() {
		return woType;
	}

	public void setWoType(String woType) {
		this.woType = woType;
	}

	public String getWoCode() {
		return woCode;
	}

	public void setWoCode(String woCode) {
		this.woCode = woCode;
	}

	public String getSignTime() {
		return signTime;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

}
