package com.example.demo.ws

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/action")
class ActionResource(
    private val webSocketService: WebSocketService
) {
    @PostMapping("/rollDice")
    fun rollDice() {
        webSocketService.rollDice()
    }
}