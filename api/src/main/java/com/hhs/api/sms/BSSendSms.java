package com.hhs.api.sms;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.hhs.base.config.BSBaseConfig;
import com.hhs.utils.DateUtil;
import com.hhs.utils.HttpRequestUtil;
import com.hhs.utils.Md5Util;
import com.hhs.utils.StringUtil;

@Component
public class BSSendSms {

	private static final Logger logger = LoggerFactory.getLogger(BSSendSms.class);

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
	public Map<String, Object> sendValidMsg(String mobile, String vcode, int minute) {
		return sendSms(mobile, vcode + "," + minute);
	}

	/**
	 * 统一发送入口
	 * 
	 * @param type
	 * @param mobile
	 * @param param
	 * @return
	 */
	public Map<String, Object> sendSms(String mobile, String param) {

		Map<String, Object> map = new HashMap<>();

		boolean ismobile = StringUtil.isMobile(mobile);

		if (ismobile) {

			String userid = BSBaseConfig.getUserid();
			String username = BSBaseConfig.getUsername();
			String password = BSBaseConfig.getPassword();
			String sMSApiUrl = BSBaseConfig.getsMSApiUrl();

			String timestamp = DateUtil.dateToStr(new Date(), "yyyyMMddHHmmss");

			String dateTime = DateUtil.dateToStr(new Date(), "yyyy年MM月dd日HH:mm分");

			String sign = Md5Util.getMD5(username + password + timestamp);
			String content = "【竹语商城】 验证码:" + param + "，您于" + dateTime + "进行修改个人信息,注意保密哦!";
			String sendTime = "";
			String action = "send";
			String extno = "";

			String data = "userid=" + userid + "&timestamp=" + timestamp + "&sign=" + sign + "&mobile=" + mobile
					+ "&content=" + content + "&sendTime=" + sendTime + "&action=" + action + "&extno=" + extno;

			String string = HttpRequestUtil.sendPost(sMSApiUrl, data);
			logger.info("sendSms:The String is {}", string);

			if (string.contains("<message>ok</message>")) {
				map.put("status", 1);
				map.put("msg", "消息发送成功！");

			} else {
				map.put("status", 2);
				map.put("msg", "消息发送失败！");

			}

		} else {
			map.put("state", 4);
			map.put("msg", "联系方式不是手机号！");
		}

		logger.info("sendSms:The Map to json is {}", JSON.toJSON(map));
		return map;
	}

	public static void main(String[] args) {
	}

}
