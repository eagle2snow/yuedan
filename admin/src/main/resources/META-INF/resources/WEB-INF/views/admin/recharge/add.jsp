<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>充值新增 </title>

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
                                  <label class="col-sm-2 control-label">会员:</label>
                          <div class="col-sm-8">
											<select name="client.id" style="width: 100% !important;" class="form-control select2" id="client">
                                      <c:forEach items="${clientList}" var="m">

                              <option value="${m.id}">
                                  ${m.name}
													</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>










                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">充值方式:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="充值方式" id="rechargePathway" name="rechargePathway"          />
                                    </div>
                                </div>
                            </div>













                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">支付方式:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="支付方式" id="payPathway" name="payPathway"          />
                                    </div>
                                </div>
                            </div>













                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">充值金额:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="充值金额" id="totalMoney" name="totalMoney"          />
                                    </div>
                                </div>
                            </div>













                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">金币数:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="金币数" id="goldNumber" name="goldNumber"          />
                                    </div>
                                </div>
                            </div>













                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">砖石数:</label>
                                    <div class="col-sm-8">
                                        <input type="number" class="form-control"
                                               placeholder="砖石数" id="masonryNumber" name="masonryNumber"          />
                                    </div>
                                </div>
                            </div>

















								<div class="box-body">
                                  <div class="form-group">
                                  <label class="col-sm-2 control-label">充值时间:</label>
                          <div style="width: 65.5%; padding-left: 21px;" class="input-group date form_datetime1 col-md-5" data-date-format="yyyy-MM-dd HH:mm:ss"
											data-link-field="dtp_input1">
                                                    <input style="background-color: white;"  class="form-control" type="text" placeholder="充值时间" id="rechargeTime" name="rechargeTime" readonly>
                          <span class="input-group-addon">
                                  <span class="glyphicon glyphicon-remove"></span>
                                  </span>
                                  <span class="input-group-addon">
                                  <span class="glyphicon glyphicon-th"></span>
                                  </span>
                                  <div>
                                  <input type="hidden" id="dtp_input1" value="" /><br />
									</div>
								</div>















								<div class="box-body">
                                  <div class="form-group">
                                  <label class="col-sm-2 control-label">支付状态:</label>
                          <div class="col-sm-8">
											<label><input value="1" type="radio" class="minimal" name="statusPay">支付成功</label>
											<label><input value="2" type="radio" class="minimal" name="statusPay">支付失败</label>
											<label><input value="3" type="radio" class="minimal" name="statusPay">待支付</label>
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
                         $('#rechargeTime').val(time);
                    },
                    callback : addResult
                });

				 	var ue =  UE.getEditor('content');












                    </script>
</body>
</html>
					
