package com.example.rabbitmq.rabbitmq;

import com.example.rabbitmq.dto.MessageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageReciever {

    @RabbitListener(queues = "${app-config.rabbit.queue.example}")
    public void recieverMessage(MessageDTO message) {
        try {
            log.info("Recebendo mensagem com a informação: {}",
                    new ObjectMapper().writeValueAsString(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
