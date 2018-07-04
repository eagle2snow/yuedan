package com.hhs.api.sms;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.hhs.base.config.BaseConfig;
import com.hhs.base.enums.SmsEnum;
import com.hhs.utils.DateUtil;
import com.hhs.utils.HttpRequestUtil;
import com.hhs.utils.Md5Util;
import com.hhs.utils.StringUtil;

@Component
public class SendSms {
	/**
	 * 发送验证码
	 * 
	 * @param type
	 *            短信类型
	 * @param mobile
	 *            接收手机
	 * @param vcode
	 *            验证码
	 * @param minute
	 *            有效时间
	 * @return
	 */
	public Map<String, Object> sendValidMsg(SmsEnum type, String mobile, String vcode, int minute) {
		return sendSms(type, mobile, vcode + "," + minute);
	}

	/**
	 * 发送商户号
	 * 
	 * @param mobile
	 * @param bussinessCode
	 */
	public void sendBusinessCode(String mobile, String bussinessCode) {
		sendSms(SmsEnum.SNED_BUSINESS_CODE, mobile, bussinessCode);
	}

	/**
	 * 会员注册验证码
	 * 
	 * @param mobile
	 * @param bussinessCode
	 */
	public Map<String, Object> sendMemberRegCode(String mobile, String code) {
		return sendSms(SmsEnum.MEMBER_REG, mobile, code + ",10");
	}

	/**
	 * 会员修改密码验证码
	 * 
	 * @param mobile
	 * @param bussinessCode
	 */
	public Map<String, Object> sendMemberUpdatePassword(String mobile, String code) {
		return sendSms(SmsEnum.MEMBER_RESET_PASS, mobile, code + ",10");
	}

	/**
	 * 商家修改手机号验证码
	 * 
	 * @param mobile
	 * @param code
	 * @return
	 */
	public Map<String, Object> sendStoreUpdateMobile(String mobile, String code) {
		return sendSms(SmsEnum.STORE_USER_UPDATE_MOBILE, mobile, code + ",10");
	}





	/**
	 * 统一发送入口
	 * 
	 * @param type
	 * @param mobile
	 * @param param
	 * @return
	 */
	public Map<String, Object> sendSms(SmsEnum type, String mobile, String param) {
		Map<String, Object> map = new HashMap<>();
		boolean ismobile = StringUtil.isMobile(mobile);
		if (ismobile) {
			String appid = BaseConfig.getSmsAppId();
			String sid = BaseConfig.getSmsSid();
			String appUrl = BaseConfig.getSmsApiUrl();
			String token = BaseConfig.getSmsToken();
			String time = DateUtil.dateToStr(new Date(), "yyyyMMddHHmmssSSS");
			String sign = Md5Util.getMD5(sid + time + token);
			String data = "sid=" + sid + "&appId=" + appid + "&time=" + time + "&sign=" + sign + "&to=" + mobile
					+ "&templateId=" + type.getTemplateId() + "&param=" + param;
			String string = HttpRequestUtil.sendPost(appUrl, data);
			System.out.println(string);
			string = string.substring(21, 27);
			if ("000000".equals(string)) {
				map.put("state", 1);
				map.put("msg", "消息发送成功！");
			} else {
				map.put("state", 2);
				map.put("msg", "消息发送失败！");
			}
		} else {
			map.put("state", 3);
			map.put("msg", "联系方式不是手机号！");
		}
		return map;
	}


}
