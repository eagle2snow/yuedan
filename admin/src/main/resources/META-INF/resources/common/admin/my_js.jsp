<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script src="/static/admin/js/file.js"></script>
<script src="/static/admin/js/main.js"></script>


<script type="text/javascript">


	var pat = new RegExp("[^a-zA-Z0-9\_\u4e00-\u9fa5]", "i");//数字字母中文
	var numAndAbc = new RegExp("[^a-zA-Z0-9]", "i");//只能是数字和字母
	var rx = new RegExp("[^\x00-\xff]");

	$(".showimg img").bind("click",function(){
		var imgUrl = $(this).attr("src");
		layer.open({
			type : 2,
			title : '图片预览',
			shadeClose : true,
			shade : 0.5,
			area : [ '90%', '90%' ],
			content : imgUrl
		});
	});
	
	//convertImgToBase64(imgs,function(res){
	//	console.log(res);
	//	$("#base64").attr("src",res);
	//  });
	
	function convertImgToBase64(url, callback, outputFormat){
		var canvas = document.createElement('canvas'),
		    ctx = canvas.getContext('2d'),
		    img = new Image;
			img.crossOrigin = 'Anonymous';
			img.onload = function(){
				    canvas.height = img.height;
				    canvas.width = img.width;
				    ctx.drawImage(img,0,0);
				    var dataURL = canvas.toDataURL(outputFormat || 'image/png');
				    callback.call(this, dataURL);
				    u = this;
				    canvas = null; 
			};
		    img.src = url;
		}


</script>


