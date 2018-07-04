<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>查看全部评论</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
</head>
<body>
<!-- 中间 -->
<!-- 一行 -->
<a href="${ctx}wx/commodity/commodityDetail/${cid}" class="secmtitle"><i class="back_tico tico"></i>返回上一级</a>
<c:forEach items="${model}" var="u">
	<li class="comment">
		<div class="comment_mt">
			<div class="comment_avator"><img src="${u.member.iocUrl}" alt=""></div>
			<div class="comment_mtcont">
				<span class="itm">${u.member.nickname }</span><span class="itm">会员等级：<c:choose>
						<c:when test="${u.member.level==1}">竹语游客</c:when>  
						<c:when test="${u.member.level==2}">普通会员</c:when>  
						<c:when test="${u.member.level==3}">业务经理</c:when>  
						<c:when test="${u.member.level==4}">城市经理</c:when>  
						<c:when test="${u.member.level==5}">合作伙伴</c:when>  
				</c:choose></span>
			</div>
			<a href="###" class="secondlinebtn radiusbtn msbtn" onclick="jb()">举报</a>
			<!-- <a href="###" class="primarylinebtn radiusbtn msbtn">评论</a> -->
		</div>
		<div class="comment_mc">
			<p class="para">${u.content }</p>
		</div>
		<div class="comment_mb">
			<div class="comment_mbcont"><span class="date"><javatime:format value="${u.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></span></div>
			
			<span class="vitm"><span class="num">${u.commodity.browse /1000}</span>K浏览</span>
			<span class="vitm"><span class="num">${u.commodity.comment /1000}</span>K评论</span>
			<span class="vitm"><span class="num">${u.commodity.praise /1000}</span>K赞</span>
		</div>
	</li>
<!-- 	<li class="comment">
		<div class="comment_mt">
			<div class="comment_avator"><img src="images/portrait/50/01.jpg" alt=""></div>
			<div class="comment_mtcont">
				<span class="itm">麦田的那边</span><span class="itm">会员号：41651612</span>
			</div>
			<a href="###" class="secondlinebtn radiusbtn msbtn">举报</a>
			<a href="###" class="primarylinebtn radiusbtn msbtn">评论</a>
		</div>
		<div class="comment_mc">
			<p class="para">纸质很棒，是正品，还会来买的！</p>
		</div>
		<div class="comment_mb">
			<div class="comment_mbcont"><span class="date">2018-04-08  03:05:45</span></div>
			<span class="vitm"><span class="num">3.8K</span>浏览</span>
			<span class="vitm"><span class="num">2.1K</span>评论</span>
			<span class="vitm"><span class="num">2150</span>赞</span>
		</div>
	</li> -->
	<!-- <li class="comment">
		<div class="comment_mt">
			<div class="comment_avator"><img src="images/portrait/50/01.jpg" alt=""></div>
			<div class="comment_mtcont">
				<span class="itm">麦田的那边</span><span class="itm">会员号：41651612</span>
			</div>
			<a href="###" class="secondlinebtn radiusbtn msbtn">举报</a>
			<a href="###" class="primarylinebtn radiusbtn msbtn">评论</a>
		</div>
		<div class="comment_mc">
			<p class="para">纸质很棒，是正品，还会来买的！</p>
		</div>
		<div class="comment_mb">
			<div class="comment_mbcont"><span class="date">2018-04-08  03:05:45</span></div>
			<span class="vitm"><span class="num">3.8K</span>浏览</span>
			<span class="vitm"><span class="num">2.1K</span>评论</span>
			<span class="vitm"><span class="num">2150</span>赞</span>
		</div>
	</li> -->
</c:forEach>
<!-- end 一行 -->
<!--end 中间-->

<%@ include file="/common/wx/js.jsp"%>
<%@ include file="/common/wx/socket.jsp"%>

<script>
document.addEventListener("touchstart", function(){}, true);

function jb() {
	$.alert("举报成功!您真是火眼金睛,我们会尽快审核,感谢您对我们的支持!", "举报!");
}
</script>


</body>
</html>