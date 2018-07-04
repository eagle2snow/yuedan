<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>支付失败</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
</head>
<body>
	<!-- 中间 -->
	<!-- 一行 -->
<!-- 	<div class="showdtlist wpbox">
		<div class="showdtitem">
			<a href="###" class="dl">
				<p>
					首单支付后，重复消费<span class="secondtxt">立减80%</span>，相当于<span
						class="secondtxt">8折优惠</span>
				</p>
			</a>
		</div>
	</div> -->
	<!-- end 一行 -->
	<!-- 一行 -->
	<ul class="stepbar">
		<li class="active cart stepbaritem"></li>
		<li class="active edit stepbaritem"></li>
		<li class="error success stepbaritem"></li>
	</ul>
	<!-- end 一行 -->
	<!-- 一行 -->
	<div class="ntbox">
		<div class="ntbox_dt">
			<i class="md_error_ntico ntico"></i>支付失败
		</div>
		<div class="ntbox_dd">对不起，支付遇到问题，您可以：</div>
	</div>
	<div class="mt80 spcbtnrow">
		<div class="spcbtnrow_item">
			<a href="${ctx}wx/setMeal/"
				class="warnbtn mdbtn">重新支付</a>
		</div>


		<div class="spcbtnrow_item">
			<a href="${ctx}wx/chat" class="secondbtn mdbtn">联系客服</a>
		</div>
	</div>
	<!-- end 一行 -->
	<!--end 中间-->

	<script>
		document.addEventListener("touchstart", function() {
		}, true);
	</script>


</body>
</html>