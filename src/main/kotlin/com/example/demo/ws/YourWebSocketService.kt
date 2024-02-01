package com.example.demo.ws

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.stomp.StompSessionHandler
import org.springframework.stereotype.Service
import org.springframework.web.socket.messaging.WebSocketStompClient


@Service
class YourWebSocketService @Autowired constructor(
    private val stompClient: WebSocketStompClient,
    private val stompSessionHandler: StompSessionHandler
) {
    fun connectToWebSocket() {
        stompClient.connect("ws://localhost:8080/api/game-updates", stompSessionHandler)
    }

    init {
        connectToWebSocket()
    }
}
