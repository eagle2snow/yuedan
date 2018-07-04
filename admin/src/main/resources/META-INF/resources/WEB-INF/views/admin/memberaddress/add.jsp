<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>会员收货地址新增 </title>

<%@ include file="/common/admin/head.jsp"%>

</head>

<body>
	<section class="content">
	<form class="form-horizontal" method="post" id="form-admin-add" action="${adp}add.json">
		<div class="row">
			<div class="col-md-12">
			
			<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">添加</h3>
					</div>
						 	
							<div class="box-body">
								<div class="form-group">
									<label class="col-sm-2 control-label"><i class="red">*</i>收货人:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" 
								        placeholder="名称" id="name" name="name" datatype="*" errormsg="请输入名称"         />
									</div>
								</div>
							</div>	
                        
						
							
							
							
							
							
						 	
                        
						
						
						
                        
                        
						
								<div class="box-body">
									<div class="form-group">
										<label class="col-sm-2 control-label">所属会员:</label>
										<div class="col-sm-8">
											<select name="member.id" style="width: 100% !important;" class="form-control select2" id="member">
												<c:forEach items="${memberList}" var="m">
												
													<option value="${m.id}">
														${m.name}
													</option>
												</c:forEach> 
											</select>
										</div>
									</div>
								</div>
							
							
							
							
							
						 	
							<div class="box-body">
								<div class="form-group">
									<label class="col-sm-2 control-label">手机号:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" 
								        placeholder="手机号" id="mobile" name="mobile"           />
									</div>
								</div>
							</div>	
                        
						
						
						
                        
                        
						
							
							
							
							
							
						 	
							<div class="box-body">
								<div class="form-group">
									<label class="col-sm-2 control-label">固话:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" 
								        placeholder="固话" id="phone" name="phone"           />
									</div>
								</div>
							</div>	
                        
						
						
						
                        
                        
						
							
							
							
							
							
						 	
							<div class="box-body">
								<div class="form-group">
									<label class="col-sm-2 control-label">邮编:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" 
								        placeholder="邮编" id="postcode" name="postcode"           />
									</div>
								</div>
							</div>	
                        
						
						
						
                        
                        
						
							
							
							
							
							
						 	
							<div class="box-body">
								<div class="form-group">
									<label class="col-sm-2 control-label">省份:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" 
								        placeholder="省份" id="province" name="province"           />
									</div>
								</div>
							</div>	
                        
						
						
						
                        
                        
						
							
							
							
							
							
						 	
							<div class="box-body">
								<div class="form-group">
									<label class="col-sm-2 control-label">城市:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" 
								        placeholder="城市" id="city" name="city"           />
									</div>
								</div>
							</div>	
                        
						
						
						
                        
                        
						
							
							
							
							
							
						 	
							<div class="box-body">
								<div class="form-group">
									<label class="col-sm-2 control-label">区域:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" 
								        placeholder="区域" id="area" name="area"           />
									</div>
								</div>
							</div>	
                        
						
						
						
                        
                        
						
							
							
							
							
							
						 	
							<div class="box-body">
								<div class="form-group">
									<label class="col-sm-2 control-label">详细地址:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" 
								        placeholder="详细地址" id="address" name="address"           />
									</div>
								</div>
							</div>	
                        
						
						
						
                        
                        
						
							<div class="box-body">
									<div class="form-group">
										<label class="col-sm-2 control-label">是否是默认地址:</label>
										<div class="col-sm-8">
											<label><input value="1" type="radio" class="minimal" name="activity">是</label>
											<label><input value="2" type="radio" class="minimal" name="activity">否</label>
										</div>
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
			},		
			callback : addResult
		});
		
				 	var ue =  UE.getEditor('content');
		
		
				
				
				
				
				
				
				
				
				
				
				
	</script>	
	</body>
</html>
					
