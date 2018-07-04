
function prePay(orderNo, orderName, amount) {
	$.getJSON('/wx/pay/prePay?orderNo=' + orderNo + "&orderName=" + orderName
			+ "&amount=" + amount, function(res) {
		var appId = res.appId;
		var timeStamp = res.timeStamp;
		var nonceStr = res.nonceStr;
		var packAge = res.packAge;
		var signType = res.signType;
		var paySign = res.paySign;
		onBridgeReady(appId, timeStamp, nonceStr, packAge, signType, paySign);
	});
}

function onBridgeReady(appId, timeStamp, nonceStr, packAge, signType, paySign) {
	WeixinJSBridge.invoke('getBrandWCPayRequest', {
		"appId" : appId,
		"timeStamp" : timeStamp,
		"nonceStr" : nonceStr,
		"package" : packAge,
		"signType" : signType,
		"paySign" : paySign
	}, function(res) {
		// 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回 ok，但并不保证它绝对可靠。
		if (res.err_msg == "get_brand_wcpay_request:ok") {
		}
	});
	if (typeof WeixinJSBridge == "undefined") {
		if (document.addEventListener) {
			document.addEventListener('WeixinJSBridgeReady',
					this.onBridgeReady, false);
		} else if (document.attachEvent) {
			document.attachEvent('WeixinJSBridgeReady', this.onBridgeReady);
			document.attachEvent('onWeixinJSBridgeReady', this.onBridgeReady);
		}
	}
}