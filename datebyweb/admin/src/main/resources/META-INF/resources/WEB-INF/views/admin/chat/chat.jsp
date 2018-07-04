<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<%@ include file="/common/admin/global.jsp"%>
<%@ include file="/common/admin/mate.jsp"%>
<%@ include file="/common/admin/css.jsp"%>
<%@ include file="/common/admin/js.jsp"%>

<title>聊天窗口</title>
<link rel="stylesheet" href="/static/admin/chat/chat.css" />
</head>
<body>
	<div class="modal fade" tabindex="-1" role="dialog" id="imgyulan" aria-labelledby="gridSystemModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
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
		<div class="chat-left">
			<div class="search-bar">
				<div class="my-msg">
					<a class="chat-img"><img src="${curUser.avatar }"></a>
					<p class="chat-name">${curUser.name }</p>
				</div>
				<div class="input-box">
					<input placeholder="搜索" v-model="kw"> <span class="icon-box"><i class="fa fa-search"></i></span>
				</div>
			</div>
			<ul class="menu">
				<li :class="toId==model.id?'active':''" v-for="model in memberList" @click='chMember(model)'><a
					class="chat-img"> <img :src="model.iocUrl">
				</a>
					<p class="chat-name">{{model.nickname}}<small v-text='model.noReadMsgCount' v-show='model.noReadMsgCount>0' class="label pull-right bg-red"></small></p></li>
			</ul>
		</div>
		<div class="chat-right">
			<div class="chat-w">
				<div class="title">
					<h3 class="col-sm-11 title-name" v-text="toName"></h3>
					<a @click='closeChat()' class="fa fa-times col-sm-1 pull-right"
						style="margin: 2px 0 0; padding: 0 10px 0 0; text-align: right; font-size: 20px;"></a>
				</div>
				<div class="chat-area" id='chatArea'>
					<div class="msg-item" :class="(item.cat=='KF_TO_MEMBER')?'msg-item-self':''" v-for='item in msgs'>
						<div class="msg-user">
							<img :src="(item.cat=='KF_TO_MEMBER')?fromAvatar:toAvatar">
						</div>
						<div class="msg-content">
							<!-- 文字 -->
							<div class="msg-content-inner" v-html='item.content' v-if="item.type == 'TEXT' "></div>
							<!-- 图片 -->
							<div class="msg-content-inner" v-if="item.type == 'IMG' ">
								<div v-if='item.baseThumb == null || item.baseThumb == "" '>
									<img :src="item.pic" @click="look($event)" />
								</div>

								<div v-else-if='item.baseThumb != null '>
									<img :src="pic" @click="look($event)" v-for="(pic,index) in item.baseThumb.split('|')" v-if="pic !='' " />
								</div>

							</div>
							<div class="msg-content-arrow"></div>
						</div>
					</div>
				</div>
			</div>


			<div class="write-area">
				<textarea v-model='willSend' @keydown="keySend($event)" placeholder="请输入内容，按ctrl+回车发送"></textarea>
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
		var init_member_list=${memberList};
		function closeImg(){
			layer.close(img_index);
		}
	
		var hh =  document.body.clientHeight;
		initSendKey();
		var sk =getCookie('sendKey'); 
		var exampleData = {
			memberList:${memberList},
			msgs : ${msgs},
			willSend:'',
			fromId :${curUser.id},
			fromAvatar:'${ctx}${curUser.avatar}',
			toId : ${toId},
			toAvatar:'${ctx}${toAvatar}',
			toName:'${toName}',
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
				send:function(){
					var t = this.willSend;
					if(t==''){
						layer.msg("请输入内容");
					}else{
						$.getJSON('${adp}sendToMember?memberId='+vue.toId+'&text='+t,function(res){
							var msg ={};
							msg.fromId=vue.fromId;
							msg.toId=vue.toId;
							msg.content=t;
							msg.type="TEXT";
							msg.cat='KF_TO_MEMBER';
							msg.fromAvatar=vue.fromAvatar;
							vue.msgs.push(msg);
							vue.willSend='';
						});
					}
				},

				chMember:function(m){
					
					m.noReadMsgCount=0;
					
					var mid = m.id;
					var avt=m.iocUrl;
					var name=m.nickname;					
					vue.toId="";
					vue.toAvatar="";
					vue.toName="";
					vue.toId=mid;
					vue.toAvatar=avt;
					vue.toName=name;
					$.getJSON('${adp}getChatMsgs/'+mid,function(res){
						vue.msgs="";
						vue.msgs=res.msgs;
					});
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
				kw: function (val) {
					if(val){
						var arr = vue.memberList;
						vue.memberList=arr.filter(item => item.nickname.indexOf(val) > -1);
					}else{
						vue.memberList=init_member_list;
					}
				}
			}
		});
		
		
		var showMsgToHeader = function(msg) {
			
			var cat = msg.cat; 
			
			if(cat=='MEMBER_IN_CHAT'){
				//alert("会员："+msg.fromId+"进入聊天");				
				return;
			}else if(cat=='MEMBER_TO_KF'){
				if(msg.fromId == vue.toId){ //发来消息的会员为当会员直接显示消息
					vue.msgs.push(msg); 
				}else{ //消息数量+1
					$.each(vue.memberList,function(k,v){
						if(v.id==msg.fromId){
							v.noReadMsgCount=v.noReadMsgCount+1;
						}
					});					
				}
			}else if(cat=='KF_TO_MEMBER'){
				if(msg.toId == vue.toId){
					vue.msgs.push(msg); 
				}
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

		
		
	</script>



</body>

</html>