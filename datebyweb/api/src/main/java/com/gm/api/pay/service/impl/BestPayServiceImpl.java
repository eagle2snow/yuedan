package com.gm.api.pay.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.gm.api.pay.config.SignType;
import com.gm.api.pay.config.WxPayH5Config;
import com.gm.api.pay.emums.BestPayResultEnum;
import com.gm.api.pay.emums.BestPayTypeEnum;
import com.gm.api.pay.exception.BestPayException;
import com.gm.api.pay.model.PayRequest;
import com.gm.api.pay.model.PayResponse;
import com.gm.api.pay.model.RefundRequest;
import com.gm.api.pay.model.RefundResponse;
import com.gm.api.pay.service.BestPayService;

import java.util.Map;

public class BestPayServiceImpl extends AbstractComponent implements BestPayService {

	private WxPayH5Config wxPayH5Config;

	public void setWxPayH5Config(WxPayH5Config wxPayH5Config) {
		this.wxPayH5Config = wxPayH5Config;
	}

	@Override
	public PayResponse pay(PayRequest request) throws BestPayException{
		// 微信h5支付
		WxPayServiceImpl wxPayService = new WxPayServiceImpl();
		wxPayService.setWxPayH5Config(this.wxPayH5Config);
		PayResponse payResponse = wxPayService.pay(request);
		return payResponse;
	}

	/**
	 * 同步返回
	 *
	 * @param request
	 * @return
	 */
	public PayResponse syncNotify(HttpServletRequest request) {
		return null;
	}

	@Override
	public boolean verify(Map<String, String> toBeVerifiedParamMap, SignType signType, String sign) {
		return false;
	}

	/**
	 * 异步回调
	 *
	 * @return
	 */
	public PayResponse asyncNotify(String notifyData) {

		// 微信h5支付
		WxPayServiceImpl wxPayService = new WxPayServiceImpl();
		wxPayService.setWxPayH5Config(this.wxPayH5Config);

		return wxPayService.asyncNotify(notifyData);
	}

	/**
	 * 判断是什么支付类型(从同步回调中获取参数)
	 *
	 * @param request
	 * @return
	 * @throws BestPayException 
	 */
	private BestPayTypeEnum payType(HttpServletRequest request) throws BestPayException {
		// 先判断是微信还是支付宝 是否是xml
		// 支付宝同步还是异步
		if (request.getParameter("notify_type") == null) {
			// 支付宝同步
			if (request.getParameter("exterface") != null
					&& request.getParameter("exterface").equals("create_direct_pay_by_user")) {
				return BestPayTypeEnum.ALIPAY_PC;
			}
			if (request.getParameter("method") != null
					&& request.getParameter("method").equals("alipay.trade.wap.pay.return")) {
				return BestPayTypeEnum.ALIPAY_WAP;
			}
		} else {
			// 支付宝异步(发起支付时使用这个参数标识支付方式)
			String payType = request.getParameter("passback_params");
			return BestPayTypeEnum.getByCode(payType);
		}

		throw new BestPayException(BestPayResultEnum.PAY_TYPE_ERROR);
	}

	@Override
	public RefundResponse refund(RefundRequest request) {
		// 微信h5支付
		WxPayServiceImpl wxPayService = new WxPayServiceImpl();
		wxPayService.setWxPayH5Config(this.wxPayH5Config);
		return wxPayService.refund(request);
	}
}