package com.hhs.base.enums;

/***
 * 消息类型枚举
 * 
 * @author hw
 *
 */
public enum MsgTypeEnum {
	TEXT("文本", 1), IMG("图片", 2), VOICE("语音", 3), VIDEO("视频", 4), MIX("混合", 5);
	// 成员变量
	private String name;
	private int index;

	private MsgTypeEnum(String name, int index) {
		this.name = name;
		this.index = index;
	}

	// 普通方法
	public static String getName(int index) {
		for (MsgTypeEnum c : MsgTypeEnum.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}

	// get set 方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
