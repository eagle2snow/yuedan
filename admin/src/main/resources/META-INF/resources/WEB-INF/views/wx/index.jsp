<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>首页</title>

<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
</head>
<body>
	<!-- banner -->
	<div class="ibn" id="ibn">
		<ul class="bd">
			<li><a href=""><img
					src="/static/wx/images/banner/ibn/01.jpg" alt=""></a></li>
			<li><a href=""><img
					src="/static/wx/images/banner/ibn/02.jpg" alt=""></a></li>
			<li><a href=""><img
					src="/static/wx/images/banner/ibn/03.jpg" alt=""></a></li>
		</ul>
		<ul class="hd"></ul>
	</div>
	<!-- banner -->
	<!-- 中间 -->
	<!-- 一行 -->
	
	
	
	<ul class="showpiclist">
		<c:forEach items="${page.list }" var='p'>
			<li class="showpicitem"><a
				href="/wx/commodity/commodityDetail/${p.id}"><img
					src="${p.imgerPath}" height="280" alt=""></a></li>
		</c:forEach>
	</ul>
	<!-- end 一行 -->
	<!-- 一行 -->
	<section class="servicebox">
		<div class="secmtitle">客&ensp;服</div>
		<div class="contactcardlist boxshadow">
			<ul class="boxshadow_inner">
				<li class="fore01 contactcard"><a href="###"
					class="contactcard_link"><div class="contactcard_produce">
							<div class="dt">客服电话</div>
							<div class="dd">400-090-6068</div>
						</div></a></li>
				<li class="fore02 contactcard"><a href="###"
					class="contactcard_link"><div class="contactcard_produce">
							<div class="dt">400电话服务时间</div>
							<div class="dd">9:00-18:30</div>
						</div></a></li>
				<li class="fore03 contactcard"><a href="###"
					class="contactcard_link"><div class="contactcard_produce">
							<div class="dt">维修服务时间</div>
							<div class="dd">9:00-18:30</div>
						</div></a></li>
				<li class="fore04 contactcard"><a href="###"
					class="contactcard_link"><div class="contactcard_produce">
							<div class="dt">在线咨询服务时间</div>
							<div class="dd">9:00-18:30</div>
						</div></a></li>
			</ul>
		</div>
	</section>
	<!-- end 一行 -->
	<!-- 一行 -->
	<section class="servicebox">
		<div class="secmtitle">售&ensp;后</div>
		<div class="aftersell_dlist">
			<div class="aftersell_dl">
				<div class="dt">
					<span class="tagtitle boxshadow"><span
						class="tagtitle_inner boxshadow_inner"><i
							class="get_mico mico"></i>签&nbsp;收</span></span>
				</div>
				<div class="dd">
					<div class="sec">如果产品严重破损，请拒收。</div>
				</div>
			</div>
			<div class="aftersell_dl">
				<div class="dt">
					<span class="tagtitle boxshadow"><span
						class="tagtitle_inner boxshadow_inner"><i
							class="back_mico mico"></i>退&nbsp;货</span></span>
				</div>
				<div class="dd">
					<div class="sec">
						<p>产品没有拆开，不影响二次销售的情况下，</p>
						<p>拍下货物15天内可以无条件退货；</p>
						<p>非质量问题退货，需承担发货和退货产生的快递费用；</p>
						<p>系统确认收货后，非质量原因概不办理退款退货；</p>
						<p>如因质量问题需退货，请拍照联系客服。</p>
					</div>
					<div class="sec" style="margin-bottom: 8rem;">
						<span class="primarytxt"><i class="local_sico sico"></i>地址：桂林市叠彩区恒大广场3栋2302室</span>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- end 一行 -->
	<!--end 中间-->
	<!-- 底部 -->

	<nav class="fnavlist">
		<a href="${ctx}wx/myCenter/myQrCode" class="myqrcode fnavitem">我的二维码</a>
		<a href="${ctx}wx/commodity/showCart" class="cart fnavitem">购物车</a> <a
			href="${ctx}wx/myCenter/index?fuck" class="user fnavitem">个人中心</a>
	</nav>

	<!--end 底部-->


	<!-- ftools -->
	<nav class="ftools">
		<a href="${ctx}/wx/chat" class="service_ftoolsitem"><span
			class="primarybtn msbtn">客&nbsp;服</span></a>
	</nav>
	<!-- ftools -->

	<%@ include file="/common/wx/js.jsp"%>
	<%@ include file="/common/wx/socket.jsp"%>

</body>
</html>