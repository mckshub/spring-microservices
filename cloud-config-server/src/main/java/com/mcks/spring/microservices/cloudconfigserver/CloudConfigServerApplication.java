package com.mcks.spring.microservices.cloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableConfigServer
@RefreshScope
public class CloudConfigServerApplication {

	public static void main(String[] args) {
		System.out.println("Starting up Spring Cloud Config Server. Please wait .... ");
		SpringApplication.run(CloudConfigServerApplication.class, args);

	}

}
