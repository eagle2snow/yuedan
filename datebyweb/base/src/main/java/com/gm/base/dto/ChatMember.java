package com.gm.base.dto;

import com.gm.base.model.Member;

/**
 * 聊天会员列表
 * 
 * @author hw
 *
 */
public class ChatMember {
	private Integer id;
	private String nickname;
	private String iocUrl;
	private Integer noReadMsgCount;

	public ChatMember() {

	}

	public ChatMember(Member member, Integer noReadMsgCount) {
		super();
		this.id = member.getId();
		this.nickname = member.getNickname();
		this.iocUrl = member.getIocUrl();
		this.noReadMsgCount = noReadMsgCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getIocUrl() {
		return iocUrl;
	}

	public void setIocUrl(String iocUrl) {
		this.iocUrl = iocUrl;
	}

	public Integer getNoReadMsgCount() {
		return noReadMsgCount;
	}

	public void setNoReadMsgCount(Integer noReadMsgCount) {
		this.noReadMsgCount = noReadMsgCount;
	}

}
