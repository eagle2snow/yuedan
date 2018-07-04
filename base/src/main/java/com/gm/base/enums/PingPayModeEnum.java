package com.gm.base.enums;

/**
 * ping ++ 支付模式
 * 
 * @author ying
 *
 */
public enum PingPayModeEnum {

	TEST("测试模式"), LIVE("生产模式");

	private String name;

	private PingPayModeEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}