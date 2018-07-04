package com.hhs.base.consts;

import java.math.BigDecimal;

/**
 * 静态常量
 * 
 * @author ying
 *
 */
public class Const {
	public static final String CUR_USER = "curUser";// 当前登录后台用户
	public static final String CUR_WX_MEMBER = "curMember";// 当前登录微信的会员

	public static final String REDERECT_403 = "redirect:/error/403";// 重定向到403页面
	public static final String REDERECT_404 = "redirect:/error/404";// 重定向到404页面
	public static final String REDERECT_500 = "redirect:/error/500";// 重定向到500页面
	public static final String SEND_NEW_MSG_TO_KF = "/msg/sendToKf/";// 发送消息到客服
	public static final String SEND_NEW_MSG_TO_MEMBER = "/msg/sendToMember/";// 发送消息给会员

	// 以下为微信参数
	public static final String TOKEN = "451dsfDsadf11313sAaxGjhjk";
	public static final String APPID = "wxcf0651a0ff3ed734";
	public static final String SECRET = "98efddf97a7d50a90951b2f6d87ad3dd";
	public static final Long INIT_MEMBER_COUNT = 10000L;// 初始会员数量，设定后不能修改！！！

	// 以下为微信商户参数，支付用
	public static final String PASSWORD_SECRET = "qweoxm235DHG24!@#$xss";// 密钥
	public static final String MCHID = "1502723581"; // 商户id
	public static final String MCHKEY = "a74srx89fxadcgq0ertcAQEXqxdQs541";// 商户key
	// public static final String NOTIFY_URL =
	// "http://aijfc.iask.in/wx/pay/paySuccess";// 支付成功后回调
	// public static final String RETURN_URL = "http://aijfc.iask.in/wx/index";//
	// 支付完成后的同步返回地址

	public static final String NOTIFY_URL = "/wx/pay/paySuccess";// 支付成功后回调
	public static final String RETURN_URL = "/wx/index";// 支付完成后的同步返回地址

	// 一下为短信方向参数
	public static final String userId = "8131";// 企业id
	public static final String userName = "zhuyu";// 企业账号
	public static final String password = "wsB7sX83zy";// 企业密码
	public static final String action = "send";// 发送任务命令
	public static final String sMSApiUrl = "http://211.147.242.161:8888/v2sms.aspx";// 发送任务命令

	// 以下为系统需要的其他常量
	public static final String verificationCode2Session = "";// 验证码
	

	public static final BigDecimal MEMBER_AMOUNT = BigDecimal.valueOf(0.01);// 会员套餐价格，單位（元）
	public static final Integer directMember = 10;						   // 直推人数
	public static final Integer betweenMember = 100;					   // 直系人数
	public static final BigDecimal discount = BigDecimal.valueOf(0.8);	   // 折扣数
	public static final BigDecimal pushMoney = BigDecimal.valueOf(0.01);   // 提成
	public static final Integer returnOne= 10;							   // 十件商品返一件

}
