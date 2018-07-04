<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>会员信息修改 </title>

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
						<h3 class="box-title">编辑</h3>
					</div>
							<div class="form-group">
								<label class="col-sm-2 control-label"><i class="red">*</i>名称:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.name}"
							        placeholder="名称" id="name" name="name" datatype="*" errormsg="请输入名称"         />
								</div>
							</div>
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">openid:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.openid}"
							        placeholder="openid" id="openid" name="openid"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group" hidden="hidden">
								<label class="col-sm-2 control-label">推广ID:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.generalizeId}"
							        placeholder="推广ID" id="generalizeId" name="generalizeId"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">昵称:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.nickname}"
							        placeholder="昵称" id="nickname" name="nickname"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
                        
							<div class="form-group">
								<label class="col-sm-2 control-label">密码:</label>
								<div class="col-sm-8">
									<input type="password" class="form-control" 
						        	placeholder="密码" id="password" name="password"          />
								</div>
							</div>
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
	                        <div class="box-body">
								<div class="form-group">
									<label class="col-sm-2 control-label">头像地址:</label>
									<div class="col-sm-8">
									
										<input class="file" type="file" id='iocUrl'> <input value="${model.iocUrl}"
											name="iocUrl" id="iocUrl_input" type="hidden" />
										<div style="overflow: hidden;" class="iocUrl">
										
										<div class="showimg-box pull-left">
												<div class="showimg">
													<img src="${model.iocUrl}" width="80" height="60"
														onclick="adminShowPic(this)">
												</div>
												<span onclick="delPic(this,iocUrl)"
													class="fa fa-close delete"></span>
											</div>
										
										
										</div>
									</div>
								</div>
							</div>
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">手机号:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.mobile}"
							        placeholder="手机号" id="mobile" name="mobile"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">等级:</label>
										<div class="col-sm-8">
											<input type="number" class="form-control" value="${model.level}"
								        	placeholder="等级" id="level" name="level" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
									<div class="form-group">
										<label class="col-sm-2 control-label">性别:</label>
										<div class="col-sm-8">
											<label><input value="1"  ${model.gender==1?'checked':'' }  type="radio" class="minimal" name="gender">男</label>
											<label><input value="2"  ${model.gender==2?'checked':'' }  type="radio" class="minimal" name="gender">女</label>
											<label><input value="0"  ${model.gender==3?'checked':'' }  type="radio" class="minimal" name="gender">不详</label>
										</div>
								</div>
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">可用积分:</label>
										<div class="col-sm-8">
											<input type="number" class="form-control" value="${model.integral}"
								        	placeholder="可用积分" id="integral" name="integral" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">国家:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.country}"
							        placeholder="国家" id="country" name="country"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">省份:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.province}"
							        placeholder="省份" id="province" name="province"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">城市:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.city}"
							        placeholder="城市" id="city" name="city"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">所在区域:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.area}"
							        placeholder="所在区域" id="area" name="area"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group" hidden="hidden">
								<label class="col-sm-2 control-label">推荐人的开放ID:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.referrerGeneralizeId}"
							        placeholder="推荐人的开放ID" id="referrerGeneralizeId" name="referrerGeneralizeId"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">推荐人昵称:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.referrerNickname}"
							        placeholder="推荐人昵称" id="referrerNickname" name="referrerNickname"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">营业额:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.totalRevenue}"
							        placeholder="营业额" id="totalRevenue" name="totalRevenue"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">消费额:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.consume}"
							        placeholder="消费额" id="consume" name="consume"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">爱心扶贫:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.love}"
							        placeholder="爱心扶贫" id="love" name="love"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">推广费:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.generalizeCost}"
							        placeholder="推广费" id="generalizeCost" name="generalizeCost"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">可提现金额:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.balance}"
							        placeholder="可提现金额" id="balance" name="balance"           />
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
			callback : updateResult
		});
		
			
				 	var ue =  UE.getEditor('content');
		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	</script>	
	</body>
</html>
					
