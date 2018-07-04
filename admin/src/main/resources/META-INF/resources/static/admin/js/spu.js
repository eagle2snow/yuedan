	/**
	 * 全局变量
	 */
	var spuAttrList = [];
	var spname = [];
	var svname = [];
	var goodsCode = "";
	var effobjList = [];//功效
	var spuJson;
	var skuListjson;
	
	
	var table_th = new Vue({
		el : '#table_thead',
		data : function() {
			return {
				th : []
			}
		},
	});
	
	var table_td = new Vue({
		el : '#table_body',
		data : {
			skutr : []
		}
	});
	
	var effhtml = new Vue({
		el : '#yxgx',
		data : function() {
			return {
				yxgxList : [ "" ]
			}
		},
	});
	
	var shuxingHtml = new Vue({
		el : '#shuxing',
		data : function() {
			return {
				shuxingList : [ "" ]
			}
		},
	});
	// 点击按钮变红色
	$(function() {
		$('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
			checkboxClass : 'icheckbox_flat-red',
			radioClass : 'iradio_flat-red'
		});
	
	});
	
	function addSpec(url, id) {
		if(spname.length>0){
			var index = layer.confirm('此操作需清除已选规格商品？', {
				  btn: ['确定','不要'] //按钮
				}, function(){
					layer.close(index);
					goOpen(url, id);
				}, function(){
					return;
				});
		}else{
			goOpen(url, id);
		}
	}
	
	
	function goOpen(url, id){
		spname = [];
		svname = [];
		table_th.th = [];// 
		table_td.skutr = [];
		
		goodsCode = $("#goodsCode").val();
		if ("" == goodsCode) {
			layer.msg("请输入货品编码");
			return;
		}
		var storId = id;
		var index = layer.open({
			type : 2,
			area : [ "90%", "90%" ],
			shade : 0.8,
			shadeClose : true,
			end : guigehuidiao,
			content : url + 'addSpuSpecValue/'+storId+'.htm',
		});
	}
	
	
	
	// 选择规格回调
	function guigehuidiao() {
	
		/*
		 * 
		 */
		goodsCode = $("#goodsCode").val();
		var thArray = new Array();
		thArray.push('商品货号');
		for (var i = 0; i < spname.length; i++) {
			thArray.push(spname[i]);
		}
		thArray.push('原价');
		thArray.push('售价');
		thArray.push('库存');
		thArray.push('操作');
		table_th.th = thArray;// 表头
	
		var arr = svname;
 
		var sarr = [ [] ]; //
	
		for (var i = 0; i < arr.length; i++) {
			var tarr = [];
			for (var j = 0; j < sarr.length; j++)
				for (var k = 0; k < arr[i].length; k++) {
					tarr.push(sarr[j].concat(arr[i][k]));
				}
			sarr = tarr;
		}
		var tdArray = new Array();
		for (var i = 0; i < sarr.length; i++) {
			var trHtml = '<td><input class="form-control"  readonly="readonly"  value="'
					+ goodsCode + '-' + (i + 1) + '"></td>';
			var coPr = "";
			var saPr = "";
			for (var j = 0; j < sarr[i].length; j++) {
				var vname = sarr[i][j].split("|")[0];
				coPr = Number(coPr) + Number(sarr[i][j].split("|")[1]);
				saPr = Number(saPr) + Number(sarr[i][j].split("|")[2]);
				trHtml += '<td><input type="button" class="btn" name="spec_value_id" data-svid="'
						+ sarr[i][j] + '" value="' + vname + '"></td>';
			}
			var showcopr = "100";
			var showsapr = "100";
			if (coPr > 0 || saPr > 0) {
				showcopr = coPr;
				showsapr = saPr;
			}
			var ds = '';
			trHtml += '<td><input class="form-control"  name="costPrice" onchange="priceonchange(this);" placeholder="原价" value="'
					+ showcopr
					+ '"></td>'
					+ '<td><input class="form-control" name="salePrice" onchange="priceonchange(this);" placeholder="售价"	value="'
					+ showsapr
					+ '"></td>'
					+ '<td><input class="form-control" name="countNum" onchange="countNumonchange(this);" placeholder="库存"	value="100"></td>'
					+ '<td><span class="glyphicon glyphicon-trash" data-disa="1" onclick="delete_td(this)"></span></td>';
	
			tdArray.push(trHtml);
		}
		table_td.skutr = tdArray;
		$("#goodsCode").attr("readonly", "readonly");
	}
	// 删除货品 有bug
	function delete_td(ts) {
		if ($("#table_body tr").length == 1) {
			spname = [];
			svname = [];
			table_th.th = [];// 
			table_td.skutr = [];
			$("#goodsCode").removeAttr("readonly");
		} else {
			// 删除对应的数组
			
			$(ts).parents('tr:first').remove();
		}
	}
	
	// 添加功效
	function addEffic(url) {
		var catId = $("#cat option:selected").attr("data-parId");
		var index = layer.open({
			type : 2,
			area : [ "60%", "60%" ],
			shade : 0.8,
			fixed : true,
			shadeClose : false,
			closeBtn : 0,
			end : gongxiao,
			content : url + 'addSpuEffcacy/' + catId + '.htm',
		});
	}
	// 添加功效回调
	
	function gongxiao() {
		var btnhtml_list = [];
		for (var i = 0; i < effobjList.length; i++) {
			var bh = '<span data-effid="'
					+ effobjList[i].id
					+ '" data-inde="'
					+ i
					+ '">'
					+ effobjList[i].name
					+ '</span><i class="fa fa-times shanchu" onclick="remodeeff(this);"></i>';
			btnhtml_list.push(bh);
		}
		effhtml.yxgxList = btnhtml_list;
		if(btnhtml_list.length>0){
			$("#yxgx").show();
		}else{
			$("#yxgx").hide();
		}
	}
	// 删除功效
	function remodeeff(ts) {
		var index = $(ts).siblings("span").data("inde");
		effobjList.splice(index, 1);
		gongxiao();
	}
	

	$("input").change(function() {
		if ($(this).val().trim() == "") {
			layer.msg("不能输入空");
		}
		$(this).val($(this).val().trim());
	});
	
	
	$("#goodsCode").change(function() {
		if (rx.test($(this).val())) {
			layer.msg("货品编码不能包含中文！");
			$(this).val("");
			return;
		}
		if (pat.test($(this).val())) {
			layer.msg("编码中含有非法字符！");
			$(this).val("");
			return;
		}
		
		if ($(this).val().length < 3) {
			layer.msg("编码不能少于3位！");
			$(this).val("");
			return;
		}
		if ($(this).val().length > 12) {
			layer.msg("编码不能大于12位！");
			$(this).val("");
		}
		var addType = 2;
		
		if(addType==1){
			
		}else{
			$.ajax({
				url:"/web/store/spu/verification.json",
				data: "goodsCode="+$(this).val(),
				dataType:"json",
				success : function(data) {
					if(data.status=="n"){
						layer.msg("编码已存在,请重新输入！");
						$("#goodsCode").val("");
					}
					
				},
			});	
		}
	});
 
	$("#cat").change(function() {
		effobjList = [];
		effhtml.yxgxList = effobjList;
	});
	$("#unitName").change(function() {
		var va = $(this).val();
		if (va.length < 1 || va.length > 2) {
			layer.msg("计算单位不能为空！或者大于2个字");
			$(this).val("");
		}
		if (pat.test(va)) {
			layer.msg("不能含有非法字符！");
			$(this).val("");
		}
	});
	// 商品表单验证
	function priceonchange(ts) {
		var va = $(ts).val();
		if (!isNaN(va)) {
			va = new Number(va);
			$(ts).val(va.toFixed(2));
		} else {
			layer.msg("请输入数字类型！只能保留2位小数");
			$(ts).val(100);
		}
	}
	function countNumonchange(ts) {
		var va = $(ts).val();
		if (/\D/.test(va)) {
			layer.msg("请输入数字类型！");
			$(ts).val(100);
		}
		if (va.length > 6) {
			layer.msg("库存量太大了");
			$(ts).val(100);
		}
	}
	
	// 提交表单
	function sbm(url) {
		var index_1 = layer.msg('正在验证提交', {
			icon : 16
		});
		var url = url + 'add.json';
		var isSell = $("input[name='isSell']:checked").val();
		if (isSell == 2) {
			layer.confirm('该商品确定不上架？', {
				btn : [ '是的', '返回修改' ]
			// 按钮
			}, function() {
				layer.msg('以后需上架可在商品管理中查看', {
					icon : 1
				});
			}, function() {
				return;
			});
		}
		if (yanzheng()) {
			var data = {
				"spuJson" : spuJson,
				"skuListjson" : skuListjson,
				"spuAttrList" : spuAttrList
			};
			data = JSON.stringify(data);
			var index_2 = layer.msg("提交表单", {
				icon : 16
			});
			$.post(url, {
				"jsonString" : data
			}, function(result) {
				layer.close(index_2);
				layer.msg("正在提交表单");
				addResult(result);
			});
		}
		layer.close(index_1);
		return;
	}
	
	function yanzheng() {
		var name = $("#name").val().trim();
		if (name.length == 0) {
			layer.msg("请输入货品名称！");
			return false;
		} else if (name.length > 30) {
			layer.msg("货品名称不能超过30个字！");
			return false;
		}
		if (pat.test(name) == true) {
			layer.msg("名称中含有非法字符！");
			return false;
		}
		var unitName = $("#unitName").val().trim();
		if (unitName.length == 0) {
			layer.msg("计算单位不能为空");
			return false;
		}
		if (showType == 3) {
			if (effobjList.length == 0) {
				layer.msg("请选择功效！");
				return false;
			}
		}
		if ($("#table_body").html() == "") {
			layer.alert("请点击添加规格，填写货品信息！");
			return false;
		}
		if ($("#thumb_input").val() == "") {
			layer.msg("请上传封面图");
			return false;
		}
		if ($("#pics_input").val() == "") {
			layer.msg("请上传组图");
			return false;
		}
	
		var picslength = $("#pics_input").val().split("|");
		if (picslength.length > 5) {
			layer.msg("图片不能超过5张");
			return false;
		}
	
		getSku();
		return true;
	}
	

	var minCop;
	var minSap;
	function getSku() {
		var json_array = new Array();
		var cosList = [];
		var sapList = [];
		var trlist = $("#table_body tr");
		for (var i = 0; i < trlist.length; i++) {
			var ti = trlist[i];// 当前 tr对象
			var inputList = $(ti).find("input");
			var obj = new sku();// sku
			var ipu_0 = inputList[0];
			obj.name = $(ipu_0).val();
			var svalue = [];
			for (var j = 1; j < inputList.length; j++) {
				var ipu_j = inputList[j];
				var inputname = $(ipu_j).attr("name");
				if (inputname == "spec_value_id") {
					svalue.push($(ipu_j).data("svid"));
				} else if (inputname == "costPrice") {
					cosList.push($(ipu_j).val());
					obj.costPrice = $(ipu_j).val();
				} else if (inputname == "salePrice") {
					obj.salePrice = $(ipu_j).val();
					sapList.push($(ipu_j).val());
				} else if (inputname == "countNum") {
					obj.countNum = $(ipu_j).val();
				}
			}
			obj.specName = spname;
			obj.specValue = svalue;// 规格值数据
			json_array.push(obj);
		}
		minCop = cosList.sort(sortNumber)[0];
		minSap = sapList.sort(sortNumber)[0];
		skuListjson = json_array;
		getSpu();
	}
	function sortNumber(a, b) {
		return a - b
	}
	function getSpu() {
		var spuModel = new spu();
		spuModel.name = $("#name").val();
		spuModel.catId = $("#cat").val();
		spuModel.brandId = $("#brand").val();
		spuModel.memberGradeId = $("#memberGrade").val();
		spuModel.isSell = $("input[name='isSell']:checked").val();
		spuModel.thumb = $("#thumb_input").val();
		spuModel.pics = $("#pics_input").val();
		spuModel.unitName = $("#unitName").val();
		spuModel.goodsCode = $("#goodsCode").val();
		spuModel.content = ue.getContent();
		spuModel.costPrice = minCop;
		spuModel.salePrice = minSap;
		var elength = effobjList.length;
		var idString = "";
		for (var i = 0; i < elength; i++) {
			if (i + 1 < elength) {
				idString += effobjList[i].id + ",";
			} else {
				idString += effobjList[i].id;
			}
		}
		spuModel.effId = idString;
		spuJson = spuModel;
	}
	
	// 添加属性
	function addattr(url) {
		var index = layer.open({
			type : 2,
			title : '添加属性',
			area : [ "60%", "60%" ],
			shade : 0.8,
			shadeClose : false,
			end : shuxing,
			content : url + 'addattr.htm',
		});
	}
	// 添加完属性回调
	function shuxing() {
		var btnhtml_list = [];
		for (var i = 0; i < spuAttrList.length; i++) {
			var bh = '<span data-inde="'
					+ i
					+ '">'
					+ spuAttrList[i].name
					+ ':'
					+ spuAttrList[i].attrValue
					+ '</span><i class="fa fa-times shanchu"  onclick="remodeattr(this)"></i>';
			btnhtml_list.push(bh);
		}
		shuxingHtml.shuxingList = btnhtml_list;
		if(btnhtml_list.length>0){
			$("#shuxing").show();
		}else{
			$("#shuxing").hide();
		}
	}
	// 删除属性
	function remodeattr(ts) {
		var index = $(ts).siblings("span").data("inde");
		spuAttrList.splice(index, 1);
		shuxing();
	}
	
	//属性对象
	function uAttr() {
		this.name;
		this.attrValue;
	}
	
	function eff(){
		this.id;
		this.name;
	}	
	// 先获取sku,再获取spu;
	function sku() {
		this.name;
		this.costPrice;
		this.salePrice;
		this.countNum;
		this.specValue;
		this.specName;
	}
	function spu() {
		this.name;
		this.catId;
		this.brandId;
		this.memberGradeId;
		this.isSell;
		this.thumb;
		this.pics;
		this.costPrice;
		this.salePrice;
		this.unitName;
		this.content;
		this.effId;
		this.goodsCode;
	}

	
	
	
	
	
	