<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>提成订单</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
</head>
<body>
<!-- 中间 -->
<!-- 一行 -->
<nav class="tabhd">
	<ul class="blocktabhd">
		<li ${type==1?'class="on"':'' } ><a href="/wx/myCenter/order/pushOrders/1">未确认</a></li>
		<li ${type==2?'class="on"':'' } ><a href="/wx/myCenter/order/pushOrders/2">已确认</a></li>
	</ul>
</nav>
<!-- end 一行 -->
<!-- 一行 -->
<div class="mt16 simpletable_wrap">
	<table class="simpletable">
		<thead >
			<tr>
				<th>昵称</th>
				<th>订单号</th>
				<th>金额/推广费</th>
				<th>状态</th>
				<th>下单时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${order}" var="o">
			<tr ${o.status ne '10' and type==2 ? 'style="display: none"':''}, ${o.status eq '10' and type==1 ? 'style="display: none"':''} >
				<td>${o.member.nickname }</td>
				<td>${o.orderNo } </td>
				<td>${o.totalMoney }/${o.totalMoney /100}</td>
				<td>
					<c:if test="${o.status == '1'}">待付款</c:if>
					<c:if test="${o.status == '2'||o.status == '11'}">待发货</c:if>
					<c:if test="${o.status == '3'}">待收货</c:if>
					<c:if test="${o.status == '4'}">已收货</c:if>
					<c:if test="${o.status == '5'}">退换货申请中</c:if>
					<c:if test="${o.status == '6'}">退换货申请通过，待买家发货</c:if>
					<c:if test="${o.status == '7'}">退换货申请通过，买家已发货</c:if>
					<c:if test="${o.status == '8'}">退换货申请不通过</c:if>
					<c:if test="${o.status == '9'}">订单已退款</c:if>
					<c:if test="${o.status == '10'}">订单已完成</c:if>
				</td>
				<td>
				<javatime:format value="${o.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
</div>
<!-- end 一行 -->
<!--end 中间-->
	<%@ include file="/common/wx/js.jsp"%>
	<%@ include file="/common/wx/socket.jsp"%>


<script>
document.addEventListener("touchstart", function(){}, true);
</script>


</body>
</html>