package com.gm.base.config;

import java.math.BigDecimal;

import com.gm.base.enums.PingPayModeEnum;

public class BaseConfig {

	public static String appName = "《好闺蜜》";

	/**
	 * 环境参数开始
	 */
	public static String danwei = "runi8";
	public static PingPayModeEnum pingpp_mode = PingPayModeEnum.LIVE;
	/**
	 * 环境参数结束
	 */

	/**
	 * 消息类接口配置 ----- 云之迅
	 */
	private static String smsAppId = "";
	private static String smsSid = "";
	private static String smsToken = "";
	private static String smsApiUrl = "";

	/**
	 * ping ++ 接口配置
	 */
	private static String ping_pp_apikey = "";
	private static String ping_pp_appId = "";

	// public static final String baseUrl = "http://jueyingwenhua.com:8080";
	public static final String baseUrl = "http://192.168.0.15:8080";
	// public static final String baseUrl = "http://runi8.com";

	/**
	 * 默认费率
	 */
	public static final BigDecimal feeRat = BigDecimal.valueOf(0.1);


	
	static {
		if ("lexingditie".equals(danwei)) {
			smsAppId = "85fc871c0b314ce38c8b355b7a2d782f";
			smsSid = "c020f3543361432d096d92721244c870";
			smsToken = "2ce93249e4ed2a6e2b8fe412fb422d48";
			smsApiUrl = "http://www.ucpaas.com/maap/sms/code";
			ping_pp_appId = "app_4GGWX5OGefXHSunj";
			
			
			if (pingpp_mode.equals(PingPayModeEnum.TEST)) {
				setPing_pp_apikey("sk_test_4effjTKm5ejLjzrXjPPKSOC8");
			} else if (pingpp_mode.equals(PingPayModeEnum.LIVE)) {
				setPing_pp_apikey("sk_live_OGKyH4Oq5qzPGanjTC4q9SOS");
			}
			
			
		}else if("runi8".equals(danwei)){
			smsAppId = "85fc871c0b314ce38c8b355b7a2d782f";
			smsSid = "c020f3543361432d096d92721244c870";
			smsToken = "2ce93249e4ed2a6e2b8fe412fb422d48";
			smsApiUrl = "http://www.ucpaas.com/maap/sms/code";
			ping_pp_appId = "app_WnfX1GSO4CSSWXz5";
			
			
			if (pingpp_mode.equals(PingPayModeEnum.TEST)) {
				setPing_pp_apikey("sk_test_8uz5i9K0KeHOz1GGyPOq14q9");
			} else if (pingpp_mode.equals(PingPayModeEnum.LIVE)) {
				setPing_pp_apikey("sk_live_H4WHeD0O8y90LO8W5Gef9O0O");
			}
			
		}



	}

	public static String getDanwei() {
		return danwei;
	}

	public static void setDanwei(String danwei) {
		BaseConfig.danwei = danwei;
	}

	public static String getSmsAppId() {
		return smsAppId;
	}

	public static void setSmsAppId(String smsAppId) {
		BaseConfig.smsAppId = smsAppId;
	}

	public static String getSmsSid() {
		return smsSid;
	}

	public static void setSmsSid(String smsSid) {
		BaseConfig.smsSid = smsSid;
	}

	public static String getSmsToken() {
		return smsToken;
	}

	public static void setSmsToken(String smsToken) {
		BaseConfig.smsToken = smsToken;
	}

	public static String getSmsApiUrl() {
		return smsApiUrl;
	}

	public static void setSmsApiUrl(String smsApiUrl) {
		BaseConfig.smsApiUrl = smsApiUrl;
	}

	public static String getPing_pp_apikey() {
		return ping_pp_apikey;
	}

	public static void setPing_pp_apikey(String ping_pp_apikey) {
		BaseConfig.ping_pp_apikey = ping_pp_apikey;
	}

	public static String getPing_pp_appId() {
		return ping_pp_appId;
	}

	public static void setPing_pp_appId(String ping_pp_appId) {
		BaseConfig.ping_pp_appId = ping_pp_appId;
	}

}
