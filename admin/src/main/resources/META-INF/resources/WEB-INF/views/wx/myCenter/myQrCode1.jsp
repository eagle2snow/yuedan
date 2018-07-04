<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>推广我的二维码</title>
<link rel="stylesheet" type="text/css" href="/static/wx/css/css.css" />

<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>

</head>
<body>
	<!-- 中间 -->
	<!-- cpop -->
	<div class="show cpop">
		<div class="cpopcenter">
			<div class="centerntbox">
				<div class="centernthead">
					<div class="tr">
						<span class="avator150"><img
							src="${user.iocUrl}" alt=""></span>
					</div>
					<div class="tr">
						<span class="name">${user.nickname}</span>
					</div>
				</div>
				<div class="myqrcodebox">
					<img src="http://zhuyu.tiexinxi.cn${user.qrCode }" alt="">
				</div>
				<!-- <div class="ac dtrins">分享方式：<br>①直接扫描二维码<br>②长按二维码 -> 发送给朋友</div> -->
			</div>
		</div>
	</div>
	<!-- cpop -->
	<!--end 中间-->

	<%@ include file="/common/wx/js.jsp"%>
	<%@ include file="/common/wx/socket.jsp"%>
	
	 <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>




</body>
</html>