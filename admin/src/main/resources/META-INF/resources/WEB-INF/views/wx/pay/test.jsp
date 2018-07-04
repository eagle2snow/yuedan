<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>测试支付</title>
<link rel="stylesheet" type="text/css" href="/static/wx/css/css.css" />

<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>

<style type="text/css">
.Validform_title {
	display: none;
}
</style>

</head>
<body>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<a href="javascript:void(0);" onclick="prePay()"
		class="weui-btn weui-btn_primary">支付0.01元</a>

	<%@ include file="/common/wx/js.jsp"%>
	<%@ include file="/common/wx/socket.jsp"%>

	<script type="text/javascript"
		src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>

	<script type="text/javascript">
		document.addEventListener("touchstart", function() {
		}, true);

		function prePay() {
			$.getJSON('/wx/testPay/prePay', function(res) {
				var appId = res.appId;
				var timeStamp = res.timeStamp;
				var nonceStr = res.nonceStr;
				var packAge = res.packAge;
				var signType = res.signType;
				var paySign = res.paySign;
				onBridgeReady(appId, timeStamp, nonceStr, packAge, signType,
						paySign);
			});
		}

		function onBridgeReady(appId, timeStamp, nonceStr, packAge, signType,
				paySign) {
			WeixinJSBridge.invoke('getBrandWCPayRequest', {
				"appId" : appId, //公众号名称，由商户传入     
				"timeStamp" : timeStamp, //时间戳，自1970年以来的秒数     
				"nonceStr" : nonceStr, //随机串     
				"package" : packAge,
				"signType" : signType, //微信签名方式：     
				"paySign" : paySign
			//微信签名 
			}, function(res) {
				if (res.err_msg == "get_brand_wcpay_request:ok") {
				} // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
			});
			if (typeof WeixinJSBridge == "undefined") {
				if (document.addEventListener) {
					document.addEventListener('WeixinJSBridgeReady',
							this.onBridgeReady, false);
				} else if (document.attachEvent) {
					document.attachEvent('WeixinJSBridgeReady',
							this.onBridgeReady);
					document.attachEvent('onWeixinJSBridgeReady',
							this.onBridgeReady);
				}
			}

		}
	</script>


</body>
</html>