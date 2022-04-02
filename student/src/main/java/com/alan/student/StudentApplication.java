package com.alan.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(
	scanBasePackages = {
			"com.alan.student",
			"com.alan.amqpapp"
	}
)
@EnableEurekaClient
@EnableFeignClients(
		basePackages = "com.alan.clientsapp"
)
@PropertySources({
	@PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class StudentApplication 
{
    public static void main(String[] args )
    {
        SpringApplication.run(StudentApplication.class, args);
    }
}
