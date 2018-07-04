package com.gm.base.enums;

/**
 * 提现状态
 * 
 * @author pqr
 *
 */
public enum DrawStateEnum {

	PENDING("待处理", 1), SUC("提现成功", 2), FAIL("提现失败", 3),;

	private String value;
	private Integer index;

	private DrawStateEnum() {

	}

	private DrawStateEnum(String value, int index) {
		this.value = value;
		this.index = index;
	}

	public String getValue() {
		return value;
	}

	public int getIndex() {
		return index;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static DrawStateEnum getOrdersStateEnum(int index) {

		DrawStateEnum state = null;
		for (DrawStateEnum ordersStateEnum : DrawStateEnum.values()) {
			if (ordersStateEnum.getIndex() == index) {
				state = ordersStateEnum;
			}
		}
		return state;
	}

}
