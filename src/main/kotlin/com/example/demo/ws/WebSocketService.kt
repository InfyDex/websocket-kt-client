package com.example.demo.ws

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandler
import org.springframework.stereotype.Service
import org.springframework.web.socket.messaging.WebSocketStompClient


@Service
class WebSocketService @Autowired constructor(
    private val stompClient: WebSocketStompClient,
    private val stompSessionHandler: StompSessionHandler
) {
    private var stompSession: StompSession? = null

    private final fun connectToWebSocket() {
        stompSession = stompClient.connect("ws://localhost:8080/api/game-updates/123", stompSessionHandler).get()
    }

    init {
        connectToWebSocket()
    }

    fun rollDice() {
        stompSession?.send("/app/123/action", "rollDice")
    }
}
