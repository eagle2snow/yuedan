<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>提现记录</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
</head>
<body>
	<ul class="mt16 addresslist">
		<c:forEach items="${list }" var='draw'>
			<li class="addressitem">
				<div class="addressitem_info">
					<span class="name">${draw.cardUser}</span> <span class="ins">${draw.amount}元</span>
				</div>
				<div class="addressitem_local">银行卡号：${draw.cardNo}</div>
				<div class="addressitem_mb">
					<div class="addressitem_sel">
						<c:choose>
							<c:when test="${draw.status==1}">待审核</c:when>
							<c:when test="${draw.status==2}">拒绝提现</c:when>
							<c:when test="${draw.status==3}">待打款</c:when>
							<c:when test="${draw.status==4}">已打款</c:when>
							<c:when test="${draw.status==5}">已作废</c:when>
						</c:choose>
						&nbsp;&nbsp;&nbsp;&nbsp;${draw.oprator}&nbsp;&nbsp;&nbsp;&nbsp;<br>						
 
						<c:if test="${not empty draw.dealDate}"><span>处理时间：${draw.dealDate}</span></c:if>
					</div>
					<c:if test="${draw.status==1 or draw.status==2}">
						<div class="addressitem_tool">
							<a href="javascript:void(0);" onclick="cancelDraw(${draw.id})"
								class="addressitem_edit">取消</a>
						</div>
					</c:if>


				</div>
			</li>
		</c:forEach>
	</ul>

	<!-- 底部 -->
	<div class="fbottom">
		<nav class="btool">
			<div class="btool_halfcont">
				<a href="${adp}toDraw" class="primarybtn btoolbtn">提&nbsp;现</a>
			</div>
		</nav>
	</div>
	<!--end 底部-->

	<%@ include file="/common/wx/js.jsp"%>
	<script>
		document.addEventListener("touchstart", function() {
		}, true);
		
		function cancelDraw(id){
			$.confirm("确定取消提现？", function() {
				$.getJSON('${adp}cancelDraw/'+id,function(res){
					if(res.s==1){
						$.toast("操作成功");
						re();
					}else if(res.s==2){
						$.alert('已审核，取消失败');
					}else{
						$.alert('系统有误，取消失败');
					}
				});
			}, function() {
			  //点击取消后的回调函数
			  });
		}
		
	</script>


</body>
</html>