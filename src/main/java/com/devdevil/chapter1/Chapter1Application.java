package com.devdevil.chapter1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Chapter1Application {
	public static void main(String[] args) {
		SpringApplication.run(Chapter1Application.class, args);
	}
}
