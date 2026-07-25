package com.coforge.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SbSmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbSmsApplication.class, args);
	}

}
