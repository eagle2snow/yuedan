<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>填写退货单</title>
<link rel="stylesheet" type="text/css" href="/static/wx/css/css.css" />

<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>

<style type="text/css">
.Validform_title {
	display: none;
}
</style>

</head>
<body>

	<form action="${adp}backOrder" class='form'>
	
		<input name="orderId" value="${order.id }" type="hidden"/>
	
		<div class="weui-cells weui-cells_form">

			<div class="weui-cells__title">退款理由</div>
			<div class="weui-cells">
				<div class="weui-cell weui-cell_select">
					<div class="weui-cell__bd">
						<select class="weui-select" name="reason">
							<option value="七天无条件包退">七天无条件包退换</option>
							<option value="质量问题">质量问题</option>
							<option value="其他理由">其他理由</option>
						</select>
					</div>
				</div>
			</div>


			<div class="weui-cells__title">备注</div>
			<div class="weui-cells weui-cells_form">
				<div class="weui-cell">
					<div class="weui-cell__bd">
						<textarea class="weui-textarea" placeholder="请输入备注" rows="3" name="mark"></textarea>
					</div>
				</div>
			</div>

			<div class="weui-cells__title">上传图片</div>

			<div class="weui-cells weui-cells_form">
				<div class="weui-cell">
					<div class="weui-cell__bd">
						<div class="weui-uploader">
							<div class="weui-uploader__bd">
								<ul class="weui-uploader__files" id="uploaderFiles">
								</ul>
								<div class="weui-uploader__input-box">
									<input id="uploaderInput" class="weui-uploader__input"
										onclick="wxChooseImage()">
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<input name="pics" id="pics" type="hidden" />
				
				
			</div>
			<div class="weui-cells weui-cells_form">
				<p class="weui-btn-area">
					<a href="javascript:;" class="weui-btn weui-btn_primary">提交</a> <a
						href="javascript:;" class="weui-btn weui-btn_default">返回</a>
				</p>
			</div>
		</div>
	</form>






	<%@ include file="/common/wx/js.jsp"%>
	<%@ include file="/common/wx/socket.jsp"%>

	<script type="text/javascript"
		src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>

	<script type="text/javascript">
		$(function() {
			wx.config({
				debug : false,
				appId : '${appId}',
				timestamp : '${res.timestamp}',
				nonceStr : '${res.noncestr}',
				signature : '${res.signature}',
				jsApiList : [
				// 所有要调用的 API 都要加到这个列表中  
				'chooseImage', 'previewImage', 'uploadImage', 'downloadImage' ]
			});

			wx.ready(function() {
				wx.checkJsApi({
					jsApiList : [ 'chooseImage', 'previewImage', 'uploadImage',
							'downloadImage' ],
					success : function(res) {
						if (res.checkResult.getLocation == false) {
							alert('你的微信版本太低，不支持微信JS接口，请升级到最新的微信版本！');
							return;
						}
					}
				});
			});
			wx.error(function(res) {
				// config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。  
				alert("验证失败，请重试！");
				wx.closeWindow();
			});

		});

		var images = {
			localId : [],
			serverId : []
		};

		//拍照或从手机相册中选图接口  
		function wxChooseImage() {

			wx
					.chooseImage({
						success : function(res) {
							images.localId = res.localIds;
							if (images.localId.length == 0) {
								alert('请先使用 chooseImage 接口选择图片');
								return;
							}
							var i = 0, length = images.localId.length;
							images.serverId = [];
							function upload() {
								//图片上传  
								wx
										.uploadImage({
											localId : images.localId[i],
											success : function(res) {
												i++;
												images.serverId
														.push(res.serverId);
												//图片上传完成之后，进行图片的下载，图片上传完成之后会返回一个在腾讯服务器的存放的图片的ID--->serverId  
												wx
														.downloadImage({
															serverId : res.serverId, // 需要下载的图片的服务器端ID，由uploadImage接口获得  
															isShowProgressTips : 1, // 默认为1，显示进度提示  
															success : function(
																	res) {
																var localId = res.localId; // 返回图片下载后的本地ID  

																//通过下载的本地的ID获取的图片的base64数据，通过对数据的转换进行图片的保存  
																wx
																		.getLocalImgData({
																			localId : localId, // 图片的localID  
																			success : function(
																					res) {
																				var localData = res.localData; // localData是图片的base64数据，可以用img标签显示  

																				$(
																						"#uploaderFiles")
																						.append(
																								"<li class='weui-uploader__file'><img src='"
																										+ localData
																										+ "'></li>");
																			}
																		});
															}
														});
												if (i < length) {
													upload();
												}
											},
											fail : function(res) {
												alert(JSON.stringify(res));
											}
										});
							}
							upload();
						}
					});
		}
	</script>

<script src="/static/plugins/Validform/5.3.2/Validform.min.js"></script>

	<script>
	
	
	$(".form").Validform({
		btnSubmit : ".weui-btn_primary",
		tiptype : 3,
		ignoreHidden : false,
		dragonfly : false,
		tipSweep : true,
		label : ".label",
		showAllError : false,
		postonce : true,
		ajaxPost : true,
		beforeCheck : function(curform) {
		},
		beforeSubmit : function(curform) {
			var pics = images.serverId.join("|");
			$("#pics").val(pics);
		},
		callback : function(res) {
			if(res.s==1){
				$.alert("申请成功，我们将在24小时内审核", function() {
					location.href="${adp}myOrders/0";
				});
			}else if(res.s==2){
				$.alert("系统有误", function() {
					history.go(-1);	
				});
			}else{
				$.alert("订单状态有误", function() {
					history.go(-1);	
				});
			}
		}
	});
	
		document.addEventListener("touchstart", function() {
		}, true);
	</script>


</body>
</html>