<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="/static/plugins/socket/sockjs.js"></script>
<script src="/static/plugins/socket/stomp.js"></script>
<script type="text/javascript">
	var stompClient = null;

	$(document).ready(function() {
		connect();
	});

	function connect() {
		var socket = new SockJS("${baseUrl}/wskjs");
		stompClient = Stomp.over(socket);
		stompClient.connect('abc', '123', function(frame) {
			console.log("ws已连接");
			//订阅个性路径，用于接收 定向消息
			stompClient.subscribe('/msg/sendToKf/${curUser.id}', function(
					data) {
				getMsg(data);
			});
		});
	}


	function getMsg(msg) {
		var message = JSON.parse(msg.body);
		if(typeof(layerobj) != "undefined" && layerobj != null){
			var iframeWin = window[layerobj.find('iframe')[0]['name']];
				iframeWin.showMsgToHeader(message); 
		}else{
			showMsgToHeader(message); 
		}
	}
	
	
	var  layerobj = null;
	//打开聊天窗口
	function contact(memberId) {
		layer.open({
			type : 2,
			title : false,
			closeBtn:0,
			moveOut :false,
			shadeClose: false,
			shade : 0.8,
			fixed: false, //不固定
			area : [ '798px', '595px' ],
			content:'${ctx}admin/chat/to/'+memberId,
			success:function(layero, index){
				layerobj = layero;
			},
			end:function(){
				layerobj = null;
			}
		});
	}
	
</script>


