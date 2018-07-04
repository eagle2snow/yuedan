<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="/common/admin/global.jsp"%>
<%@ include file="/common/admin/mate.jsp"%>
<!-- login -->
<link rel="stylesheet" href="/static/admin/css/pintuer.css">
<link rel="stylesheet" href="/static/admin/css/login.css">
<script src="/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script src="/static/admin/js/md5.js"></script>
</head>
<body>
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<form action="" method="post" id="form">
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>新项目管理中心</h1>
						</div>
						<div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="username"
										value="" placeholder="登录账号" data-validate="required:请填写账号" />
									<span class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="password"
										id="password" value="" placeholder="登录密码"
										data-validate="required:请填写密码" /> <span
										class="icon icon-key margin-small"></span>
								</div>
							</div>
							<div class="form-group" style="display: none;">
								<div class="field">
									<input type="text" class="input input-big" name="code"
										placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
									<img src="/static/admin/img/passcode.jpg" alt="" width="100"
										height="32" class="passcode"
										style="height: 43px; cursor: pointer;"
										onclick="this.src=this.src+'?'">

								</div>
							</div>
						</div>
						<div style="padding: 30px;">
							<input type="button" onclick="login()" id="loginBtn"
								class="button button-block bg-main text-big input-big"
								value="登录">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function login() {

			//md5();

			$("#loginBtn").val("正在登录...");
			$.ajax({
				type : "POST",
				url : '/admin/loginAction',
				dataType : "json",
				data : $("#form").serialize(),
				success : function(data) {
					if (data.s == 1) {
						layer.msg("登录成功，正在跳转...", {
							icon : 6
						});
						$("#loginBtn").val("正在跳转...");
						location.href = "/admin/member/list/1/115.htm";
					} else if (data.s == 2) {
						$("#loginBtn").val("登录");
						$("#password").val("");
						layer.msg('账号已被禁用，请联系管理员', {
							icon : 5
						});
					} else {
						$("#loginBtn").val("登录");
						$("#password").val("");
						layer.msg('账号或密码不正确', {
							icon : 5
						});
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(errorThrown);
				}
			});
		}

		function md5() {
			var hash = $.md5(document.getElementById("password").value);
			document.getElementById("password").value = hash;
		}
	</script>


	<script src="/static/admin/js/pintuer.js"></script>
</body>
</html>