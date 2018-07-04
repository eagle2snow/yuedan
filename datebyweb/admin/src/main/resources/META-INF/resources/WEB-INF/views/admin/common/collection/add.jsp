<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>通用收藏新增 </title>

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
									<label class="col-sm-2 control-label"><i class="red">*</i>名称:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" 
								        placeholder="名称" id="name" name="name" datatype="*" errormsg="请输入名称"         />
									</div>
								</div>
							</div>	
                        
						
						
						
                        
                        
						
							
							
							
							
							
						 	
                        
						
	                        <div class="box-body">
								<div class="form-group">
									<label class="col-sm-2 control-label">封面:</label>
									<div class="col-sm-8">
									
										<input type="hidden" id="baseThumb" name="baseThumb" value="">
									
										<input class="file" type="file" id='thumb'> <input
											name="thumb" id="thumb_input" type="hidden" />
										<div style="overflow: hidden;" class="thumb"></div>
									</div>
								</div>
							</div>
						
						
                        
                        
						
							
							
							
							
							
						 	
                        
						
						
						
                        
	                            <div class="box-body">
	                               <div class="form-group">
										<label class="col-sm-2 control-label">内容:</label>
										<div class="col-sm-8">
											 <script id="content" name="content" type="text/plain" class="ue-editor" style="width: 100%; height: 400px;"></script>
										</div>
									</div>
								</div>
                        
						
							
							
							
							
							
						 	
                        
						
						
						
                        
                        
						
								<div class="box-body">
									<div class="form-group">
										<label class="col-sm-2 control-label">:</label>
										<div class="col-sm-8">
											<select name="model" style="width: auto !important;" class="form-control select2" id="model">
											<option value="0">member</option>
											<option value="1">zan</option>
											<option value="2">comment</option>
											<option value="3">memberTopic</option>
											<option value="4">topicEstheticsTalent</option>
											<option value="5">spu</option>
											<option value="6">store</option>
											<option value="7">order</option>
											</select>
										</div>
									</div>
								</div>
							
							
							
							
							
						 	
							<div class="box-body">
								<div class="form-group">
									<label class="col-sm-2 control-label">数据ID:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" 
								        placeholder="数据ID" id="modelId" name="modelId"           />
									</div>
								</div>
							</div>	
                        
						
						
						
                        
                        
						
							
							
							
							
							
						 	
                        
						
						
						
                        
                        
						
								<div class="box-body">
									<div class="form-group">
										<label class="col-sm-2 control-label">收藏会员:</label>
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
					
