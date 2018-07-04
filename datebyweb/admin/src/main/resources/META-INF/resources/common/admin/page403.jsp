<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Content Wrapper. Contains page content -->
<div>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>403 禁止访问</h1>
		<!-- 
		<ol class="breadcrumb">
			<li><a href="/admin/index"><i class="fa fa-dashboard"></i>
					主页</a></li>
			<li class="active">禁止访问</li>
		</ol>
		 -->
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="error-page">
			<h2 class="headline text-yellow">403</h2>

			<div class="error-content">
				<h3>
					<i class="fa fa-warning text-yellow"></i> 禁止访问
				</h3>

				<p>
					对不起，您无权限访问此页面 
				</p>
                 <br>
                    <div class="box-footer text-center" id="sType">
									<button type="button" class="btn btn-danger " onclick="sumb();">返回</button>
								</div>

				
			</div>
			<!-- /.error-content -->
		</div>
		<!-- /.error-page -->
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->