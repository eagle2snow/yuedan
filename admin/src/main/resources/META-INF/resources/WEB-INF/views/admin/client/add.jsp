<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>客户信息新增 </title>

    <%@ include file="/common/admin/head.jsp"%>
    <%@ include file="/common/admin/datetimepic.jsp"%>

</head>

<body>
<section class="content">
    <form class="form-horizontal" method="post" id="form-admin-add" action="${adp}add.json">
        <div class="row">
            <div class="col-md-12">

                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">添加</h3>
                    </div>

							<div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><i class="red">*</i>名称:</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control"
                                               placeholder="名称" id="name" name="name" datatype="*" errormsg="请输入名称"         />
                                    </div>
                                </div>
                            </div>


















	                               <div class="form-group">
										<label class="col-sm-2 control-label">内容:</label>
										<div class="col-sm-8">
											 <script id="content" name="content" type="text/plain" class="ue-editor" style="width:100%; height: 400px;"> ${model.content} </script>
										</div>
                          </div>










	                        <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">头像地址:</label>
                                    <div class="col-sm-8">


                                        <input class="file" type="file" id='iocUrl'> <input
                                            name="iocUrl" id="iocUrl_input" type="hidden" />
                                        <div style="overflow: hidden;" class="iocUrl"></div>
                                    </div>
                                </div>
                            </div>












							<div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">密码:</label>
                                    <div class="col-sm-8">
                                        <input type="password" class="form-control"
                                               placeholder="密码" id="password" name="password"          />
                                    </div>
                                </div>
                            </div>






















								<div class="box-body">
                                  <div class="form-group">
                                  <label class="col-sm-2 control-label">性别:</label>
                          <div class="col-sm-8">
											<label><input value="0" type="radio" class="minimal" name="gender">不详</label>
											<label><input value="1" type="radio" class="minimal" name="gender">男</label>
											<label><input value="2" type="radio" class="minimal" name="gender">女</label>
										</div>
									</div>
								</div>







                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">等级:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="等级" id="level" name="level"          />
                                    </div>
                                </div>
                            </div>













                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">积分:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="积分" id="integral" name="integral"          />
                                    </div>
                                </div>
                            </div>













                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">经度:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="经度" id="longitude" name="longitude"          />
                                    </div>
                                </div>
                            </div>













                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">纬度:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="纬度" id="latitude" name="latitude"          />
                                    </div>
                                </div>
                            </div>









							<div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">手机号:</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control"
                                               placeholder="手机号" id="mobile" name="mobile"           />
                                    </div>
                                </div>
                            </div>













							<div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">微信号:</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control"
                                               placeholder="微信号" id="wechat" name="wechat"           />
                                    </div>
                                </div>
                            </div>













							<div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">微博号:</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control"
                                               placeholder="微博号" id="microblog" name="microblog"           />
                                    </div>
                                </div>
                            </div>

















                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">是否展示微博号:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="是否展示微博号" id="statusMicroblog" name="statusMicroblog"          />
                                    </div>
                                </div>
                            </div>









							<div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">简介:</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control"
                                               placeholder="简介" id="profile" name="profile"           />
                                    </div>
                                </div>
                            </div>

















                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">赞:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="赞" id="praise" name="praise"          />
                                    </div>
                                </div>
                            </div>













                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">访客:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="访客" id="visitor" name="visitor"          />
                                    </div>
                                </div>
                            </div>













                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">活跃度:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="活跃度" id="liveness" name="liveness"          />
                                    </div>
                                </div>
                            </div>













                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">授权:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="授权" id="auth" name="auth"          />
                                    </div>
                                </div>
                            </div>













                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">认证:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="认证" id="authentication" name="authentication"          />
                                    </div>
                                </div>
                            </div>








                        <div class="box-body">
                        <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-sm-8">
                        <button type="submit" class="btn_sub btn btn-success">提交</button>
                        <button type="button" onClick="closeAll();" class="btn_reset btn btn-primary">关闭</button>
                        </div>
                        </div>
                        </div>
                        </div>
                        <!--end .box .box-info -->

                        </div>
                        <!--end .col-md-12-->
                        </div>
                        <!-- end .row -->
                        </form>
                        </section>

                        <%@ include file="/common/admin/my_js.jsp"%>

                        <script>

                var newDate = new Date();
                var t       = newDate.toJSON();
                $('.form_datetime1').datetimepicker({
                    weekStart : 0, //一周从哪一天开始
                    todayBtn : 1, //
                    autoclose : 1,
                    todayHighlight : true,
                    todayHighlight : 1,
                    startView : 2,
                    forceParse : 0,
                    language : 'zh_CN',
                    showMeridian : 1,
                    format : 'yyyy-mm-dd HH:mm:ss',
                    startDate:new Date(t)
                });

                $(".form-horizontal").Validform({
                    btnSubmit: ".btn_sub",
                    btnReset: ".btn_reset",
                    tiptype: 3,
                    ignoreHidden: false,
                    dragonfly: false,
                    tipSweep: true,
                    label: ".label",
                    showAllError: false,
                    postonce: true,
                    ajaxPost: true,

                    beforeCheck: function (curform) {
                        //在表单提交执行验证之前执行的函数，curform参数是当前表单对象。
                        //这里明确return false的话将不会继续执行验证操作;
                    },
                    beforeSubmit: function (curform) {
                        //在验证成功后，表单提交前执行的函数，curform参数是当前表单对象。
                        //这里明确return false的话表单将不会提交;
                        var time = $('.auto-kal');
                    },
                    callback : addResult
                });

				 	var ue =  UE.getEditor('content');





















                    </script>
</body>
</html>
					
