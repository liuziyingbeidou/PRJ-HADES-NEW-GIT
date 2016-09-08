package com.zjs.dto;

import com.zjs.common.BaseModel;
import java.util.Date;

public class SignWorkerTask extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 419074421730404541L;

	private long id; // 任务编号

	private String refId; // 关联id

	private Integer taskType; // 任务类型

	private String taskData; // 操作数据

	private int taskExeCount; // 执行数

	private String exeInstanceIp; // 执行实例服务器IP

	private int status; // 执行状态

	private Date exeTime; // 任务计划执行时间

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public String getTaskData() {
		return taskData;
	}

	public void setTaskData(String taskData) {
		this.taskData = taskData;
	}

	public int getTaskExeCount() {
		return taskExeCount;
	}

	public void setTaskExeCount(int taskExeCount) {
		this.taskExeCount = taskExeCount;
	}

	public String getExeInstanceIp() {
		return exeInstanceIp;
	}

	public void setExeInstanceIp(String exeInstanceIp) {
		this.exeInstanceIp = exeInstanceIp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getExeTime() {
		return exeTime;
	}

	public void setExeTime(Date exeTime) {
		this.exeTime = exeTime;
	}

	@Override
	public String toString() {
		return "SignWorkerTask [id=" + id + ", refId=" + refId + ", taskType="
				+ taskType + ", taskData=" + taskData + ", taskExeCount="
				+ taskExeCount + ", exeInstanceIp=" + exeInstanceIp
				+ ", status=" + status + ", exeTime=" + exeTime + "]";
	}
		
	
}