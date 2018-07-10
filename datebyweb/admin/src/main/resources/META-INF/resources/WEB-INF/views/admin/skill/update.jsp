<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>技能表修改 </title>

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













									<div class= "form-group" >
                                  < label class="col-sm-2 control-label" >菜单:</label >
                          < div class="col-sm-8" >
											<select name = "classify.id" style = "width: 100% !important;" class= "form-control select2" id = "classify" >
                                      < c:forEach items = "${classifyList}" var ="m" >
                              < option    ${model.classify.id == m.id ? 'selected' : '' }  value="${m.id}">
                                  ${m.name}
													</option>
												</c:forEach> 
											</select>
									</div>
								</div>













									<div class= "form-group" >
                                  < label class="col-sm-2 control-label" >教育:</label >
                          < div class="col-sm-8" >
											<select name = "education.id" style = "width: 100% !important;" class= "form-control select2" id = "education" >
                                      < c:forEach items = "${educationList}" var ="m" >
                              < option    ${model.education.id == m.id ? 'selected' : '' }  value="${m.id}">
                                  ${m.name}
													</option>
												</c:forEach> 
											</select>
									</div>
								</div>













									<div class= "form-group" >
                                  < label class="col-sm-2 control-label" >工作:</label >
                          < div class="col-sm-8" >
											<select name = "work.id" style = "width: 100% !important;" class= "form-control select2" id = "work" >
                                      < c:forEach items = "${workList}" var ="m" >
                              < option    ${model.work.id == m.id ? 'selected' : '' }  value="${m.id}">
                                  ${m.name}
													</option>
												</c:forEach> 
											</select>
									</div>
								</div>







	                        <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">技能相册:</label>
                                    <div class="col-sm-8">
									
                                        <input class="file" type="file" id='skillImagesUrl'> <input
                                            value="${model.skillImagesUrl}"
                                            name="skillImagesUrl" id="skillImagesUrl_input" type="hidden"/>
                                        <div style="overflow: hidden;" class="skillImagesUrl">

                                            <div class="showimg-box pull-left">
                                                <div class="showimg">
                                                    <img src="${model.skillImagesUrl}" width="80" height="60"
                                                         onclick="adminShowPic(this)">
                                                </div>
                                                <span onclick="delPic(this,skillImagesUrl)"
                                                      class="fa fa-close delete"></span>
                                            </div>


                                        </div>
                                    </div>
                                </div>
                            </div>






















									<div class="form-group">
                                        <label class="col-sm-2 control-label">咨询对象:</label>
                                        <div class="col-sm-8">
											<label><input value="1"  ${model.statusAdvisory==1
                                                ?'checked':'' } type="radio" class="minimal" name="statusAdvisory"
                                                >单方需要咨询</label>
											<label><input value="2"  ${model.statusAdvisory==2
                                                ?'checked':'' } type="radio" class="minimal" name="statusAdvisory"
                                                >双方需要咨询</label>
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
                                <label class="col-sm-2 control-label">服务擅长:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.adept}"
                                           placeholder="服务擅长" id="adept" name="adept"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>













							<div class="form-group">
                                <label class="col-sm-2 control-label">服务介绍:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.introduce}"
                                           placeholder="服务介绍" id="introduce" name="introduce"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>













							<div class="form-group">
                                <label class="col-sm-2 control-label">专业回答:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.specialty}"
                                           placeholder="专业回答" id="specialty" name="specialty"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>

















									<div class="form-group">
                                        <label class="col-sm-2 control-label">服务价格:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control"
                                                   value="${model.serviceMoney}"
                                                   placeholder="服务价格" id="serviceMoney"
                                                   name="serviceMoney"/>
                                        </div>
                                    </div>




















									<div class="form-group">
                                        <label class="col-sm-2 control-label">派单状态:</label>
                                        <div class="col-sm-8">
											<label><input value="1"  ${model.statusSendOrder==1
                                                ?'checked':'' } type="radio" class="minimal" name="statusSendOrder"
                                                >接受派单</label>
											<label><input value="2"  ${model.statusSendOrder==2
                                                ?'checked':'' } type="radio" class="minimal" name="statusSendOrder"
                                                >不接派单</label>
                                        </div>
                                    </div>






									<div class="form-group">
                                        <label class="col-sm-2 control-label">应邀数:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control"
                                                   value="${model.totalInvitation}"
                                                   placeholder="应邀数" id="totalInvitation"
                                                   name="totalInvitation"/>
                                        </div>
                                    </div>




















									<div class="form-group">
                                        <label class="col-sm-2 control-label">审核状态:</label>
                                        <div class="col-sm-8">
											<label><input value="1"  ${model.statusCheck==1
                                                ?'checked':'' } type="radio" class="minimal" name="statusCheck"
                                                >待完善</label>
											<label><input value="2"  ${model.statusCheck==2
                                                ?'checked':'' } type="radio" class="minimal" name="statusCheck"
                                                >审核中</label>
											<label><input value="3"  ${model.statusCheck==3
                                                ?'checked':'' } type="radio" class="minimal" name="statusCheck"
                                                >已驳回</label>
											<label><input value="4"  ${model.statusCheck==4
                                                ?'checked':'' } type="radio" class="minimal" name="statusCheck"
                                                >已通过</label>
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
        },
        callback: updateResult
    });
		
			
				 	var ue = UE.getEditor('content');
		
















</script>
</body>
</html>
					
