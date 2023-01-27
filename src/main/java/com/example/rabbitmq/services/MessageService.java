package com.example.rabbitmq.services;

import com.example.rabbitmq.dto.MessageDTO;
import com.example.rabbitmq.rabbitmq.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageSender messageSender;

    public void sendMessage(MessageDTO message) {
        messageSender.sendMessages(message);
    }
}
