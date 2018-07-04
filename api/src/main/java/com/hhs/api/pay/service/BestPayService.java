package com.hhs.api.pay.service;

import javax.servlet.http.HttpServletRequest;

import com.hhs.api.pay.config.SignType;
import com.hhs.api.pay.exception.BestPayException;
import com.hhs.api.pay.model.PayRequest;
import com.hhs.api.pay.model.PayResponse;
import com.hhs.api.pay.model.RefundRequest;
import com.hhs.api.pay.model.RefundResponse;

import java.util.Map;

public interface BestPayService {

	/**
	 * 发起支付.
	 */
	PayResponse pay(PayRequest request) throws BestPayException;

	/**
	 * 验证支付结果. 包括同步和异步.
	 *
	 * @param toBeVerifiedParamMap 待验证的支付结果参数.
	 * @param signType             签名方式.
	 * @param sign                 签名.
	 * @return 验证结果.
	 */
	boolean verify(Map<String, String> toBeVerifiedParamMap, SignType signType, String sign);

	/**
	 * 同步回调
	 * @param request
	 * @return
	 */
	PayResponse syncNotify(HttpServletRequest request);

	/**
	 * 异步回调
	 * @param notifyData
	 * @return
	 */
	PayResponse asyncNotify(String notifyData);

	/**
	 * 退款
	 * @param request
	 * @return
	 */
	RefundResponse refund(RefundRequest request);

}
