package com.gm.api.pay.exception;

import com.gm.api.pay.emums.BestPayResultEnum;

public class BestPayException extends Exception {

	private Integer code;

	public BestPayException(BestPayResultEnum payTypeError) {
		super(payTypeError.getMsg());
		code = payTypeError.getCode();
	}

	public Integer getCode() {
		return code;
	}
}
