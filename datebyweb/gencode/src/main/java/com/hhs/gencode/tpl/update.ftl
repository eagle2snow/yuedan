<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<#list list as l>
	<#if (l_index < 1)>
<title>${l.m}修改 </title>
	</#if>
</#list>

    <%@ include file="/common/admin/head.jsp"%>


</head>

<body>
<section class="content">
    <form class="form-horizontal" method="post" id="form-admin-add" action="${r"${adp}"}update.json">
        <input type="hidden" name="id" value="${r"${model.id}"}"/>
        <div class="row">
            <div class="col-md-12">

                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">编辑</h3>
                    </div>
					<#assign n=-1 />
					  <#list list as f>
						  <#if f.type=='ONOFF' >
						  </#if>
						  <#if f.type=='HIDDEN' >
                      	  <input type="hidden" class="form-control" value="${r"${model."}${f.fieldName}}"
                                 placeholder="${f.lable!""}" id="${f.fieldName!""}" name="${f.fieldName!""}"/>
						  </#if>
						  <#if f.type=='TEXTINPUT' >
							<div class="form-group">
                                <label class="col-sm-2 control-label"><#if f.datatype??><#if f.datatype!=""><i class="red">*</i></#if></#if>${f.lable!""}:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" value="${r"${model."}${f.fieldName}}"
                                           placeholder="${f.lable!""}" id="${f.fieldName!""}" name="${f.fieldName!""}" <#if f.datatype?? && f.datatype!="">datatype="${f.datatype}"</#if> <#if f.errormsg?? && f.errormsg!="">errormsg="${f.errormsg}"</#if>  <#if f.recheck?? && f.recheck!="">recheck="${f.recheck}"</#if> <#if f.ajaxurl?? && f.ajaxurl!="">ajaxurl="${f.ajaxurl}"</#if> <#if f.sucmsg?? && f.sucmsg!="">sucmsg="${f.sucmsg}"</#if> <#if f.nullmsg?? && f.nullmsg!="">nullmsg="${f.nullmsg}"</#if> <#if f.ignore?? && f.ignore!="">ignore="${f.ignore}"</#if> <#if f.tip?? && f.tip!="">tip="${f.tip}"</#if> <#if f.altercss?? && f.altercss!="">altercss="${f.altercss}"</#if> <#if f.plugin?? && f.plugin!="">plugin="${f.plugin}"</#if>/>
                                </div>
                            </div>
						  </#if>

						  <#if f.type=='PASSWORD' >
							<div class="form-group">
                                <label class="col-sm-2 control-label"><#if f.datatype??><#if f.datatype!=""><i class="red">*</i></#if></#if>${f.lable!""}:</label>
                                <div class="col-sm-8">
                                    <input type="password" class="form-control"
                                           placeholder="${f.lable!""}" id="${f.fieldName!""}" name="${f.fieldName!""}" <#if f.datatype?? && f.datatype!="">datatype="${f.datatype}"</#if> <#if f.errormsg?? && f.errormsg!="">errormsg="${f.errormsg}"</#if> <#if f.recheck?? && f.recheck!="">recheck="${f.recheck}"</#if> <#if f.ajaxurl?? && f.ajaxurl!="">ajaxurl="${f.ajaxurl}"</#if> <#if f.sucmsg?? && f.sucmsg!="">sucmsg="${f.sucmsg}"</#if> <#if f.nullmsg?? && f.nullmsg!="">nullmsg="${f.nullmsg}"</#if> <#if f.ignore?? && f.ignore!="">ignore="${f.ignore}"</#if> <#if f.tip?? && f.tip!="">tip="${f.tip}"</#if> <#if f.altercss?? && f.altercss!="">altercss="${f.altercss}"</#if> <#if f.plugin?? && f.plugin!="">plugin="${f.plugin}"</#if>/>
                                </div>
                            </div>
						  </#if>

						  <#if f.type=='PICTURE' >
	                        <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">${f.lable!""}:</label>
                                    <div class="col-sm-8">
									
									<#if f.fieldName=='thumb' >
										<input type="hidden" id="baseThumb" name="baseThumb" value="${r"${model.baseThumb}"}">
									</#if>
                                        <input class="file" type="file" id='${f.fieldName!""}'> <input value="${r"${model."}${f.fieldName}}"
                                                                                                       name="${f.fieldName!""}" id="${f.fieldName!""}_input" type="hidden" />
                                        <div style="overflow: hidden;" class="${f.fieldName!""}">

                                            <div class="showimg-box pull-left">
                                                <div class="showimg">
                                                    <img src="${r"${model."}${f.fieldName}}" width="80" height="60"
                                                         onclick="adminShowPic(this)">
                                                </div>
                                                <span onclick="delPic(this,${f.fieldName})"
                                                      class="fa fa-close delete"></span>
                                            </div>


                                        </div>
                                    </div>
                                </div>
                            </div>
						  </#if>

						  <#if f.type=='PICTURELIST' >
						<div class="box-body">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">${f.lable!""}:</label>
                                <div class="col-sm-8">
                                    <input class="files" type="file" id='${f.fieldName!""}' multiple> <input
                                        name="${f.fieldName!""}" id="${f.fieldName!""}_input" type="hidden" value="${r"${model."}${f.fieldName}}" />
                                    <div style="overflow: hidden;" class="${f.fieldName!""}">

                                        <c:forEach	items='${r"${fn:split(model."}${f.fieldName},"|")}' var='p'>
                                            <div class="showimg-box pull-left">
                                                <div class="showimg">
                                                    <img src='${r"${p}"}' width="80" height="60"
                                                         onclick="adminShowPic(this)">
                                                </div>
                                                <span onclick="delPics(this,${f.fieldName})"
                                                      class="fa fa-close delete"></span>
                                            </div>
                                        </c:forEach>


                                    </div>
                                </div>
                            </div>
                        </div>
						  </#if>

						  <#if f.type=='NUMBER' >
									<div class="form-group">
                                        <label class="col-sm-2 control-label">${f.lable!""}:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control" value="${r"${model."}${f.fieldName}}"
                                                   placeholder="${f.lable!""}" id="${f.fieldName!""}" name="${f.fieldName!""}" />
                                        </div>
                                    </div>
						  </#if>

						  <#if f.type=='EDITOR' >
	                               <div class="form-group">
										<label class="col-sm-2 control-label"><#if f.datatype??><#if f.datatype!=""><i class="red">*</i></#if></#if>${f.lable!""}:</label>
										<div class="col-sm-8">
											 <script id="${f.fieldName!""}" name="${f.fieldName!""}" type="text/plain" class="ue-editor" style="width:100%; height: 400px;"> ${r"${model."}${f.fieldName}} </script>
										</div>
                          </div>
						  </#if>


						  <#if f.type=='FILE' >
							  <#assign n=n+1 />
								<div class="form-group">
                                  <label class="col-sm-2 control-label"><#if f.datatype??><#if f.datatype!=""><i class="red">*</i></#if></#if>${f.lable!""}:</label>
                          <div class="col-sm-8">
                                  <div id="uploader${n}" class="wu-example">
                                  <!--用来存放文件信息-->
                                  <div class="thelist uploader-list">
                                  <div id="WU_FILE_0" class="item">
                                  <input name="${f.fieldName}" id="WU_FILE_${n}_input" value="" type="hidden">
                                  <h4 class="info">${r"${model."}${f.fieldName}}<i class="glyphicon glyphicon-remove-circle"></i></h4>

                          </div>
                          </div>
                          <div class="btns">
                                  <div class="picker${n} pull-left ">选择文件</div>
                                  <button type="button" class="ctlBtn btn btn-default pull-left col-sm-2" style="height: 40px;margin-left: 10px;">开始上传</button>
											</div>
										</div>
									</div>
								</div>
						  </#if>

						  <#if f.type=='SELECT' >
									<div class="form-group">
                                  <label class="col-sm-2 control-label"><#if f.datatype??><#if f.datatype!=""><i class="red">*</i></#if></#if>${f.lable!""}:</label>
                          <div class="col-sm-8">
							  <#if f.dataNature=='ARRAY' >
											<select name="${f.fieldName!""}" style="width: 100% !important;" class="form-control select2" id="${f.fieldName!""}">
								  <#if f.dataArray?? && f.dataArray?size gt 0>
									  <#list f.dataArray?keys as key  >
											<option value="${key}" ${r'${(model.'}${f.fieldName}==${key})?'selected':''}>${f.dataArray[key]!}</option>
									  </#list>
								  </#if>
							  </#if>
							  <#if f.dataNature=='MODEL'>
											<select name="${f.fieldName!""}.id" style="width: 100% !important;" class="form-control select2" id="${f.fieldName!""}">
                                      <c:forEach items="${r"${"}${f.fieldName!""}List}" var="m">
                              <option    ${r"${model."}${f.fieldName}.id==m.id?'selected':'' }  value="${r"${m.id}"}">
								  ${r"${m.name}"}
													</option>
												</c:forEach> 
							  </#if>
											</select>
									</div>
								</div>
						  </#if>

						  <#if f.type=='TIME' >
									<div class="form-group">
                                  <label class="col-sm-2 control-label"><#if f.datatype??><#if f.datatype!=""><i class="red">*</i></#if></#if>${f.lable!""}:</label>
                          <div class="col-sm-8">
                                  <input value="" id="${f.fieldName!""}" name="${f.fieldName!""}" type="hidden">
                                  <div class="auto-kal" data-kal="months: 2, direction: 'future'"></div>
										</div>
								</div>
						  </#if>

						  <#if f.type=='CHECKBOX' >
									<div class="form-group">
                                  <label class="col-sm-2 control-label"><#if f.datatype??><#if f.datatype!=""><i class="red">*</i></#if></#if>${f.lable!""}:</label>
                          <div class="col-sm-8">
							  <#if f.dataNature=='ARRAY' >
								  <#if f.dataArray?? && f.dataArray?size gt 0>
									  <#list f.dataArray?keys as key  >
											<label><input value="${key}" name="${f.fieldName!""}" type="checkbox" class="minimal">${f.dataArray[key]!}</label>
									  </#list>
								  </#if>
											<script type="text/javascript">
											var checkboxs = '${r"${model."}${f.fieldName}}';
											var arr = new Array();
											arr = checkboxs.split(",");
											var item = document.getElementsByName('${f.fieldName}');
											for (i = 0; i < item.length; i++) {
                                                for(j=0;j<arr.length;j++){
                                                    if(item[i].value==arr[j]){
                                                        item[i].checked = true;
                                                    }
                                                }
                                            }
											</script>
							  </#if>
							  <#if f.dataNature=='MODEL'>
												<div class="check-box ${f.fieldName!""}-admin-check-box">
                                                    <c:forEach items="${r"${"}${f.fieldName!""}List}" var="${f.fieldName!""}Model">
                                                        <label><input value="${r"${"}${f.fieldName!""}Model.id}" name="${f.fieldName!""}" type="checkbox" class="minimal">${r"${"}${f.fieldName!""}Model.name}</label>
                                                    </c:forEach>
                                                </div>
							  </#if>
									</div>
								</div>
						  </#if>

						  <#if f.type=='RADIO' >
									<div class="form-group">
                                        <label class="col-sm-2 control-label"><#if f.datatype??><#if f.datatype!=""><i class="red">*</i></#if></#if>${f.lable!""}:</label>
                                        <div class="col-sm-8">
											<#if f.dataNature=='ARRAY' >
												<#if f.dataArray?? && f.dataArray?size gt 0>
													<#list f.dataArray?keys as key  >
											<label><input value="${key}"  ${r"${model."}${f.fieldName}==${key}?'checked':'' }  type="radio" class="minimal" name="${f.fieldName}">${f.dataArray[key]!}</label>
													</#list>
												</#if>
											</#if>
											<#if f.dataNature=='MODEL'>
											<c:forEach items="${r"${"}${f.fieldName!""}List}" var="${f.fieldName!""}Model">
                                                <label><input value="${r"${"}${f.fieldName!""}Model.id}"  type="radio" class="minimal" name="${f.fieldName!""}">${f.dataArray[key]!}</label>
                                            </c:forEach>
											</#if>
                                        </div>
                                    </div>
						  </#if>

						  <#if f.type=='TEXTAREA' >
									<div class="form-group">
                                        <label class="col-sm-2 control-label"><#if f.datatype??><#if f.datatype!=""><i class="red">*</i></#if></#if>${f.lable!""}:</label>
                                        <div class="col-sm-8">
                                            <textarea name="${f.fieldName!""}" class="form-control" id="${f.fieldName!""}" rows="3" placeholder="Enter ..." <#if f.datatype?? && f.datatype!="">datatype="${f.datatype}"</#if> <#if f.errormsg?? && f.errormsg!="">errormsg="${f.errormsg}"</#if> <#if f.recheck?? && f.recheck!="">recheck="${f.recheck}"</#if> <#if f.ajaxurl?? && f.ajaxurl!="">ajaxurl="${f.ajaxurl}"</#if> <#if f.sucmsg?? && f.sucmsg!="">sucmsg="${f.sucmsg}"</#if> <#if f.nullmsg?? && f.nullmsg!="">nullmsg="${f.nullmsg}"</#if> <#if f.ignore?? && f.ignore!="">ignore="${f.ignore}"</#if> <#if f.tip?? && f.tip!="">tip="${f.tip}"</#if> <#if f.altercss?? && f.altercss!="">altercss="${f.altercss}"</#if> <#if f.plugin?? && f.plugin!="">plugin="${f.plugin}"</#if>>${r"${model."}${f.fieldName}}</textarea>

                                        </div>
                                    </div>
						  </#if>

						  <#if f.type=='TREE' >
						  </#if>
					  </#list>
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
				 <#list list as f>
					 <#if f.type=='TIME' >
						 ${r"$('#"+f.fieldName+"').val(time);"}
					 </#if>
				 </#list>
        },
        callback : updateResult
    });
		
			
		<#list list as f>
			<#if f.type=='EDITOR' >
				 	var ue =  UE.getEditor('${f.fieldName}');
			</#if>
		</#list>
		
		<#assign x=-1 />
		<#list list as f>
			<#if f.type=='FILE' >
				<#assign x=x+1 />
		var $list${x} = $(".thelist").eq(${x}); 
		var $btn${x} = $(".ctlBtn").eq(${x});
		
		var state = 'pending',
                uploader${x};
		var uploader${x} = WebUploader.create({
            // swf文件路径
            swf: '/static/plugins/webuploader/Uploader.swf',
            // 文件接收服务端。
            server: '/euditor?action=uploadfile',
            fileNumLimit:1,
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '.picker${x}',
            // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
            resize: false
        });
		// 当有文件被添加进队列的时候
		uploader${x}.on('fileQueued', function(file) {
            $list${x}.append('<div id="' + file.id + '" class="item">' +
                    '<input name="${f.fieldName!""}" id="'+file.id+'_input" type="hidden" value="${r"${model."}${f.fieldName}}" />'+
                    '<h4 class="info">' + file.name + '<i class="glyphicon glyphicon-remove-circle"></i></h4>' +
                    '<p class="state">等待上传...</p>' +
                    '</div>');
            $list${x}.find("i").bind("click", function() {
                $(this).parent().parent().remove();
            });

        });
		// 文件上传过程中创建进度条实时显示。
		uploader${x}.on('uploadProgress', function(file, percentage) {
            var $li = $('#' + file.id),
                    $percent = $li.find('.progress .progress-bar');

            // 避免重复创建
            if(!$percent.length) {
                $percent = $('<div class="progress progress-striped active">' +
                        '<div class="progress-bar" role="progressbar" style="width: 0%">' +
                        '</div>' +
                        '</div>').appendTo($li).find('.progress-bar');
            }
            $li.find('p.state').text('上传中');
            $percent.css('width', percentage * 100 + '%');
        });

		uploader${x}.on('uploadSuccess', function(file,res) {
            $('#' + file.id+"_input").val(res.url);
            $('#' + file.id).find('p.state').text('已上传');
        });

		uploader${x}.on('uploadError', function(file) {
            $('#' + file.id).find('p.state').text('上传出错');
        });

		uploader${x}.on('uploadComplete', function(file) {
            $('#' + file.id).find('.progress').fadeOut();
        });

		uploader${x}.on('all', function(type) {
            if(type === 'startUpload') {
                state = 'uploading';
            } else if(type === 'stopUpload') {
                state = 'paused';
            } else if(type === 'uploadFinished') {
                state = 'done';
            }

            if(state === 'uploading') {
                $btn${x}.text('暂停上传');
            } else {
                $btn${x}.text('开始上传');
            }
        });
		$list${x}.find("i").bind("click", function() {
            $(this).parent().parent().remove();
        });
		$btn${x}.on('click', function() {
            if(state === 'uploading') {
                uploader${x}.stop();
            } else {
                uploader${x}.upload();
            }
        });
			</#if>

		</#list>
</script>
</body>
</html>
					
					