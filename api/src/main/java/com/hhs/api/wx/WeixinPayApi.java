package com.hhs.api.wx;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import com.hhs.api.pay.config.WxPayH5Config;
import com.hhs.api.pay.emums.BestPayTypeEnum;
import com.hhs.api.pay.exception.BestPayException;
import com.hhs.api.pay.model.PayRequest;
import com.hhs.api.pay.model.PayResponse;
import com.hhs.api.pay.service.impl.BestPayServiceImpl;
import com.hhs.base.consts.Const;

public class WeixinPayApi {

	private static WxPayH5Config wxPayH5Config;

	private WeixinPayApi() {
	}

	/**
	 * 获取WxPayH5Config
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static WxPayH5Config getWxPayH5Config(String domain) {
		if (wxPayH5Config == null) {
			synchronized (WeixinPayApi.class) {
				if (wxPayH5Config == null) {
					wxPayH5Config = new WxPayH5Config();
					wxPayH5Config.setAppId(Const.APPID);
					wxPayH5Config.setAppSecret(Const.SECRET);
					wxPayH5Config.setMchId(Const.MCHID);
					wxPayH5Config.setMchKey(Const.MCHKEY);
					wxPayH5Config.setNotifyUrl(domain + Const.NOTIFY_URL);
					wxPayH5Config.setReturnUrl(domain + Const.RETURN_URL);
				}
			}
		}
		return wxPayH5Config;
	}

	/**
	 * <p>
	 * 描述:发起微信支付
	 * </p>
	 * 
	 * @author 灰灰
	 * @param orderNo
	 *            订单号
	 * @param orderName
	 *            订单名称
	 * @param amount
	 *            支付金额（元）
	 * @param openid
	 *            当前支付人的openid
	 * @date 2018年5月7日
	 * 
	 * @version 1.0
	 */
	public static PayResponse pay(String orderNo, String orderName, BigDecimal amount, String openid, String domain)
			throws BestPayException {
		PayRequest payRequest = new PayRequest();
		payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
		payRequest.setOrderId(orderNo);
		payRequest.setOrderName(orderName);
		payRequest.setOrderAmount(amount.doubleValue());
		payRequest.setOpenid(openid);
		PayResponse response = getBestPayServiceImpl(domain).pay(payRequest);
		return response;
	}

	public static BestPayServiceImpl getBestPayServiceImpl(String domain) {
		BestPayServiceImpl bestPayService = new BestPayServiceImpl();
		bestPayService.setWxPayH5Config(getWxPayH5Config(domain));
		return bestPayService;
	}

}
