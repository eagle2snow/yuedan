<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>结算</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>


<style type="text/css">
.itm {
	margin-left: 2rem;
}
</style>

</head>
<body>

	<div id="orderBody">
		<!-- 中间 -->
		<!-- 一行 -->
		<div class="showdtlist wpbox">
			<div class="showdtitem">
				<a href="###" class="dl">
					<p>
						<span class="secondtxt">购买套餐</span>后，再次消费所有商品，<span
							class="secondtxt">一律八折</span>
					</p>
				</a>
			</div>
		</div>
		<!-- end 一行 -->
		<!-- 一行 -->
		<ul class="stepbar">
			<li class="active cart stepbaritem"></li>
			<li class="active edit stepbaritem"></li>
			<li class="success stepbaritem"></li>
		</ul>
		<!-- end 一行 -->
		<!-- 一行 -->

		<div class="weui-cells weui-cells_radio">

			<label class="weui-cell weui-check__label" :for="ad.id"
				@click='setAddress(ad.id)' v-for="(ad,index) in addressList">
				<div class="weui-cell__bd">
					<a href="" class="">
						<div class="sendcard_mt">
							收货人：<span v-text='ad.name'></span><span class="itm" v-text='ad.mobile'></span>
						</div>
						<div class="sendcard_mb">
							<i class="local_mbico mbico"></i>
							<div class="sendcard_mbcont" v-text='ad.pca+ad.address'></div>
						</div>
					</a>
				</div>
				<div class="weui-cell__ft">
					<input type="radio" class="weui-check" name="memberAddress"
						:id="ad.id" :value="ad.id"
						:checked="ad.id==order.memberAddress.id"> <span
						class="weui-icon-checked"></span>
				</div>
			</label> <a href="${adp}addAddress/${orderId}"
				class="weui-cell weui-cell_link">
				<div class="weui-cell__bd">新地址</div>
			</a>
		</div>

		<!-- end 一行 -->
		<!-- 一行 -->
		<div class="wbox">
			<div class="boxmt">
				<div class="boxmt_cont">
					<h3 class="boxmtitle">订单商品</h3>
				</div>
			</div>

			<div class="cartpro" v-for="item in items">
				<div class="cartpro_pic">
					<a href=""><img :src="item.commodity.imgerPath" alt=""></a>
				</div>
				<div class="cartpro_cont">
					<div class="cuth" v-text="item.name"></div>
					<div class="cutd" v-text="'规格：'+item.commodity.specifications"></div>
					<div class="cutd">
						<span v-text='"单价："+item.commodity.showPrice'></span> &nbsp;&nbsp;
						<span v-text='"库存："+item.commodity.totalStock'></span>
					</div>
					<div class="cutd">
						<div class="cutdcont">
							<ins>
								&yen;<span class="insm"
									v-text="(item.commodity.showPrice * item.buyCount).toFixed(2)"></span>
							</ins>
						</div>
						<span class="bdclnum numBox"><i @click="subNum(item)"
							class="bdclnum_reduce reduceNum"></i> <input type="number"
							pattern="\d*"
							onkeypress="return event.keyCode>=48&&event.keyCode<=57"
							@keyup="limitInput($event,item)" onpaste="return false"
							ng-pattern="/[^a-zA-Z]/" min="1" v-model="item.buyCount"
							class="bdclnum_input numtext" /> <i
							class="bdclnum_increase increaseNum" @click="addNum(item)"></i></span>
					</div>
				</div>
			</div>



		</div>
		<!-- end 一行 -->
		<!-- 一行 -->
		<ul class="showdtlist wpbox">
			<li class="showdtitem">
				<div class="dl">
					<div class="dt">商品金额</div>
					<div class="dd">
						&yen;<span class="insm" v-text='totalAmount'></span>
					</div>
				</div>
			</li>
			<li class="showdtitem">
				<div class="dl">
					<div class="dt">折扣</div>
					<div class="dd">
						-&yen;<span class="insm" v-text='disconut'></span>
					</div>
				</div>
			</li>
			<li class="showdtitem">
				<div class="dl">
					<div class="dt">运费</div>
					<div class="dd">
						&yen;<span class="insm">0.00</span>
					</div>
				</div>
			</li>
			<li class="showdtitem">
				<div class="dl">
					<div class="dt">应付金额</div>
					<div class="dd">
						<ins>
							&yen;<span class="insm" v-text='realTotalAmount'></span>
						</ins>
					</div>
				</div>
			</li>
		</ul>
		<!-- end 一行 -->
		<!-- 一行 -->
		<div class="wbox">
			<div class="boxmt">
				<div class="boxmt_cont">
					<h3 class="boxmtitle">支付方式</h3>
				</div>
			</div>
			<ul class="paywaylist">
				<!-- <li class="paywayitem"><input type="radio"
					id="payway01" name="payway"> <label for="payway01"
					class="paywaylabel"> <img
						src="/static/wx/images/pic/payway/01.png" alt="" class="icon">
						<div class="wbw">
							<span class="name">支付宝支付</span>
						</div>
				</label></li> -->
				<li class="paywayitem"><input type="radio" id="payway02"
					checked="checked" name="payway"> <label for="payway02"
					class="paywaylabel"> <img
						src="/static/wx/images/pic/payway/02.png" alt="" class="icon">
						<div class="wbw">
							<span class="name">微信支付</span>
						</div>
				</label></li>
			</ul>
			<div class="dtrins">竹语提醒您：港澳台及海外不能发货，公司随机发货不能指定快递，少数偏远地区以及快递不到的镇、村、组的快件需自提，公司不承担额外的快递费用，快递物流时效为一个月，请在发货后7天内吉时查询物流信息，新老包装随机发货，不能指定包装，如有问题请联系客服。</div>
		</div>
		<!-- end 一行 -->
		<!-- 一行 -->
		<div class="setlist">
			<div class="setitem">
				<div class="dltop">
					<div class="dd">
						<textarea placeholder="备注：点击此处输入内容" class="textint"
							v-model='content'></textarea>
					</div>
				</div>
			</div>
		</div>
		<!-- end 一行 -->
		<!--end 中间-->
		<!-- 底部 -->
		<div class="fbottom">
			<nav class="btool">
				<div class="btool_halfcont">
					<a href="javascript:void(0);" class="primarybtn btoolbtn"
						@click='prePay()'>立&nbsp;即&nbsp;支&nbsp;付</a>
				</div>
			</nav>
		</div>
		<!--end 底部-->
	</div>


	<%@ include file="/common/wx/js.jsp"%>
	<%@ include file="/common/wx/socket.jsp"%>

	<script src="/static/wx/js/pay.js"></script>

	<script type="text/javascript">
	
	Number.prototype.toFixed = function(s)  
	{  
	    return (parseInt(this * Math.pow( 10, s ) + 0.5)/ Math.pow( 10, s )).toString();  
	} 
	
	
	
var orderVue = new Vue({
	el : '#orderBody',
	data : {
		order : ${order},
		items : ${items},
		addressList:${addressList},
		orderAddress:'${orderAddressId}',
		content:'',
	},
	methods : {
		addNum : function(item) {
			item.buyCount=parseInt(item.buyCount)+1;
		},
		subNum:function(item) {
			var n= parseInt(item.buyCount);
			if(n>1){
				item.buyCount=parseInt(item.buyCount)-1;
			}
		},
		checkAll:function(){
			var ck = $("#allCart").prop('checked');
			this.items.forEach(item=>item.had=ck);
		},
		limitInput:function(event,item){
		     var value=event.currentTarget.value;
		     var totalStock = item.commodity.totalStock;
		     var min=1;
		     if(parseInt(value)<min){
		    	 item.buyCount=min;
		     }else if(parseInt(value)>totalStock){
		    	 item.buyCount=totalStock;
		    	 $.alert('库存不足，最多只能购买'+totalStock+"个");	 
		     }
		},
		setAddress:function(addressId){
			this.orderAddress=addressId;
		},
		prePay:function(){
			if(!this.orderAddress){
				$.alert('请填写收货地址',function(){
					to('${adp}addAddress/${orderId}');
				});
				return;
			}
			
			var buys=[];
			  this.items.forEach(item=>{
				 var c = {};
				 c.orderItemId=item.id;
				 c.orderId=this.order.id;
				 c.commodityId=item.commodity.id;
				 c.buyCount=item.buyCount;
				 buys.push(c);
			  });
			  $.getJSON('${ctx}wx/order/prePayOrder',{'orderId':this.order.id,'addressId':this.orderAddress,'itemsStr':JSON.stringify(buys),'content':this.content},function(res){
					if(res.s=='ok'){
						prePay(orderVue.order.orderNo,'支付商品',orderVue.totalAmount);//申请支付参数					
					}else if(res.s=='no'){
						 $.alert("商品库存不足");
					}else if(res.s=='paid'){
						 $.alert("订单已付款");
					}else if(res.s=='null'){
						 $.alert("订单不存在");
					}
					else{
						 $.alert("系统出错");
					}				  
			  });
		},
	},
	computed:{
		totalAmount:function(){
		  var t = parseFloat(0);
		  this.items.forEach(item => t += parseFloat((item.commodity.showPrice * item.buyCount).toFixed(2)));
		  return t.toFixed(2);
		},
		
		disconut:function(){
			var t = parseFloat(0);
			if(${curMember.setMeal}!=1){
				t = this.totalAmount*0.2;
				return t.toFixed(2);
			}else{
				return t;
			}
		},
		realTotalAmount:function(){
			var t = parseFloat(0);
			t=this.totalAmount-this.disconut;
			return t.toFixed(2);
		},
		
		checkAllItem:function(){
			var all =  this.items.length;
			var chk = this.items.filter(item => item.had).length; 
			return all==chk;
		}
	}
})


//微信支付js
document.addEventListener("touchstart", function() {
}, true);


//(String orderNo, String orderName, BigDecimal amount

function prePay() {
	$.getJSON('/wx/pay/prePayOrder',{'orderNo':orderVue.order.orderNo,'orderName':'购买商品','amount':orderVue.realTotalAmount}, function(res) {
		if(res.s===1){
			var appId = res.data.appId;
			var timeStamp = res.data.timeStamp;
			var nonceStr = res.data.nonceStr;
			var packAge = res.data.packAge;
			var signType = res.data.signType;
			var paySign = res.data.paySign;
			onBridgeReady(appId, timeStamp, nonceStr, packAge, signType,
				paySign);
		}else{
			$.alert(res.s);
		}
	});
}

function onBridgeReady(appId, timeStamp, nonceStr, packAge, signType,
		paySign) {
	WeixinJSBridge.invoke('getBrandWCPayRequest', {
		"appId" : appId, //公众号名称，由商户传入     
		"timeStamp" : timeStamp, //时间戳，自1970年以来的秒数     
		"nonceStr" : nonceStr, //随机串     
		"package" : packAge,
		"signType" : signType, //微信签名方式：     
		"paySign" : paySign
	//微信签名 
	}, function(res) {
		if (res.err_msg == "get_brand_wcpay_request:ok") {
			location.href='${adp}paySuccess?orderId='+orderVue.order.id+'&amount='+orderVue.totalAmount;
			$.toast(orderVue.order.id+":"+orderVue.totalAmount,"text");
		}else{
			location.href='${adp}payFail?orderId='+orderVue.order.id;
		}
	});
	if (typeof WeixinJSBridge == "undefined") {
		if (document.addEventListener) {
			document.addEventListener('WeixinJSBridgeReady',
					this.onBridgeReady, false);
		} else if (document.attachEvent) {
			document.attachEvent('WeixinJSBridgeReady',
					this.onBridgeReady);
			document.attachEvent('onWeixinJSBridgeReady',
					this.onBridgeReady);
		}
	}

}




</script>




</body>
</html>