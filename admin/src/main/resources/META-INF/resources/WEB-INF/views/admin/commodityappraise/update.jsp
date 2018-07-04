<%@page import="java.text.SimpleDateFormat"%>  
<%@page import="java.util.*"%> 
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>会员评价修改 </title>

<%@ include file="/common/admin/head.jsp"%>

</head>

<body>
	<%  
        Date d = new Date();  
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String now = df.format(d);  
    %>  
	<section class="content">
	<form class="form-horizontal" method="post" id="form-admin-add" action="${adp}update.json">
		<input type="hidden" name="id" value="${model.id}"/>	
		<div class="row">
			<div class="col-md-12">
			
			<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">编辑</h3>
					</div>
							<%-- <div class="form-group" style="display: ">
								<label class="col-sm-2 control-label">名称:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.name}"
							        placeholder="名称" id="name" name="name" datatype="*" errormsg="请输入名称"         />
								</div>
							</div> --%>
                        
							<%-- <div class="form-group" style="display: ">
								<label class="col-sm-2 control-label">创建时间:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="<javatime:format value="${model.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />"
							        placeholder="创建时间" id="createTime" name="createTime"  />                                           
								</div>
							</div> --%>
							<%-- <div class="form-group" style="display: ">
								<label class="col-sm-2 control-label">商品评价表:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.commodityEvaluation.id}"
							        placeholder="商品评价表" id="commodityEvaluation.id" name="commodityEvaluation.id"           />
								</div>
							</div> --%>
							
							
							<div class="form-group" style="display:none " >
								<label class="col-sm-2 control-label">订单项:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.orderItem.id}"
							        placeholder="订单项" id=orderItem.id name="orderItem.id"           />
								</div>
							</div>
							<div class="form-group" style="display:none ">
								<label class="col-sm-2 control-label">会员表:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.member.id}"
							        placeholder="会员表" id="member.id" name="member.id"           />
								</div>
							</div>
							<div class="form-group" style="display:none ">
								<label class="col-sm-2 control-label">商品表:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.commodity.id}"
							        placeholder="商品表" id="commodity.id" name="commodity.id"           />
								</div>
							</div>
							<div class="form-group" style="display:none ">
								<label class="col-sm-2 control-label">管理员表:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${sessionScope.curUser.id}"
							        placeholder="管理员表" id="user.id" name="user.id"           />
								</div>
							</div>
							<div class="form-group" style="display:none ">
								<label class="col-sm-2 control-label">管理员回复时间:</label>
								<div class="col-sm-8">
									<input type="" class="form-control" value="<%=now %>"
							        placeholder="管理员回复时间" id="replyTime" name="replyTime"           />
								</div>
							</div>
                        
			                
			                
			                
							 
							
							
							
			                
                        
                        
						
						
                        
	                               <div class="form-group" style="display:">
										<label class="col-sm-2 control-label">内容:</label>
										<div class="col-sm-8">
											<!-- <script id="content" name="content" type="text/plain" class="ue-editor" style="width:100%; height: 400px;"> ${model.content} </script> --> 
											<input type="text" class="form-control" value="${model.content}"
								        	placeholder="买家评价" id="content" name="content" 
											style="border: none;" readonly="readonly" />
										</div>
								</div>
	                               
	                               <div class="form-group" style="display:">
										<label class="col-sm-2 control-label">首页显示图片:</label>
										<div class="col-sm-8" >
											<img alt="" src="${model.orderItem.imgerPath}" width="200" height="180" >
										</div>
								</div>
	                               

							
			                
			                
			                
							 
							
							
							
			                
							<div class="form-group" style="display:none ">
								<label class="col-sm-2 control-label">管理员是否回复:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="1"
							        placeholder="管理员是否回复" id="state" name="state"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
							 
							
							
							
			                
							<div class="form-group" style="display: ">
								<label class="col-sm-2 control-label">星级:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.starLevel}"
							        placeholder="星级" id="starLevel" name="starLevel"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
							 
							
							
							
			                
                        
                        
						
						
                        
	                               <div class="form-group">
										<label class="col-sm-2 control-label"><i class="red">*</i>管理员回复:</label>
										<div class="col-sm-8">
											 <script id="replyDeails" name="replyDeails" type="text/plain" class="ue-editor" style="width:100%; height: 300px;" datatype="*" errormsg="请输入内容"> ${model.replyDeails} </script>
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
			},	
			callback : updateResult
		});
		
			
				 	var ue =  UE.getEditor('content');
				 	var ue =  UE.getEditor('replyDeails');
		
				
				
				
				
				
	</script>	
	</body>
</html>
					
