package com.example.demo.ws

import org.springframework.messaging.simp.stomp.StompFrameHandler
import org.springframework.messaging.simp.stomp.StompHeaders
import java.lang.reflect.Type


class MyStompFrameHandler : StompFrameHandler {
    override fun getPayloadType(headers: StompHeaders): Type {
        return String::class.java
    }

    override fun handleFrame(headers: StompHeaders, payload: Any?) {
        println("Received message: " + payload.toString())
        // Process the received message as needed
    }
}
