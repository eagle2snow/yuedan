<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>后台管理</title>

 <%@ include file="/common/admin/head.jsp"%>




</head>
<body>
	<article class="page-container">
		<form class="form form-horizontal" id="form-admin-add"
			action="${adp}update.json" method="post">

			<input type="hidden" name="id" value="${model.id}" />


			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"> <span
					class="c-red">*</span> 名称：
				</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder="名称" id="name"
						name="name" value="${model.name}" datatype="*" errormsg="请输入标题" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">分配权限:</label>
				<div class="col-sm-8">
					<ul id="treeDemo" class="ztree"></ul>
					<input id="resStr" name="resStr" type="hidden">
				</div>
			</div>


			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<button class="btn btn-secondary radius btn_sub" type="button">
						<i class="Hui-iconfont">&#xe632;</i> 保存
					</button>
					<button onClick="closeAll();" class="btn btn-default radius"
						type="button">&nbsp;&nbsp;关闭&nbsp;&nbsp;</button>
				</div>
			</div>
		</form>
	</article>
    <%@ include file="/common/admin/my_js.jsp"%> 
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