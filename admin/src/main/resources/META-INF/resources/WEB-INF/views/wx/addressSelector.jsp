<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="/static/wx/css/css.css" />
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta name="format-detection" content="telephone=no" />
<meta name="format-detection" content="email=no" />
<meta name="msapplication-tap-highlight" content="no">
</head>
<body>
<!-- 中间 -->
<!-- 一行 -->
<div class="setlist">
	<div class="setitem">
		<div class="dl">
			<div class="min120 dt">收货人</div>
			<div class="dd"><input type="text" placeholder="请填写收货人姓名" class="dtint"></div>
		</div>
	</div>
	<div class="setitem">
		<div class="dl">
			<div class="min120 dt">联系电话</div>
			<div class="dd"><input type="tel" placeholder="请填写手机号/固定电话" class="dtint"></div>
		</div>
	</div>
	<div class="setitem">
		<div onclick="document.getElementById('cityselcpop').classList.add('show');" class="dl">
			<div class="min120 dt">所在地区</div>
			<div class="dd"><input type="text" placeholder="请选择城市地址" class="dtint"></div>
		</div>
	</div>
	<div class="setitem">
		<a href="###" class="dl">
			<div class="dd"><input type="text" placeholder="请输入详细地址（请勿重复输入省市县）" class="dtint"></div>
		</a>
	</div>
</div>
<div class="mt80 spcbtnrow">
	<div class="spcbtnrow_item"><a href="###" class="secondbtn radiusbtn mdbtn">清除信息</a></div>
	<div class="spcbtnrow_item"><a href="###" class="primarybtn radiusbtn mdbtn">保存地址</a></div>
</div>
<!-- end 一行 -->
<!--end 中间-->



<!-- cpop -->
<div class="show cpop" id="cityselcpop">
	<div onclick="document.getElementById('cityselcpop').classList.remove('show');" class="fade_bkbg"></div>
	<div class="cpopcenter">
		<div class="selcpop">
			<div class="selcpop_mt">请选择城市地址</div>
			<div class="selcpop_mc">
				<ul class="selcpop_citylist">
					<li><a href="###">云南</a></li>
					<li><a href="###">内蒙古</a></li>
					<li><a href="###">吉林</a></li>
					<li><a href="###">四川</a></li>
					<li><a href="###">宁夏</a></li>
					<li><a href="###">安徽</a></li>
					<li><a href="###">山东</a></li>
					<li><a href="###">山西</a></li>
					<li><a href="###">广东</a></li>
					<li><a href="###">广西</a></li>
				</ul>
			</div>
			<div class="tborder selcpop_mb">
				<div class="spcbtnrow">
					<div class="spcbtnrow_item"><a href="javascript:;" onclick="document.getElementById('cityselcpop').classList.remove('show');"  class="popmbtn">取消</a></div>
					<div class="spcbtnrow_item"><a href="###" class="popmbtn">重选</a></div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- cpop -->



<script>
document.addEventListener("touchstart", function(){}, true);
</script>


</body>
</html>