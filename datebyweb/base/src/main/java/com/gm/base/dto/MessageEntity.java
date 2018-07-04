package com.gm.base.dto;

/**
 * @auth eagle
 * @date 2018年4月25日
 * @desc 用于ajax返回数据的消息
 */
public class MessageEntity {

	private Integer status;
	private String msg;

	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public MessageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
