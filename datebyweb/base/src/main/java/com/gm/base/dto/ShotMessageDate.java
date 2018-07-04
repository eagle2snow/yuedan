package com.gm.base.dto;

public class ShotMessageDate {

	// status</returnstatus> ---------- 返回状态值：成功返回Success 失败返回：Faild
	private String status;

	// <message>message</message> ---------- 返回信息：见下表
	private String message;

	// remainpoint</remainpoint> ---------- 返回余额
	private String remainpoint;

	// <taskID>taskID</taskID> ----------- 返回本次任务的序列ID
	private String taskID;

	// <successCounts>successCounts</successCounts> --成功短信数：当成功后返回提交成功短信数
	private String successCounts;

	public ShotMessageDate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRemainpoint() {
		return remainpoint;
	}

	public void setRemainpoint(String remainpoint) {
		this.remainpoint = remainpoint;
	}

	public String getTaskID() {
		return taskID;
	}

	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}

	public String getSuccessCounts() {
		return successCounts;
	}

	public void setSuccessCounts(String successCounts) {
		this.successCounts = successCounts;
	}

}
