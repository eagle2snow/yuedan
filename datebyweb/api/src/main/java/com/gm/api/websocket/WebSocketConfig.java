package com.gm.api.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// 在网页上我们就可以通过这个链接 /server/hello 来和服务器的WebSocket连接
		registry.addEndpoint("/wskjs").setAllowedOrigins("*").withSockJS().setStreamBytesLimit(13107200);
	}

	@Override
	public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
		registration.setMessageSizeLimit(1024 * 1024 * 10);
		registration.setSendBufferSizeLimit(1024 * 1024 * 10);
		registration.setSendTimeLimit(20000);
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// 如果是以/topic,/queue开头则会被转发给消息代理（broker），由broker广播给连接的客户端。
		config.enableSimpleBroker("/msg", "/topic", "/queue");
		config.setApplicationDestinationPrefixes("/wsk");
		config.setUserDestinationPrefix("/user");
	}

}