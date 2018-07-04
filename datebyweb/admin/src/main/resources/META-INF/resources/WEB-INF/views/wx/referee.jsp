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
<div class="cutuser wbox">
	<a href="###" class="cutuser_produce">
		<div class="cutuser_avator"><img src="images/portrait/170/01.jpg" alt=""></div>
		<div class="cutuser_cont">
			<div class="tr">会员号：8412349</div>
			<div class="tr">会员昵称：竹语小fans</div>
			<div class="tr">推荐人：竹语达人 <span onclick="document.getElementById('refereecpop').classList.add('show');" class="ml20 primarybtn msbtn">更&ensp;改</span></div>
		</div>
		<i class="rgt"></i>
	</a>
</div>
<!-- end 一行 -->
<!-- 一行 -->
<ul class="showdata wbox">
	<li>
		<div class="og dd"><span class="n">869.00</span>元</div>
		<div class="dt">消费额</div>
	</li>
	<li>
		<div class="dd"><span class="n">0.86</span>棵</div>
		<div class="dt">拯救树</div>
	</li>
	<li>
		<div class="dd"><span class="n">118.00</span>元</div>
		<div class="dt">推广费</div>
	</li>
</ul>
<!-- end 一行 -->
<!-- 一行 -->
<ul class="ordernavlist">
	<li class="ordernavitem"><a href="###" class="ordernavpro">
		<i class="order_mbico mbico"></i>
		<div class="dt">我的订单</div>
	</a></li>
	<li class="ordernavitem"><a href="###" class="ordernavpro">
		<i class="commission_mbico mbico"></i>
		<div class="dt">提成订单</div>
	</a></li>
</ul>
<!-- end 一行 -->
<!-- 一行 -->
<ul class="gonavlist">
	<li class="gonavitem">
		<a href="###" class="gonavdl">
			<div class="dt">我的会员</div>
			<i class="rgt"></i>
		</a>
	</li>
	<li class="gonavitem">
		<a href="###" class="gonavdl">
			<div class="dt">我的评论</div>
			<i class="rgt"></i>
		</a>
	</li>
	<li class="gonavitem">
		<a href="###" class="gonavdl">
			<div class="dt">我的二维码</div>
			<i class="qrcode_mico mico"></i>
			<i class="rgt"></i>
		</a>
	</li>
</ul>
<ul class="gonavlist">
	<li class="gonavitem">
		<a href="###" class="gonavdl">
			<div class="dt">收货地址</div>
			<i class="rgt"></i>
		</a>
	</li>
</ul>
<ul class="gonavlist">
	<li class="gonavitem">
		<a href="###" class="gonavdl">
			<div class="dt">可提现金额</div>
			<span class="primarytxt"><span class="mr10 fz30">118.00</span>元</span>
			<i class="rgt"></i>
		</a>
	</li>
</ul>
<ul class="gonavlist">
	<li class="gonavitem">
		<a href="###" class="gonavdl">
			<div class="dt"><a href="/wx/profile.jsp">公司简介</a></div>
			<i class="rgt"></i>
		</a>
	</li>
</ul>
<ul class="gonavlist">
	<li class="gonavitem">
		<a href="###" class="gonavdl">
			<div class="dt">联系客服</div>
			<i class="rgt"></i>
		</a>
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




<!-- cpop -->
<div class="show cpop" id="refereecpop">
	<div onclick="document.getElementById('refereecpop').classList.remove('show');" class="fade_bkbg"></div>
	<div class="cpopcenter">
		<div class="ntcpop_container">
			<div class="ntcpop_mt">更改推荐人</div>
			<div class="ntcpop_mc">
				<div class="dtitem">
					<div class="dl">
						<div class="dd"><input type="text" placeholder="请输入推荐人的昵称或会员号" class="dtint"></div>
					</div>
					<div class="setitem_bins"><span class="secondtxt">* 推荐人只能更改一次，请慎重填写</span></div>
				</div>
			</div>
			<div class="ntcpop_mb"><a href="javascript:;" onclick="document.getElementById('refereecpop').classList.remove('show');"  class="primarylinebtn mdbtn">确&ensp;定</a></div>
		</div>
	</div>
</div>
<!-- cpop -->




<script>
document.addEventListener("touchstart", function(){}, true);
</script>


</body>
</html>