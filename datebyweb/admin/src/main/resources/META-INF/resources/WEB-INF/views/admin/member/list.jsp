<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>会员信息列表 </title>

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
						<div class="box-header with-border">
							<h3 class="box-title">会员信息列表</h3>
						</div>
						<!-- /.box-header -->
						<div class="box">
							
							<!-- /.box-header -->
							<div class="box-body">
								<!--搜索框-->
								<div class="row">
									<div class="col-sm-6">
										<div class="cl pd-5 bg-1 bk-gray mt-20">
											<span class="l">
												<a href="javascript:;" onclick="delByIds('${adp}')" class="btn btn-danger radius">
													<i class="glyphicon glyphicon-trash"></i> 
													批量删除
												</a> 
													<%-- <button onclick="openPerRe('添加',90,90,'${adp}add.htm')" class="btn btn-primary radius">
													<i class="glyphicon glyphicon-plus"></i>
														添加
													</button> --%>
											</span>
											<span class="r">共有数据：<strong id="count">${page.count}</strong> 条</span>
										</div>
									</div>
									<div class="col-sm-6">
										<div id="example1_filter" class="dataTables_filter">
											<div class="text-c">
												<input type="text" name="" id="key" placeholder="名称、介绍等"
													onkeypress="if(event.keyCode==13) {btn.click();return false;}"
													value='${key}' style="width: 250px;height:33px" class="input-text">
												<button name="" id="btn" class="btn btn-success" type="submit"
													onclick="getData(1)">
													<i class="glyphicon glyphicon-search"></i> 搜索
												</button>
											</div>
										</div>
									</div>
								</div>
								<!--表单数据-->
								<table  class="table table-bordered table-striped">
									<thead>
									
										<tr>
											<th width="25"><input  name="checkAll" class="minimal" type="checkbox"></th>
											<th width="40">ID</th>
											<th>名字</th>
											<th>等级</th>
											<th>性别</th>
											<th>省份</th>
											<th>城市</th>
											<th>推荐人昵称</th>
											<th>创建时间</th>
											<th width="100">状态</th>
											<th width="150" style="text-align: right;">上家 | 直推 | 直系</th>
											<th width="100">详情 | 删除</th>
										</tr>
									</thead>
									<tbody>
									
										<c:forEach items="${page.list}" var="model">
										<tr>
											<td><input type="checkbox" class="minimal" name="ids" value="${model.id}"></td>
											<td>${model.id}</td>
											
											 <th>${model.name}</th>
											
<!-- 											1：竹语游客 2：普通会员 3：业务经理 4：城市经理 5：合作伙伴 -->
											 <th>
											 	
											 	${model.level eq 1?'竹语游客':""}
											 	${model.level eq 2?'普通会员':""}
											 	${model.level eq 3?'业务经理':""}
											 	${model.level eq 4?'城市经理':""}
											 	${model.level eq 5?'合作伙伴':""}
											 	
											 </th>
											
											 <th>${model.gender eq 1?'男':(model.gender eq 2?'女':'')}</th>
											
											 <th>${model.province}</th>
											
											 <th>${model.city}</th>
											
											
											 <th>${model.referrerNickname}</th>
											
											<td><javatime:format value="${model.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
											<td class="td-status">
														<div class="switch switchevent" data-on="primary"
															lang="${model.id}" title="${model.enable}"
															data-on-label="开" data-off-label="关" data-off="info">
															<input type="checkbox" ${(model.enable==1)?'checked':'' }
																class="swbtn" />
														</div>
											</td>
											<td style="text-align: right;">
												<button onclick="getUpperRelate(${model.id})"  class="btn btn-sm btn-info"><i class="glyphicon glyphicon-menu-up" title="上家"></i></button>
												<button onclick="getDirectChild(${model.id})"  class="btn btn-sm btn-info"><i class="glyphicon glyphicon-menu-down" title="直推"></i></button>
												<button onclick="getAllChild(${model.id})" class="btn btn-sm btn-success"><i class="glyphicon glyphicon-triangle-bottom " title="直系"></i></button>
											</td>
											<td >
												<button onclick="details(${model.id})"  class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-list" title="详情"></i></button>
												<%-- <button  onclick="edit(${model.id})"  class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-pencil" title="修改"></i></button> --%>
												<button onclick="del(${model.id})" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-trash" title="删除"></i></button>
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
				$("#key").focus();
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
		
		
		function getData(indexPage){
			  var k = $("#key").val();
		      location.href = '${adp}list/'+indexPage+'/${page.sizePage}.htm?k='+k;
		}
		
		
		function details(id){
		
				openPerRe("会员详细信息", 90,90,'${adp}details/'+id+'.htm');
		
			
		}
		
		function edit(id){
		
				openPerRe("编辑会员信息", 90,90,'${adp}update/'+id+'.htm');
		
			
		}
		
		function del(id){
			delById(id, '${adp}'); 
		}
		
		//开关回调
		/* var enableFun = function(){
		} */

		//上家会员
		function getUpperRelate(id)
		{
            openPerRe("上家会员信息", 90,　90, '${adp}upperRelate/' + id + '.htm');
		}

		//直推会员
		function getDirectChild(id)
		{
            openPerRe("直推会员信息", 90, 90, '${adp}directChild/' + id + '.htm');
		}

		//直系会员
		function getAllChild(id)
		{
            openPerRe("直系会员信息", 90, 90, '${adp}allChild/' + id + '.htm');
		}
		</script>
	</body>

</html>