package com.alan.apigwy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.alan.apigwy.ApiGWYApplication;


@EnableEurekaClient
@SpringBootApplication
public class ApiGWYApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ApiGWYApplication.class, args);
    }
}