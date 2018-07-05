<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>服务分类表修改 </title>

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
                                  < label class="col-sm-2 control-label" >分类:</label >
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





							<div class="form-group">
                                <label class="col-sm-2 control-label">服务类型:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${model.serve}"
                                           placeholder="服务类型" id="serve" name="serve"
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           />
                                </div>
                            </div>

















									<div class="form-group">
                                        <label class="col-sm-2 control-label">价格:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control"
                                                   value="${model.showPrice}"
                                                   placeholder="价格" id="showPrice"
                                                   name="showPrice"/>
                                        </div>
                                    </div>











	                        <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">显示图片:</label>
                                    <div class="col-sm-8">
									
                                        <input class="file" type="file" id='imgerPath'> <input
                                            value="${model.imgerPath}"
                                            name="imgerPath" id="imgerPath_input" type="hidden"/>
                                        <div style="overflow: hidden;" class="imgerPath">

                                            <div class="showimg-box pull-left">
                                                <div class="showimg">
                                                    <img src="${model.imgerPath}" width="80" height="60"
                                                         onclick="adminShowPic(this)">
                                                </div>
                                                <span onclick="delPic(this,imgerPath)"
                                                      class="fa fa-close delete"></span>
                                            </div>


                                        </div>
                                    </div>
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

















									<div class="form-group">
                                        <label class="col-sm-2 control-label">排序:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control"
                                                   value="${model.sort}"
                                                   placeholder="排序" id="sort"
                                                   name="sort"/>
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
					
