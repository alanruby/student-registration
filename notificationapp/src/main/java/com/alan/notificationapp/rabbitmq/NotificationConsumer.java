package com.alan.notificationapp.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alan.clientsapp.notification.NotificationRequest;
import com.alan.notificationapp.NotificationService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Component
public class NotificationConsumer {
	
	private final NotificationService notificationService;
	
	@RabbitListener(queues = "${rabbitmq.queue.notification}")
	public void consumer(NotificationRequest notificationRequest) {
		log.info("Consumed {} from queue", notificationRequest);
		notificationService.send(notificationRequest);
	}

}