<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<%@ include file="/common/wx/head.jsp"%>

<title>聊天窗口</title>
<link rel="stylesheet" href="/static/admin/chat/chat.css" />
</head>
<body>
	<div class="modal fade" tabindex="-1" role="dialog" id="imgyulan"
		aria-labelledby="gridSystemModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row imgyulan text-center"></div>

				</div>
			</div>
		</div>
	</div>
	<div class="chat-box">
		<div class="chat-right">
			<div class="chat-w">
				<div class="title">
					<h3 class="col-sm-11 title-name" v-text="toName"></h3>
					<a @click='closeChat()' class="fa fa-times col-sm-1 pull-right"
						style="margin: 2px 0 0; padding: 0 10px 0 0; text-align: right; font-size: 20px;"></a>
				</div>
				
				<div class="chat-area" id='chatArea'>
					<div class="msg-item"
						:class="(item.cat=='MEMBER_TO_KF')?'msg-item-self':''"
						v-for='item in msgs'>
						<div class="msg-user">
							<img :src="(item.cat=='MEMBER_TO_KF')?fromAvatar:toAvatar">
						</div>
						<div class="msg-content">
							<!-- 文字 -->
							<div class="msg-content-inner" v-html='item.content'
								v-if="item.type == 'TEXT' "></div>
							<!-- 图片 -->
							<div class="msg-content-inner" v-if="item.type == 'IMG' ">
								<div v-if='item.baseThumb == null || item.baseThumb == "" '>
									<img :src="item.pic" @click="look($event)" />
								</div>

								<div v-else-if='item.baseThumb != null '>
									<img :src="pic" @click="look($event)"
										v-for="(pic,index) in item.baseThumb.split('|')"
										v-if="pic !='' " />
								</div>

							</div>
							<div class="msg-content-arrow"></div>
						</div>
					</div>
				</div>
			</div>


			<div class="write-area">
				<textarea v-model='willSend' @keydown="keySend($event)"
					placeholder="请输入内容，按ctrl+回车发送"></textarea>
				<div class="btn-group">
					<button type="button" @click='send()' class="send">
						发送 <span class="sanjiao"><i class="caret"></i></span>
					</button>

				</div>
				<ul class="fasong">
					<li><a @click="chSendKek('enter')"><span id="s1"
							:class="sendKey=='enter'? 'fa fa-check maright5':'maright5'"></span>按Enter键发送消息</a></li>
					<li><a @click="chSendKek('ctrlenter')"><span id="s2"
							:class="sendKey=='ctrlenter'? 'fa fa-check maright5':'maright5'"></span>按Ctrl+Enter键发送消息</a></li>
				</ul>
				<div class="mengban"></div>
			</div>




		</div>

	</div>

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
			el : '.chat-box',
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
						layer.msg("请输入内容");
					}else{
						var msg ={};
						msg.fromId=vue.fromId;
						msg.toId=vue.toId;
						msg.content=t;
						msg.cat='MEMBER_TO_KF';
						msg.type="TEXT";
						vue.msgs.push(msg);
						vue.willSend='';
						$.getJSON('/wx/sendTextMsg',msg,function(res){
							console.log(res.s);
						});
					}
				},

				keySend:function(event){
					if (vue.sendKey=='enter'){
						if(event.ctrlKey && event.keyCode == 13){
							vue.willSend=vue.willSend+"\r\n";				
						}else if(event.keyCode == 13){
							vue.send();
						}
					}else if(vue.sendKey=='ctrlenter'){
						if(event.ctrlKey && event.keyCode == 13){
							vue.send();
						}
					}
					
				},
				toButtom:function(){
					var scrollHeight = document.getElementById("chatArea");
					chatArea.scrollTop = chatArea.scrollHeight;
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
				var ht = '<p>您想了解以下哪方面呢：</p>';
				$.each(res.autoMsgs,function(k,v){
					k=Number(k)+1;
					ht+= '<a href="javascript:void(0);" onClick="showContent(\''+v.name+'\',\''+v.content+'\')"><p>（'+k+'）'+v.name+'</p></a>';					
				});
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
			vue.msgs.push(msg2);
			sendToUrl(msg2,"/msg/sendToKf/${toId}");
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



</body>

</html>