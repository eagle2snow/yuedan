<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="main-header">
	<a href="/admin/index.html" class="logo"> <span class="logo-mini">新项目后台管理系统</span>
		<span class="logo-lg">新项目后台管理系统</span>
	</a>

	<nav class="navbar navbar-static-top" role="navigation">
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a>
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">


				<li @click="chat()" class="dropdown notifications-menu"><a
					href="javascript:void(0)"> <i class="fa fa-commenting-o"></i> <span
						class="label label-warning" v-text='msgNum'></span>
				</a></li>


				<li class="dropdown messages-menu site-demo-layim" data-type="chat"><a
					href="#" class="dropdown-toggle" data-toggle="dropdown"> <i
						class="fa fa-envelope-o"></i> <span class="label label-success">4</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">您有4条消息</li>
						<li>
							<ul class="menu">
								<li><a href="#">
										<div class="pull-left">
											<img src="/static/admin/img/user2-160x160.jpg"
												class="img-circle" alt="User Image">
										</div>
										<h4>
											Support Team <small><i class="fa fa-clock-o"></i> 5
												mins</small>
										</h4>
										<p>Why not buy a new awesome theme?</p>
								</a></li>
							</ul>
						</li>
						<li class="footer"><a href="#">See All Messages</a></li>
					</ul></li>



				<li class="dropdown notifications-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="fa fa-bell-o"></i> <span class="label label-warning">10</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">You have 10 notifications</li>
						<li>
							<ul class="menu">
								<li><a href="#"> <i class="fa fa-users text-aqua"></i>
										5 new members joined today
								</a></li>
							</ul>
						</li>
						<li class="footer"><a href="#">测试</a></li>
					</ul></li>
				<li class="dropdown tasks-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="fa fa-flag-o"></i> <span class="label label-danger">9</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">You have 9 tasks</li>
						<li>
							<ul class="menu">
								<li><a href="#">
										<h3>
											Design some buttons <small class="pull-right">20%</small>
										</h3>
										<div class="progress xs">
											<div class="progress-bar progress-bar-aqua"
												style="width: 20%" role="progressbar" aria-valuenow="20"
												aria-valuemin="0" aria-valuemax="100">
												<span class="sr-only">20% Complete</span>
											</div>
										</div>
								</a></li>
							</ul>
						</li>
						<li class="footer"><a href="#">View all tasks</a></li>
					</ul></li>
					
					
					
					
					
					
					
					
				<li class="dropdown tasks-menu">
				<a href="/admin/logout" class="dropdown-toggle" data-toggle="dropdown"> 
					<span id="logout" onclick="out()" class="glyphicon glyphicon-log-out"></span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">You have 9 tasks</li>
						<li>
							<ul class="menu">
								<li><a href="#">
										<h3>
											Design some buttons <small class="pull-right">20%</small>
										</h3>
										<div class="progress xs">
											<div class="progress-bar progress-bar-aqua"
												style="width: 20%" role="progressbar" aria-valuenow="20"
												aria-valuemin="0" aria-valuemax="100">
												<span class="sr-only">20% Complete</span>
											</div>
										</div>
								</a></li>
							</ul>
						</li>
						<li class="footer"><a href="#">View all tasks</a></li>
					</ul></li>
					
					
					
				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <img
						src="/static/admin/img/avatar5.png" class="user-image"
						alt="User Image"> <span class="hidden-xs">${curUser.name }</span>
				</a>
					<ul class="dropdown-menu">
						<li class="user-header"><img
							src="/static/admin/img/avatar5.png" class="img-circle"
							alt="User Image">

							<p>
								Alexander Pierce - Web Developer <small>Member since
									Nov. 2012</small>
							</p></li>
						<li class="user-body">
							<div class="row">
								<div class="col-xs-4 text-center">
									<a href="#">Followers</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Sales</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Friends</a>
								</div>
							</div>
						</li>
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-default btn-flat">个人资料</a>
							</div>
							<div class="pull-right">
								<a href="/admin/logout" class="btn btn-default btn-flat">退出登录</a>
							</div>
						</li>
					</ul></li>

			</ul>
		</div>
	</nav>

	<div id="yuyin" style="display: none;"></div>


<!-- 	<script src="https://openapi.baidu.com"></script> -->

	<script type="text/javascript">
		
	
		//登出
		function out(){
			if(confirm("确定要退出登录么？")){
				location.href="/admin/logout";
				}
		}
	
		//播放新订单语音
		function playNewOrderMsg() {
			var message = "您有新订单，请及时处理";
			var yuyinhtml = '<iframe scrolling="yes" name="yuyin" style="position: absolute;bottom: 0;height: 40px;width: 100px; " frameborder="0" src="https://tts.baidu.com/text2audio?idx=1&tex='
					+ message
					+ '&cuid=baidu_speech_demo&cod=2&lan=zh&ctp=1&pdt=1&spd=7&per=0&vol=5&pit=5"></iframe>';
			$("#yuyin").html(yuyinhtml);

		}

		//收到消息
		var showMsgToHeader = function(msg) {
			var cat = msg.cat;
			headerVue.memberId=msg.fromId;
			if (cat == 'MEMBER_TO_KF') {
				headerVue.msgNum += 1;
			} else if (cat == 'MEMBER_IN_CHAT') {
				alert("有会员加入聊天");
			}
		}

		/* 	var exampleData = {
				msgNum : ${notReadMsgNum},
				orderNum : ${paymentsOrderNum},
				memberId:0
			} */

		var exampleData = {
			msgNum : 0,
			orderNum : 0,
			memberId : 0 //最后发消息来的会员id
		}

		var headerVue = new Vue({
			el : '.navbar-static-top',
			data : exampleData,
			methods : {
				look : function(event) {
				},
				chat : function() {
					headerVue.msgNum = 0;
					contact(headerVue.memberId);
				}
			},
			mounted : function() {
			},
			updated : function() {
			}
		});
	</script>



</header>



