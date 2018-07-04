String.prototype.replaceAll = function(s1, s2) {
	return this.replace(new RegExp(s1, "gm"), s2);
}

var layer = '/static/plugins/layer/layer.js';

document.write('<script type="text/javascript" src="' + layer + '"></script>');

function re(t) {
	if(typeof(t)=='undefined'){
		location.reload();
	}else{
		ret(t);
	}
}

function ret(t) {
	setTimeout(function() {
		location.reload();
	}, t);
}

/**
 * ajax封装函数
 * 
 * @param {}
 * 
 * url 提交地址
 * @param {}
 *            formId 表单ID
 * @param {}
 *            _function 回调函数
 */
function ajax(url, formId, _function) {
	$.ajax({
		type : "POST",
		url : url,
		dataType : "json",
		data : $("#" + formId).serialize(),
		success : function(data) {
			_function(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(errorThrown);
		}
	});
}

/**
 * 获取表单值
 * 
 * @param {}
 *            inputId
 * @return {}
 */
function getValue(inputId) {
	return $("#" + inputId).val();
}

/**
 * 设置指定表单值
 * 
 * @param {}
 *            inputId
 * @param {}
 *            value
 */
function setValue(inputId, value) {
	$("#" + inputId).val(value);
}

/**
 * 据Id删除实体根
 */

function delById(id, url) {
	layer.confirm('您确定要删除吗？', {
		btn : [ '确定', '不删' ]
	// 按钮
	}, function() {
		$.getJSON(url + 'deleteById/' + id + ".json", deleteResult);
	}, function() {
		//layer.msg('不删除！');
	});
}
/**
 * 不删除刷新页面
 */
function delByIdReloadParent(id, url) {
	layer.confirm('您确定要删除吗？', {
		btn : [ '确定', '不删' ]
	// 按钮
	}, function() {
		$.getJSON(url + 'deleteById/' + id + ".json", deleteResult);
	}, function() {
		layer.msg('不删除！');
		location.reload();
	});
}

/**
 * 根据Id删除实体，删除完跳转回列表
 */

function delByIdToList(id, url) {

	$.layer({
		shade : [ 0 ],
		offset : [ '300px', '800px' ],
		area : [ 'auto', 'auto' ],
		dialog : {
			msg : '您确定要删除吗？',
			btns : 2,
			type : 4,
			btn : [ '确定', '不删' ],
			yes : function() {
				$.getJSON(url + "?id=" + id, toList);

			},
			no : function() {
				// layer.msg('你是奇葩！', 2, 13);
			}
		}
	});
}

/**
 * 根据Id更新某个属性
 */

function delById2(url, id, _function) {
	$.getJSON(url + "?id=" + id, function(data) {
		location.reload();
	});
}

function md5() {
	var hash = $.md5(document.getElementById("password").value);
	document.getElementById("password").value = hash;
}

function md51(str) {
	return $.md5(str);
}

function update(url, _function) {
	$.getJSON(url, function(data) {
		_function(data);
	});
}

function updatePvById(id, url, p, v) {
	/*
	 * $.getJSON(url + "?id=" + id + "&p=" + p + "&v=" +
	 * encodeURI(encodeURI(v)), updateResult);
	 */
	$.getJSON(url, updateResult);

}

function updatePvById2(id, url, p, v) {
	layer.confirm('您确定要删除吗？', {
		btn : [ '确定', '不删' ]
	// 按钮
	}, function() {
		// layer.msg(url);
		$.getJSON(url + "?id=" + id + "&p=" + p + "&v=" + v, updateResult);
	}, function() {
		layer.msg('不删除！');

	});

}

// 根据id、属性名、属性值 更新。
function updatePvById3(id, url, p, v) {
	$.getJSON(url + "?id=" + id + "&p=" + p + "&v=" + v, updateResult);
}

/** 检查是否有复选框被选中 */
function checkCheck(checkName) {
	var item = document.getElementsByName(checkName);
	for (i = 0; i < item.length; i++) {
		if (item[i].checked) {
			return true;
			break;
		}
	}
	return false;
}

/**
 * 根据name获取选中值value字串
 * 
 * @param name
 * @returns
 */
function getCheckBoxValueByName(name) {
	obj = document.getElementsByName(name);
	check_val = [];
	for (k in obj) {
		if (obj[k].checked)
			check_val.push(obj[k].value);
	}
	return check_val;
}

/**
 * 根据name获取选中value字串
 * 
 * @param name
 * @returns
 */
function getCheckBoxValueStrByName(name) {
	return getCheckBoxValueByName(name).join(',');
}

/**
 * 根据class获取选中value字串
 * 
 * @param name
 * @returns
 */
function getCheckBoxValueStrByClass(name) {
	return getCheckBoxValueByClass(name).join(',');
}

/**
 * 根据class获取选中某个属性字串
 * 
 * @param name
 * @returns
 */
function getCheckedProStrByClass(className, pro, j) {
	return getCheckedProArrByClass(className, pro).join(j);
}

/**
 * 根据class获取选中value的数组
 * 
 * @param pro
 * @param name
 * @returns
 */
function getCheckBoxValueByClass(name) {
	var check_val = [];
	$("." + name).each(function() {
		if (this.checked) {
			check_val.push($(this).val());
		}
	});
	return check_val;
}

/**
 * 根据class获取选中某个属性的数组
 * 
 * @param pro
 * @param name
 * @returns
 */
function getCheckedProArrByClass(className, pro) {
	var check_val = [];
	$("." + className).each(function() {
		if (this.checked) {
			check_val.push($(this).attr(pro));
		}
	});
	return check_val;
}

/** 批量删除 */
function delByIds(url) {
	var ids = getCheckBoxValueByName("ids");
	if (ids != '') {
		layer.confirm('您确定要删除选中的数据吗？', {
			btn : [ '确定', '不删' ]
		// 按钮
		}, function() {
			$.getJSON(url + 'deleteByIds/' + ids + ".json", deleteResult);
		}, function() {
		});
	} else {
		layer.msg('请勾选');
	}
}

function imp() {
	// layer.msg('你是奇葩！', 2, 13);
	layer.prompt({
		title : '随便上传个东东，并确认',
		type : 2
	}, function(file) {
		alert(file);
	});
}

/** 添加后执行 */
function addResult(data) {
	if (data.status === 'ok') {
		var i = data.status.length;
		var n = setTime(i);
		layer.msg('操作成功');
		reloadData(n * 1000);
	} else if (data.status == 'no') {
		layer.msg('操作失败');
	} else if (data.status == 'NOLO') {
		layer.msg('操作失败，请先登录！');
	} else if (data.inf != null) {
		layer.msg(data.inf);
	} else {
		layer.msg(data.status, {
			icon : 6
		});
	}
}

/**
 * 添加后执行刷新父级页面
 */
function addResultReload(data) {
	console.log(data);
	if (data.status == 'ok') {
		var i = data.status.length;
		var n = setTime(i);
		layer.msg('操作成功');
		exe(reloadParent, 1000);
	} else if (data.status == 'no') {
		layer.msg('操作失败!' + data.info);
	} else if (data.status == 'NOLO') {
		layer.msg('操作失败，请先登录！');
	} else if (data.inf != null) {
		layer.msg(data.inf);
	} else {
		layer.msg(data.status, {
			icon : 6
		});
	}
}

/** 添加后执行 */
function addResult_nf(data) {
	if (data.status == 'ok') {
		var i = data.status.length;
		layer.msg('操作成功');
	} else if (data.status == 'no') {
		layer.msg('操作失败');
	} else if (data.status == 'NOLO') {
		layer.msg('操作失败，请先登录！');
	} else if (data.inf != null) {
		layer.msg(data.inf);
	} else {
		layer.msg(data.status, {
			icon : 6
		});
	}
}

function setTime(i) {
	var n = 2;
	if (i > 5 && i <= 9) {
		n = 2;
	} else if (i > 9 && i <= 12) {
		n = 3;
	} else if (i > 12) {
		n = 5;
	}
	return n;
}

/** 删除后执行 */
function deleteResult(data) {
	console.log(data.status);
	reloadData(1000);
	if (data.status == 'ok') {
		layer.msg('删除成功');
	} else if (data.status == 'no') {
		layer.msg('删除失败');
	} else if (data.status == 'NOLO') {
		layer.msg('删除失败，请先登录！');
	} else {
		layer.msg(data.status, {
			icon : 6
		});
	}
}

function toList(data) {
	if (data.status == 'ok') {
		layer.alert('删除成功', 1, function() {
			location.href = 'postbar/index.html';
		});

	} else if (data.status == 'no') {
		layer.alert('删除失败', 2);
	} else if (data.status == 'NOLO') {
		layer.alert('删除失败，请先登录！', 2);
	} else {
		layer.alert(data.status, 2);
	}
}

/** 更新后执行 */
function updateResult(data) {
	var i = data.status.length;
	var n = setTime(i);
	reloadData(n * 1000);
	if (data.status == 'ok') {
		layer.msg('操作成功');
	} else if (data.status == 'no') {
		layer.msg('操作失败');
	} else if (data.status == 'NOLO') {
		layer.msg('操作失败，请先登录！');
	} else {
		layer.msg(data.status, {
			icon : 6
		});
	}
}
/** 更新后执行刷新父级页面 */
function updateResultReload(data) {
	var i = data.status.length;
	var n = setTime(i);
	if (data.status == 'ok') {
		layer.msg('操作成功');
		exe(reloadParent, 2000);
	} else if (data.status == 'no') {
		layer.msg('操作失败');
	} else if (data.status == 'NOLO') {
		layer.msg('操作失败，请先登录！');
	} else {
		layer.msg(data.status, {
			icon : 6
		});
	}
}
/** 更新后执行不刷新 */
function updateResult2(data) {
	if (data.status == 'ok') {
		layer.msg('操作成功');
	} else if (data.status == 'no') {
		layer.msg('操作失败');
	} else if (data.status == 'NOLO') {
		layer.msg('操作失败，请先登录！');
	} else {
		layer.msg(data.status, {
			icon : 6
		});
	}
}

/** 执行后执行 */
function exeResult(data) {
	var i = data.status.length;
	var n = setTime(i);
	exe(toUrl('/'), n * 1000)
	if (data.status == 'ok') {
		layer.msg('操作成功！');
	} else if (data.status == 'no') {
		layer.msg('操作失败');
	} else if (data.status == 'NOLO') {
		layer.msg('操作失败，请先登录！');
	} else {
		layer.msg(data.status, {
			icon : 6
		});
	}
}

function toUrl(url) {
	location.href = url;
}

/**
 * 显示结果并关闭层
 * 
 * @param fun
 * @param data
 */
function showResultAndExit(data) {
	var i = data.status.length;
	var n = setTime(i);
	closeAfterTime(n * 1000);
	if (data.status == 'ok') {
		layer.msg('操作成功');
	} else if (data.status == 'no') {
		layer.msg('操作失败');
	} else if (data.status == 'NOLO') {
		layer.msg('操作失败，请先登录！');
	} else {
		layer.msg(data.status, {
			icon : 6
		});
	}
}

/** time毫秒后执行 */
function closeAfterTime(time) {
	setTimeout('closeLayer()', time);
}

/** time毫秒后刷新 */
function reloadData(time) {
	setTimeout("location.reload()", time);
}

/** time毫秒后执行 */
function exe(_fun, time) {
	setTimeout(_fun, time);
}

/**
 * 关闭一个层
 * 
 * @returns
 */
function closeLayer() {
	parent.layer.close(index);
}
/**
 * 关闭所有层
 */
function closeAll() {
	parent.layer.closeAll();
}

function delByName(url, name, _function) {
	$.getJSON(url + "?name=" + encodeURI(encodeURI(name)), function(date) {
		_function(date);
	});
}

function importData(url, name, _function) {
	$.getJSON(url + "?name=" + encodeURI(encodeURI(name)), function(date) {
		_function(date);
	});
}

function updateById(url, id, v, _function) {
	$.getJSON(url + v + "?id=" + id, function(date) {
		_function(date);
	});
}



var checkAll = $("[name='checkAll']");
var checkboxes = $("[name='ids']");
checkAll.on('ifChecked ifUnchecked', function(event) {
	if (event.type == 'ifChecked') {
		checkboxes.iCheck('check');
	} else {
		checkboxes.iCheck('uncheck');
	}
});

checkboxes.on('ifChanged', function(event){
	if(checkboxes.filter(':checked').length == checkboxes.length) {
		checkAll.prop('checked', 'checked');
	} else {
		checkAll.prop('checked', false);
	}
	checkAll.iCheck('update');
});



/**
 * 全选
 * 
 * @param {}
 *            checkName
 */
function checkAll(checkName) {
	var item = document.getElementsByName(checkName);

	if (item.length > 0) {
		for (i = 0; i < item.length; i++) {
			item[i].checked = true;
		}
	}
}

/**
 * 取消选择
 * 
 * @param {}
 *            checkName
 */
function noCheckAll(checkName) {
	var item = document.getElementsByName(checkName);
	if (item.length > 0) {
		for (i = 0; i < item.length; i++) {
			item[i].checked = false;
		}
	}
}
/**
 * 复选框反选
 * 
 * @param {}
 *            checkName
 */
function invertCheck(checkName) {
	var item = document.getElementsByName(checkName);
	if (item.length > 0) {
		for (i = 0; i < item.length; i++) {
			if (item[i].checked) {
				item[i].checked = false;
			} else {
				item[i].checked = true;
			}
		}
	}
}

// 复选框事件
// 全选、取消全选的事件
function selectAll() {
	var smObj = document.getElementById("selectall");
	console.log("12" + smObj.checked);
	var item = document.getElementsByName("ids");
	if (smObj.checked) {
		if (item.length > 0) {
			for (i = 0; i < item.length; i++) {
				item[i].checked = true;
			}
		}
	} else {
		if (item.length > 0) {
			for (i = 0; i < item.length; i++) {
				item[i].checked = false;
			}
		}
	}
}
// 子复选框的事件
function setSelectAll() {
	// 当没有选中某个子复选框时，SelectAll取消选中
	if (!$("#subcheck").checked) {
		$("#SelectAll").attr("checked", false);
	}
	var chsub = $("input[type='checkbox'][id='subcheck']").length; // 获取subcheck的个数
	var checkedsub = $("input[type='checkbox'][id='subcheck']:checked").length; // 获取选中的subcheck的个数
	if (checkedsub == chsub) {
		$("#SelectAll").attr("checked", true);
	}
}

/**
 * 控制div的显示隐藏
 * 
 * @param {}
 *            idName
 */
function showOrHidden(idName) {

	if ($("#" + idName).is(":hidden")) {
		$("#" + idName).show();
	} else {
		$("#" + idName).hide();
	}
}
/**
 * 只能输入数字,bug 能输入汉字
 * 
 * @param e
 */
function isNum(e) {
	var k = window.event ? e.keyCode : e.which;
	if (((k >= 48) && (k <= 57)) || k == 8 || k == 0) {
	} else {
		if (window.event) {
			window.event.returnValue = false;
		} else {
			e.preventDefault(); // for firefox
		}
	}
}

function clearNoNum(obj) {
	// 先把非数字的都替换掉，除了数字和.
	obj.value = obj.value.replace(/[^\d.]/g, "");
	// 必须保证第一个为数字而不是.
	obj.value = obj.value.replace(/^\./g, "");
	// 保证只有出现一个.而没有多个.
	obj.value = obj.value.replace(/\.{2,}/g, ".");
	// 保证.只出现一次，而不能出现两次以上
	obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$",
			".");
}

/**
 * 将浮点数四舍五入，取小数点后2位，如果不足2位则补0,
 */
function changeTwoDecimal_f(x) {
	var f_x = parseFloat(x);
	if (isNaN(f_x)) {
		return false;
	}
	var f_x = Math.round(x * 100) / 100;
	var s_x = f_x.toString();
	var pos_decimal = s_x.indexOf('.');
	if (pos_decimal < 0) {
		pos_decimal = s_x.length;
		s_x += '.';
	}
	while (s_x.length <= pos_decimal + 2) {
		s_x += '0';
	}
	return s_x;
}

var ID;
var V;
var PATH;

/**
 * 提交审批
 * 
 * @param reason
 */
function auditAction(reason) {
	$.getJSON(ctx + PATH + "?id=" + ID + "&v=" + V + "&reason=" + reason,
			updateResult);
}

/**
 * 审批
 * 
 * @param id
 * @param v
 * @param url
 */
function audit(id, v, path) {
	ID = id;
	V = v;
	PATH = path;
	if (v == 3) {
		$
				.layer({
					type : 1,
					shade : [ 0 ],
					fix : false,
					title : '不通过理由',
					maxmin : true,
					page : {
						html : '<div><textarea id="ta" class="textinput" style="width:278px;height:103px;"></textarea><input style="margin-left:120px;" type="button" value="提交" onclick=\'auditAction($("#ta").val());\' class="ibtn" /></div>'
					},
					area : [ '300px', '200px' ],
					close : function(index) {
						// location.reload();
					}
				});
	} else {
		$.layer({
			shade : [ 0 ],
			offset : [ '300px', '800px' ],
			area : [ 'auto', 'auto' ],
			dialog : {
				msg : '您确定要提交吗？',
				btns : 2,
				type : 4,
				btn : [ '确定', '取消' ],
				yes : function() {
					auditAction("审批通过！");
				},
			}
		});
	}
}
/**
 * 编辑须审批对象
 * 
 * @param url
 * @param sta
 */

function editAudit(url, sta) {
	if (sta != 1) {
		$.layer({
			shade : [ 0 ],
			offset : [ '300px', '800px' ],
			area : [ 'auto', 'auto' ],
			dialog : {
				msg : '此计划已经审批过，若要修改，须重新审批，是否继续？',
				btns : 2,
				type : 4,
				btn : [ '继续', '取消' ],
				yes : function() {
					location.href = url;
				},
			}
		});
	} else {
		location.href = url;
	}
}

/**
 * 添加成功后跳转至编辑页面
 * 
 * @param data
 */
function toEdit(data) {
	var id = data.status;
	if (id != 0) {
		alert("添加成功！");
		location.href = fpath + 'update.html?id=' + id;
	} else {
		alert("添加失败！");
	}
}

/**
 * 树形菜单 start
 */

var setting = {
	check : {
		enable : true,
		chkStyle : "radio",
		radioType : "all"
	},
	view : {
		dblClickExpand : false
	},
	data : {
		simpleData : {
			enable : true
		}
	},
	callback : {
		onClick : onClick,
		onCheck : onCheck
	}
};

function treeInit() {
	$('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title',
			'Collapse this branch');
	$('.tree li.parent_li > span').on(
			'click',
			function(e) {
				var children = $(this).parent('li.parent_li')
						.find(' > ul > li');
				if (children.is(":visible")) {
					children.hide('fast');
					$(this).attr('title', 'Expand this branch').find(' > i')
							.addClass('icon-plus-sign').removeClass(
									'icon-minus-sign');
				} else {
					children.show('fast');
					$(this).attr('title', 'Collapse this branch').find(' > i')
							.addClass('icon-minus-sign').removeClass(
									'icon-plus-sign');
				}
				e.stopPropagation();
			});

	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
}

function onClick(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.checkNode(treeNode, !treeNode.checked, null, true);
	return false;
}

function onCheck(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"), nodes = zTree
			.getCheckedNodes(true), v = "";
	pid = "";
	for (var i = 0, l = nodes.length; i < l; i++) {
		v += nodes[i].name;
		pid += nodes[i].id;
		console.log(pid);
		break;
	}

	var cityObj = $("#citySel");
	cityObj.attr("value", v);
	$("#pid").attr("value", pid);
}

function showMenu() {
	var cityObj = $("#citySel");
	var cityOffset = $("#citySel").offset();
	$("#menuContent").css({
		left : cityOffset.left + "px",
		top : cityOffset.top + cityObj.outerHeight() + "px"
	}).slideDown("fast");

	$("body").bind("mousedown", onBodyDown);
}
function hideMenu() {
	$("#menuContent").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown);
}
function onBodyDown(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "citySel"
			|| event.target.id == "menuContent" || $(event.target).parents(
			"#menuContent").length > 0)) {
		hideMenu();
	}
}

/**
 * 树形菜单方法end
 */

/**
 * 日期插件初始化
 */
function dateimepickerInit() {
	$(".ui_datapicker").datepicker({
		buttonImageOnly : true
	});

	$(".ui_timepicker").datetimepicker({
		buttonImageOnly : true,
		timeFormat : 'HH:mm:ss',
		stepHour : 1,
		stepMinute : 1,
	});
}

/**
 * 是否为手机号
 * 
 * @param str
 * @returns {Boolean}
 */
function isMobile(str) {
	if (!(/^1[34578]\d{9}$/.test(str))) {
		alert("手机号格式不正确，请重新输入！");
		return false;
	} else {
		return true;
	}
}

/**
 * 获取验证码
 */

var vc;
function getMvcode(path) {

	var mobile = $("#mobile").val();

	if (isMobile(mobile)) {

		var p = 'mobileCode';
		if (typeof (path) != 'undefined') {
			p = path;
		}
		$.getJSON(ctx + 'api/sms/send/' + p + '.json?phoneNumber=' + mobile,
				function(data) {
					if (data.status != '0') {
						alert("验证码已发送到您的手机，请注意查收");
						vc = data.status;
						var o = document.getElementById("getmvbtn");
						time(o);
					}
				});
	} else {
		$("#mobile").select();
		$("#mobile").focus();
	}
}

function getEvcode(email) {
	$.getJSON(ctx + 'api/email/send.json?email=' + email, function(data) {
		if (data.s == 'ok') {
			layer.msg("验证码已发送到您的邮箱");
		} else {
			layer.msg('发送失败，请重试');
		}
	});
}

/**
 * layer 打开层
 */
function opens(title, w, h, url) {
	if ((typeof w == 'number')
			|| (w.indexOf('%') == -1 && w.indexOf('px') == -1
					&& w.indexOf('PX') == -1 && w.indexOf('Px') == -1 && w
					.indexOf('pX') == -1)) {
		w = w + 'px';
	}

	if ((typeof h == 'number')
			|| (h.indexOf('%') == -1 && h.indexOf('px') == -1
					&& h.indexOf('PX') == -1 && h.indexOf('Px') == -1 && h
					.indexOf('pX') == -1)) {
		h = h + 'px';
	}

	layer.open({
		type : 2,
		title : title,
		shadeClose : false,
		fix : true,
		scrolling : 'no',
		maxmin : true,
		shade : 0.8,
		area : [ w, h ],
		end : re,
		content : url
	});
}

/**
 * layer 打开层
 */
function openFull(title, url) {
	layer.open({
		type : 2,
		title : title,
		shadeClose : true,
		fix : true,
		maxmin : true,
		scrolling : 'no',
		shade : 0.8,
		area : [ "100%", "100%" ],
		content : url
	});
}

/**
 * layer 打开层，百分比宽高
 */
function openPer(title, w, h, url) {
	layer.open({
		type : 2,
		title : title,
		shadeClose : true,
		fix : true,
		shade : 0.8,
		maxmin : true,
		area : [ w + "%", h + "%" ],
		content : url
	});
}

/**
 * layer 打开层，百分比宽高，关闭后刷新父页面
 */
function openPerRe(title, w, h, url) {
	layer.open({
		type : 2,
		title : title,
		shadeClose : true,
		fix : true,
		shade : 0.8,
		maxmin : true,
		end : re,
		area : [ w + "%", h + "%" ],
		content : url
	});
}

/**
 * 验证手机验证码
 */
function checkmvcode() {
	var code = $("#mvcode").val();
	code = md51(code);
	if (code != vc) {
		alert("验证码不正确，请核对！");
	} else {
		cont = false;
		$("#getmvbtn").val('验证码正确！');
	}
	return code == vc;
}

/**
 * 验证码倒计时
 */
var wait = 60;
var cont = true;
function time(o) {
	if (cont) {
		if (wait == 0) {
			o.removeAttribute("disabled");
			o.value = "重新获取";
			wait = 5;
		} else {
			o.setAttribute("disabled", true);
			o.value = "重新获取 (" + wait + ")";
			wait--;
			setTimeout(function() {
				time(o)
			}, 1000)
		}
	}
}

function isEmail(str) {
	var reg = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
	return reg.test(str);
}

function checkEmail() {
	var emailValue = document.getElementById("email").value;
	if (!isEmail(emailValue)) {
		alert("您输入的邮箱有误,请重新核对后再输入!");
		document.getElementById("email").focus();
		return false;
	}
	return true;
}

var htmls = "";
var mb = $("#view").html();
function process(obj) {
	var tr = mb;
	$.each(obj, function(k, v) {
		for ( var f in obj) {
			if (f == k) {
				tr = tr.replaceAll('@' + k + '@', v);
			}
		}
	});
	htmls += tr;
}

function suc(p) {
	if (typeof (p) == "undefined") {
		p = 'enable';
	}
	document.getElementById('view').innerHTML = htmls;
	$('.switch')['bootstrapSwitch']();
	$('.switch').on(
			'switch-change',
			function(e, data) {
				var id = $(data.el).context.value;
				var flag = data.value;
				var enable = flag ? 1 : 2;
				update(adp + 'updatePVById/' + p + '/' + enable + '/' + id
						+ '.json', updateResult);
			});
}

function loadPageOk() {

}
/**
 * 获取树选中叶子的id串
 * 
 * @param treeObj
 * @returns
 */
function getCheckedNodesIdStr(treeObj) {
	var checkedNodes = treeObj.getCheckedNodes();
	var nodes = new Array();
	for (var i = 0; i < checkedNodes.length; i++) {
		nodes.push(checkedNodes[i].id);
	}
	return nodes.join(",");
}

function fixCheckBoxAndRadio() {
	$('.skin-minimal input').iCheck({
		checkboxClass : 'icheckbox-blue',
		radioClass : 'iradio-blue',
		increaseArea : '20%'
	});
}

document.onkeyup = keyUp;

function keyUp(e) {
	var currKey = 0, e = e || event;
	currKey = e.keyCode || e.which || e.charCode;
	var keyName = String.fromCharCode(currKey);
	keyUpDo(currKey, keyName);
}

function keyUpDo(currKey, keyName) {
	if (currKey == 27) {
		closeAll();
	}
}

function deleteRemoteFile(filePath) {
	$.getJSON(ctx + 'api/file/deleteFile?filePath=' + filePath, function(data) {

	});
}

/**
 * 刷新父级页面
 */
function reloadParent() {
	parent.location.reload();
}


$(document).ready(function() {
	$(".select2").select2({
		placeholder : "请选择"
	});
});

// Initialize Select2 Elements
$(".select2").select2();

// Initialize for checkbox and radio inputs
$('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
	checkboxClass : 'icheckbox_minimal-blue',
	radioClass : 'iradio_minimal-blue'
});

function setiCheck() {
	$('input[type="checkbox"].minimal, input[type="radio"]').iCheck({
		checkboxClass : 'icheckbox_minimal-blue',
		radioClass : 'iradio_minimal-blue'
	});
}

$(".switchevent").on(
		'switch-change',
		function(e, data) {
			var flag = data.value;
			var id = this.lang;
			var enable = flag ? 1 : 2;

			if (typeof (enableFun) == 'undefined') {
				update(adp + 'updatePVById/enable/' + enable + '/' + id
						+ '.json', updateResult2);
			} else {
				enableFun();
			}
		});



// <div id="uploader" class="wu-example">
// <!--用来存放文件信息-->
// <div class="thelist uploader-list">
// <!--<div id="WU_FILE_0" class="item"><h4 class="info">load.png<i
// class="glyphicon glyphicon-remove-circle"></i></h4>
// <p class="state">等待上传...</p></div>-->
// </div>
// <div class="btns">
// <div id="picker" class="pull-left ">选择文件</div>
// <button class="ctlBtn btn btn-default pull-left col-sm-2" style="height:
// 40px;margin-left: 10px;">开始上传</button>
// </div>
// </div>

//var $list = $(".thelist");
//var $btn = $(".ctlBtn");
//var state = 'pending', uploader;
//if ($list.length != 0) {
//	var uploader = WebUploader.create({
//		// swf文件路径
//		swf : '../css/webuploader/Uploader.swf',
//		// 文件接收服务端。
//		server : '#',
//		// 选择文件的按钮。可选。
//		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
//		pick : '.picker',
//		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
//		resize : false
//	});
//	// 当有文件被添加进队列的时候
//	uploader.on('fileQueued', function(file) {
//		$list.append('<div id="' + file.id + '" class="item">'
//				+ '<h4 class="info">' + file.name
//				+ '<i class="glyphicon glyphicon-remove-circle"></i></h4>'
//				+ '<p class="state">等待上传...</p>' + '</div>');
//		$list.find("i").bind("click", function() {
//			$(this).parent().parent().remove();
//		});
//
//	});
//	// 文件上传过程中创建进度条实时显示。
//	uploader
//			.on(
//					'uploadProgress',
//					function(file, percentage) {
//						var $li = $('#' + file.id), $percent = $li
//								.find('.progress .progress-bar');
//
//						// 避免重复创建
//						if (!$percent.length) {
//							$percent = $(
//									'<div class="progress progress-striped active">'
//											+ '<div class="progress-bar" role="progressbar" style="width: 0%">'
//											+ '</div>' + '</div>')
//									.appendTo($li).find('.progress-bar');
//						}
//						$li.find('p.state').text('上传中');
//						$percent.css('width', percentage * 100 + '%');
//					});
//
//	uploader.on('uploadSuccess', function(file) {
//		$('#' + file.id).find('p.state').text('已上传');
//	});
//
//	uploader.on('uploadError', function(file) {
//		$('#' + file.id).find('p.state').text('上传出错');
//	});
//
//	uploader.on('uploadComplete', function(file) {
//		$('#' + file.id).find('.progress').fadeOut();
//	});
//	uploader.on('all', function(type) {
//		if (type === 'startUpload') {
//			state = 'uploading';
//		} else if (type === 'stopUpload') {
//			state = 'paused';
//		} else if (type === 'uploadFinished') {
//			state = 'done';
//		}
//
//		if (state === 'uploading') {
//			$btn.text('暂停上传');
//		} else {
//			$btn.text('开始上传');
//		}
//	});
//
//	$btn.on('click', function() {
//		if (state === 'uploading') {
//			uploader.stop();
//		} else {
//			uploader.upload();
//		}
//	});
//}

function t(v,s){
	layer.msg(v, {icon: s});
}


