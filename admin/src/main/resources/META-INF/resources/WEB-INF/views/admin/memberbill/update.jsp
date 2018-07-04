<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>会员账单修改 </title>

<%@ include file="/common/admin/head.jsp"%>
<%@ include file="/common/admin/datetimepic.jsp"%>

</head>

<body>
	<section class="content">
	<form class="form-horizontal" method="post" id="form-admin-add" action="${adp}update.json">
		<input type="hidden" name="id" value="${model.id}"/>	
			
					<div class="box-header with-border">
						<h3 class="box-title">编辑</h3>
					</div>
							<div class="form-group">
								<label class="col-sm-2 control-label"><i class="red">*</i>名称:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.name}"
							        placeholder="名称" id="name" name="name"/>
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
							 
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			                
							 
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			                
									<div class="form-group">
										<label class="col-sm-2 control-label">会员名字:</label>
										<div class="col-sm-8">
											<select name="member.id" style="width: 100% !important;" class="form-control select2" id="member">
												<c:forEach items="${memberList}" var="m">
													<option    ${model.member.id==m.id?'selected':'' }  value="${m.id}">
														${m.name}
													</option>
												</c:forEach> 
											</select>
									</div>
								</div>
							 
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">余额:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.balance}"
							        placeholder="余额" id="balance" name="balance"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
							 
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">余额来源:</label>
										<div class="col-sm-8">
											<input type="number" class="form-control" value="${model.pathway}"
								        	placeholder="余额来源" id="pathway" name="pathway" />
										</div>
								</div>
                        
			                
			                
			                
							 
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">获利总额:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.totalMoney}"
							        placeholder="获利总额" id="totalMoney" name="totalMoney"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
							 
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">账单总额:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.recordMoney}"
							        placeholder="账单总额" id="recordMoney" name="recordMoney"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
							 
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			                
							 
									<div class="form-group">
										<label class="col-sm-2 control-label">获利时间:</label>
										<div style="width:65.5%; padding-left: 17px; "  class="input-group date form_datetime1 col-md-5" data-date-format="yyyy-MM-dd HH:mm:ss"
											data-link-field="dtp_input1">
											<input style="background-color: white;"  class="form-control" type="text" placeholder="获利时间" id="gainTime" name="gainTime" readonly>
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-remove"></span>
											</span> 
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-th"></span>
											</span>
											<div>
											<input type="hidden" id="dtp_input1" value="" /><br />
									</div>
								</div>
							
							
							
							
						 	
                        
						
						
						
                        
                        
						
							
								<div class="box-body">
									<div class="form-group">
										<label class="col-sm-2 control-label">交易时间:</label>
										<div style="width:65.5%;  padding-left: 20px ;background-color: white;" class="input-group date form_datetime1 col-md-5" data-date-format="yyyy-MM-dd HH:mm:ss"
											data-link-field="dtp_input1">
											<input style="background-color: white;"  class="form-control" type="text" placeholder="交易时间" id="dealTime" name="dealTime" readonly>
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-remove"></span>
											</span> 
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-th"></span>
											</span>
											<div>
											<input type="hidden" id="dtp_input1" value="" /><br />
									</div>
								</div>
							
							
			                
							<div class="form-group" style="padding-left: 17px ;">
								<label class="col-sm-2 control-label">交易详情:</label>
								<div  class="col-sm-8">
									<input type="text" class="form-control" value="${model.details}"
							        placeholder="交易详情" id="details" name="details"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
							 
							
							
							
			                
							<div class="box-body">
							<div class="form-group">
								<label class="col-sm-2 control-label"></label>
								<div class="col-sm-8">
									<button type="submit" class="btn_sub btn btn-success">提交</button>
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
		
		var newDate = new Date();
	    var t       = newDate.toJSON(); 
		$('.form_datetime1').datetimepicker({
			weekStart : 0, //一周从哪一天开始
			todayBtn : 1, //
			autoclose : 1,
			todayHighlight : true,
			todayHighlight : 1,
			startView : 2,
			forceParse : 0,
			language : 'zh_CN',
			showMeridian : 1,
			format : 'yyyy-mm-dd HH:mm:ss',
			startDate:new Date(t)
		});
	
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
				 	$('#gainTime').val(time);
				 	$('#dealTime').val(time);
			},	
			callback : updateResult
		});
		
			
				 	var ue =  UE.getEditor('content');
		
				
				
				
				
				
				
				
				
				
				
	</script>	
	</body>
</html>
					
