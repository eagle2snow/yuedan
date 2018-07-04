package com.gm.base.enums;

/**
 * 订单状态
 * 
 * @author pqr
 *
 */
public enum OrdersStateEnum {
	/** 待付款 */
	pendingPayment("待付款", 0),
	/** 已付款 */
	payments("已付款", 1),
	/** 已完成 */
	complete("已完成", 2),
	/** 待收货 */
	waitingReceiving("待收货", 4),
	/** 退款中 */
	refunding("退款中", 5),
	/** 待核销 */
	pending("待核销", 6),
	/** 已取消 */
	canceled("已取消", 7),
	/** 取消中 */
	cancelling("取消中", 8),
	/** 未发货 */
	notShipped("未发货", 9),
	/** 已退款 */
	refund("已退款", 10),

	;

	private String value;
	private Integer index;

	private OrdersStateEnum() {

	}

	private OrdersStateEnum(String value, int index) {
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

	public static OrdersStateEnum getOrdersStateEnum(int index) {

		OrdersStateEnum state = null;
		for (OrdersStateEnum ordersStateEnum : OrdersStateEnum.values()) {
			if (ordersStateEnum.getIndex() == index) {
				state = ordersStateEnum;
			}
		}
		return state;
	}

}
