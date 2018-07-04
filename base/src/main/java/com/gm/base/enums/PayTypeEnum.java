package com.gm.base.enums;

/**
 * 支付渠道
 * 
 * @author ying
 *
 */
public enum PayTypeEnum {
	alipay("支付宝手机支付", "alipay", 1), alipay_wap("支付宝手机网页支付", "alipay_wap", 2), alipay_pc_direct("支付宝 PC网页支付",
			"alipay_pc_direct",
			3), alipay_qr("支付宝扫码支付", "alipay_qr", 4), bfb("百度钱包移动快捷支付", "bfb", 5), bfb_wap("百度钱包手机网页支付", "bfb_wap",
					6), upacp("银联全渠道支付", "upacp", 7), upacp_wap("银联全渠道手机网页支付", "upacp_wap", 8), upacp_pc("银联 PC 网页支付",
							"upacp_pc", 9), cp_b2b("银联企业网银支付", "cp_b2b", 10), wx("微信支付", "wx", 11), wx_pub("微信公众账号支付",
									"wx_pub",
									12), wx_pub_qr("微信公众账号扫码支付", "wx_pub_qr", 13), yeepay_wap("易宝手机网页支付", "yeepay_wap",
											14), jdpay_wap("京东手机网页支付", "jdpay_wap", 15), cnp_u("应用内快捷支付（银联）", "cnp_u",
													16), cnp_f("应用内快捷支付（外卡）", "cnp_f", 17), applepay_upacp("Apple Pay",
															"applepay_upacp", 18), fqlpay_wap("分期乐支付", "fqlpay_wap",
																	19), qgbc_wap("量化派支付", "qgbc_wap",
																			20), inpay("余额支付", "inpay", 21);
	private String name;
	private String ename;
	private int index;

	private PayTypeEnum(String name, String ename, int index) {
		this.name = name;
		this.ename = ename;
		this.index = index;
	}

	public static PayTypeEnum getPayType(String payType) {

		for (PayTypeEnum c : PayTypeEnum.values()) {
			if (payType.equals(c.getEname())) {
				return c;
			}
		}
		return null;

	}

	public static String getName(String str) {
		for (PayTypeEnum c : PayTypeEnum.values()) {
			if (str.equals(c.getEname())) {
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}