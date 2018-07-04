<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>修改用户</title>

<%@ include file="/common/admin/head.jsp"%>

</head>


<body>


	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">修改用户</h3>
					</div>

					<form class="form-horizontal" method="post" id="form-admin-add" action="${adp}update.json">

						<input type="hidden" name="id" value="${model.id }"> 
						<input type="hidden" name="username" value="${model.username }"> 
						<input type="hidden"
							name="enable" value="${model.enable }"> <input name="password" type="hidden"
							value="${model.password }" />


						<div class="box-body">
							<div class="form-group">
								<label class="col-sm-2 control-label"><i class="red">*</i>姓名:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="姓名" value="${model.name}" id="name"
										name="name" datatype="*" errormsg="请输入姓名" />
								</div>
							</div>

							


							<div class="box-body">
								<div class="form-group">
									<label class="col-sm-2 control-label">头像:</label>
									<div class="col-sm-8">

										<input class="file" type="file" id='pic'> <input value="${model.avatar}"
											name="avatar" id="pic_input" type="hidden" />
										<div style="overflow: hidden;" class="pic">

											<div class="showimg-box pull-left">
												<div class="showimg">
													<img src="${model.avatar}" width="80" height="60" onclick="adminShowPic(this)">
												</div>
												<span onclick="delPic(this,pic)" class="fa fa-close delete"></span>
											</div>

										</div>
									</div>
								</div>
							</div>


							<div class="form-group">
								<label class="col-sm-2 control-label"><i class="red">*</i>手机号:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="请输入手机号" value="${model.mobile }"
										id="mobile" name="mobile" datatype="m" errormsg="手机号格式不对" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">密码:</label>
								<div class="col-sm-8">
									<input type="password" class="form-control" placeholder="留空则不修改" id="newPass"
										name="newPass" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label"></label>
								<div class="col-sm-8">
									<button type="submit" class="btn_sub btn btn-success">提交</button>
									<button type="button" onclick="closeAll()" class="btn btn-primary">关闭</button>
								</div>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</section>


	<%@ include file="/common/admin/my_js.jsp"%>

	<script>
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
			},
			callback : updateResult
		});
	</script>

</body>

</html>