package com.santho.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MailServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MailServiceApplication.class, args);
	}

}
