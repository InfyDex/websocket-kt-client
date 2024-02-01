package com.example.demo.ws

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.converter.MappingJackson2MessageConverter
import org.springframework.messaging.converter.SimpleMessageConverter
import org.springframework.messaging.converter.StringMessageConverter
import org.springframework.messaging.simp.stomp.StompSessionHandler
import org.springframework.web.socket.client.standard.StandardWebSocketClient
import org.springframework.web.socket.messaging.WebSocketStompClient


@Configuration
class WebSocketConfig {
    @Bean
    fun stompClient(): WebSocketStompClient {
        val stompClient = WebSocketStompClient(StandardWebSocketClient())
        stompClient.messageConverter = StringMessageConverter()
        return stompClient
    }

    @Bean
    fun stompSessionHandler(): StompSessionHandler {
        return MyStompSessionHandler()
    }
}
