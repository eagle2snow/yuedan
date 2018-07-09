<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>客户账单修改 </title>

    <%@ include file="/common/admin/head.jsp"%>
    <%@ include file="/common/admin/datetimepic.jsp"%>

</head>

<body>
<section class="content">
    <form class="form-horizontal" method="post" id="form-admin-add" action="${adp}update.json">
        <input type="hidden" name="id" value="${model.id}"/>
        <div class="row">
            <div class="col-md-12">

                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">编辑</h3>
                    </div>
							<div class="form-group">
                                <label class="col-sm-2 control-label"><i
                                        class="red">*</i>名称:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.name}"
                                           placeholder="名称" id="name" name="name"
                                           datatype="*"
                                           errormsg="请输入名称"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>


















	                               <div class="form-group">
										<label class="col-sm-2 control-label">内容:</label>
										<div class="col-sm-8">
											 <script id="content" name="content" type="text/plain"
                                                     class="ue-editor"
                                                     style="width:100%; height: 400px;"> ${model.content}
                                             </script>
										</div>
                          < /div>
















									<div class= "form-group" >
                                  < label class="col-sm-2 control-label" >会员:</label >
                          < div class="col-sm-8" >
											<select name = "client.id" style = "width: 100% !important;" class= "form-control select2" id = "client" >
                                      < c:forEach items = "${clientList}" var ="m" >
                              < option    ${model.client.id == m.id ? 'selected' : '' }  value="${m.id}">
                                  ${m.name}
													</option>
												</c:forEach> 
											</select>
									</div>
								</div>





							<div class="form-group">
                                <label class="col-sm-2 control-label">余额:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.balance}"
                                           placeholder="余额" id="balance" name="balance"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>













							<div class="form-group">
                                <label class="col-sm-2 control-label">我的充值:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.pay}"
                                           placeholder="我的充值" id="pay" name="pay"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>
























									<div class="form-group">
                                        <label class="col-sm-2 control-label">货币形式:</label>
                                        <div class="col-sm-8">
											<label><input value="1"  ${model.form==1
                                                ?'checked':'' } type="radio" class="minimal" name="form"
                                                >金币</label>
											<label><input value="2"  ${model.form==2
                                                ?'checked':'' } type="radio" class="minimal" name="form"
                                                >砖石</label>
                                        </div>
                                    </div>













									<div class="form-group">
                                        <label class="col-sm-2 control-label">充值方式:</label>
                                        <div class="col-sm-8">
											<label><input value="1"  ${model.payPathway==1
                                                ?'checked':'' } type="radio" class="minimal" name="payPathway"
                                                >支付宝</label>
											<label><input value="2"  ${model.payPathway==2
                                                ?'checked':'' } type="radio" class="minimal" name="payPathway"
                                                >微信</label>
											<label><input value="3"  ${model.payPathway==3
                                                ?'checked':'' } type="radio" class="minimal" name="payPathway"
                                                >约单</label>
                                        </div>
                                    </div>


							<div class="form-group">
                                <label class="col-sm-2 control-label">收入金额:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.income}"
                                           placeholder="收入金额" id="income" name="income"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>

















									<div class="form-group">
                                        <label class="col-sm-2 control-label">收入来源:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control"
                                                   value="${model.incomePathway}"
                                                   placeholder="收入来源" id="incomePathway"
                                                   name="incomePathway"/>
                                        </div>
                                    </div>


















								<div class= "box-body" >
                                  < div class= "form-group" >
                                  < label class="col-sm-2 control-label" >收入时间:</label >
                          < div style = "width: 65.5%; padding-left: 21px;" class= "input-group date form_datetime1 col-md-5" data - date - format = "yyyy-MM-dd HH:mm:ss"
											data - link - field = "dtp_input1" >
                                                    < input style = "background-color: white;"  class= "form-control" type = "text" placeholder = "收入时间" id = "incomeTime" name = "incomeTime" readonly >
                          < span class= "input-group-addon" >
                                  < span class= "glyphicon glyphicon-remove" > < /span>
                                  < /span>
                                  < span class= "input-group-addon" >
                                  < span class= "glyphicon glyphicon-th" > < /span>
                                  < /span>
                                  < div >
                                  < input type = "hidden" id = "dtp_input1" value="" /><br />
									</div>
								</div>




							<div class="form-group">
                                <label class="col-sm-2 control-label">支出金额:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.expenditure}"
                                           placeholder="支出金额" id="expenditure" name="expenditure"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>

















									<div class="form-group">
                                        <label class="col-sm-2 control-label">支出途径:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control"
                                                   value="${model.expenditurePathway}"
                                                   placeholder="支出途径" id="expenditurePathway"
                                                   name="expenditurePathway"/>
                                        </div>
                                    </div>


















								<div class= "box-body" >
                                  < div class= "form-group" >
                                  < label class="col-sm-2 control-label" >支出时间:</label >
                          < div style = "width: 65.5%; padding-left: 21px;" class= "input-group date form_datetime1 col-md-5" data - date - format = "yyyy-MM-dd HH:mm:ss"
											data - link - field = "dtp_input1" >
                                                    < input style = "background-color: white;"  class= "form-control" type = "text" placeholder = "支出时间" id = "expenditureTime" name = "expenditureTime" readonly >
                          < span class= "input-group-addon" >
                                  < span class= "glyphicon glyphicon-remove" > < /span>
                                  < /span>
                                  < span class= "input-group-addon" >
                                  < span class= "glyphicon glyphicon-th" > < /span>
                                  < /span>
                                  < div >
                                  < input type = "hidden" id = "dtp_input1" value="" /><br />
									</div>
								</div>















									<div class="form-group">
                                        <label class="col-sm-2 control-label">支付状态:</label>
                                        <div class="col-sm-8">
                                        </div>
                                    </div>


							<div class="form-group">
                                <label class="col-sm-2 control-label">交易详情:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.details}"
                                           placeholder="交易详情" id="details" name="details"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>













                    <div class="box-body">
                        <div class="form-group">
                            <label class="col-sm-2 control-label"></label>
                            <div class="col-sm-8">
                                <button type="submit" class="btn_sub btn btn-success">提交</button>
                                <button type="button" onClick="closeAll();" class="btn_reset btn btn-primary">关闭
                                </button>
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
    var t = newDate.toJSON();
    $('.form_datetime1').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn: 1, //
        autoclose: 1,
        todayHighlight: true,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        language: 'zh_CN',
        showMeridian: 1,
        format: 'yyyy-mm-dd HH:mm:ss',
        startDate: new Date(t)
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
                         $('#incomeTime').val(time);
                         $('#expenditureTime').val(time);
        },
        callback: updateResult
    });
		
			
				 	var ue = UE.getEditor('content');
		















</script>
</body>
</html>
					
