<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>商品详情</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
</head>
<body>
	<!-- 中间 -->
	<!-- 一行 -->
	<div class="wbox">
		<!-- 一行 -->
		<div class="proinf">
			<div class="proinf_title">${model.name }</div>
			<div class="proinf_info">
				<ins class="ins">
					&yen;<span class="insm">${model.showPrice }</span>
				</ins>
			</div>
		</div>
		<!-- end 一行 -->
		<!-- 一行 -->
		<div class="profocus">
			<img src="${model.imgerPath }" alt="">
<!-- 			<div class="profocus_bdecs"> -->
<!-- 				<div class="wb"> -->
<!-- 					<i class="mr10 translate_bsico bsico"></i> -->
<!-- 					<div class="wbw">新疆、西藏补差15元新疆、西藏补差15元新疆、西藏补差15元</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
		</div>
		<!-- end 一行 -->
	</div>
	<!-- end 一行 -->
	<!-- 一行 -->
	<div class="wbox">
		<div class="boxmt">
			<div class="boxmt_cont">
				<h3 class="boxmtitle">评论（${model.comment}）</h3>
			</div>
			<a href="${ctx}wx/comments/allComments/${model.id }" class="boxmtmore">查看全部评论<i class="rgt"></i></a>
		</div>
		<ul class="nospactor_comments comments">
			<li class="comment">
				<div class="comment_mt">
					<div class="comment_avator">
						<img src="${model.code eq '1'? '/usr/static/img/ioc/213.jpg':'/usr/static/img/ioc/321.jpg'}" alt="">
					</div>
					<div class="comment_mtcont">
						<span class="itm">${model.code eq "1"? "飞翔的梦想":"紫萱"}</span>
<!-- 						<span class="itm"> -->
<!-- 							会员等级： -->
<%-- 							<c:choose> --%>
<%-- 									<c:when test="${member.level==1}">竹语游客</c:when>   --%>
<%-- 									<c:when test="${member.level==2}">普通会员</c:when>   --%>
<%-- 									<c:when test="${member.level==3}">业务经理</c:when>   --%>
<%-- 									<c:when test="${member.level==4}">城市经理</c:when>   --%>
<%-- 									<c:when test="${member.level==5}">合作伙伴</c:when>   --%>
<%-- 							</c:choose> --%>
						
<!-- 						</span> -->
					</div>
				</div>
				<div class="comment_mc">
					<p class="para">${model.code eq "1"? "酒很好喝，是正品，还会来买的！":"纸的质量还真不错，下次推荐朋友来购买！"}</p>

				</div>
				<div class="comment_mb">
					<div class="comment_mbcont">
<!-- 						<span class="date">2018-04-08 03:05:45</span> -->
						<span class="date">${date}</span>
					</div>
					<span class="vitm"><span class="num">${model.browse/1000}K</span>浏览</span> 
					<span class="vitm"><span class="num">${model.comment/1000}K</span>评论</span> 
					<span class="vitm"><span class="num">${model.praise}</span>赞</span>
				</div>
				
			</li>
		</ul>
	</div>
	<!-- end 一行 -->
	<!-- 一行 -->
	<div class="prodetail">
		<div class="pic">



			<c:forEach items="${fn:split(model.imgeListShow,'|')}" var='p'>
				<img src="${ctx }${p}" alt="">
			</c:forEach>
		</div>
	</div>
	<!-- end 一行 -->
	<!--end 中间-->
	<!-- 底部 -->
	<div class="fbottom">
		<nav class="btool">
			<div class="btool_halfcont">
				<a href="javascript:void(0);" onclick="addToCart(${model.id})"
					class="primarybtn btoolbtn">立&nbsp;即&nbsp;购&nbsp;买</a>
			</div>
		</nav>
	</div>
	<!--end 底部-->

	<%@ include file="/common/wx/js.jsp"%>
	<%@ include file="/common/wx/socket.jsp"%>

	<script>
		document.addEventListener("touchstart", function() {
		}, true);
		
		function addToCart(cid){
			$.getJSON('${adp}addToCart/'+cid+'/1',function(res){
				if(res.s=='ok'){
					$.toast("加入成功");
					setTimeout(function(){
						to('${adp}showCart');
					},300);
				}else{
					$.toast("加入失败", "cancel", function(toast) {
				        console.log(toast);
				    });
				}
			});
		}
		
		
		
	</script>


</body>
</html>