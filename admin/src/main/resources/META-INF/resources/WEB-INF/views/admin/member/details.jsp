<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>会员详细信息</title>

<%@ include file="/common/admin/head.jsp"%>


</head>

<body>
	<section class="content">
		<form class="form-horizontal" method="post" id="form-admin-add"
			action="${adp}details.json">
			<input type="hidden" name="id" value="${model.id}" />
			<div class="row">
				<div class="col-md-12">

					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">详情</h3>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"> 名称:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" value="${model.name}"
									style="border: none;" readonly="readonly" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label"> openid:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" value="${model.openid}"
									style="border: none;" readonly="readonly" />
							</div>
						</div>










						<div class="form-group">
							<label class="col-sm-2 control-label"> 推广ID:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
									value="${model.generalizeId}" style="border: none;"
									readonly="readonly" />
							</div>
						</div>













						<div class="form-group">
							<label class="col-sm-2 control-label"> 昵称:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
									value="${model.nickname}" style="border: none;"
									readonly="readonly" />
							</div>
						</div>













						<div class="form-group">
							<label class="col-sm-2 control-label"> 头像地址:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" value="${model.iocUrl}"
									style="border: none;" readonly="readonly" />
							</div>
						</div>















						<div class="form-group">
							<label class="col-sm-2 control-label"> 手机号:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" value="${model.mobile}"
									style="border: none;" readonly="readonly" />
							</div>
						</div>











						<div class="form-group"  >
							<label class="col-sm-2 control-label"> 等级:</label>
							<div class="col-sm-8">
								<input style="text-align: left;" type="text" class="form-control" 
								value="<c:if test="${model.level == 1}">竹语游客</c:if><c:if test="${model.level == 2}">普通会员 </c:if><c:if test="${model.level == 3}">业务经理 </c:if><c:if test="${model.level == 4}">城市经理</c:if><c:if test="${model.level == 5}">合作伙伴</c:if>"
									style="border: none;" readonly="readonly" />
							</div>
						</div>

















						<div class="form-group">
							<label class="col-sm-2 control-label"> 性别:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
									value="${model.gender eq 1?'男':(model.gender eq 2?'女':'不详')}"
									style="border: none;" readonly="readonly" />
							</div>
						</div>




















						<div class="form-group">
							<label class="col-sm-2 control-label"> 可用积分:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
									value="${model.integral}" style="border: none;"
									readonly="readonly" />
							</div>
						</div>






						<div class="form-group">
							<label class="col-sm-2 control-label"> 国家:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" value="${model.country}"
									style="border: none;" readonly="readonly" />
							</div>
						</div>









						<div class="form-group">
							<label class="col-sm-2 control-label"> 省份:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
									value="${model.province}" style="border: none;"
									readonly="readonly" />
							</div>
						</div>













						<div class="form-group">
							<label class="col-sm-2 control-label"> 城市:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" value="${model.city}"
									style="border: none;" readonly="readonly" />
							</div>
						</div>













						<div class="form-group">
							<label class="col-sm-2 control-label"> 所在区域:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" value="${model.area}"
									style="border: none;" readonly="readonly" />
							</div>
						</div>













						<div class="form-group">
							<label class="col-sm-2 control-label"> 推荐人的开放ID:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
									value="${model.referrerGeneralizeId}" style="border: none;"
									readonly="readonly" />
							</div>
						</div>


























						<div class="form-group">
							<label class="col-sm-2 control-label"> 推荐人昵称:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
									value="${model.referrerNickname}" style="border: none;"
									readonly="readonly" />
							</div>
						</div>



























						<div class="form-group">
							<label class="col-sm-2 control-label"> 消费额:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" value="${model.consume}"
									style="border: none;" readonly="readonly" />
							</div>
						</div>















						<div class="form-group">
							<label class="col-sm-2 control-label"> 拯救树:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" value="${model.love}"
									style="border: none;" readonly="readonly" />
							</div>
						</div>









						<div class="form-group">
							<label class="col-sm-2 control-label"> 推广费:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" value="${model.generalizeCost}"
									style="border: none;" readonly="readonly" />
							</div>
						</div>













						<div class="form-group">
							<label class="col-sm-2 control-label"> 可提现金额:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" value="${model.balance}"
									style="border: none;" readonly="readonly" />
							</div>
						</div>











						<div class="box-body">
							<div class="form-group">
								<label class="col-sm-2 control-label"></label>
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
			btnSubmit : ".btn_sub",
			btnReset : ".btn_reset",
			tiptype : 3,
			ignoreHidden : false,
			dragonfly : false,
			tipSweep : true,
			label : ".label",
			showAllError : false,
			postonce : true,
			ajaxPost : true,

			beforeCheck : function(curform) {
				//在表单提交执行验证之前执行的函数，curform参数是当前表单对象。
				//这里明确return false的话将不会继续执行验证操作;	
			},
			beforeSubmit : function(curform) {
				//在验证成功后，表单提交前执行的函数，curform参数是当前表单对象。
				//这里明确return false的话表单将不会提交;
				var time = $('.auto-kal');
			},
			callback : updateResult
		});

		var ue = UE.getEditor('content');
	</script>
</body>
</html>

