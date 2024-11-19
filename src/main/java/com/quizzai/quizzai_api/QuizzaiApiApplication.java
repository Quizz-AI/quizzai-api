package com.quizzai.quizzai_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.quizzai.quizzai_api.config.environment.DotenvInitializer;

@SpringBootApplication
public class QuizzaiApiApplication {

	public static void main(String[] args) {
		DotenvInitializer.load();
		SpringApplication.run(QuizzaiApiApplication.class, args);
	}

}
