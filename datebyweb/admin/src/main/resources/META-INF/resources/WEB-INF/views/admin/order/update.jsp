<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>订单表修改 </title>

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
                                        <label class="col-sm-2 control-label">咨询类型(品类):</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control"
                                                   value="${model.categoryId}"
                                                   placeholder="咨询类型(品类)" id="categoryId"
                                                   name="categoryId"/>
                                        </div>
                                    </div>




















									<div class="form-group">
                                        <label class="col-sm-2 control-label">订单状态:</label>
                                        <div class="col-sm-8">
											<label><input value="1"  ${model.statusOrder==1
                                                ?'checked':'' } type="radio" class="minimal" name="statusOrder"
                                                >待应邀</label>
											<label><input value="2"  ${model.statusOrder==2
                                                ?'checked':'' } type="radio" class="minimal" name="statusOrder"
                                                >已应邀</label>
											<label><input value="3"  ${model.statusOrder==3
                                                ?'checked':'' } type="radio" class="minimal" name="statusOrder"
                                                >已成交</label>
											<label><input value="4"  ${model.statusOrder==4
                                                ?'checked':'' } type="radio" class="minimal" name="statusOrder"
                                                >已过期</label>
											<label><input value="5"  ${model.statusOrder==5
                                                ?'checked':'' } type="radio" class="minimal" name="statusOrder"
                                                >订单进行中</label>
                                        </div>
                                    </div>













									<div class="form-group">
                                        <label class="col-sm-2 control-label">支付状态:</label>
                                        <div class="col-sm-8">
											<label><input value="1"  ${model.statusPay==1
                                                ?'checked':'' } type="radio" class="minimal" name="statusPay"
                                                >未付款</label>
											<label><input value="2"  ${model.statusPay==2
                                                ?'checked':'' } type="radio" class="minimal" name="statusPay"
                                                >已付定金</label>
											<label><input value="3"  ${model.statusPay==3
                                                ?'checked':'' } type="radio" class="minimal" name="statusPay"
                                                >已确认定金</label>
											<label><input value="4"  ${model.statusPay==4
                                                ?'checked':'' } type="radio" class="minimal" name="statusPay"
                                                >待确认全款</label>
											<label><input value="5"  ${model.statusPay==5
                                                ?'checked':'' } type="radio" class="minimal" name="statusPay"
                                                >已同意退款</label>
											<label><input value="6"  ${model.statusPay==6
                                                ?'checked':'' } type="radio" class="minimal" name="statusPay"
                                                >已驳回退款</label>
                                        </div>
                                    </div>













									<div class="form-group">
                                        <label class="col-sm-2 control-label">性别要求:</label>
                                        <div class="col-sm-8">
											<label><input value="1"  ${model.gender==1
                                                ?'checked':'' } type="radio" class="minimal" name="gender"
                                                >男</label>
											<label><input value="2"  ${model.gender==2
                                                ?'checked':'' } type="radio" class="minimal" name="gender"
                                                >女</label>
                                        </div>
                                    </div>






									<div class="form-group">
                                        <label class="col-sm-2 control-label">距离:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control"
                                                   value="${model.distance}"
                                                   placeholder="距离" id="distance"
                                                   name="distance"/>
                                        </div>
                                    </div>









							<div class="form-group">
                                <label class="col-sm-2 control-label">订单号:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.orderNo}"
                                           placeholder="订单号" id="orderNo" name="orderNo"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>













							<div class="form-group">
                                <label class="col-sm-2 control-label">服务类型:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.type}"
                                           placeholder="服务类型" id="type" name="type"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>

















									<div class="form-group">
                                        <label class="col-sm-2 control-label">服务时间:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control"
                                                   value="${model.serviceTime}"
                                                   placeholder="服务时间" id="serviceTime"
                                                   name="serviceTime"/>
                                        </div>
                                    </div>













									<div class="form-group">
                                        <label class="col-sm-2 control-label">诚意金:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control"
                                                   value="${model.earnestMoney}"
                                                   placeholder="诚意金" id="earnestMoney"
                                                   name="earnestMoney"/>
                                        </div>
                                    </div>













									<div class="form-group">
                                        <label class="col-sm-2 control-label">订单总价:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control"
                                                   value="${model.totalMoney}"
                                                   placeholder="订单总价" id="totalMoney"
                                                   name="totalMoney"/>
                                        </div>
                                    </div>













									<div class="form-group">
                                        <label class="col-sm-2 control-label">支付方式:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control"
                                                   value="${model.payPathway}"
                                                   placeholder="支付方式" id="payPathway"
                                                   name="payPathway"/>
                                        </div>
                                    </div>









							<div class="form-group">
                                <label class="col-sm-2 control-label">支付宝交易号:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.alipayNo}"
                                           placeholder="支付宝交易号" id="alipayNo" name="alipayNo"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>













							<div class="form-group">
                                <label class="col-sm-2 control-label">微信交易号:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.wechatNo}"
                                           placeholder="微信交易号" id="wechatNo" name="wechatNo"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>






















								<div class= "box-body" >
                                  < div class= "form-group" >
                                  < label class="col-sm-2 control-label" >支付时间:</label >
                          < div style = "width: 65.5%; padding-left: 21px;" class= "input-group date form_datetime1 col-md-5" data - date - format = "yyyy-MM-dd HH:mm:ss"
											data - link - field = "dtp_input1" >
                                                    < input style = "background-color: white;"  class= "form-control" type = "text" placeholder = "支付时间" id = "payTime" name = "payTime" readonly >
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













								<div class= "box-body" >
                                  < div class= "form-group" >
                                  < label class="col-sm-2 control-label" >预约时间:</label >
                          < div style = "width: 65.5%; padding-left: 21px;" class= "input-group date form_datetime1 col-md-5" data - date - format = "yyyy-MM-dd HH:mm:ss"
											data - link - field = "dtp_input1" >
                                                    < input style = "background-color: white;"  class= "form-control" type = "text" placeholder = "预约时间" id = "appointmentTime" name = "appointmentTime" readonly >
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













								<div class= "box-body" >
                                  < div class= "form-group" >
                                  < label class="col-sm-2 control-label" >应邀时间:</label >
                          < div style = "width: 65.5%; padding-left: 21px;" class= "input-group date form_datetime1 col-md-5" data - date - format = "yyyy-MM-dd HH:mm:ss"
											data - link - field = "dtp_input1" >
                                                    < input style = "background-color: white;"  class= "form-control" type = "text" placeholder = "应邀时间" id = "onInvitationTime" name = "onInvitationTime" readonly >
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













								<div class= "box-body" >
                                  < div class= "form-group" >
                                  < label class="col-sm-2 control-label" >结束时间:</label >
                          < div style = "width: 65.5%; padding-left: 21px;" class= "input-group date form_datetime1 col-md-5" data - date - format = "yyyy-MM-dd HH:mm:ss"
											data - link - field = "dtp_input1" >
                                                    < input style = "background-color: white;"  class= "form-control" type = "text" placeholder = "结束时间" id = "endTime" name = "endTime" readonly >
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
                                <label class="col-sm-2 control-label">应邀优势:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.advantage}"
                                           placeholder="应邀优势" id="advantage" name="advantage"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>






















								<div class= "box-body" >
                                  < div class= "form-group" >
                                  < label class="col-sm-2 control-label" >付款时间:</label >
                          < div style = "width: 65.5%; padding-left: 21px;" class= "input-group date form_datetime1 col-md-5" data - date - format = "yyyy-MM-dd HH:mm:ss"
											data - link - field = "dtp_input1" >
                                                    < input style = "background-color: white;"  class= "form-control" type = "text" placeholder = "付款时间" id = "paymentTime" name = "paymentTime" readonly >
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













								<div class= "box-body" >
                                  < div class= "form-group" >
                                  < label class="col-sm-2 control-label" >订单完成时间:</label >
                          < div style = "width: 65.5%; padding-left: 21px;" class= "input-group date form_datetime1 col-md-5" data - date - format = "yyyy-MM-dd HH:mm:ss"
											data - link - field = "dtp_input1" >
                                                    < input style = "background-color: white;"  class= "form-control" type = "text" placeholder = "订单完成时间" id = "finishTime" name = "finishTime" readonly >
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
                                        <label class="col-sm-2 control-label">是否已评价:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control"
                                                   value="${model.appraise}"
                                                   placeholder="是否已评价" id="appraise"
                                                   name="appraise"/>
                                        </div>
                                    </div>


















								<div class= "box-body" >
                                  < div class= "form-group" >
                                  < label class="col-sm-2 control-label" >评价时间:</label >
                          < div style = "width: 65.5%; padding-left: 21px;" class= "input-group date form_datetime1 col-md-5" data - date - format = "yyyy-MM-dd HH:mm:ss"
											data - link - field = "dtp_input1" >
                                                    < input style = "background-color: white;"  class= "form-control" type = "text" placeholder = "评价时间" id = "appraiseTime" name = "appraiseTime" readonly >
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
                                        <label class="col-sm-2 control-label">退款金额:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control"
                                                   value="${model.orderRefundTime}"
                                                   placeholder="退款金额" id="orderRefundTime"
                                                   name="orderRefundTime"/>
                                        </div>
                                    </div>









							<div class="form-group">
                                <label class="col-sm-2 control-label">退款理由:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.refundReason}"
                                           placeholder="退款理由" id="refundReason" name="refundReason"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>






















								<div class= "box-body" >
                                  < div class= "form-group" >
                                  < label class="col-sm-2 control-label" >退款时间:</label >
                          < div style = "width: 65.5%; padding-left: 21px;" class= "input-group date form_datetime1 col-md-5" data - date - format = "yyyy-MM-dd HH:mm:ss"
											data - link - field = "dtp_input1" >
                                                    < input style = "background-color: white;"  class= "form-control" type = "text" placeholder = "退款时间" id = "refundTime" name = "refundTime" readonly >
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
                                <label class="col-sm-2 control-label">拒绝退款:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.rejectReason}"
                                           placeholder="拒绝退款" id="rejectReason" name="rejectReason"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>






















								<div class= "box-body" >
                                  < div class= "form-group" >
                                  < label class="col-sm-2 control-label" >拒退时间:</label >
                          < div style = "width: 65.5%; padding-left: 21px;" class= "input-group date form_datetime1 col-md-5" data - date - format = "yyyy-MM-dd HH:mm:ss"
											data - link - field = "dtp_input1" >
                                                    < input style = "background-color: white;"  class= "form-control" type = "text" placeholder = "拒退时间" id = "rejectTime" name = "rejectTime" readonly >
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
                                <label class="col-sm-2 control-label">备注:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.remarks}"
                                           placeholder="备注" id="remarks" name="remarks"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
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
                         $('#payTime').val(time);
                         $('#appointmentTime').val(time);
                         $('#onInvitationTime').val(time);
                         $('#endTime').val(time);
                         $('#paymentTime').val(time);
                         $('#finishTime').val(time);
                         $('#appraiseTime').val(time);
                         $('#refundTime').val(time);
                         $('#rejectTime').val(time);
        },
        callback: updateResult
    });
		
			
				 	var ue = UE.getEditor('content');
		































</script>
</body>
</html>
					
