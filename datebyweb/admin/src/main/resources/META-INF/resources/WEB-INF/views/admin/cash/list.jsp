<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>提现列表 </title>

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
							<h3 class="box-title">提现列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box">

                            <!-- /.box-header -->
                            <div class="box-body">
                                <!--搜索框-->
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="cl pd-5 bg-1 bk-gray mt-20">
											<span class="l"><a href="javascript:;"
                                                               onclick="delByIds('${adp}')"
                                                               class="btn btn-danger radius"><i
                                                    class="glyphicon glyphicon-trash"></i> 批量删除</a>
                                                <%--<button--%>
                                                    <%--onclick="openPerRe('添加',90,90,'${adp}add.htm')"--%>
                                                    <%--class="btn btn-primary radius"><i--%>
                                                    <%--class="glyphicon glyphicon-plus"></i>--%>
													<%--添加</button>--%>

                                            </span> <span class="r">共有数据：<strong
                                                id="count">${page.count}</strong> 条
											</span>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div id="example1_filter" class="dataTables_filter">
                                            <div class="text-c">
                                                <input type="text" name="" id="key" placeholder="名称、介绍等"
                                                       onkeypress="if(event.keyCode==13) {btn.click();return false;}"
                                                       value='${key}' style="width: 250px;height:33px"
                                                       class="input-text">
                                                <button name="" id="btn" class="btn btn-success" type="submit"
                                                        onclick="getData(1)">
                                                    <i class="glyphicon glyphicon-search"></i> 搜索
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--表单数据-->
                                <table class="table table-bordered table-striped">
                                    <thead>

                                    <tr>
                                        <th width="25"><input name="checkAll" class="minimal" type="checkbox"></th>
                                        <th width="40">ID</th>
											<th>名称</th>
											<th>会员</th>
											<th>持卡人</th>
											<th>银行卡账号</th>
											<th>银行名称</th>
											<th>提现金额</th>
											<th>服务费</th>
											<th>状态</th>
											<th>银行流水号</th>
											<th>处理时间</th>
                                        <th width="130">创建时间</th>
                                        <th width="100">状态</th>
                                        <th width="100">修改|删除</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${page.list}" var="model">
                                        <tr>
                                            <td><input type="checkbox" class="minimal" name="ids"
                                                       value="${model.id}"></td>
                                            <td>${model.id}</td>

											 <th>${model.name}</th>


											 <th>${model.client.name}</th>

											 <th>${model.cardUser}</th>

											 <th>${model.cardNo}</th>

											 <th>${model.cardName}</th>

											 <th>${model.amount}</th>

											 <th>${model.serviceCharge}</th>

											 <th>${model.status}</th>

											 <th>${model.flowNo}</th>


											 <th>${model.dealTime}</th>


                                            <td>
                                                <javatime:format value="${model.createTime}"
                                                                 pattern="yyyy-MM-dd HH:mm:ss"/>
                                            </td>
                                            <td class="td-status">
                                                <div class="switch switchevent" data-on="primary"
                                                     lang="${model.id}" title="${model.enable}"
                                                     data-on-label="开" data-off-label="关" data-off="info">
                                                    <input type="checkbox" ${(model.enable==1)?'checked':'' }
                                                           class="swbtn"/>
                                                </div>
                                            </td>
                                            <td>
                                                <button onclick="edit(${model.id})"
                                                        class="btn btn-sm btn-warning"><i
                                                        class="glyphicon glyphicon-pencil" title="修改"></i></button>
                                                <button onclick="del(${model.id})" class="btn btn-sm btn-danger">
                                                    <i class="glyphicon glyphicon-trash" title="删除"></i></button>
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
    $(function () {
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
        curr: function () {
            var page = ${page.indexPage};
            return page;
        }(),
        jump: function (e, first) { //触发分页后的回调
            if (!first) { //一定要加此判断，否则初始时会无限刷新
                getData(e.curr);
            }
        }
    });


    function getData(indexPage) {
        var k = $("#key").val();
        location.href = '${adp}list/' + indexPage + '/${page.sizePage}.htm?k=' + k;
    }


    function edit(id) {
		
				openPerRe("编辑提现", 90, 90, '${adp}update/' + id + '.htm');

    }

    function del(id) {
        delById(id, '${adp}');
    }

    //开关回调
    /* var enableFun = function(){
    } */


</script>
</body>

</html>