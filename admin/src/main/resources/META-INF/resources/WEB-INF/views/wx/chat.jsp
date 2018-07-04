<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/wx/global.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>聊天窗口</title>
<%@ include file="/common/wx/mate.jsp"%>
<%@ include file="/common/wx/css.jsp"%>
</head>
<body>
	<!-- 中间 -->

	<!-- 一行 -->
	<div class="chatwrap">
		<!-- 一行 -->
		<div class="chatlist" id="chatArea" style="height: 566px;">
			<div class="chatinsrow">
				<span class="label">客服<span class="name">小竹</span>为您服务
				</span>
			</div>


			<div class="chatitem"
				:class="(item.cat=='MEMBER_TO_KF')?'my_chatitem':'guest_chatitem'"
				v-for='item in msgs'>
				<div class="chatitem_photo">
					<img :src="(item.cat=='MEMBER_TO_KF')?fromAvatar:toAvatar" alt="" />
				</div>
				<div class="chatitem_content">
					<div class="chatdialog" v-if="item.type == 'TEXT'"
						v-html='item.content'></div>
				</div>
			</div>



		</div>
		<!-- end 一行 -->
		<!-- 一行 -->
		<div class="chatbottom" id="chatbottom">
			<div class="chatbtool">
				<div class="chatbtool_cont">
					<input type="text" placeholder="点击输入文字" class="mybtext_input"
						v-model='willSend' @keydown="keySend($event)" />
				</div>
				<button class="primarybtn mybtext_btn" @click='send()'>发送</button>
			</div>
		</div>
	</div>


	<%@ include file="/common/wx/js.jsp"%>
	<%@ include file="/common/wx/socket.jsp"%>


	<script type="text/javascript">
		var img_index;
		function closeImg(){
			layer.close(img_index);
		}
	
		var hh =  document.body.clientHeight;
		initSendKey();
		var sk =getCookie('sendKey'); 
		var exampleData = {
			msgs : ${msgs},
			willSend:'',
			fromId :${mid},
			fromAvatar:'/static/upload/image/20180414/1523688790978009809.jpg',
			toId : ${toId},
			toAvatar:'/static/admin/img/user8-128x128.jpg',
			toName:'管理员',
			sendKey:sk,
			kw:''
		}

		var vue = new Vue({
			el : '.chatwrap',
			data : exampleData,
			methods:{
				look:function(event){
					var tars = event.target;
					var $img= $(tars);
					var w = $img.width();
					var h = $img.height();
					var ht='<img src="'+$img.attr('src')+'" style="width:100%;overflow-y:scroll;" />'; 
					img_index=parent.layer.open({
						  type: 1,
						  title: false,
						  closeBtn: 2,
						  area: ['90%', '95%'],
						//  offset: ['0', '0'],
						  skin: 'layui-layer-nobg', //没有背景色
						  shadeClose: true,
						  content:ht
						}); 
					
				},
				/*  getAutoMsgByType:function(type){
					$.getJSON('/wx/getAutoMsgByType/'+type,function(res){
						console.log(res.autoMsgs);
					});		
				}, */
				
				send:function(){
					var t = this.willSend;
					if(t==''){
						$.toast("请输入", "text");
					}else{
						var msg ={};
						msg.fromId=vue.fromId;
						msg.toId=vue.toId;
						msg.content=t;
						msg.cat='MEMBER_TO_KF';
						msg.type="TEXT";
						vue.msgs.push(msg);
						vue.willSend='';
						
						console.log(msg);
						
						$.getJSON('/wx/sendTextMsg',msg,function(res){
							console.log(res.s);
						});
					}
				},

				keySend:function(event){
					 if(event.keyCode == 13){
						vue.send();
					}
				},
				toButtom:function(){
					var chatArea = document.getElementById("chatArea");
					chatArea.scrollTop = chatArea.scrollHeight+50;
				},
				chSendKek:function(k){
		  			setCookie('sendKey',k);
		  			vue.sendKey=k;
			  	},
			  	closeChat:function(){
			  		var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
			  	},
			},
			mounted:function(){
				this.toButtom();
			},
			updated:function(){
				this.toButtom();				
			},
			watch:{
			
			}
		});
		
		
		var showMsgToHeader = function(msg) {
			if(msg.fromId == vue.toId){
				vue.msgs.push(msg); 
			}else{
				console.log("其他人:"+msg.fromId);
			}
		}
	
		
		
		//发送弹出
		$(".fasong").hide();
		$(".sanjiao").click(function(event){
			$(".fasong").slideToggle(10);
			$(".mengban").toggle();
			 event.stopPropagation();
		});
		
		$(".fasong li a").click(function(){
			setTimeout(function(){
				$(".fasong").slideToggle(10);
				$(".mengban").toggle();
			},10)
		})
		
	  	$(".mengban").click(function(){
	  		setTimeout(function(){
				$(".fasong").slideToggle(10);
				$(".mengban").toggle();
			},10)
	  	})
		
		function setCookie(name,value){
			var Days = 30;
			var exp = new Date();
			exp.setTime(exp.getTime() + Days*24*60*60*1000);
			document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
		}
		
		
		function getCookie(name)	{
			var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
			if(arr=document.cookie.match(reg)){
				return unescape(arr[2]);
			}
			else{
				return null;
			}
		}
		
		
		function initSendKey(){
			if(!getCookie('sendKey')){
				setCookie('sendKey','enter');		
			}
		}
		
		
		function getAutoMsgByType(type,name){
			var msg={};
			msg.fromId=${mid};
			msg.toId=${toId};
			msg.content=name;
			msg.cat='MEMBER_TO_KF';
			msg.type='TEXT';
			vue.msgs.push(msg);
			sendMsg(msg);
		 	$.getJSON('/wx/getAutoMsgByType/'+type,function(res){
				var ht = '<div class="chat_faqbox">'+
						 '<div class="chat_faq_dt">请选择</div>'+
						 '<ul class="chat_faqlist">';
				$.each(res.autoMsgs,function(k,v){
					ht+= '<a href="javascript:void(0);" onClick="showContent(\''+v.name+'\',\''+v.content+'\')"><p>'+v.name+'</p></a>';					
				});
				ht +='</ul></div>';
				
				var msg2={};
				msg2.fromId=${toId};
				msg2.toId=${mid};
				msg2.content=ht;
				msg2.cat='KF_TO_MEMBER';
				msg2.type='TEXT';
				vue.msgs.push(msg2);
				msg2.object=
				sendToUrl(msg2,"/msg/sendToKf/${toId}");
			});
		}
		

		
		function showContent(name,c){
			var msg={};
			msg.fromId=${mid};
			msg.toId=${toId};
			msg.content=name;
			msg.cat='MEMBER_TO_KF';
			msg.type='TEXT';
			vue.msgs.push(msg);
			sendMsg(msg);
			
			var msg2={};
			msg2.fromId=${toId};
			msg2.toId=${mid};
			msg2.content=c;
			msg2.cat='KF_TO_MEMBER';
			msg2.type='TEXT';
			
			setTimeout(function(){
				vue.msgs.push(msg2);
				sendToUrl(msg2,"/msg/sendToKf/${toId}");
			},500);
		}
		
		
		//发消息
		function sendMsg(msg){
			$.getJSON('/wx/send',msg,function(res){
				console.log(res.s);
			});
		}
		
		//发给客服端
		function sendToUrl(msg,url){
			$.getJSON('/wx/sendToUrl?url='+url,msg,function(res){
				console.log(res.s);
			});
		}
		
		
		
		
		
	</script>




	<script>
document.addEventListener("touchstart", function(){}, true);
</script>



</body>
</html>