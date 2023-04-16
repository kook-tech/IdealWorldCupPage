package com.kch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IdealWordlCupPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdealWordlCupPageApplication.class, args);
	}

}
