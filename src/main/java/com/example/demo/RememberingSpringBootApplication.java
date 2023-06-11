package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = RememberingSpringBootApplication.class)
public class RememberingSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RememberingSpringBootApplication.class, args);
	}

}
