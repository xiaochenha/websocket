package com.example.websocket.project.controller;

import com.example.websocket.project.websocket.WebSocket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private WebSocket webSocket;

    @GetMapping("/sendAllWebSocket")
    public String test() {
        String text="【websocket】 广播";
        webSocket.sendAllMessage(text);
        return text;
    }

    @GetMapping("/sendOneWebSocket/{id}")
    public String sendOneWebSocket(@PathVariable("id") String id) {
        String text="【websocket】 点对点";
        webSocket.sendOneMessage(id,text);
        return text;
    }

}
