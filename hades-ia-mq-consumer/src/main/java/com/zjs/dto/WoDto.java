package com.zjs.dto;

import java.math.BigDecimal;

/**
 * 工作单的DTO
 * 
 * @author MrDu
 *
 */
public class WoDto {

	private String vWocode; // 工作单号

	private String pkCorpSend; // 客户主键

	private BigDecimal iItemNum; // 件数

	private BigDecimal nActlWeit; // 实际重量

	private BigDecimal nFeeWeit; // 计费重量

	private Integer fBalnType; // 结算方式

	private Integer fWoType; // 工作单类型

	private String pkSettleCorp; // 结算单位

	private String bCod; // 是否COD

	public String getvWocode() {
		return vWocode;
	}

	public void setvWocode(String vWocode) {
		this.vWocode = vWocode;
	}

	public String getPkCorpSend() {
		return pkCorpSend;
	}

	public void setPkCorpSend(String pkCorpSend) {
		this.pkCorpSend = pkCorpSend;
	}

	public BigDecimal getiItemNum() {
		return iItemNum;
	}

	public void setiItemNum(BigDecimal iItemNum) {
		this.iItemNum = iItemNum;
	}

	public BigDecimal getnActlWeit() {
		return nActlWeit;
	}

	public void setnActlWeit(BigDecimal nActlWeit) {
		this.nActlWeit = nActlWeit;
	}

	public BigDecimal getnFeeWeit() {
		return nFeeWeit;
	}

	public void setnFeeWeit(BigDecimal nFeeWeit) {
		this.nFeeWeit = nFeeWeit;
	}

	public Integer getfBalnType() {
		return fBalnType;
	}

	public void setfBalnType(Integer fBalnType) {
		this.fBalnType = fBalnType;
	}

	public Integer getfWoType() {
		return fWoType;
	}

	public void setfWoType(Integer fWoType) {
		this.fWoType = fWoType;
	}

	public String getPkSettleCorp() {
		return pkSettleCorp;
	}

	public void setPkSettleCorp(String pkSettleCorp) {
		this.pkSettleCorp = pkSettleCorp;
	}

	public String getbCod() {
		return bCod;
	}

	public void setbCod(String bCod) {
		this.bCod = bCod;
	}
}
