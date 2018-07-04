<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="/static/wx/css/css.css" />
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta name="format-detection" content="telephone=no" />
<meta name="format-detection" content="email=no" />
<meta name="msapplication-tap-highlight" content="no">
</head>
<body>
<!-- 中间 -->
<!-- 一行 -->
<a href="###" class="secmtitle">新增一个收货地址</a>
<ul class="mt16 addresslist">
	<li class="addressitem">
		<div class="addressitem_info">
			<span class="name">吴先生的女士</span>
			<span class="phonenum">13551581322</span>
		</div>
		<div class="addressitem_local">广西壮族自治区南宁市青秀区  民族大道  XXX号  XXX小区  XXX栋  XXX房</div>
		<div class="addressitem_mb">
			<div class="addressitem_sel">
				<input type="radio" checked="checked" id="addressitem01" name="addressitem" />
				<label for="addressitem01" class="label">默认地址</label>
			</div>
			<div class="addressitem_tool">
				<a href="###" class="addressitem_edit">修改</a>
				<a href="javascript:;" onclick="delAddressitem(this);" class="addressitem_del">删除</a>
			</div>
		</div>
	</li>
	<li class="addressitem">
		<div class="addressitem_info">
			<span class="name">吴先生的女士</span>
			<span class="phonenum">13551581322</span>
		</div>
		<div class="addressitem_local">广西壮族自治区南宁市青秀区  民族大道  XXX号  XXX小区  XXX栋  XXX房广西壮族自治区南宁市青秀区  民族大道  XXX号  XXX小区  XXX栋  XXX房</div>
		<div class="addressitem_mb">
			<div class="addressitem_sel">
				<input type="radio" id="addressitem02" name="addressitem" />
				<label for="addressitem02" class="label">设为默认</label>
			</div>
			<div class="addressitem_tool">
				<a href="###" class="addressitem_edit">修改</a>
				<a href="javascript:;" onclick="delAddressitem(this);" class="addressitem_del">删除</a>
			</div>
		</div>
	</li>
</ul>
<!-- end 一行 -->
<!--end 中间-->
<!-- 底部 -->
<div class="fbottom">
	<nav class="fnavlist">
		<a href="###" class="myqrcode fnavitem">最新活动</a>
		<a href="###" class="cart fnavitem">购物车</a>
		<a href="###" class="on user fnavitem">个人中心</a>
	</nav>
</div>
<!--end 底部-->





<script src="js/tool.js"></script>


</body>
</html>