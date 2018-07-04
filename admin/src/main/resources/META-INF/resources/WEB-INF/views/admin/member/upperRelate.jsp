<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>上家会员信息 </title>
    <%@ include file="/common/admin/head.jsp" %>
</head>
<body>
<section class="content" ${empty upperRelate.id ? "style='display: none'":""} >
    <form class="form-horizontal" method="post" id="form-admin-add"
          action="${adp}details.json">
        <input type="hidden" name="id" value="${upperRelate.id}"/>
        <div class="row">
            <div class="col-md-12">

                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">详情</h3>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label"> 名称:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" value="${upperRelate.name}"
                                   style="border: none;" readonly="readonly"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"> openid:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" value="${upperRelate.openid}"
                                   style="border: none;" readonly="readonly"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"> 推广ID:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"
                                   value="${upperRelate.generalizeId}" style="border: none;"
                                   readonly="readonly"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"> 昵称:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"
                                   value="${upperRelate.nickname}" style="border: none;"
                                   readonly="readonly"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"> 头像地址:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" value="${upperRelate.iocUrl}"
                                   style="border: none;" readonly="readonly"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"> 手机号:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" value="${upperRelate.mobile}"
                                   style="border: none;" readonly="readonly"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"> 等级:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" value="${upperRelate.level}"
                                   style="border: none;" readonly="readonly"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"> 性别:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"
                                   value="${upperRelate.gender eq 1?'男':(upperRelate.gender eq 2?'女':'不详')}"
                                   style="border: none;" readonly="readonly"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"> 可用积分:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"
                                   value="${upperRelate.integral}" style="border: none;"
                                   readonly="readonly"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"> 国家:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" value="${upperRelate.country}"
                                   style="border: none;" readonly="readonly"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"> 省份:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"
                                   value="${upperRelate.province}" style="border: none;"
                                   readonly="readonly"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"> 城市:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" value="${upperRelate.city}"
                                   style="border: none;" readonly="readonly"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"> 所在区域:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" value="${upperRelate.area}"
                                   style="border: none;" readonly="readonly"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"> 拯救树:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" value="${upperRelate.love}"
                                   style="border: none;" readonly="readonly"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"> 可提现金额:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" value="${upperRelate.balance}"
                                   style="border: none;" readonly="readonly"/>
                        </div>
                    </div>


                    <div class="box-body">
                        <div class="form-group">
                            <label class="col-sm-2 control-label"></label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</section>
<span ${empty upperRelate.id ? "style='font-size: 20px'":"style='display: none'"} >&nbsp;&nbsp;&nbsp; 没有上家</span>
<%@ include file="/common/admin/my_js.jsp" %>
</body>
</html>

