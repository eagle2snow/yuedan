package com.gm.base.enums;
/**
 * 商家账户枚举
 * @author Administrator
 *
 */
public enum FinanceEnum {
	 
	MEMBER_PAY(1,"会员支付"),
	MIDOU(2,"蜜豆兑换"),
	Recharge(3,"账户充值"),
	TI_XIAN(4,"提现"),
	SERVICE_COST(5,"平台费用");
	
	// 成员变量
	private String name;
	private int index;	
	
	private FinanceEnum(int index,String name){
		this.name = name;
		this.index = index;
	}
	// 普通方法
	public static String getName(int index) {
		for (FinanceEnum c : FinanceEnum.values()) {
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
