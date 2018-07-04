<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>提成订单-未确认</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
<body>
<!-- 中间 -->
<!-- 一行 -->
<nav class="tabhd">
	<ul class="blocktabhd">
		<li class="on"><a href="###">未确认</a></li>
		<li><a href="###">已确认</a></li>
	</ul>
</nav>
<!-- end 一行 -->
<!-- 一行 -->
<div class="mt16 simpletable_wrap">
	<table class="simpletable">
		<thead>
			<tr>
				<th>昵称</th>
				<th>订单</th>
				<th>金额/推广费</th>
				<th>状态</th>
				<th>下单时间</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>麦田的那边</td>
				<td>20170614<br />12348942</td>
				<td>869/8.69</td>
				<td>未收货</td>
				<td>2017-06-14</td>
			</tr>
			<tr>
				<td>麦田的那边</td>
				<td>20170614<br />12348942</td>
				<td>869/8.69</td>
				<td>未收货</td>
				<td>2017-06-14</td>
			</tr>
			<tr>
				<td>麦田的那边</td>
				<td>20170614<br />12348942</td>
				<td>869/8.69</td>
				<td>未收货</td>
				<td>2017-06-14</td>
			</tr>
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