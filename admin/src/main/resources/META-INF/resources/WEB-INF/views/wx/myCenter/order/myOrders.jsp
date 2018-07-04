<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/wx/global.jsp"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>我的订单</title>
		<%@ include file="/common/wx/mate.jsp"%>
		<%@ include file="/common/wx/css.jsp"%>
	</head>

	<body>
		<!-- 中间 -->
		<!-- 一行 -->
		<nav class="tabhd">
			<ul class="equaitemline hasline shortabhd">
				<li ${status==0? 'class="on"': '' }>
					<a href="${adp}myOrders/0">全部</a>
				</li>
				<li ${status==1? 'class="on"': '' }>
					<a href="${adp}myOrders/1">待付款</a>
				</li>
				<li ${status==2? 'class="on"': '' }>
					<a href="${adp}myOrders/2">待发货</a>
				</li>
				<li ${status==11? 'class="on"': '' }>
					<a href="${adp}myOrders/11">已加急</a>
				</li>
				<li ${status==3? 'class="on"': '' }>
					<a href="${adp}myOrders/3">待收货</a>
				</li> 
				<li ${status==10? 'class="on"': '' }>
					<a href="${adp}myOrders/10">评价</a>
				</li>
			</ul>
		</nav>
		<!-- end 一行 -->
		<!-- 一行 -->
		<ul class="mt16 orderlist">
			<c:forEach items="${orders }" var='order'>
				<li  data-state="finish" class="orderitem">
					<div class="order_mt">
						<span class="t">订单号：${order.orderNo }</span>
						<div class="order_mtcont">
							<ins>
							&yen;<span class="insm">${order.totalMoney }</span>
						</ins>
						</div>
						<span class="state"> 
					<c:choose>
							<c:when test="${order.status eq 1 }">待付款</c:when>
							<c:when test="${order.status eq 2 }">待发货</c:when>
							<c:when test="${order.status eq 3 }">待收货</c:when>
							<c:when test="${order.status eq 11 }">待发货</c:when>
							<c:when test="${order.status eq 4 }">已收货</c:when>
							<c:when test="${order.status eq 5 }">退换货申请中</c:when>
							<c:when test="${order.status eq 6 }">退换申请通过待发货</c:when>
							<c:when test="${order.status eq 7 }">退换申请通过已发货</c:when>
							<c:when test="${order.status eq 8 }">退换货申请没有通过</c:when>
							<c:when test="${order.status eq 9 }">订单已退款</c:when>
							<c:when test="${order.status eq 10 }">订单已完成</c:when>
						</c:choose>

					</span>
					</div>
					<c:forEach items='${order.items }' var='item'>
						<div class="order_mc" ${item.appraise eq "1" and status==4? 'style="display:none"': ''}>
							<a href="###" class="cartpro">
								<div class="cartpro_pic">
									<img src="${item.imgerPath }" alt="">
								</div>
								<div class="cartpro_cont">
									<div class="cuth">${item.name }</div>
									<div class="cutd">规格：${item.specifications }</div>
									<div class="cutd"></div>
									<div class="cutd">

										<div class="cutdcont">
											数量：${item.buyCount }
										</div>
									<c:if test="${order.status==10 and item.appraise!='1'}">
											<span onclick="comments(${item.id})"  class="defaultlinebtn radiusbtn msbtn" ${item.appraise eq "1"? 'style="display:none"': ''} style="float: right;margin-right: 1rem;">即刻评价</span>
											<%-- <span onclick="toBackOrder(${order.id})" class="defaultlinebtn radiusbtn msbtn">申请售后</span> --%>
									</c:if>
									
									<c:if test="${order.status==10 and item.appraise=='1'}">
											<span onclick="lookAppraise()"  class="defaultlinebtn radiusbtn msbtn"  style="float: right;margin-right: 1rem;">查看评价</span>
											<%-- <span onclick="toBackOrder(${order.id})" class="defaultlinebtn radiusbtn msbtn">申请售后</span> --%>
									</c:if>
									
									</div>

								</div>
							</a>
						</div>
					</c:forEach>
				</li>
				<c:forEach items='${order.items }' var='item'>
				
				
				
				<li 
				<c:if test="${order.status==10 and item.appraise=='1'}">style="display:none;"</c:if>
				<c:if test="${order.status==1}" >style="display:none;"</c:if>
				<c:if test="${order.status==2}" >style="display:none;"</c:if>
				<c:if test="${order.status==11}" >style="display:none;"</c:if>
				<c:if test="${order.status==3}" >style="display:none;"</c:if>
				<c:if test="${order.status==10}" >style="display:none;"</c:if>
					  style="background-color: #fff;margin-bottom: 1rem;height: 2.5rem;margin-top: -1rem;padding-top: 0.5rem;">

					<c:if test="${order.status ne 1 and order.status ne 2 and order.status ne 4}">
						<%-- 						<span onclick="logisticsQuery(${order.id})" class="defaultlinebtn radiusbtn msbtn" style="margin-left: 45%;">查看物流</span> --%>
					</c:if>

					<c:if test="${order.status==9}">
						<span class="defaultlinebtn radiusbtn msbtn"  style="float: right;margin-right: 2rem;box-shadow: none;">退款成功</span>
					</c:if>
					
				

					<c:if test="${order.status==7}">
						<span class="defaultlinebtn radiusbtn msbtn" style="float: right;margin-right: 2rem;box-shadow: none;">待卖家收货</span>
					</c:if>

					<c:if test="${order.status==6}">
						<span <%-- onclick="exitGoods(${order.id})" --%>  class="defaultlinebtn radiusbtn msbtn" style="float: right;margin-right: 2rem;box-shadow: none;">待卖家发货</span>
					</c:if>

					<c:if test="${order.status==5}">
						<span class="defaultlinebtn radiusbtn msbtn" style="float: right;margin-right: 2rem;box-shadow: none;">退换货中</span>
					</c:if>

				<%-- 	<c:if test="${order.status==10 and item.appraise=='1' }">
						<span onclick="lookAppraise()"  class="defaultlinebtn radiusbtn msbtn" style="float: right;margin-right: 2rem;">查看评价</span>
					</c:if> --%>
				<%-- 	<c:if test="${order.status==10 and item.appraise!='1'}">
							<span   class="defaultlinebtn radiusbtn msbtn" style="float: right;margin-right: 2rem;box-shadow: none;">订单完成</span>
					</c:if> --%>
					

<%-- 					<c:if test="${order.status==10}"> --%>
<%-- 						<span  style="margin-left: 45%;" class="defaultlinebtn radiusbtn msbtn" ${item.appraise eq "1"? 'style="display:none"': ''}>订单完成</span> --%>
<%-- 					</c:if> --%>

				</c:forEach>

				<li  <c:if test="${order.status!=1}" >style="display:none;"</c:if> style="background-color: #fff;margin-bottom: 1rem;height: 2.5rem;margin-top: -1rem;padding-top: 0.5rem;"
					>
					<c:if test="${order.status==1}"> <span onclick="payMoney(${order.id})" class="defaultlinebtn radiusbtn msbtn" style="float: right;margin-right: 2rem;">马上付款</span>
						<span onclick="cancelOrder(${order.id})" class="defaultlinebtn radiusbtn msbtn" style="float: right;margin-right: 1rem;">取消订单</span>
					</c:if>
				</li>
				<li  <c:if test="${order.status!=2}" >style="display:none;"</c:if> style="background-color: #fff;margin-bottom: 1rem;height: 2.5rem;margin-top: -1rem;padding-top: 0.5rem;"
					>
					<c:if test="${order.status==2}">
						<span id="urgent" onclick="urgent(${order.id})" class="defaultlinebtn radiusbtn msbtn" style="float: right;margin-right: 2rem;" >给我加急</span>
					</c:if>
				</li>
				<li <c:if test="${order.status!=11}" >style="display:none;"</c:if> style="background-color: #fff;margin-bottom: 1rem;height: 2.5rem;margin-top: -1rem;padding-top: 0.5rem;"
					>
					<c:if test="${order.status==11}">
						<span class="defaultlinebtn radiusbtn msbtn" style="float: right;margin-right: 2rem;box-shadow: none;">加急中</span>
					</c:if>
				</li>
				<li <c:if test="${order.status!=3}" >style="display:none;"</c:if> style="background-color: #fff;margin-bottom: 1rem;height: 2.5rem;margin-top: -1rem;padding-top: 0.5rem;"
					>
						<c:if test="${order.status==3}">
						<span onclick="confirmGoods(${order.id})" class="defaultlinebtn radiusbtn msbtn" style="float: right;margin-right: 2rem;" >确认收货</span> 
						<span onclick="lookExpressage(${order.id})" class="defaultlinebtn radiusbtn msbtn" style="float: right;margin-right: 1rem;" >查看快递</span> 
					</c:if>
				</li>
					
				</li>
			</c:forEach>

		</ul>
		<!-- end 一行 -->
		<!--end 中间-->
		
		<div id="Popup" style="width: 100%;height: 100%;background: rgba(0,0,0,0.4);z-index: 99;position: fixed;top: 0;left: 0;display:none ;">
				<div style="width: 73%;height: 12.5rem;position: fixed;top:20%;left: 15%;">
				<ul>
				<li style="padding-left: 2rem;background: #8fbb26; height: 2.5rem;text-align: center;line-height: 2.5rem;color: #fff;font-size: 1.5rem;border-top-left-radius:5px;border-top-right-radius:5px;">查看快递
				<span id="off" style="float: right;padding-right: 1rem;">X</span></li>
				<li style="height: 4rem;background: #fff;padding-top: 1rem;">
					<span style="display: block;width: 31%;font-size: 2rem;margin-right: auto;margin-left: auto;width: 31%;">顺丰快递</span><br>
				</li>
				<li style="height: 5rem;background: #fff">
					<span style="display: block;font-size: 2rem;width: 63%;margin-left: auto;margin-right: auto;">51654619656164</span>
				</li>
				<li style="background: #fff;">
				<span id="Popup_off" style="line-height: 3rem;cursor: pointer;width: 100%;float: left;display:block;font-size: 1.8rem;text-align: center;height: 3rem;background:#8fbb26;color: #fff;">复制单号</span></li>
				</ul>
				</div>
			</div>
		

		<%@ include file="/common/wx/js.jsp"%>
		<%@ include file="/common/wx/socket.jsp"%>

	<script>
	
		
		//申请售后 1
		function toBackOrder(orderId){
			location.href='${adp}toBackOrder/'+orderId;
		}	
	
		document.addEventListener("touchstart", function() {
		}, true);
		
		//查看评价
		function lookAppraise(){ 
			$.confirm("确定查看评价么?", function() {
				  //点击确认后的回调函数
					location.href='${ctx}wx/myCenter/replyMessage/1';
				  }, function() {
				  //点击取消后的回调函数
				  });
		}
		
		//即刻评价 
		function comments(orderId){
			$.confirm("确定即刻评价么?", function() {
				  //点击确认后的回调函数
					location.href='${ctx}wx/comments/toCommondityComment/'+orderId;
				  }, function() {
				  //点击取消后的回调函数
				  });
		}
		
		//我要退货 
		function exitGoods(orderId){
			location.href="${ctx}wx/order/exitGoods/"+orderId
		}
		
		//确认收货 
		function confirmGoods(orderId){
// 			location.href="${ctx}wx/order/confirmGoods/"+orderId
			$.confirm("确认收货么?", function() {
			  //点击确认后的回调函数
				$.getJSON("${ctx}wx/order/confirmGoods/"+orderId,function (data){
					if(data.status == 1){
						$.alert(data.msg);
						re();
					}
						
				});
			  }, function() {
			  //点击取消后的回调函数
			  });
			
		}
		
		//给我加急
		function urgent(orderId){
			$.getJSON("${ctx}wx/order/urgent/"+orderId,function (data){
				$.alert(data.msg);
				if(data.status == 1){
					$("#urgent").text("已加急"); 
					re();
				}else{
					$.alert("网络出错，请稍后再试。");
					
				}
			});
		}
		
		//物流查询
		function logisticsQuery(orderId){
			location.href="${ctx}wx/order/logisticsQuery/"+orderId
		}
		
		//查看快递 
		function lookExpressage(orderId){
				$.getJSON("${ctx}/wx/myCenter/order/lookExpressage/"+orderId,function (data){
					$.alert({
						  title: '快递信息',
						  text: data.name,
						  onOK: function () {
						    //点击确认
						  }
						});
		});
		}
		
		//马上付款 1
		function payMoney(orderId){
			location.href="${ctx}wx/order/confirmOrder/"+orderId
		}
		
		//取消订单 1
		function cancelOrder(orderId){
			
			$.getJSON("${ctx}wx/order/cancelOrder/"+orderId,function (data){
				console.log(data);
				if(data.status == 1){
					layer.msg(data.msg,{icon:6});
					re();
				}
				if(data.status == 2){
					layer.msg(data.msg,{icon:5});
					re();
					
				}
			});
			
		}
	</script>
<script type="text/javascript">
$(document).ready(function(){
	  $("#Popup_off").click(function(){
	  $("#Popup").fadeToggle(500);
	  });
	  $("#off").click(function(){
		  $("#Popup").fadeToggle(500);
		  });
});
</script>

</body>
</html>