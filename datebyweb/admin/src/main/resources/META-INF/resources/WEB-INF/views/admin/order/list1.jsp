<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>订单表-发货 </title>

<%@ include file="/common/admin/head.jsp"%>
<style type="text/css">
#Popup{

}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">

		<%@ include file="/common/admin/header.jsp"%>
		<%@ include file="/common/admin/left.jsp"%>
		
		<div class="content-wrapper">
		<div id="bzid" style="display: none">123</div>
		<!-- Main content -->
		<section class="content">
		
			<div class="row">
				<!-- left column -->
				<div class="col-md-12">
				
					<!-- Horizontal Form -->
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">发货管理</h3>
						</div>
						<!-- /.box-header -->
						<div class="box">
							
							<!-- /.box-header -->
							<div class="box-body">
								<!--搜索框-->
								<div class="row">
									<div class="col-sm-6">
										<div class="cl pd-5 bg-1 bk-gray mt-20">
											<span class="l"><a href="javascript:;"
												onclick="delByIds('${adp}')" class="btn btn-danger radius"><i
													class="glyphicon glyphicon-trash"></i> 批量删除</a> <%-- <button
													onclick="openPerRe('添加',90,90,'${adp}add.htm')"
												class="btn btn-primary radius"><i class="glyphicon glyphicon-plus"></i>
													添加</button> --%></span> <span class="r">共有数据：<strong id="count">${page.count}</strong> 条
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
								</div>
								<!--表单数据-->
								<table  class="table table-bordered table-striped">
									<thead>
									
										<tr>
											<th width="25"><input  name="checkAll" class="minimal" type="checkbox"></th>
											<th >订单号</th>
											<!-- <th>名称</th> -->
											<th>订单状态</th>
											<th>收货人名字</th>
											<th>收货人电话</th>
											<th>收货人地址</th>
											<th>会员名字</th>
											<th>订单总额</th>
											<!-- <th>邮费</th> -->
											<!-- <th>支付方式</th> -->
											<th>用户备注</th>
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
											<th>商家备注</th>
											<!-- <th>退款备注</th> -->
											<!-- <th>支付宝交易号</th>
											<th>微信交易号</th> -->
											<th width="130">创建时间</th>
											<!-- <th width="100">状态</th> -->
											<th width="150">详情 | 发货 | 备注</th>
										</tr>
									</thead>
									<tbody>
									
										<c:forEach items="${page.list}" var="model">
										<tr>
											<td><input type="checkbox" class="minimal" name="ids" value="${model.id}"></td>
											<td>${model.orderNo}</td>
											
											 <%-- <th>${model.name}</th> --%>
											
											 <th width="100">
												<c:if test="${model.status == '2'}">待发货</c:if>
												<c:if test="${model.status == '11'}">加急</c:if>
												<%-- <c:if test="${model.status == '1'}">待付款</c:if>
												<c:if test="${model.status == '3'}">待收货</c:if>
												<c:if test="${model.status == '4'}">已收货</c:if>
												<c:if test="${model.status == '5'}">退换货申请中</c:if>
												<c:if test="${model.status == '6'}">退换货申请通过，待买家发货</c:if>
												<c:if test="${model.status == '7'}">退换货申请通过，买家已发货</c:if>
												<c:if test="${model.status == '8'}">退换货申请不通过</c:if>
												<c:if test="${model.status == '9'}">订单已退款</c:if>
												<c:if test="${model.status == '10'}">订单已完成</c:if> --%>
											 </th>
											 <th>${model.memberAddress.name}</th>
											 <th>${model.memberAddress.mobile}</th>
											 <th>${model.memberAddress.pca} &nbsp; ${model.memberAddress.address}</th>
											 <th>${model.member.name}</th>
											
											 <th>${model.totalMoney}</th>
											
											 <%-- <th>${model.postageMoney}</th> --%>
											
											 <%-- <th>${model.payPathway eq 1 ? "微信":"支付宝"}</th> --%>
											
											 <th>${model.orderRemarks}</th>
											
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
											
											 <th>${model.businessRemarks}</th>
											
											<%--  <th>${model.refundRemarks}</th> --%>
											
											 <%-- <th>${model.alipayNumber}</th>
											
											 <th>${model.wxNumber}</th> --%>
											
											<td><javatime:format value="${model.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
											<%-- <td class="td-status">
														<div class="switch switchevent" data-on="primary"
															lang="${model.id}" title="${model.enable}"
															data-on-label="开" data-off-label="关" data-off="info">
										 					<input type="checkbox" ${(model.enable==1)?'checked':'' }
																class="swbtn" />
														</div>
											</td> --%>
											<td>
												<button onclick="details(${model.id})" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-list" title="详情"></i></button>
												<button onclick="ok(${model.id})"  class="btn btn-sm btn-success"><i class="glyphicon glyphicon-ok" title="确认发货"></i></button>
												<button onclick="bz(${model.id})" class="btn btn-sm btn-info"  ><i class="glyphicon glyphicon-list-alt" title="备注"></i></button>
											</td>
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
		<%@ include file="/common/admin/footer.jsp"%>
		<%@ include file="/common/admin/right.jsp"%>
		<%@ include file="/common/admin/my_js.jsp"%>

		<div class="control-sidebar-bg"></div>
		
		
	</div>
	
			<div id="Popup" style="width: 100%;height: 100%;background: rgba(0,0,0,0.4);z-index: 99;position: fixed;top: 0;left: 0;display:none ;">
				<div style="width: 300px;height: 200px;position: fixed;top:40%;left: 40%;">
				<ul>
				<li style="background: #3c8dbc; height: 40px;text-align: center;line-height: 45px;color: #fff;font-size: 16px;border-top-left-radius:5px;border-top-right-radius:5px;">请输入备注</li>
				<li style="height: 131px;width:300px;background: #fff">
				<textarea id="area" style="padding-top: 5px;height: 100px;width: 250px;margin-left: 8%;margin-top: 4%;padding-left:10px;font-size: 16px; "></textarea>
				<p style="float: left;position: relative;top: -20px;left: 220px;"><span id="text-count">50</span>/50</p>
				</li>
				<li style="background: #fff;">
				<span style="line-height: 40px;cursor: pointer;display:block;font-size: 18px;text-align: center;float: left;width: 150px;border-right: 1px solid #ccc;height: 40px;background:#3c8dbc;color: #fff;" onclick="bzs()">确定</span>
				<span id="Popup_off" style="line-height: 40px;cursor: pointer;width: 150px;float: left;display:block;font-size: 18px;text-align: center;border-left: 1px solid #ccc;height: 40px;background:#3c8dbc;color: #fff;">取消</span></li>
				</ul>
				</div>
			</div>



	<div id="Popup1" style="width: 100%;height: 100%;background: rgba(0,0,0,0.4);z-index: 99;position: fixed;top: 0;left: 0;display:none;">
				<div style="width: 340px;height: 200px;position: fixed;top:40%;left: 40%;">
				<ul>
				<li style="background: #3c8dbc; height: 40px;text-align: center;line-height: 45px;color: #fff;font-size: 16px;border-top-left-radius:5px;border-top-right-radius:5px;">请输入备注</li>
				<li style="height: 50px;width:340px;background: #fff;padding-left: 8%;padding-top: 4%;">
				<span style="font-size: 16px;">快递公司</span><input id="company" type="text" style="margin-left: 2%;padding-left: 5px;width: 210px;height: 30px;">
				</li>
				<li style="height: 50px;width:340px;background: #fff;padding-left: 8%;padding-top: 2%;">
				<span style="font-size: 16px;">快递单号</span><input id="Order" type="text" style="margin-left: 2%;padding-left: 5px;width: 210px;height: 30px;">
				</li>
				<li style="background: #fff;">
				<span style="line-height: 40px;cursor: pointer;display:block;font-size: 18px;text-align: center;float: left;width: 170px;border-right: 1px solid #ccc;height: 40px;background:#3c8dbc;color: #fff;" onclick="oks()">确定</span>
				<span id="Popup_off1" style="line-height: 40px;cursor: pointer;width: 170px;float: left;display:block;font-size: 18px;text-align: center;border-left: 1px solid #ccc;height: 40px;background:#3c8dbc;color: #fff;">取消</span></li>
				</ul>
				</div>
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
		
		
		/* function ok(id){
		
				openPerRe("编辑订单表", 90,90,'${adp}update/'+id+'.htm');
				$("#okid").text(id);
				  document.getElementById('Popup1').style.display = '';
		
			
		} */
		function details(id){
		
				openPerRe("编辑订单表", 90,90,'${adp}details1/'+id+'.htm');
		
			
		}
		
		function del(id){
			delById(id, '${adp}'); 
		}
		
		function ok(id){
				  //alert(id);
				  $("#bzid").text(id);
				  document.getElementById('Popup1').style.display = '';
		}
		function oks(){
				  //alert(id);
				 // alert($("#company").val());
				  //alert($("#Order").val());
			 $.ajax({
	             type: "POST",
	             url: "${ctx}admin/order/updateExpress",
	             data: {id:$("#bzid").text(), express:$("#company").val(), numbers:$("#Order").val()},
	             dataType: "json",
	             success: function(data){
	                         if(data == 0){
	                        	$("#company").val("");
	           				    $("#Order").val("");
	                        	 window.location.reload();
	                         }
	         },
	    
});
		}
		function bz(id){
				  //alert(id);
				  $("#bzid").text(id);
				  document.getElementById('Popup').style.display = '';
		}
		function bzs(){
				   $.ajax({
			             type: "POST",
			             url: "${ctx}admin/order/updateNotes",
			             data: {id:$("#bzid").text(), content:$("#area").val()},
			             dataType: "json",
			             success: function(data){
			                         if(data == 0){
			                        	 $("#area").val("");
			                        	 window.location.reload();
			                         }
			         },
			    
		});
			
		}	
		
		
		//开关回调
		/* var enableFun = function(){
		} */
 		$(document).ready(function(){
			  $("#Popup_off").click(function(){
			  $("#area").val("");
			  $("#Popup").fadeToggle(1000);
			  });
			  
			  $("#area").on("input propertychange", function() {  
			        var $this = $(this),  
			            _val = $this.val(),  
			            count = "";  
			        if (_val.length > 50) {  
			            $this.val(_val.substring(0, 50));  
			        }  
			        count = 50 - $this.val().length;  
			        $("#text-count").text(count);  
			    });  
			  $("#Popup_off1").click(function(){
				  $("#Order").val("");
				  $("#company").val("");
				  $("#Popup1").fadeToggle(1000);
				  });
				  
			});

		</script>
	</body>

</html>