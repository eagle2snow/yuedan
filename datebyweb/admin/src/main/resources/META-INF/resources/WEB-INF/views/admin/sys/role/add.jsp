<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>后台管理系统</title>

<%@ include file="/common/admin/head.jsp"%>


<style type="text/css">
.radio-lable {
	margin-top: 6px
}
</style>

</head>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<%@ include file="/common/admin/header.jsp"%>
		<%@ include file="/common/admin/left.jsp"%>

		<div class="content-wrapper">
			<section class="content-header">
				<h1>添加角色</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
					<li class="active">添加角色</li>
				</ol>
			</section>
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">添加</h3>
							</div>

							<form class="form-horizontal" method="post" id="form-admin-add"
								action="${adp}add.json">
								<div class="box-body">
									<div class="form-group">
										<label class="col-sm-2 control-label"><i class="red">*</i>角色名称:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" placeholder="名称"
												id="name" name="name" datatype="*" errormsg="请输入标题" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">分配权限:</label>
										<div class="col-sm-8">
											<ul id="treeDemo" class="ztree"></ul>
											<input id="resStr" name="resStr" type="hidden">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label"></label>
										<div class="col-sm-8">
											<button type="submit" class="btn_sub btn btn-primary">提交</button>
											<button type="button" class="btn_reset btn btn-primary">返回</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</section>
		</div>

		<%@ include file="/common/admin/footer.jsp"%>
		<%@ include file="/common/admin/right.jsp"%>
		<%@ include file="/common/admin/my_js.jsp"%>


		<div class="control-sidebar-bg"></div>
	</div>


	<script>
	var setting = {
			check: {
				enable: true,
				chkboxType: { "Y": "ps", "N": "ps" },
				
			},
			data: {
				simpleData: {
					enable: true
				}
			}
	}; 
	var zNodes =[${zNodes}];	  	 
	
	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	});
	
		 $(".form-horizontal").Validform({
				btnSubmit : ".btn_sub",
				tiptype : 3,
				ignoreHidden : false,
				dragonfly : false,
				tipSweep : true,
				showAllError : true,
				postonce : true,
				ajaxPost : true,
				beforeCheck : function(curform) {
				},
				beforeSubmit : function(curform) {
					if ($("#name").val()=="") {
						alert("角色名不能是空");
						return;
					}
					var nodes = treeObj.getCheckedNodes(true);
					var str = new String();
					for(var i=0;i<nodes.length;i++){  
				        str+=nodes[i].id + ",";  
				     }   
					 $("#resStr").val(str);	
				},
				callback : addResult
			});

	</script>
</body>

</html>