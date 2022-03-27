package com.alan.notificationapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alan.amqpapp.RabbitMQMessageProducer;

@SpringBootApplication(
		scanBasePackages = {
				"com.alan.notificationapp",
				"com.alan.amqpapp"
		}
)
public class NotificationApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(NotificationApplication.class, args);
    }
    
//  @Bean
//  CommandLineRunner commandLineRunner(
//  		 RabbitMQMessageProducer producer,
//  		 NotificationConfig notificationConfig
//  		) {
//  	return args -> {
//  		producer.publish(
//  				new Person("Pessoa!",33),
//  				notificationConfig.getInternalExchange(),
//  				notificationConfig.getInternalNotificationRoutingKey());
//  	};
//  }
//  record Person(String name, int age) {}
}
