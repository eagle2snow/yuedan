<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>我的会员</title>
<link rel="stylesheet" type="text/css" href="/static/wx/css/css.css" />
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
	name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta name="format-detection" content="telephone=no" />
<meta name="format-detection" content="email=no" />
<meta name="msapplication-tap-highlight" content="no">
</head>
<body>
	<!-- 中间 -->
	<!-- 一行 -->
	<nav class="tabhd">
		<ul class="blocktabhd">
			<li ${type==1?'class="on"':'' }"><a href="/wx/myCenter/myMembers/1">未购买</a></li>
			<li ${type==2?'class="on"':'' } ><a href="/wx/myCenter/myMembers/2">已购买</a></li>
		</ul>
	</nav>
	<!-- end 一行 -->
	<!-- 一行 -->


	<div class="mt16 simpletable_wrap">
		<table class="simpletable">
			<thead>
				<tr>
					<th>昵称</th>
					<th>联系方式</th>
					<th>注册时间</th>
				</tr>
			</thead>


			<c:forEach items="${list}" var="user">
				<tr>
					<td>${user.nickname}</td>
					<td>${user.mobile}</td>
					<td><javatime:format value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
			</c:forEach>

		</table>
	</div>
	<!-- end 一行 -->
	<!--end 中间-->



	<script>
		document.addEventListener("touchstart", function() {
		}, true);
	</script>


</body>
</html>