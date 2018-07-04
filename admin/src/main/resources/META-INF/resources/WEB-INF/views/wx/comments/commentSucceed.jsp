<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>商品评价（成功）</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
</head>
<body>
<!-- 中间 -->
<!-- 一行 -->
<div class="ntpage">
	<div class="ntpage_cartoon"><i class="bs_success_ntico ntico"></i></div>
	<div class="ntpage_dt">评价成功，感谢您的支持~</div>
	<div class="ntpage_foot"><a href="${ctx}wx/myCenter/replyMessage/1" class="butxt">点击前往评价列表&nbsp;&gt;</a></div>
</div>
<!-- end 一行 -->
<!--end 中间-->
<!-- 底部 -->
<div class="fbottom">
	<nav class="btool">
		<div class="btool_halfcont"><a href="${ctx}wx/index" class="primarybtn btoolbtn">继续购物</a></div>
	</nav>
</div>
<!--end 底部-->

<%@ include file="/common/wx/js.jsp"%>
<%@ include file="/common/wx/socket.jsp"%>


<script>
document.addEventListener("touchstart", function(){}, true);
</script>


</body>
</html>