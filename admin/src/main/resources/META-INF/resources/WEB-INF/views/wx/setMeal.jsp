<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>购买套餐</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
</head>
<body>
	<!-- 中间 -->
	<!-- 一行 -->
	<ul class="toselist">
		<li class="toselitem"><input type="radio" checked="checked"
			id="tosel01" name="tosel"> <label for="tosel01"
			class="toselabel">
				<div class="toselabel_cont">
					<div class="name">竹语会员</div>
					<div class="info">成为会员，享受专属福利</div>
				</div> <span class="price"><ins>398元</ins>/1套</span>
		</label></li>
	</ul>
	<!-- end 一行 -->
	<!-- 一行 -->
	<div class="cartpro_pic">
			<a href=""><img :src="static/wx/images/Introduction/08.png" alt="纸"></a>
			<a href=""><img :src="static/wx/images/Introduction/09.png" alt="酒"></a>
   </div>
<!-- 	<section class="binsbox"> -->
<!-- 		<h3 class="binsbox_dt">VIP专享分红佣金：</h3> -->
<!-- 		<ul class="decimalist"> -->
<!-- 			<li>购买首页套餐成为会员</li> -->
<!-- 			<li>会员直推10个会员，反自身全部套餐款作为佣金</li> -->
<!-- 			<li>下级：不管下多少级，满足直推人员到10人，直系团队总人数到100人开始，以后每加1人，获得5元佣金。（特别说明：下级团队中的任意一个点，团队数满足100人，立即脱离上级团队）</li> -->
<!-- 			<li> -->
<!-- 				<div>满足条件：</div> -->
<!-- 				<p>A、直推30人</p> -->
<!-- 				<p>B、下级团队人数满1000人（包含脱离出去的）</p> -->
<!-- 				<p>C.、推得团队中有3个人满足100人下级</p> -->
<!-- 			</li> -->
<!-- 			<li>会员升级后做在会员中心醒目位置坐LOGO标注</li> -->
<!-- 		</ul> -->
<!-- 	</section> -->
	<!-- end 一行 -->
	<!--end 中间-->
	<!-- 底部 -->
	<div class="fbottom">
		<nav class="btool">
			<div class="btool_halfcont">
				<a onclick="prePay()" class="primarybtn btoolbtn">立&nbsp;即&nbsp;购&nbsp;买</a>
			</div>
		</nav>
	</div>
	<!--end 底部-->
	<%@ include file="/common/wx/js.jsp"%>
	<%@ include file="/common/wx/socket.jsp"%>
	<script src="${ctx}static/wx/js/tool.js"></script>

	<script>
		document.addEventListener("touchstart", function() {
		}, true);

		function prePay() {
			$.getJSON('${ctx}wx/pay/prePayCombo', function(res) {
				if (res.s === 1) {
					var appId = res.data.appId;
					var timeStamp = res.data.timeStamp;
					var nonceStr = res.data.nonceStr;
					var packAge = res.data.packAge;
					var signType = res.data.signType;
					var paySign = res.data.paySign;
					onBridgeReady(appId, timeStamp, nonceStr, packAge,
							signType, paySign);
				} else {
					$.alert(res.s);
				}
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
					location.href = '/wx/payMemberSuccess';
				} else {
					location.href = '/wx/payMemberFail';
				}
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