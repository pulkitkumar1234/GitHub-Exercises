package com.ttn.SpringBootExercise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages={"com.ttn.SpringBootExercise.Question7.entity"})
@EnableJpaRepositories(basePackages={"com.ttn.SpringBootExercise.Question7.repository"})
public class SpringBootExerciseApplication {

	@Value("${DataBase_Port}")
	Integer port;

	@Value("${DataBase_Name}")
	String name;

	@Bean
	public User user(){
		User user=new User();
		user.setPassword(1234);
		user.setUserName("Pulkit");
		return user;
	}

	@Bean
	public DataBase dataBase(){
		DataBase dataBase=new DataBase();
		dataBase.setPort(port);
		dataBase.setName(name);
    	return dataBase;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExerciseApplication.class, args);
	}

}
