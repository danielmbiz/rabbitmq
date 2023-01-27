package com.example.rabbitmq.rabbitmq;

import com.example.rabbitmq.dto.MessageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class MessageSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${app-config.rabbit.queue.example}")
	private String exampleQueue;

	@Transactional
	public void sendMessages(MessageDTO message) {
		try {
			log.info("Enviando mensagem: {}", new ObjectMapper().writeValueAsString(message));
			rabbitTemplate.convertAndSend(exampleQueue, message);
			log.info("Mensagem enviada com sucesso!");
		} catch (Exception e) {
			log.info("Erro ao enviar mensagem " + e.getMessage());
		}
	}

}
