package com.example.demo.ws

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.lang.Nullable
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandler
import org.springframework.stereotype.Component
import java.lang.reflect.Type


@Component
class MyStompSessionHandler : StompSessionHandler {
    override fun getPayloadType(p0: StompHeaders): Type {
        TODO("Not yet implemented")
    }

    override fun handleFrame(headers: StompHeaders, payload: Any?) {
        println("Handle frame in MyStompFrameHandler: $payload")

        if (payload is String) {
            println("Handle frame in MyStompFrameHandler: $payload")
        } else {
            // Handle other payload types if needed
            println("Received payload of unexpected type: ${payload?.javaClass}")
        }
    }

    override fun afterConnected(session: StompSession, connectedHeaders: StompHeaders) {
        println("Connected to WebSocket")
        session.subscribe("/topic/game-updates", MyStompFrameHandler())
    }

    override fun handleException(p0: StompSession, p1: StompCommand?, p2: StompHeaders, p3: ByteArray, p4: Throwable) {
        println("handleException ${p4.printStackTrace()}")
    }

    override fun handleTransportError(p0: StompSession, p1: Throwable) {
        println("handleTransportError")
    }
}

data class YourMessageType(
    val id: Int,
    val socket: String,
    val type: String,
    val reply: Boolean
)
