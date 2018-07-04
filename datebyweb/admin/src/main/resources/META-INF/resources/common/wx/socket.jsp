<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			stompClient.subscribe('/msg/sendToMember/${mid}', function(
					data) {
				getMsg(data);
			});
		});
	}


	function getMsg(msg) {
		var message = JSON.parse(msg.body);
		vue.msgs.push(message);
	}
	
</script>


