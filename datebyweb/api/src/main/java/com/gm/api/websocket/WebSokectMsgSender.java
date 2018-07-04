package com.gm.api.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.gm.base.consts.Const;
import com.gm.base.model.Msg;

/**
 * 消息发送器
 * 
 * @author Administrator
 *
 */
@Component
public class WebSokectMsgSender {

	@Autowired
	private SimpMessagingTemplate template;

	public void sendToUrl(Msg msg, String url) {
		try {
			template.convertAndSend(url, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send(Msg msg) {
		switch (msg.getCat()) {
		case KF_TO_MEMBER:
			sendToMember(msg);
			break;
		case MEMBER_TO_KF:
			sendToKf(msg);
			break;
		default:
			System.err.println("消息未发送");
			break;
		}
	}

	/**
	 * 发给会员
	 */
	private void sendToMember(Msg msg) {
		try {
			template.convertAndSend(Const.SEND_NEW_MSG_TO_MEMBER + msg.getToId(), msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 发给后台客服
	 * 
	 * @param msg
	 */
	private void sendToKf(Msg msg) {
		try {
			Object toId = msg.getToId();
			template.convertAndSend(Const.SEND_NEW_MSG_TO_KF + toId, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 给商家发新订单提醒
	 * 
	 * @param order
	 */
	/*
	 * public void sendNewOrderToStore(Msg msg) { sendToWebStore(msg);
	 * sendToAppStore(msg); }
	 * 
	 *//**
		 * 给商家发提现成功提醒
		 * 
		 * @param msg
		 */
	/*
	 * public void sendDrawSUCToStore(Msg msg) { sendToWebStore(msg);
	 * sendToAppStore(msg); }
	 * 
	 *//**
		 * 给商家发新评价提醒
		 * 
		 * @param msg
		 *//*
			 * public void sendNewCommentToStore(Msg msg) { sendToWebStore(msg);
			 * sendToAppStore(msg); }
			 */
}
