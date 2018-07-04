package com.gm.base.enums;

/**
 * 商家用户类型
 * 
 * @author ying
 *
 */
public enum BillStateEnum {
	/**
	 * 未审核（订单，提现）
	 */
	NotAudit,
	/**
	 * 已审核，未入账（订单）
	 */
	HadAudit,
	/**
	 * 已入账（订单）
	 */
	HadInCome,

}
