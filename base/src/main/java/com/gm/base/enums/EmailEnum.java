package com.gm.base.enums;

/**
 * 验证码枚举
 * 
 * @author ying
 *
 */
public enum EmailEnum {
	/**
	 * 商家邮箱注册
	 */
	STORE_USER_EMAIL_REG(1, "商家邮箱注册"),
	/**
	 * 商家邮箱修改
	 */
	
	STORE_USER_EMAIL_UPDATE(2, "商家邮箱修改"),
    
	/**
	 * 商家邮箱修改，第一步邮箱修改用
	 */
	STORE_USER_EMAIL_UPDATE2(4,"商家邮箱修改2"),
	
	/**
	 * 商家邮箱激活
	 */
	STORE_USER_EMAIL_ACTIVATE(3, "商家邮箱激活");
	
	
	

	private int code;
	private String name;

	private EmailEnum(int code, String name) {
		this.code = code;
		this.name = name;
		
	}

	// 普通方法
	public static String getName(int code) {
		for (EmailEnum c : EmailEnum.values()) {
			if (c.getCode() == code) {
				return c.name;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}



}