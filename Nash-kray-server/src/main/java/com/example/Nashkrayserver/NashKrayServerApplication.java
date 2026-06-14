package com.example.Nashkrayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NashKrayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NashKrayServerApplication.class, args);
	}

}
