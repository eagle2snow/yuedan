<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside class="main-sidebar">

	<section class="sidebar">
		<div class="user-panel">
			<div class="pull-left image">
				<img src="/static/admin/img/avatar5.png" class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>管理员</p>
				<a href="#"><i class="fa fa-circle text-success"></i>在线</a>
			</div>
		</div>

		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control" placeholder="Search..."> <span class="input-group-btn">
					<button type="submit" name="search" id="search-btn" class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>

	
		<ul class="sidebar-menu">
			<c:forEach items="${menu }" var="m1">
				<c:choose>
					<c:when test="${m1.sons.size()>0 }">

						<li class="treeview active"><a href="#"> <span>${m1.name }</span> <span
								class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>
							</span>
						</a>
							<ul class="treeview-menu" style="background: #41494c">
								<c:forEach items="${m1.sons }" var='m2'>
									<li style="margin-left: 20px;"><a href="${m2.url }">${m2.name }</a></li>
								</c:forEach>
							</ul></li>

					</c:when>
					<c:otherwise>
						<li><a href="${m1.url }"><span>${m1.name }</span></a></li>
					</c:otherwise>
				</c:choose>

			</c:forEach>

		</ul>
	
	
	</section>
</aside>