<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>角色列表</title>

<%@ include file="/common/admin/head.jsp"%>



</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<%@ include file="/common/admin/header.jsp"%>
		<%@ include file="/common/admin/left.jsp"%>

		<div class="content-wrapper">
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<!-- left column -->
					<div class="col-md-12">
						<!-- Horizontal Form -->
						<div class="box box-info">

							<!-- /.box-header -->
							<div class="box">

								<!-- /.box-header -->
								<div class="box-body">
									<!--搜索框-->
									<div class="row">
										<div class="col-sm-6">
											<div class="cl pd-5 bg-1 bk-gray mt-20">
												<span class="l"><a href="javascript:;" onclick="delByIds('${adp}')" class="btn btn-danger radius"><i
														class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a href="javascript:;" onclick="openPerRe('添加','90','90','${adp}add.htm')"
													class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加</a></span> <span class="r">共有数据：<strong
													id="count">${page.count}</strong> 条
												</span>
											</div>
										</div>
										<div class="col-sm-6">
											<div id="example1_filter" class="dataTables_filter">
												<div class="text-c">
													<input type="text" name="" id="key" placeholder="名称、介绍等"
														onkeypress="if(event.keyCode==13) {btn.click();return false;}" value='${key}' style="width: 250px"
														class="input-text">
													<button name="" id="btn" class="btn btn-success" type="submit" onclick="getData(1)">
														<i class="Hui-iconfont">&#xe665;</i> 搜索
													</button>
												</div>
											</div>
										</div>
									</div>
									<!--表单数据-->
									<table id="example1" class="table table-bordered table-striped">
										<thead>

											<tr>
												<th width="25"><input id="checkAll" type="checkbox"></th>
												<th width="40">ID</th>
												<th>名称</th>
												<th>内容</th>
												<th width="130">加入时间</th>
												<th width="100">状态</th>
												<th width="100">操作</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach items="${page.list}" var="model">
												<tr>
													<td><input type="checkbox" name="ids" value="${model.id}"></td>
													<td>${model.id}</td>
													<th>${model.name}</th>
													<th>${model.content}</th>

													<td><javatime:format value="${model.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
													<td class="td-status">
														<div class="switch" data-on-label="已启用" data-off-label="已禁用">
															<input type="checkbox" name="enable" ${(model.enable==1)?'checked':'' } value="${model.id}">
														</div>
													</td>
													<td>
														<button onclick="edit(${model.id})" class="btn btn-sm btn-primary">
															<i class="glyphicon glyphicon-cog" title="修改"></i>
														</button>
														<button onclick="del(${model.id})" class="btn btn-sm btn-danger">
															<i class="glyphicon glyphicon-trash" title="删除"></i>
														</button>
													</td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
									<!--分页-->
									<div class="row">
										<div id="page" class="text-c mt-10"></div>
									</div>

								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->

						</div>
						<!-- /.box -->
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
			$(function() {
				$("#example1").DataTable();
			});
			
			laypage({
		  cont: 'page',
		  skin: 'yahei',
		  groups: 10,
		  first: '首页', 
		  last: '尾页',
		  prev: '<', //若不显示，设置false即可
		  next: '>', //若不显示，设置false即可
		  pages: ${page.countPage}, 
		  curr: function(){
		    var page = ${page.indexPage};
		    return page;
		  }(), 
		  jump: function(e, first){ //触发分页后的回调
		    if(!first){ //一定要加此判断，否则初始时会无限刷新
		    	getData(e.curr);
		    }
		  }
		});
		
		function edit(id){
			openPerRe("编辑", 90,90,'${adp}update/'+id+'.htm');
		}
		
		function del(id){
			delById(id, '${adp}'); 
		}
		
		function getData(indexPage){
			  var k = $("#key").val();
		      location.href = '${adp}list/'+indexPage+'/${page.sizePage}.htm?k='+k;
		}
		
		$('.switch').on(
				'switch-change',
				function(e, data) {
					var id = $(data.el).context.value;
					var flag = data.value;
					var enable = flag ? 1 : 2;
					update(adp + 'updatePVById/enable/' + enable + '/' + id
							+ '.json', updateResult);
				});
		
		$("#key").focus();
		
		</script>
</body>

</html>