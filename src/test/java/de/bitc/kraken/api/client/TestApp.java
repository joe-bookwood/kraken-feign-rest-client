package de.bitc.kraken.api.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TestApp {
	public static void main(String[] args) {
		SpringApplication.run(TestApp.class, args);
	}
}
