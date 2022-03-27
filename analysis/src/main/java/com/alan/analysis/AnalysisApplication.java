package com.alan.analysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AnalysisApplication {
	public static void main(String[] args) {
		SpringApplication.run(AnalysisApplication.class, args);
	}
}