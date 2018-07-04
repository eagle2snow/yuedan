$('.file')
		.fileinput({
			dropZoneEnabled : false,
			showCaption : false,
			showRemove : false,
			showUpload : false,
			showPreview : false,
			showCancel : false,
			uploadUrl : '/euditor?action=uploadimage',
			allowedFileExtensions : [ 'jpeg', 'jpg', 'png', 'gif' ]
		})
		.on("filebatchselected", function(event, files) {
			$(this).fileinput("upload");// 选择完立即上传
		})
		.on(
				"fileuploaded",
				function(event, data, previewId, index) {// 上传完后
					var url = data.response.url;
					if (typeof (url) == 'undefined') {
						return false;
					}
					var inputId = this.id;
					var img = '<div class="showimg-box pull-left"><div class="showimg"><img src="'
							+ url
							+ '" width="80" height="60" onclick="adminShowPic(this)"/></div><span onclick="delPic(this,'
							+ this.id
							+ ')" class="fa fa-close delete"></span></div>';

					var $inp = $('#' + inputId + '_input');
					
					convertImgToBase64(url,function(res){
						$("#baseThumb").val(res); 
					});
					
					$inp.val(url);
					$('.' + inputId).html(img);
				});

$('.files')
		.fileinput({
			dropZoneEnabled : false,
			showCaption : false,
			showRemove : false,
			showUpload : false,
			showPreview : false,
			showCancel : false,
			uploadUrl : '/euditor?action=uploadimage',
			allowedFileExtensions : [ 'jpeg', 'jpg', 'png', 'gif' ]
		})
		.on("filebatchselected", function(event, files) {
			$(this).fileinput("upload");// 选择完立即上传
		})
		.on(
				"fileuploaded",
				function(event, data, previewId, index) {// 上传完后
					var url = data.response.url;
					if (typeof (url) == 'undefined') {
						return false;
					}
					var inputId = this.id;
					var img = '<div class="showimg-box pull-left"><div class="showimg"><img src="'
							+ url
							+ '" width="80" height="60" onclick="adminShowPic(this)"/></div><span onclick="delPics(this,'
							+ this.id
							+ ')" class="fa fa-close delete"></span></div>';

					var $inp = $('#' + inputId + '_input');

					var oldSrc = $inp.val();

					if ($.trim(oldSrc) == '') {
						$inp.val(url);
					} else {
						$inp.val($inp.val() + '|' + url);
					}

					$('.' + inputId).append(img);
				});

function delPic(tem, id) {
	var inputIds = $(id).attr("id");
	var src = $(tem).parent().find('img').attr('src');
	/*var v = $('#' + inputIds + '_input').val().replace(src, "");
	$('#' + inputIds + '_input').val(v);*/
	$('#' + inputIds + '_input').val("");
	$("#baseThumb").val(""); 
	
	$(tem).parent().remove();
}

function delPics(tem, id) {
	var inputIds = $(id).attr("id");
	var src = $(tem).parent().find('img').attr('src');
	var oldSrc = $('#' + inputIds + '_input').val();

	var v;
	if (oldSrc.indexOf(src) == 0) {
		v = oldSrc.replace(src, "");
	} else {
		v = oldSrc.replace("|" + src, "");
	}
	$('#' + inputIds + '_input').val(v);
	$(tem).parent().remove();
}

function adminShowPic(tem) {
	var imgUrl = $(tem).attr("src");
	layer.open({
		type : 2,
		title : '图片预览',
		shadeClose : true,
		shade : 0.5,
		area : [ '90%', '90%' ],
		content : imgUrl
	});

}