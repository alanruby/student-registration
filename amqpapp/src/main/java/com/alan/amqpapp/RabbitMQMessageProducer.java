package com.alan.amqpapp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import com.alan.amqpapp.RabbitMQMessageProducer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQMessageProducer {
	private final AmqpTemplate amqpTemplate;
	
	public void publish(Object payload, String exchange, String routingKey) {
		log.info("## Publishing to {} using routingKey {}. Payload: {}", exchange, routingKey, payload);
		amqpTemplate.convertAndSend(exchange, routingKey, payload);
		log.info("## Published to {} using routingKey {}. Payload: {}", exchange, routingKey, payload);
	}
}
