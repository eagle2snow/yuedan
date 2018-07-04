<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>收货地址</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
</head>
<body>
<!-- 中间 -->
<!-- 一行 -->
<a href="${adp}addAddress" class="secmtitle">新增一个收货地址</a>
<ul class="mt16 addresslist">
	<c:forEach items="${list}" var="model">
		<li class="addressitem">
			<div class="addressitem_info">
				<span class="name">${model.name}</span>
				<span class="phonenum">${model.mobile}</span>
			</div>
			<div class="addressitem_local">${model.pca} ${model.address}</div>
			<input type="hidden" value=${model.id} id="addrId" />
			<div class="addressitem_mb">
				<div class="addressitem_sel" onclick="changeDefault(${model.id})">
					<input type="radio" value="${model.id}"  ${(model.defaultAddress==1)?'checked':''}  name="addressitem" />
					<label for="addressitem01"  class="label">默认地址</label>
				</div>
				<div class="addressitem_tool">
					<a href="${adp}editAddressView/${model.id}" class="addressitem_edit">修改</a>
					<a onclick= deleteDefault(${model.id})  class="addressitem_del">删除</a>
				</div>
			</div>
		</li>
	</c:forEach>
</ul>
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
<script src="${ctx}static/wx/js/tool.js"></script>

<script type="text/javascript">

function deleteDefault(id){
	$.getJSON("${adp}deleteAddressView/${model.id}"+id,
			function(date) {
				console.log(date);
				var map = date;
				if(map.msg == "ok") {
					re();
				}else {
					alert("系统有点忙，等会再来试试吧！");
				}
		});
}

function changeDefault(id){
	$.getJSON("${adp}editDefaultAddress/"+id,
			function(date) {
				console.log(date);
				var map = date;
				if(map.msg == "ok") {
					re();
				}else {
					alert("系统有点忙，等会再来试试吧！");
				}
		});
}

</script>


</body>
</html>