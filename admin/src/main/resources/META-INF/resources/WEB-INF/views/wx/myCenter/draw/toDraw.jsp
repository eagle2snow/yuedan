<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>申请提现</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
<style type="text/css">
.Validform_title {
	display: none;
}
.Validform_info{
	display: none;
}

</style>

</head>
<body>
	<form action="${adp}addDraw" method="post" class="form">
		<div class="setlist">


			<div class="setitem">
				<div class="dl">
					<div class="min120 dt">持卡人</div>
					<div class="dd">
						<input type="text" placeholder="请填写持卡人姓名" class="dtint"
							name="cardUser" id="carduser">
					</div>
				</div>
			</div>

			<div class="setitem">
				<div class="dl">
					<div class="min120 dt">提现账户</div>
					<div class="dd">
						<input type="text" placeholder="请填写银行卡账号" class="dtint"
							name="cardNo" id='cardNo1'>
					</div>
				</div>
			</div>
			<div class="setitem">
				<div class="dl">
					<div class="min120 dt">再次确认</div>
					<div class="dd">
						<input type="text" placeholder="请确认银行卡账号" class="dtint"
							id='cardNo2'>
					</div>
				</div>
			</div>
			<div class="setitem">
				<div class="dl">
					<div class="min120 dt">提现金额</div>
					<span class="mr20">&yen;</span>
					<div class="dd">
						<input type="number" placeholder="请输入金额" class="dtint" id="amount"
							name="amount" pattern="\d*"
							onkeypress="return event.keyCode>=48&&event.keyCode<=57"
							onpaste="return false" ng-pattern="/[^a-zA-Z]/">
					</div>
				</div>
			</div>
			<div class="setitem">
				<a href="###" class="dl"> <span class="gytxt">当前可提现金额：&yen;<span
						class="insm" id="balance" >${curMember.balance}</span></span>
					<div class="dd"></div> <span class="primarytxt" onclick="drawAll()">全部提现</span>
				</a>
			</div>
		</div>
		<div class="fbottom">
			<nav class="btool">
				<div class="btool_halfcont">
					<a href="javascript:void(0);" class="primarybtn btoolbtn">提&nbsp;现</a>
				</div>
			</nav>
		</div>
	</form>
	<%@ include file="/common/wx/js.jsp"%>
	<script src="/static/plugins/Validform/5.3.2/Validform.min.js"></script>

	<script>
		var all = parseFloat('${curMember.balance}');
		$(".form").Validform({
			btnSubmit : ".btoolbtn",
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
				var carduser = $("#carduser").val();
				var cardNo1 = $("#cardNo1").val();
				var cardNo2 = $("#cardNo2").val();
				var amount = $("#amount").val();


				if ($.trim(carduser) == '') {
					$.toast("请输入持卡人", "text");
					return false;
				}

				if ($.trim(cardNo1) == '') {
					$.toast("请输入账号", "text");
					return false;
				}

				if ($.trim(cardNo1) != $.trim(cardNo2)) {
					$.toast("账号不一致", "text");
					return false;
				}

				if ($.trim(amount) == '') {
					$.toast("请输入金额", "text");
					return false;
				}
				if (parseFloat(amount) > all) {
					$.toast("最多能提：" + all + "元", "text");
					return false;
				}

			},
			callback : function(res) {
				if (res.s == 1) {
					$.alert("申请成功，我们将在24小时内处理", function() {
						to("${adp}drawLog");
					});
				} else if (res.s == -1) {
					all=parseFloat(res.balance);
					$("#balance").text(all);
					$("#amount").val('');
					$.alert("申请失败，余额不足<br>余额："+all+"元");
					
				} else {
					$.alert("系统出错，请稍候再试", function() {
						to("${adp}drawLog");
					});
				}
			}
		});

		document.addEventListener("touchstart", function() {
		}, true);

		function drawAll() {
			$("#amount").val(all);
		}
	</script>


</body>
</html>