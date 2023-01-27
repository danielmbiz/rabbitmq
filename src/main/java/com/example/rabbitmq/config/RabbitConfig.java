package com.example.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	@Value("${app-config.rabbit.exchange.example}")
	private String exampleTopicExchange;
	
	@Value("${app-config.rabbit.routinKey.example}")
	private String exampleKey;

	@Value("${app-config.rabbit.queue.example}")
	private String exampleMq;

	@Bean
    public TopicExchange productTopicExchange() {
        return new TopicExchange(exampleTopicExchange);
    }

    @Bean
    public Queue queue() {
        return new Queue(exampleMq, true);
    }

    @Bean
    public Binding exampleMqBinding(TopicExchange topicExchange) {
        return BindingBuilder
            .bind(queue())
            .to(topicExchange)
            .with(exampleKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
