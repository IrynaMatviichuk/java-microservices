package com.euclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EuClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuClientApplication.class, args);
	}

}
