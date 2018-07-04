<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>新增用户</title>
<%@ include file="/common/admin/head.jsp"%>


</head>


<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<%@ include file="/common/admin/header.jsp"%>
		<%@ include file="/common/admin/left.jsp"%>

		<div class="content-wrapper">
			<section class="content-header">
				<h1>添加用户</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
					<li class="active">添加用户</li>
				</ol>
			</section>

			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">添加用户</h3>
							</div>

							<form class="form-horizontal" method="post" id="form-admin-add"
								action="${adp}add.json">


								<div class="box-body">
									<div class="form-group">
										<label class="col-sm-2 control-label"><i class="red">*</i>姓名:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" placeholder="姓名"
												value="灰灰" id="name" name="name" datatype="*"
												errormsg="请输入姓名" />
										</div>
									</div>


									<div class="box-body">
										<div class="form-group">
											<label class="col-sm-2 control-label">头像:</label>
											<div class="col-sm-8">
												<input class="file" type="file" id='pic'> <input
													name="avatar" id="pic_input" type="hidden" />
												<div style="overflow: hidden;" class="pic"></div>
											</div>
										</div>
									</div>


									<div class="form-group">
										<label class="col-sm-2 control-label"><i class="red">*</i>手机号:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" placeholder="请输入手机号"
												value="18894717688" id="mobile" name="mobile" datatype="m"
												errormsg="手机号格式不对" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label"><i class="red">*</i>用户名:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" placeholder="请输入用户名"
												value="hh" id="username" name="username" datatype="*"
												errormsg="请输入用户名" />
										</div>
									</div>


									<div class="form-group">
										<label class="col-sm-2 control-label"><i class="red">*</i>密码:</label>
										<div class="col-sm-8">
											<input type="password" class="form-control" value="hh"
												placeholder="请输入密码" id="password" name="password"
												datatype="*" errormsg="请输入密码" />
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
											<button type="submit" class="btn_sub btn btn-success">提交</button>
											<a href="javascript:history.go(-1)" class="btn btn-primary">返回</a>
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
				chkStyle:"checkbox",
				chkboxType: { "Y": "ps", "N": "s" },
				
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
				datatype:{
					"mf":/^1[3,4,5,7,8,9]\d{9}$/
				},
				beforeCheck : function(curform) {
				},
				beforeSubmit : function(curform) {
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