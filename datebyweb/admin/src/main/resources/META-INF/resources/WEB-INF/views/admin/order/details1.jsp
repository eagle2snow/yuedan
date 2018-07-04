<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>订单表详情-发货 </title>

<%@ include file="/common/admin/head.jsp"%>


</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		
		<div class="content-wrapper" style="margin-left: 0">
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<!-- left column -->
				<div class="col-md-12">
					<!-- Horizontal Form -->
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">订单详情</h3>
						</div>
						<!-- /.box-header -->
						<div class="box">
							
							<!-- /.box-header -->
							<div class="box-body">
								<!--搜索框-->
								<%-- <div class="row">
									<div class="col-sm-6">
										<div class="cl pd-5 bg-1 bk-gray mt-20">
											<span class="l"><a href="javascript:;"
												onclick="delByIds('${adp}')" class="btn btn-danger radius"><i
													class="glyphicon glyphicon-trash"></i> 批量删除</a> <button
													onclick="openPerRe('添加',90,90,'${adp}add.htm')"
												class="btn btn-primary radius"><i class="glyphicon glyphicon-plus"></i>
													添加</button></span> <span class="r">共有数据：<strong id="count">${page.count}</strong> 条
											</span>
										</div>
									</div>
									<div class="col-sm-6">
										<div id="example1_filter" class="dataTables_filter">
											<div class="text-c">
												<input type="text" name="" id="key" placeholder="名称、介绍等"
													onkeypress="if(event.keyCode==13) {btn.click();return false;}"
													value='${key}' style="width: 250px;height:33px" class="input-text">
												<button name="" id="btn" class="btn btn-success" type="submit"
													onclick="getData(1)">
													<i class="glyphicon glyphicon-search"></i> 搜索
												</button>
											</div>
										</div>
									</div>
								</div> --%>
								<!--表单数据-->
								<table  class="table table-bordered table-striped">
									<thead>
									
										<tr>
											<!-- <th width="25"><input  name="checkAll" class="minimal" type="checkbox"></th> -->
											<th >订单项号</th>
											<!-- <th>名称</th> -->
											<!-- <th>订单状态</th> -->
											<th>会员昵称</th>
											<th>名称</th>
											<th>图片</th>
											<th>价格</th>
											<th>数量</th>
											<th>规格</th>
											<!-- <th>订单总额</th> -->
											<!-- <th>邮费</th> -->
											<!-- <th>支付方式</th> -->
											<!-- <th>用户备注</th> -->
											<!-- <th>付款时间</th>
											<th>发货时间</th>
											<th>收货时间</th>
											<th>退货申请时间</th>
											<th>退货审核时间</th>
											<th>退货发货时间</th>
											<th>退款时间</th>
											<th>订单完成时间</th> -->
											<!-- <th>发货快递</th> -->
											<!-- <th>退款金额</th> -->
											<!-- <th>发货快递单号</th> -->
											<!-- <th>退款理由</th> -->
											<!-- <th>退货上传图片</th> -->
											<!-- <th>拒绝退款</th> -->
											<!-- <th>退货快递</th> -->
											<!-- <th>退货快递单号</th> -->
											<!-- <th>一级分销提成</th>
											<th>二级分销提成</th> -->
											<!-- <th>是否已评价</th> -->
											<!-- <th>评价时间</th> -->
											<!-- <th>商家备注</th> -->
											<!-- <th>退款备注</th> -->
											<!-- <th>支付宝交易号</th>
											<th>微信交易号</th> -->
											<!-- <th width="130">创建时间</th> -->
											<!-- <th width="100">状态</th> -->
											<!-- <th width="150">操作</th> -->
										</tr>
									</thead>
									<tbody>
									
										<c:forEach items="${models}" var="model">
										<tr>
											<%-- <td><input type="checkbox" class="minimal" name="ids" value="${model.id}"></td> --%>
											<td>${model.id}</td>
											<td>${model.order.member.name}</td>
											<td>${model.name}</td>
											<td ><img alt="" src="${model.imgerPath}" width="100" height="100"></td>
											<td>${model.showPrice}</td>
											<td>${model.buyCount}</td>
											<td>${model.specifications}</td>
											
											 <%-- <th>${model.name}</th> --%>
											
											 <%-- <th width="100">
												<c:if test="${model.status == '0'}">待付款</c:if>
												<c:if test="${model.status == '1'}">待发货</c:if>
												<c:if test="${model.status == '2'}">待收货</c:if>
												<c:if test="${model.status == '3'}">已收货</c:if>
												<c:if test="${model.status == '4'}">退换货申请中</c:if>
												<c:if test="${model.status == '5'}">退换货申请通过，待买家发货</c:if>
												<c:if test="${model.status == '6'}">退换货申请通过，买家已发货</c:if>
												<c:if test="${model.status == '7'}">退换货申请不通过</c:if>
												<c:if test="${model.status == '8'}">订单已退款</c:if>
												<c:if test="${model.status == '9'}">订单已完成</c:if>
											 </th> --%>
											 <%-- <th>${model.member.name}</th>
											
											 <th>${model.totalMoney}</th> --%>
											
											 <%-- <th>${model.postageMoney}</th> --%>
											
											 <%-- <th>${model.payPathway eq 1 ? "微信":"支付宝"}</th>
											
											 <th>${model.orderRemarks}</th> --%>
											
											<%--  <th>${model.paymentTime}</th>
											
											 <th>${model.shipmentsTime}</th>
											
											 <th>${model.receivingTime}</th>
											
											 <th>${model.applyForTime}</th>
											
											 <th>${model.checkTime}</th>
											
											 <th>${model.buyerDshipmentsTime}</th>
											
											 <th>${model.refundTime}</th>
											
											 <th>${model.finishTime}</th> --%>
											
											<%--  <th>${model.expressName}</th> --%>
											
											 <%-- <th>${model.orderRefundTime}</th> --%>
											
											 <%-- <th>${model.expressNo}</th> --%>
											
											 <%-- <th>${model.refundReason}</th> --%>
											
											<%--  <th>${model.imageUrl}</th>
											
											 <th>${model.rejectReason}</th> --%>
											
											 <%-- <th>${model.refundExpressName}</th> --%>
											
											<%--  <th>${model.refundExpressNo}</th> --%>
											
											 <%-- <th>${model.firstLevelBrokerage}</th>
											
											 <th>${model.secondLevelBrokerage}</th> --%>
											
											
											 <%-- <th>${model.appraise eq 1 ? "已评价":"未评价"}</th> --%>
											
											 <%-- <th>${model.appraiseTime}</th> --%>
											
											 <%-- <th>${model.businessRemarks}</th> --%>
											
											<%--  <th>${model.refundRemarks}</th> --%>
											
											 <%-- <th>${model.alipayNumber}</th>
											
											 <th>${model.wxNumber}</th> --%>
											
											<%-- <td><javatime:format value="${model.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td> --%>
											<%-- <td class="td-status">
														<div class="switch switchevent" data-on="primary"
															lang="${model.id}" title="${model.enable}"
															data-on-label="开" data-off-label="关" data-off="info">
										 					<input type="checkbox" ${(model.enable==1)?'checked':'' }
																class="swbtn" />
														</div>
											</td> --%>
											<%-- <td>
												<button onclick="details(${model.id})" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-list" title="详情"></i></button>
												<button onclick="ok(${model.id})"  class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-ok" title="确认发货"></i></button>
												<button onclick="del(${model.id})" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-tag" title="备注"></i></button>
											</td> --%>
										</tr>
										</c:forEach>
										
									</tbody>
								</table>
								<!--分页-->
								<div class="row">
									<div id="page" class="text-c mt-10"></div>
								</div>

							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->

					</div>
					<!-- /.box -->
				</div>
			</div>
		</section>
		</div>
		<%-- <%@ include file="/common/admin/footer.jsp"%> --%>
		<%@ include file="/common/admin/right.jsp"%>
		<%@ include file="/common/admin/my_js.jsp"%>

		<div class="control-sidebar-bg"></div>
	</div>

		<script>
			$(function() {
				$("#example1").DataTable();
				$("#key").focus();
			});
			
		laypage({
		  cont: 'page',
		  skin: 'yahei',
		  groups: 10,
		  first: '首页', 
		  last: '尾页',
		  prev: '<', //若不显示，设置false即可
		  next: '>', //若不显示，设置false即可
		  pages: ${page.countPage}, 
		  curr: function(){
		    var page = ${page.indexPage};
		    return page;
		  }(), 
		  jump: function(e, first){ //触发分页后的回调
		    if(!first){ //一定要加此判断，否则初始时会无限刷新
		    	getData(e.curr);
		    }
		  }
		});
		
		
		function getData(indexPage){
			  var k = $("#key").val();
		      location.href = '${adp}list/'+indexPage+'/${page.sizePage}.htm?k='+k;
		}
		
		
		function ok(id){
		
				openPerRe("编辑订单表", 90,90,'${adp}update1/'+id+'.htm');
		
			
		}
		function details(id){
		
				openPerRe("编辑订单表", 90,90,'${adp}details1/'+id+'.htm');
		
			
		}
		
		function del(id){
			delById(id, '${adp}'); 
		}
		
		//开关回调
		/* var enableFun = function(){
		} */
		
		

		</script>
	</body>

</html>