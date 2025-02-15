package com.example.hubNet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.hubNet.repositories")
@EntityScan(basePackages = "com.example.hubNet.entities")
@SpringBootApplication
public class HubNetApplication {

	public static void main(String[] args) {
		SpringApplication.run(HubNetApplication.class, args);
	}

}
