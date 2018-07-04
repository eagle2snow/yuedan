package com.gm.base.enums;

/**
 * 订单审核类型
 * 
 * @author ying
 *
 */
public enum AuditStateEnum {
	/**
	 * 未审核
	 */
	NotAudit,
	/**
	 * 已审核，未入账
	 */
	HadAudit,
	/**
	 * 已入账
	 */
	HadInCome,;

}
