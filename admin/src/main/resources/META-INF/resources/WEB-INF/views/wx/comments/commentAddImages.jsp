<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>商品评价（添加照片）</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
</head>
<body>
<!-- 中间 -->
<!-- 一行 -->
<div class="mbox">
	<!-- 一行 -->
	<div class="simplecutproitem">
		<div class="simplecutpro">
			<div class="simplecutpro_pic"><img src="images/pic/simplecutpro/01.jpg" alt=""></div>
			<span class="givescorebox">
				综合评价
				<i class="givescore">
					<i class="givescore_item"></i>
					<i class="givescore_item"></i>
					<i class="givescore_item"></i>
					<i class="givescore_item"></i>
					<i class="givescore_item"></i>
				</i>
			</span>
		</div>
	</div>
	<!-- end 一行 -->
	<!-- 一行 -->
	<div class="textintbox">
		<textarea placeholder="点击此处，说说它的优点与美中不足吧~" class="remark_textint textint"></textarea>
		<div class="picthumbs">
			<div class="picthumbitm"><img src="images/pic/picthumbs/01.jpg" alt=""></div>
			<div class="picthumbitm"><img src="images/pic/picthumbs/01.jpg" alt=""></div>
			<div onclick="pop('data/takephotocpop.html')" class="addpicthumbitm picthumbitm">
				<input type="file" class="hidel">
					<i class="takephoto_bsico bsico"></i>
					<p>添加图片</p>
			</div>
		</div>
	</div>
	<!-- end 一行 -->
</div>
<!-- end 一行 -->
<!--end 中间-->
<!-- 底部 -->
<div class="fbottom">
	<nav class="btool">
		<div class="btool_halfcont"><a href="###" class="primarybtn btoolbtn">确认评价</a></div>
	</nav>
</div>
<!--end 底部-->

<%@ include file="/common/wx/js.jsp"%>
<%@ include file="/common/wx/socket.jsp"%>
<!-- cpop -->
<div class="show cpop" id="takephotocpop">
	<div onclick="document.getElementById('takephotocpop').classList.remove('show');" class="fade_bkbg"></div>
	<div class="cpopcenter">
		<div class="noradius ntcpop_container">
			<i class="nobg pop_incloser" onclick="document.getElementById('takephotocpop').classList.remove('show');"></i>
			<div class="ac ntcpop_mc">
				<div class="tr"><a href="javascript:;" class="primarybtn mdbtn">从本地导入</a></div>
				<div class="tr"><a href="###" class="primarybtn mdbtn">相机拍摄</a></div>
			</div>
		</div>
	</div>
</div>
<!-- cpop -->

<%@ include file="/common/wx/js.jsp"%>
<%@ include file="/common/wx/socket.jsp"%>
<script src="js/tool.js"></script>


</body>
</html>