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
		<div class="selint dl">
			<div class="min120 dt">所在省份</div>
			<div class="dd"><input type="text" placeholder="请选择省份地址" class="selint_label dtint"></div>
			<select name="Province" class="selint_select"></select>
		</div>
	</div>
	<div class="setitem">
		<div class="selint dl">
			<div class="min120 dt">所在城市</div>
			<div class="dd"><input type="text" placeholder="请选择城市地址" class="selint_label dtint"></div>
			<select name="City" class="selint_select"></select>
		</div>
	</div>
	<div class="setitem">
		<div class="selint dl">
			<div class="min120 dt">所在区域</div>
			<div class="dd"><input type="text" placeholder="请选择区域地址" class="selint_label dtint"></div>
			<select name="Area" class="selint_select"></select>
		</div>
	</div>
	<div class="setitem">
		<a href="###" class="dl">
			<div class="dd"><input type="text" placeholder="请输入详细地址（请勿重复输入省市县）" class="dtint"></div>
		</a>
	</div>
</div>
<div class="cherow"><input type="checkbox" id="defautlocal"><label for="defautlocal">设为默认地址</label></div>
<div class="mt80 spcbtnrow">
	<div class="spcbtnrow_item"><a href="###" class="secondbtn radiusbtn mdbtn">清除信息</a></div>
	<div class="spcbtnrow_item"><a href="###" class="primarybtn radiusbtn mdbtn">保存地址</a></div>
</div>
<!-- end 一行 -->
<!--end 中间-->


<script src="js/tool.js"></script>

<!-- 地址 -->
<script src="js/PCASClass.js" charset="GB2312"></script>
<script>
new PCAS("Province","City","Area","山东省","济南市","海淀区");
</script>
<!-- end 地址 -->



</body>
</html>