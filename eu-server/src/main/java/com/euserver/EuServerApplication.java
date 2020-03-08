package com.euserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EuServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuServerApplication.class, args);
	}

}
