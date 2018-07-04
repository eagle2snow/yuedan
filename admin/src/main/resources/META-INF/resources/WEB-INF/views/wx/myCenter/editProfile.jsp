<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/wx/global.jsp"%>	
<html>
<head>
<meta charset="utf-8" />
<title>修改个人资料</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
</head>
<body>
<!-- 中间 -->
<!-- 一行 -->
<div class="spactor_setlist setlist">
	<div class="setitem">
		<div class="dl">
			<div class="min120 dt">头像</div>
			<div class="ar dd"><span id="iocUrl" class="setitem_avator"><img id="iocUrl" src="${model.iocUrl }" alt=""><input type="file" disabled="disabled" class="hidel"></span></div>
		</div>
	</div>
	<div class="setitem">
		<div class="dl">
			<div class="min120 dt">会员等级</div>
			<div class="ar dd">
				<input  
					type="text" 
					readonly="readonly" 
					value="<c:choose ><c:when test='${model.level == 1}'>竹语游客</c:when><c:when test='${model.level == 2}'>普通会员</c:when><c:when test='${model.level == 3}'>业务经理</c:when><c:when test='${model.level == 4}'>城市经理</c:when><c:when test='${model.level == 5}'>合作伙伴</c:when></c:choose>" 
					placeholder="竹语小fans" class="dtint">
			</div>
			</div>
		</div>
	</div>
	<div class="setitem">
		<div class="dl">
			<div class="min120 dt">修改昵称</div>
			<div class="ar dd"><input onfocus="OnEnter(this)" onblur="OnExit(this)" name="nickname" id="nickname" type="text" value="${model.name}" placeholder="例如：竹语小fans" class="dtint"></div>
		</div>
	</div>
	<div class="setitem">
		<div class="dl">
			<div class="min120 dt">新手机号</div>
			<div class="ar dd">
				<input onfocus="OnEnter(this)" onblur="OnExit(this)"  name="mobile" id="mobile" type="tel" value="${model.mobile }" placeholder="例如：13551524965" class="dtint">
			</div>
		</div>
		<div class="tborder dl">
			<div class="min120 dt"></div>
			<div class="ar dd">
				<input id="verificationCode" name="verificationCode" type="text" placeholder="请输入验证码" class="dtint">
			</div>
			<a onclick="getVerificationCode()" class="ml20 primarybtn mbtn">点击获取验证码</a>
		</div>
	</div>
<div class="marginbtnrow spcbtnrow">
	<div class="spcbtnrow_item"><a id="submitId" onclick="submitFun()" class="primarybtn bigbtn">保&emsp;存</a></div>
</div>
<!-- end 一行 -->
<!--end 中间-->
<!-- 底部 -->
<div class="fbottom">
		<nav class="fnavlist">
		<a href="${ctx}wx/index" class="fnavitem">首页</a> <a
			href="${ctx}wx/commodity/showCart" class="cart fnavitem">购物车</a> <a
			href="${ctx}wx/myCenter/index?fuck" class="on user fnavitem">个人中心</a>
	</nav>
</div>
<!--end 底部-->

<%@ include file="/common/wx/js.jsp"%>
<%@ include file="/common/wx/socket.jsp"%>


<script>
	document.addEventListener("touchstart", function(){}, true);
	
// 	function onEnter(field){
// 		if(field.value == field.defaultValue){
// 			field.value == "";
// 		}
// 	}
	
// 	function onExit(field){
// 		if(field.value == ""){
// 			field.value== field.defaultValue;
// 		}
// 	}
	
	function OnEnter( field ) { 
		if( field.value == field.defaultValue ) { field.value = ""; } }  
	
	function OnExit( field ) { 
		if( field.value == "" ) { 
			field.value = field.defaultValue; 
		}
	} 
	
	
	function submitFun(){
		var nickname = document.getElementById("nickname").value;
		var mobile   = document.getElementById("mobile").value;
		var code   = document.getElementById("verificationCode").value;
		
		
		if (!(/^1[34578]\d{9}$/.test(mobile))) {
			alert("手机号格式不正确，请重新输入！");
			return false;
		}
		
		
		$.getJSON("${adp}editProfile/"+nickname+"/"+mobile+"/"+code, function(data) {
			if (data.status == 1) {
				layer.msg(data.msg,{icon:6}); 
				window.location.href = href="${ctx}wx/myCenter/index?fuck";
			
			} else if(data.status == 2) {
				layer.msg(data.msg,{icon:5}); //错误的表情 
			}else if(data.status == 3){
				layer.msg(data.msg,{icon:5}); 
			}
		});
	}
	
	function getVerificationCode(){
		var mobile = document.getElementById("mobile").value;

        mobile = mobile.replace(/\s+/g, "")
        document.getElementById("mobile").value = mobile
		
		if (!(/^1[34578]\d{9}$/.test(mobile))) {
			$.alert("手机号格式不正确，请重新输入！");
			return false;
		}
		
		$.getJSON("${adp}getVerificationCode/"+mobile, function(data) {
			if (data.status == 1) {
				layer.msg(data.msg,{icon:6}); 
			} else {
				layer.msg(data.msg,{icon:5}); 
			}
		});
	}
	
</script>

</body>
</html>