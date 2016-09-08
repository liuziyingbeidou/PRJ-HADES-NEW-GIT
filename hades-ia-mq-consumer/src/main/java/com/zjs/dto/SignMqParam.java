package com.zjs.dto;
/**
  * mq接收过来的签收信息 
  * Company: ZJS 
  * @author Zhaoyafang
  * @date 2016年7月23日 下午2:23:29
 */
public class SignMqParam {
	/**
	 * 主键
	 */
	private String pkSign;
	/**
	 * 工作单号
	 */
	private String wbCode;
	/**
	 * 签收类型
	 */
	private String fsigntype;
	/**
	 * 签收方式
	 */
	private String fsignclass;
	/**
	 * 派送员工
	 */
	private String deliverier;
	/**
	 * 派件单位
	 */
	private String pkCorpdelr;
	/**
	 * 签收人
	 */
	private String signer;
	/**
	 * 签收时间
	 */
	private String tsigntime;
	/**
	 * 修改人
	 */
	private String modifier;
	/**
	 * 修改时间
	 */
	private String modifiedtime;
	/**
	 * 客户编码
	 */
	private String custCode;
	/**
	 * 推送时间
	 */
	private String bts;
	/**
	 * dr   dr=0 签收；dr=1 取消签收 ；dr=1时，mq只推送工作单号、签收时间、bts、dr
	 */
	private String dr;
	
	
	public String getPkSign() {
		return pkSign;
	}
	public void setPkSign(String pkSign) {
		this.pkSign = pkSign;
	}
	public String getWbCode() {
		return wbCode;
	}
	public void setWbCode(String wbCode) {
		this.wbCode = wbCode;
	}
	public String getFsigntype() {
		return fsigntype;
	}
	public void setFsigntype(String fsigntype) {
		this.fsigntype = fsigntype;
	}
	public String getFsignclass() {
		return fsignclass;
	}
	public void setFsignclass(String fsignclass) {
		this.fsignclass = fsignclass;
	}
	public String getDeliverier() {
		return deliverier;
	}
	public void setDeliverier(String deliverier) {
		this.deliverier = deliverier;
	}
	public String getPkCorpdelr() {
		return pkCorpdelr;
	}
	public void setPkCorpdelr(String pkCorpdelr) {
		this.pkCorpdelr = pkCorpdelr;
	}
	public String getSigner() {
		return signer;
	}
	public void setSigner(String signer) {
		this.signer = signer;
	}
	public String getTsigntime() {
		return tsigntime;
	}
	public void setTsigntime(String tsigntime) {
		this.tsigntime = tsigntime;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getModifiedtime() {
		return modifiedtime;
	}
	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getDr() {
		return dr;
	}
	public void setDr(String dr) {
		this.dr = dr;
	}
	public String getBts() {
		return bts;
	}
	public void setBts(String bts) {
		this.bts = bts;
	}
	
}
