<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>我的二维码</title>
<link rel="stylesheet" type="text/css" href="/static/wx/css/css.css" />

<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>

</head>
<body>
	<!-- 中间 -->
	<!-- cpop -->
	<div class="show cpop">
		<div class="cpopcenter">
			<div class="centerntbox">
				<div class="centernthead">
					<div class="tr">
						<span class="avator150"><img
							src="${curMember.iocUrl}" alt=""></span>
					</div>
					<div class="tr">
						<span class="name">${curMember.nickname}</span>
					</div>
				</div>
				<div class="myqrcodebox">
					<img src="${curMember.qrCode }" alt="">
				</div>
				<div class="ac dtrins">分享方式：<br>①直接扫描二维码<br>②长按二维码 -> 发送给朋友<br>③点击右上角 -> 发送给朋友 - 分享到朋友圈</div>
			</div>
		</div>
	</div>
	<!-- cpop -->
	<!--end 中间-->

	<%@ include file="/common/wx/js.jsp"%>
	<%@ include file="/common/wx/socket.jsp"%>
	
	 <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

	<script>
	 var qrCode = "${curMember.qrCode}";
	 console.log(qrCode);
	 if(!qrCode){
		 $.alert('您还没有消费体验产品 <br>不能使用二维码');
	 }
	
		document.addEventListener("touchstart", function() {
		}, true);
	</script>
	


<script type="text/javascript">
        $(function() {
            wx.config({
                //debug : true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                appId: 'wxcf0651a0ff3ed734',
                timestamp:'${resp.timestamp}',
                nonceStr:'${resp.noncestr}',
                signature:'${resp.signature}',
                jsApiList : [ 'scanQRCode','onMenuShareAppMessage' ]
            // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
            });

            wx.ready(function(){
                // wx.hideOptionMenu();
                wx.onMenuShareTimeline({
                    title: '漓江竹语会员分享',
                    link: 'http://zhuyu.tiexinxi.cn/wx/myCenter/myQrCode/${curMember.openid }',
                    imgUrl: 'http://zhuyu.tiexinxi.cn/static/wx/images/icon/20180605125532.png',
                    success: function () { 
                        // 用户确认分享后执行的回调函数
                         alert('分享到朋友圈成功');
                    },
                    cancel: function () { 
                        // 用户取消分享后执行的回调函数
                         alert('你没有分享到朋友圈');
                    }
                });
                wx.onMenuShareAppMessage({
                      title: '漓江竹语会员分享',
                      desc: '好的商品,好的品质,优惠的价格,贴心的服务,快乐购物!!!',
                      link: 'http://zhuyu.tiexinxi.cn/wx/myCenter/myQrCode/${curMember.openid }',
                      imgUrl: 'http://zhuyu.tiexinxi.cn/static/wx/images/icon/20180605125532.png',
                      trigger: function (res) {
                        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
                      },
                      success: function (res) {
                          alert('分享给朋友成功');
                      },
                      cancel: function (res) {
                        alert('你没有分享给朋友');
                      },
                      fail: function (res) {
                        alert(JSON.stringify(res));
                      }
                    });
            });
        });
</script>


	
	


</body>
</html>