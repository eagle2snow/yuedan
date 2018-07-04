<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  
    response.setHeader("Cache-Control","no-store");  
    response.setDateHeader("Expires", 0);  
    response.setHeader("Pragma","no-cache");   
%> 
<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>个人中心</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
</head>
<body>
	<!-- 中间 -->
	<!-- 一行 -->
	<div class="cutuser wbox">
		<a  class="cutuser_produce">
			<div class="cutuser_avator">
				<img src="${member.iocUrl}" alt="">
			</div>
			<div class="cutuser_cont">
				<div class="tr">会员昵称：${member.name}</div>
				<div class="tr">
				会员等级：
				<c:choose>
						<c:when test="${member.level==1}">竹语游客</c:when>  
						<c:when test="${member.level==2}">普通会员</c:when>  
						<c:when test="${member.level==3}">业务经理</c:when>  
						<c:when test="${member.level==4}">城市经理</c:when>  
						<c:when test="${member.level==5}">合作伙伴</c:when>  
				</c:choose>
				
				</div>
				<div  class="tr">
					<span id="referrerName">推&ensp;荐&ensp;人：
						<c:if test="${not empty member.referrerNickname}">${member.referrerNickname}</c:if>
						<c:if test="${empty member.referrerNickname}">漓江竹语</c:if>
					</span> 
					<c:if test="${member.changReferrer == 0 }">
						<span id="spanId"
							onclick="document.getElementById('refereecpop').classList.add('show');"
							class="ml2 primarybtn msbtn">更&ensp;改
						</span>
					</c:if>
				
				</div>
			</div> <i onclick="editProfile(${member.id})" class="rgt"></i>
		</a>
	</div>
	<!-- end 一行 -->
	<!-- 一行 -->
	<ul class="showdata wbox">
		<li>
			<div class="og dd">
				<span class="n">${member.consume}</span>元
			</div>
			<div class="dt">消费额</div>
		</li>
		<li>
			<div class="dd">
				<span class="n">${member.love}</span>元
			</div>
			<div class="dt">爱心扶贫</div>
		</li>
		<li>
			<div class="dd">
				<span class="n">${member.generalizeCost}</span>元
			</div>
			<div class="dt">推广费</div>
		</li>
	</ul>
	<!-- end 一行 -->
	<!-- 一行 -->
	<ul class="ordernavlist">
		<li class="ordernavitem"><a href="${adp }order/myOrders/1" class="ordernavpro"> <i
				class="order_mbico mbico"></i>
				<div class="dt">我的订单</div>
		</a></li>
		<li class="ordernavitem"><a href="${adp }order/pushOrders/1" class="ordernavpro"> <i
				class="commission_mbico mbico"></i>
				<div class="dt">提成订单</div>
		</a></li>
	</ul>
	<!-- end 一行 -->
	<!-- 一行 -->
	<ul class="gonavlist">
		<li class="gonavitem"><a
			href="/wx/myCenter/myMembers/1" class="gonavdl">
				<div class="dt">我的会员</div> <i class="rgt"></i>
		</a></li>
		<li class="gonavitem"><a
			<%-- href="${ctx}wx/comments/myComments" class="gonavdl"> --%>
			href="${ctx}wx/myCenter/replyMessage/1" class="gonavdl">
				<div class="dt">我的评论</div> <i class="rgt"></i>
		</a></li>
		<li class="gonavitem"><a href="${adp }myQrCode" class="gonavdl">
				<div class="dt">我的二维码</div> <i class="qrcode_mico mico"></i> <i
				class="rgt"></i>
		</a></li>
	</ul>
	<ul class="gonavlist">
		<li class="gonavitem"><a href="${adp}shippingAddress"
			class="gonavdl">
				<div class="dt">收货地址</div> <i class="rgt"></i>
		</a></li>
	</ul>
	
	<ul class="gonavlist">
		<li class="gonavitem"><a href="${adp}draw/drawLog" class="gonavdl">
				<div class="dt">可提现金额</div> <span class="primarytxt"><span
					class="mr10 fz30">${member.balance}</span>元</span> <i class="rgt"></i>
		</a></li>
	</ul>
	
	
	<ul class="gonavlist">
		<li class="gonavitem" style="margin-bottom: 6rem;"><a href="${ctx}/wx/chat" class="gonavdl">
				<div class="dt">联系客服</div> <i class="rgt"></i>
		</a></li>
	</ul>
	<!-- end 一行 -->
	<!--end 中间-->
	<!-- 底部 -->
	
	
	<nav class="fnavlist">
		<a href="${ctx}wx/index" class="fnavitem">首页</a> <a
			href="${ctx}wx/commodity/showCart" class="cart fnavitem">购物车</a> <a
			href="${ctx}wx/myCenter/index?fuck" class="on user fnavitem">个人中心</a>
	</nav>
	
	
	<!--end 底部-->




	<!-- cpop -->
	<div class="cpop" id="refereecpop">
		<div
			onclick="document.getElementById('refereecpop').classList.remove('show');"
			class="fade_bkbg"></div>
		<div class="cpopcenter">
			<div class="ntcpop_container">
				<div class="ntcpop_mt">更改推荐人</div>
				<div class="ntcpop_mc">
					<div class="dtitem">
						<div class="dl">
							<div class="dd">
								<input type="text" onFocus=OnEnter(this) onBlur=OnExit(this)  value="请输入推荐人推广ID" class="dtint" name="referrerGeneralizeId">
							</div>
						</div>
						<div class="setitem_bins">
							<span class="secondtxt">* 推荐人只能更改一次，请慎重填写</span>
						</div>
					</div>
				</div>
				<div class="ntcpop_mb">
					<a onclick="editReperrer()" class="primarylinebtn mdbtn">确&ensp;定</a>
				</div>
			</div>
		</div>
	</div>
	<!-- cpop -->

	<%@ include file="/common/wx/js.jsp"%>
	<%@ include file="/common/wx/socket.jsp"%>


	<script>
	document.addEventListener("touchstart", function(){}, true);
	
	function editProfile(id){
		window.location.href = "${ctx}/wx/myCenter/editProfileView";
	}
	
// 	鼠标移入：清除value值
	function OnEnter( field ) { 
		if( field.value == field.defaultValue ) { field.value = ""; } }  
	
// 	鼠标移出：显示value值
	function OnExit( field ) { 
		if( field.value == "" ) { field.value = field.defaultValue; } } 
//  更改推荐人	
	function editReperrer(){
		
		var referrerGeneralizeId = $("input[ name='referrerGeneralizeId' ] ").val()
		
		$.getJSON("${adp}editReferrerAction/"+referrerGeneralizeId,
			function(date) {
                if (date.s == "1")
                    $.alert("推广码有误，请检查!");
                else if (date.s == "2")
                    $.alert("不存在推荐人，请重新更改!");
                else if(date.s == "3")
                    $.alert("推荐人只能修改一次，请勿重复修改!");
                else if(date.s == "4")
                    $.alert("推荐人不可以是自己!");
                else if (date.s == "5")
                    $.alert("推荐关系是环形！请重新选择！");
                else if (date.s == "6")
                    $.alert("推荐关系是环形　请重新选择！");
                else if (date.s == "7")
                    re()
		});
	}
	
	
</script>


</body>
</html>