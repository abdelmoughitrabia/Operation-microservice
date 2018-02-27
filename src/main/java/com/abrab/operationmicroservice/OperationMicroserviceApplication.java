package com.abrab.operationmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.abrab.operationmicroservice.serviceProxy")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class OperationMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperationMicroserviceApplication.class, args);
    }
}
