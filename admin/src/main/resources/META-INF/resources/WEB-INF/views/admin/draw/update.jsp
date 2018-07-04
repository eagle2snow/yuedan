<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>  
<%@page import="java.util.*"%> 
<!DOCTYPE html>
<html>

<head>
<title>提现修改 </title>

<%@ include file="/common/admin/head.jsp"%>
<%@ include file="/common/admin/datetimepic.jsp"%>

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
							<%-- <div class="form-group">
								<label class="col-sm-2 control-label"><i class="red">*</i>名称:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.name}"
							        placeholder="名称" id="name" name="name" datatype="*" errormsg="请输入名称"         />
								</div>
							</div> --%>
                        
                        
						
						
                        
			                
			                
			                
							 
							
							
							
			                
                        
                        
						
						
                        
	                           <!--     <div class="form-group">
										<label class="col-sm-2 control-label">内容:</label>
										<div class="col-sm-8">
											 <script id="content" name="content" type="text/plain" class="ue-editor" style="width:100%; height: 400px;"> ${model.content} </script>
										</div>
								</div> -->
			                
			                
			                
							 
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			                
									<div class="form-group">
										<label class="col-sm-2 control-label">会员:</label>
										<div class="col-sm-8">
											<select name="member.id" style="width: 100% !important;" class="form-control select2" id="member" style="border: none;" readonly="readonly">
												<c:forEach items="${memberList}" var="m">
													<option    ${model.member.id==m.id?'selected':'' }  value="${m.id}">
														${m.name}
													</option>
												</c:forEach> 
											</select>
									</div>
								</div>
							 
							
							
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">银行卡号:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.cardNo}"
							        placeholder="银行卡号" id="cardNo" name="cardNo"   
							        style="border: none;" readonly="readonly"        />
								</div>
							</div>
							
							
							
							<div class="form-group">
								<label class="col-sm-2 control-label">持卡人:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.cardUser}"
							        placeholder="持卡人" id="cardUser" name="cardUser"   
							        style="border: none;" readonly="readonly"        />
								</div>
							</div>
							
							
							
							<div class="form-group">
								<label class="col-sm-2 control-label">提现金额:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.amount}"
							        placeholder="提现金额" id="amount" name="amount"   
							        style="border: none;" readonly="readonly"        />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
							 
							
							
							<div class="form-group" style="display:none ">
								<label class="col-sm-2 control-label">处理时间:</label>
								<div class="col-sm-8">
									<input type="" class="form-control" value="<%=now %>"
							        placeholder="处理时间" id="dealDate" name="dealDate"           />
								</div>
							</div>
			                
                        
                        
						
						
                        
			                
			                
			                
							 
							
							
									<div class="form-group">
										<label class="col-sm-2 control-label">状态:</label>
										<div class="col-sm-8">
											<label><input value="1"  ${model.status==1?'checked':'' }  type="radio" class="minimal" name="status">待审核</label>
											<label><input value="2"  ${model.status==2?'checked':'' }  type="radio" class="minimal" name="status">拒绝提现</label>
											<label><input value="3"  ${model.status==3?'checked':'' }  type="radio" class="minimal" name="status">待打款</label>
											<label><input value="4"  ${model.status==4?'checked':'' }  type="radio" class="minimal" name="status">已打款</label>
											<label><input value="5"  ${model.status==5?'checked':'' }  type="radio" class="minimal" name="status">已作废</label>
										</div>
								</div>
							
			                
							<div class="form-group">
								<label class="col-sm-2 control-label">银行流水号:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" value="${model.flowNo}"
							        placeholder="银行流水号" id="flowNo" name="flowNo"           />
								</div>
							</div>
                        
                        
						
						
                        
			                
			                
			                
							 
							
							
							
			                
                        
                        
						
						
                        
			                
			                
			                
							 
							
							
							
									<div class="form-group">
										<label class="col-sm-2 control-label">备注:</label>
										<div class="col-sm-8">
			<textarea name="oprator" class="form-control" id="oprator" rows="3" placeholder="Enter ..."          >${model.oprator}</textarea>									
											
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
		
				
				
				
				
				
				
				
	</script>	
	</body>
</html>
					
