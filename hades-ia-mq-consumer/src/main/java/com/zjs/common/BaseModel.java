package com.zjs.common;

import java.io.Serializable;
import java.util.Date;

import com.zjs.util.StringUtil;

public class BaseModel implements Serializable {
	private static final long serialVersionUID = -610797345091216847L;

	protected int startRownum; // 分页开始行号
	protected int endRownum; // 分页结束行号

	protected int fetchNum; // 每次查询数据量
	protected int queueNum; // 队列数

	protected Date createTime; // 创建时间
	protected Date updateTime; // 更新时间

	protected int yn; // 是否有效 0 无效 1 有效

	protected String condition; // 取模条件
	protected String saveYn; // 取模条件

	private String dbname;// 数据库用户

	public BaseModel() {
		dbname = StringUtil.getDBUserName();
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public int getStartRownum() {
		return startRownum;
	}

	public void setStartRownum(int startRownum) {
		this.startRownum = startRownum;
	}

	public int getEndRownum() {
		return endRownum;
	}

	public void setEndRownum(int endRownum) {
		this.endRownum = endRownum;
	}

	public int getFetchNum() {
		return fetchNum;
	}

	public void setFetchNum(int fetchNum) {
		this.fetchNum = fetchNum;
	}

	public int getQueueNum() {
		return queueNum;
	}

	public void setQueueNum(int queueNum) {
		this.queueNum = queueNum;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getYn() {
		return yn;
	}

	public void setYn(int yn) {
		this.yn = yn;
	}

	public String getSaveYn() {
		return saveYn;
	}

	public void setSaveYn(String saveYn) {
		this.saveYn = saveYn;
	}
}
