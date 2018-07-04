<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>订单表修改 </title>

<%@ include file="/common/admin/head.jsp"%>


</head>

<body>
	<section class="content">
	<form class="form-horizontal" method="post" id="form-admin-add" action="${adp}update.json">
		<input type="hidden" name="id" value="${model.id}"/>	
		<div class="row">
			<div class="col-md-12">
			
			<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">订单详情</h3>
					</div>
							<div class="form-group">
								<label class="col-sm-2 control-label"><i class="red">*</i>名称:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.name}"
							        placeholder="名称" id="name" name="name" datatype="*" errormsg="请输入名称"
							        style="border: none;" readonly="readonly"         />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">会员昵称:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.member.name}"
							        placeholder="openid" id="member" name="member" 
							        style="border: none;" readonly="readonly"          />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">订单总额:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.totalMoney}"
								        	placeholder="订单总额" id="totalMoney" name="totalMoney"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">邮费:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.postageMoney}"
								        	placeholder="邮费" id="postageMoney" name="postageMoney"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">订单状态:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.status}"
								        	placeholder="订单状态" id="status" name="status"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">订单备注:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.orderRemarks}"
							        placeholder="订单备注" id="orderRemarks" name="orderRemarks" 
							        style="border: none;" readonly="readonly"          />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			                
			                
								<!-- 	<div class="form-group">
										<label class="col-sm-2 control-label">付款时间:</label>
										<div class="col-sm-8">
											<input value="" id="paymentTime" name="paymentTime" type="hidden">
											<div class="auto-kal" data-kal="months: 2, direction: 'future'"></div>
										</div>
								</div> -->
							
							<div class="form-group">
								<label class="col-sm-2 control-label">付款时间:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.paymentTime}"
							        placeholder="付款时间" id="paymentTime" name="paymentTime"     
							        style="border: none;" readonly="readonly"      />
								</div>
							</div>
							
			                
                        
                        
						
						
                        
			                
			                
			                
			                	<div class="form-group">
									<label class="col-sm-2 control-label">发货时间:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" value="${model.shipmentsTime}"
								        placeholder="发货时间" id="shipmentsTime" name="shipmentsTime"       
								        style="border: none;" readonly="readonly"    />
									</div>
								</div>
									<%-- <div class="form-group">
										<label class="col-sm-2 control-label">发货时间:</label>
										<div class="col-sm-8">
											<input type="text" value="${model.shipmentsTime}" placeholder="发货时间" id="shipmentsTime" name="shipmentsTime" 
												style="border: none;" readonly="readonly" />		
										</div>
								</div> --%>
							
							
							
			                
                        
                        
						
						
                        
			                
			                
				                
				                <div class="form-group">
									<label class="col-sm-2 control-label">收货时间:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" value="${model.receivingTime}"
								        placeholder="收货时间" id="receivingTime" name="receivingTime"       
								        style="border: none;" readonly="readonly"    />
									</div>
								</div>
								<!-- 	<div class="form-group">
										<label class="col-sm-2 control-label">收货时间:</label>
										<div class="col-sm-8">
											<input value="" id="receivingTime" name="receivingTime" type="hidden">
											<div class="auto-kal" data-kal="months: 2, direction: 'future'"></div>
										</div>
								</div> -->
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			                		<div class="form-group">
									<label class="col-sm-2 control-label">退货申请时间:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" value="${model.applyForTime}"
								        placeholder="退货申请时间" id="applyForTime" name="applyForTime"       
								        style="border: none;" readonly="readonly"    />
									</div>
								</div>
			                
								<!-- 	<div class="form-group">
										<label class="col-sm-2 control-label">退货申请时间:</label>
										<div class="col-sm-8">
											<input value="" id="applyForTime" name="applyForTime" type="hidden">
											<div class="auto-kal" data-kal="months: 2, direction: 'future'"></div>
										</div>
								</div> -->
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			                	<div class="form-group">
									<label class="col-sm-2 control-label">退货审核时间:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" value="${model.checkTime}"
								        placeholder="退货审核时间" id="checkTime" name="checkTime"       
								        style="border: none;" readonly="readonly"    />
									</div>
								</div>
			                
								<!-- 	<div class="form-group">
										<label class="col-sm-2 control-label">退货审核时间:</label>
										<div class="col-sm-8">
											<input value="" id="checkTime" name="checkTime" type="hidden">
											<div class="auto-kal" data-kal="months: 2, direction: 'future'"></div>
										</div>
								</div> -->
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			                		<div class="form-group">
									<label class="col-sm-2 control-label">退货发货时间:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" value="${model.buyerDshipmentsTime}"
								        placeholder="退货发货时间" id="buyerDshipmentsTime" name="buyerDshipmentsTime"       
								        style="border: none;" readonly="readonly"    />
									</div>
								</div>
			                
								<!-- 	<div class="form-group">
										<label class="col-sm-2 control-label">退货发货时间:</label>
										<div class="col-sm-8">
											<input value="" id="buyerDshipmentsTime" name="buyerDshipmentsTime" type="hidden">
											<div class="auto-kal" data-kal="months: 2, direction: 'future'"></div>
										</div>
								</div> -->
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			                	<div class="form-group">
									<label class="col-sm-2 control-label">退款时间:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" value="${model.refundTime}"
								        placeholder="退款时间" id="refundTime" name="refundTime"       
								        style="border: none;" readonly="readonly"    />
									</div>
								</div>
			                <!-- 
									<div class="form-group">
										<label class="col-sm-2 control-label">退款时间:</label>
										<div class="col-sm-8">
											<input value="" id="refundTime" name="refundTime" type="hidden">
											<div class="auto-kal" data-kal="months: 2, direction: 'future'"></div>
										</div>
								</div>
							 -->
							
							
			                
                        
                        
						
						
                        
			                
			                
			                	  	<div class="form-group">
									<label class="col-sm-2 control-label">订单完成时间:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" value="${model.finishTime}"
								        placeholder="订单完成时间" id="finishTime" name="finishTime"       
								        style="border: none;" readonly="readonly"    />
									</div>
								</div>
			                
								<!-- 	<div class="form-group">
										<label class="col-sm-2 control-label">订单完成时间:</label>
										<div class="col-sm-8">
											<input value="" id="finishTime" name="finishTime" type="hidden">
											<div class="auto-kal" data-kal="months: 2, direction: 'future'"></div>
										</div>
								</div> -->
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">发货快递:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.expressName}"
							        placeholder="发货快递" id="expressName" name="expressName" 
							        style="border: none;" readonly="readonly"          />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">退款金额:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.orderRefundTime}"
								        	placeholder="退款金额" id="orderRefundTime" name="orderRefundTime"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">发货快递单号:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.expressNo}"
							        placeholder="发货快递单号" id="expressNo" name="expressNo"
							        style="border: none;" readonly="readonly"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">退款理由:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.refundReason}"
							        placeholder="退款理由" id="refundReason" name="refundReason" 
							        style="border: none;" readonly="readonly"          />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">退货上传图片:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.imageUrl}"
							        placeholder="退货上传图片" id="imageUrl" name="imageUrl" 
							        style="border: none;" readonly="readonly"          />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">拒绝退款:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.rejectReason}"
							        placeholder="拒绝退款" id="rejectReason" name="rejectReason" 
							        style="border: none;" readonly="readonly"          />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">退货快递:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.refundExpressName}"
							        placeholder="退货快递" id="refundExpressName" name="refundExpressName" 
							        style="border: none;" readonly="readonly"          />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">退货快递单号:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.refundExpressNo}"
							        placeholder="退货快递单号" id="refundExpressNo" name="refundExpressNo" 
							        style="border: none;" readonly="readonly"          />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">一级分销提成:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.firstLevelBrokerage}"
								        	placeholder="一级分销提成" id="firstLevelBrokerage" name="firstLevelBrokerage"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">二级分销提成:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.secondLevelBrokerage}"
								        	placeholder="二级分销提成" id="secondLevelBrokerage" name="secondLevelBrokerage"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">支付方式:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.payPathway}"
								        	placeholder="支付方式" id="payPathway" name="payPathway"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">是否已评价:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.appraise}"
								        	placeholder="是否已评价" id="appraise" name="appraise"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
                        
			                
			                	 	<div class="form-group">
									<label class="col-sm-2 control-label">评价时间:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" value="${model.appraiseTime}"
								        placeholder="评价时间" id="appraiseTime" name="appraiseTime"       
								        style="border: none;" readonly="readonly"    />
									</div>
								</div>
			                
			                <!-- 
									<div class="form-group">
										<label class="col-sm-2 control-label">评价时间:</label>
										<div class="col-sm-8">
											<input value="" id="appraiseTime" name="appraiseTime" type="hidden">
											<div class="auto-kal" data-kal="months: 2, direction: 'future'"></div>
										</div>
								</div> -->
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">商家备注:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.businessRemarks}"
							        placeholder="商家备注" id="businessRemarks" name="businessRemarks" 
							        style="border: none;" readonly="readonly"          />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">退款备注:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.refundRemarks}"
							        placeholder="退款备注" id="refundRemarks" name="refundRemarks" 
							        style="border: none;" readonly="readonly"          />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">支付宝交易号:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.alipayNumber}"
							        placeholder="支付宝交易号" id="alipayNumber" name="alipayNumber" 
							        style="border: none;" readonly="readonly"          />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">微信交易号:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.wxNumber}"
							        placeholder="微信交易号" id="wxNumber" name="wxNumber"
							        style="border: none;" readonly="readonly"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="box-body">
							<div class="form-group">
								<label class="col-sm-2 control-label"></label>
								<div class="col-sm-8">
									<!-- <button type="submit" class="btn_sub btn btn-success">提交</button> -->
									<button type="button" onClick="closeAll();" class="btn_reset btn btn-primary">关闭</button>
								</div>
							</div>
						</div>
				</div>
					<!--end .box .box-info -->
				
					</div> 
					<!--end .col-md-12-->
				</div>
				 <!-- end .row -->
	</form>
</section>	
			<%@ include file="/common/admin/my_js.jsp"%>
				 

	<script>
		 $(".form-horizontal").Validform({
			btnSubmit: ".btn_sub",
			btnReset: ".btn_reset",
			tiptype: 3,
			ignoreHidden: false,
			dragonfly: false,
			tipSweep: true,
			label: ".label",
			showAllError: false,
			postonce: true,
			ajaxPost: true,

			beforeCheck: function (curform) {
				//在表单提交执行验证之前执行的函数，curform参数是当前表单对象。
				//这里明确return false的话将不会继续执行验证操作;	
			},
			beforeSubmit: function (curform) {
				//在验证成功后，表单提交前执行的函数，curform参数是当前表单对象。
				//这里明确return false的话表单将不会提交;
				var time = $('.auto-kal');
				 	$('#paymentTime').val(time);
				 	$('#shipmentsTime').val(time);
				 	$('#receivingTime').val(time);
				 	$('#applyForTime').val(time);
				 	$('#checkTime').val(time);
				 	$('#buyerDshipmentsTime').val(time);
				 	$('#refundTime').val(time);
				 	$('#finishTime').val(time);
				 	$('#appraiseTime').val(time);
			},	
			callback : updateResult
		});
		
			
		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	</script>	
	</body>
</html>
					
