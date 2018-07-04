<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>商品表修改 </title>

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
						<h3 class="box-title">商品详情</h3>
					</div>
							<div class="form-group">
								<label class="col-sm-2 control-label"><i class="red"></i>名称:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.name}"
							                 
							        style="border: none;" readonly="readonly" />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
                        
	                           <!--      <div class="form-group">
										<label class="col-sm-2 control-label">内容:</label>
										<div class="col-sm-8">
											 <script id="content" name="content" type="text/plain" class="ue-editor" style="width:100%; height: 400px;"> ${model.content} </script>
										</div>
								</div>  -->
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			
							
										<div class="form-group">
											<label class="col-sm-2 control-label"><i class="red"></i>商品分类:</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" value="${model.commodityClass.name}"      
							        style="border: none;" readonly="readonly" />
								</div>
							</div>
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">商品主页显示价格:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.showPrice}"
								        	placeholder="商品主页显示价格" id="showPrice" name="showPrice" 
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">商品主页显示折扣价:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.showDiscount}"
								        	placeholder="商品主页显示折扣价" id="showDiscount" name="showDiscount" 
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">商品主页显示原价:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.originalPrice}"
								        	placeholder="商品主页显示原价" id="originalPrice" name="originalPrice"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">商品邮费:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.freight}"
								        	placeholder="商品邮费" id="freight" name="freight"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">商品备注:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.remarks}"
							        placeholder="商品备注" id="remarks" name="remarks" 
							        style="border: none;" readonly="readonly"          />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">商品总库存:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.totalStock}"
								        	placeholder="商品总库存" id="totalStock" name="totalStock"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
	                        <div class="box-body">
								<div class="form-group">
									<label class="col-sm-2 control-label">商品主页显示图片:</label>
									<div class="col-sm-8">
									
										<%-- <input class="file" type="file" id='imgerPath'> <input value="${model.imgerPath}"
											name="imgerPath" id="imgerPath_input" type="hidden" /> --%>
										<div style="overflow: hidden;" class="imgerPath">
										
										<div class="showimg-box pull-left">
												<div class="showimg">
													<img src="${model.imgerPath}" width="80" height="60"
														onclick="adminShowPic(this)">
												</div>
												<span onclick="delPic(this,imgerPath)"
													class="fa fa-close delete"></span>
											</div>
										
										
										</div>
									</div>
								</div>
							</div>
						
						
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						<div class="box-body">
						    <div class="form-group">
									<label class="col-sm-2 control-label">商品图片展示列表:</label>
									<div class="col-sm-8">
										<%-- <input class="files" type="file" id='imgeListShow'> <input
											name="imgeListShow" id="imgeListShow_input" type="hidden" value="${model.imgeListShow}" /> --%>
										<div style="overflow: hidden;" class="imgeListShow">
										
										<c:forEach	items='${fn:split(model.imgeListShow,"|")}' var='p'>
												<div class="showimg-box pull-left">
													<div class="showimg">
														<img src='${p}' width="80" height="60"
															onclick="adminShowPic(this)">
													</div>
													<span onclick="delPics(this,imgeListShow)"
														class="fa fa-close delete"></span>
												</div>
											</c:forEach>
										
										
										</div>
									</div>
								</div>
						</div>    
						
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
									<div class="form-group">
										<label class="col-sm-2 control-label">是否是活动商品:</label>
										<div class="col-sm-8" >
											<label><input value="1"  ${model.activity==1?'checked':'' }  type="radio" class="minimal" name="activity" >是</label>
											<label><input value="2"  ${model.activity==2?'checked':'' }  type="radio" class="minimal" name="activity" >否</label>
										</div>
								</div>
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">商品销量:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.salesVolume}"
								        	placeholder="商品销量" id="salesVolume" name="salesVolume"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">商品多少件包邮:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.freePostage}"
								        	placeholder="商品多少件包邮" id="freePostage" name="freePostage"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">商品成本:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.cost}"
								        	placeholder="商品成本" id="cost" name="cost"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">评价数量:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.appraiseCount}"
								        	placeholder="评价数量" id="appraiseCount" name="appraiseCount"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">商品在前台显示的备注:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.showRemarks}"
							        placeholder="商品在前台显示的备注" id="showRemarks" name="showRemarks"
							        style="border: none;" readonly="readonly"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">默认重量:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.defaultWeight}"
								        	placeholder="默认重量" id="defaultWeight" name="defaultWeight"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                
			                
			                
							
							
							
			                
                        
                        
						
						
									<div class="form-group">
										<label class="col-sm-2 control-label">默认体积:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.defaultBulk}"
								        	placeholder="默认体积" id="defaultBulk" name="defaultBulk"
								        	style="border: none;" readonly="readonly" />
										</div>
								</div>
                        
			                
			                	<div class="form-group">
										<label class="col-sm-2 control-label">规格:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${model.specifications}"
								        	placeholder="规格" id="specifications" name="specifications"
								        	style="border: none;" readonly="readonly" />
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
			},	
			callback : updateResult
		});
		
			
				 	var ue =  UE.getEditor('content');
		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	</script>	
	</body>
</html>
					
