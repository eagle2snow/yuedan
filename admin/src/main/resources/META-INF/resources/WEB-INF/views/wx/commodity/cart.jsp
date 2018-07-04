<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%  
    response.setHeader("Cache-Control","no-store");  
    response.setDateHeader("Expires", 0);  
    response.setHeader("Pragma","no-cache");   
%> 

<%@ include file="/common/wx/global.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>购物车</title>

<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
</head>
<body>

	<div id="cartBody">

		<!-- 中间 -->
		<!-- 一行 -->
		<div class="showdtlist wpbox">
			<div class="showdtitem">
				<a href="###" class="dl">
					<p>
						<span class="secondtxt">购买套餐后，</span>再次消费商城所有商品，一律<span
							class="secondtxt">八折。</span>
					</p>
				</a>
			</div>
		</div>
		<!-- end 一行 -->







		<!-- 一行 -->
		<ul class="stepbar" v-if='carts!=""'>
			<li class="active cart stepbaritem"></li>
			<li class="edit stepbaritem"></li>
			<li class="success stepbaritem"></li>
		</ul>
		<!-- end 一行 -->
		<!-- 一行 -->
		<ul class="editing spactor_cartprolist cartprolist" v-if='carts!=""'>

			<li v-for='(item, index) in carts' class="cartpro"><span
				class="chespan"> <input name="cartItem" type="checkbox"
					:id="'cartproChe'+index" v-model="item.had"> <label
					:for="'cartproChe'+index" class="chelabel"></label>
			</span>
				<div class="cartpro_pic">
					<a href="###"><img :src="item.commodity.imgerPath" alt=""></a>
				</div>
				<div class="cartpro_cont">
					<div class="cuth" v-text='item.commodity.name'></div>
					<div class="cutd" v-text='"规格："+item.commodity.specifications'></div>
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
				</div></li>



		</ul>
		<!-- end 一行 -->
		<!--end 中间-->
		<!-- 底部 -->
		<div class="fbottom2 fbottom">
			<div class="fixbottom">
				<nav class="hasbg btool" v-if='carts!=""'>
					<span class="ml20 chespan"> <input type="checkbox"
						@click="checkAll()" :checked="checkAllItem" id="allCart">
						<label for="allCart" class="chelabel">全选</label>
					</span>
					<div class="ar btool_cont">
						<p>
							<ins class="fz30">
								合计：&yen;<span class="insm" v-text='totalAmount'></span>
							</ins>
						</p>
						<p class="gytxt">（不含运费）</p>
					</div>
					<a href="javascript:void(0);" @click='sett()'
						class="warnbtn btoolmbtn">结&ensp;算</a>
				</nav>
				<nav class="fnavlist">
					<a href="${ctx }wx/index" class="myqrcode fnavitem">首页</a> <a
						href="${ctx}wx/commodity/showCart" class="on cart fnavitem">购物车</a> <a href="${ctx}wx/myCenter/index?fuck"
						class="user fnavitem">个人中心</a> 
				</nav>
			</div>
		</div>
		<!--end 底部-->
	</div>
	<%@ include file="/common/wx/js.jsp"%>
	<%@ include file="/common/wx/socket.jsp"%>


	<script type="text/javascript">
	
	var cartVue = new Vue({
		el : '#cartBody',
		data : {
			carts : ${carts},
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
				this.carts.forEach(item=>item.had=ck);
			},
			sett:function(){
				var buys=[];
				  this.carts.filter(item => item.had).forEach(item=>{
					 var c = {};
					 c.id=item.id;
					 c.buyCount=item.buyCount;
					 buys.push(c);
				  });
				  console.log(buys);
				  $.getJSON('${ctx}wx/order/addOrder',{'cartsStr':JSON.stringify(buys)},function(res){
						if(res.s=='ok'){
							console.log("订单已生成");
							location.href='${ctx}wx/order/confirmOrder/'+res.orderId;
						}else if(res.s=='no'){
							 $.alert("商品库存不足");
							//console.log(res.noCarts);
						}else{
							 $.alert("系统出错");
						}				  
				  });
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
			}
		},
		computed:{
			totalAmount:function(){
			  var t = parseFloat(0);
			  this.carts.filter(item => item.had).forEach(item => t += parseFloat((item.commodity.showPrice * item.buyCount).toFixed(2)));
			  return t.toFixed(2);
			},
			checkAllItem:function(){
				var all =  this.carts.length;
				var chk = this.carts.filter(item => item.had).length; 
				return all==chk;
			}
		},
		mounted:function(){
			if(this.carts==''){
				$.alert("购物车空空如也，去逛逛吧", function() {
					location.href='${ctx}wx/index';	
				});
			}
		}
	})
</script>

</body>



</html>