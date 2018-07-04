package com.hhs.base.dto;

/**
 * @author eagle
 * @date 2018年5月7日
 * @description 用于封装短信接口需要的参数 有就设置没有就值为null
 */
public class ShotMessageParameter {

	// 企业ID
	private String userid;

	// 系统当前时间字符串，年月日时分秒，例如：20120701231212
	private String timestamp;

	// 使用 账号+密码+时间戳 生成MD5字符串作为签名。MD5生成32位，且需要小写
	private String sign;

	// 发信发送的目的号码.多个号码之间用半角逗号隔开
	private String mobile;

	// 短信的内容，内容需要UTF-8编码
	private String content;

	// 为空表示立即发送，定时发送格式2010-10-24 09:08:10
	private String sendTime;

	// 发送任务命令 设置为固定的:send
	private String action;

	// 扩展子号
	private String extno;

	public ShotMessageParameter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getExtno() {
		return extno;
	}

	public void setExtno(String extno) {
		this.extno = extno;
	}

}
