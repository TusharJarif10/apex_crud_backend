package com.apexcrud.usercrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UsercrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsercrudApplication.class, args);
	}

}
