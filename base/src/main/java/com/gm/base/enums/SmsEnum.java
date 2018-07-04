package com.gm.base.enums;

/**
 * 验证码枚举
 * 
 * @author ying
 *
 */
public enum SmsEnum {
	/**
	 * 会员注册
	 */
	MEMBER_REG(1, "会员注册", 68288),
	/**
	 * 会员登录
	 */
	MEMBER_LOGIN(2, "会员登录", 0),

	/**
	 * 会员取回密码
	 */
	MEMBER_GET_PASS(3, "会员取回密码", 0),
	/**
	 * 会员重置密码
	 */
	MEMBER_RESET_PASS(4, "会员重置密码", 72673),

	/**
	 * 商家注册获取验证码
	 */
	STORE_USER_REG_VCODE(11, "商家注册验证码", 65949),

	/**
	 * 发送商户号
	 */
	SNED_BUSINESS_CODE(11, "发送商户号", 66163),

	/**
	 * 商家通过手机取回密码发送验证码
	 */
	STORE_USER_GET_PASS_VCODE(11, "商家通过手机取回密码的验证码", 65949),

	/**
	 * 门店审核通过
	 */
	STORE_AUDIT_OK(11, "门店审核通过", 68271),
	/**
	 * 门店审核不通过
	 */
	STORE_AUDIT_NO(11, "门店审核不通过", 68274),
	/**
	 * 拒绝门店入驻
	 */
	STORE_AUDIT_REFUSE(11, "拒绝门店入驻", 68275),
	/**
	 * 商户登录
	 */
	STORE_USER_LOGIN(11, "商家登录", 0),
	/**
	 * 商家取回密码
	 */
	STORE_USER_GET_PASS(12, "商家取回密码", 0),
	/**
	 * 商家重置密码
	 */
	STORE_USER_RESET_PASS(13, "商家重置密码", 0),

	/**
	 * 商家修改手机号,旧手机号验证码
	 */
	STORE_USER_UPDATE_MOBILE(14, "商家修改手机号,旧手机号验证码", 75375),
	/**
	 * 商家修改手机号,新手机号验证码
	 */
	STORE_USER_UPDATE_MOBILE2(15, "商家修改手机号,新手机号验证码", 75376),
	/**
	 * 商家接受预约
	 */
	ACCEPT_APPPROITMENT(19, "接受预约", 94139),

	/**
	 * 商家修改预约时间
	 */
	UPDATE_APPPROITMENT(20, "修改预约", 94171),
	/**
	 * 商家修改预约时间，没有旧时间
	 */
	UPDATE_APPPROITMENT_NO_OLDTIME(22, "修改预约（无旧时间）", 106307),
	/**
	 * 商家入驻预留手机号
	 */
	STORE_ADD_MOBILE(21, "入驻预留手机号", 97494),

	/**
	 * 商家提现申请，发给后台管理员
	 */
	STORE_DRAW_NOTIC_TO_ADMIN(23, "商家提现申请，发给后台管理员", 107063),

	/**
	 * 商家提现成功，发给商家
	 */
	STORE_DRAW_SUC_TO_STORE(24, "商家提现成功，发给商家", 107421),

	/**
	 * 商家提现失败，发给商家
	 */
	STORE_DRAW_FAIL_TO_STORE(24, "商家提现失败，发给商家", 107413),

	/**
	 * 门店注册
	 */
	STORE_REG(21, "门店注册", 0);

	private int code;
	private String name;
	private Integer templateId;// 短信模板

	private SmsEnum(int code, String name, Integer templateId) {
		this.code = code;
		this.name = name;
		this.templateId = templateId;
	}

	// 普通方法
	public static String getName(int code) {
		for (SmsEnum c : SmsEnum.values()) {
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

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

}