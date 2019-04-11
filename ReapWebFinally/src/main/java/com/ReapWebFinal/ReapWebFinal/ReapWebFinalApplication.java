package com.ReapWebFinal.ReapWebFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages={"com.ReapWebFinal.ReapWebFinal.entity"})
@EnableJpaRepositories(basePackages={"com.ReapWebFinal.ReapWebFinal.repository"})
public class ReapWebFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReapWebFinalApplication.class, args);
	}

}
