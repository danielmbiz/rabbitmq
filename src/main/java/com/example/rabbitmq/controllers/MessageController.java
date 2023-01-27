package com.example.rabbitmq.controllers;

import com.example.rabbitmq.dto.MessageDTO;
import com.example.rabbitmq.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody MessageDTO message) {
        messageService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
