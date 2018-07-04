<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>通用评论修改 </title>
<%@ include file="/common/admin/head.jsp"%>


</head>

<body>
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">编辑</h3>
					</div>
					
				<form class="form-horizontal" method="post" id="form-admin-add" action="${adp}update.json">
						<input type="hidden" name="id" value="${model.id}"/>				 
					<div class="box-body">	
                        
                        
	                        <div class="box-body">
								<div class="form-group">
									<label class="col-sm-2 control-label">图片（单张）:</label>
									<div class="col-sm-8">
										<input class="file" type="file" id='thumb'> <input value="${model.thumb}"
											name="thumb" id="thumb_input" type="hidden" />
										<div style="overflow: hidden;" class="thumb">
										
										<div class="showimg-box pull-left">
												<div class="showimg">
													<img src="${model.thumb}" width="80" height="60"
														onclick="adminShowPic(this)">
												</div>
												<span onclick="delPics(this,thumb)"
													class="fa fa-close delete"></span>
											</div>
										
										
										</div>
									</div>
								</div>
							</div>
						
						
                        
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label"><i class="red">*</i>名称:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.name}"
							        placeholder="名称" id="name" name="name" datatype="*" errormsg="请输入名称"         />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
							
							
							
			                
                        
                        
						
						
                        
	                               <div class="form-group">
										<label class="col-sm-2 control-label">内容:</label>
										<div class="col-sm-8">
											 <script id="content" name="content" type="text/plain" class="ue-editor" style="width:100%; height: 400px;"> ${model.content} </script>
										</div>
								</div>
			                
			                
			                
							
							
							
			                
                        
                        
						
						
                        
			                
			                
									<div class="form-group">
										<label class="col-sm-2 control-label">:</label>
										<div class="col-sm-8">
											<select name="model" style="width: 100% !important;" class="form-control select2" id="model">
											<option value="0" ${(model.model==0)?'selected':''}>gm_member</option>
											</select>
									</div>
								</div>
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">数据ID:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.modelId}"
							        placeholder="数据ID" id="modelId" name="modelId"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
							
							
							
			                
                        
                        
						
						
                        
			                
			                
									<div class="form-group">
										<label class="col-sm-2 control-label">评论人:</label>
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
								<label class="col-sm-2 control-label">回复的评论id :</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.pid}"
							        placeholder="回复的评论id " id="pid" name="pid"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">层级:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.level}"
							        placeholder="层级" id="level" name="level"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
							
							
							
			                
                        
                        
						
						
                        
			                
			                
									<div class="form-group">
										<label class="col-sm-2 control-label">上级:</label>
										<div class="col-sm-8">
											<select name="parent.id" style="width: 100% !important;" class="form-control select2" id="parent">
												<c:forEach items="${parentList}" var="m">
													<option    ${model.parent.id==m.id?'selected':'' }  value="${m.id}">
														${m.name}
													</option>
												</c:forEach> 
											</select>
									</div>
								</div>
			                
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">点赞数量:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.likes}"
							        placeholder="点赞数量" id="likes" name="likes"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
							
							
							
			                
			           
							<div class="form-group">
								<label class="col-sm-2 control-label"></label>
								<div class="col-sm-8">
									<button type="submit" class="btn_sub btn btn-success">保存</button>
									<button type="button" onClick="closeAll();" class="btn_reset btn btn-primary">关闭</button>
								</div>
							</div>
							
						</div>
						<!-- end .box-body -->
						
					</form>     
			       		</div> 
			       		<!-- end .box .box-info-->
				    </div>             
			       <!--end .col-md-12 -->           
			    </div> 
			    <!--end .row-->            
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
			                
			                
			                
			                
			                
			                
			                
			                
                        
                        
                        
                        
                        
                        
                        
                        
                        
