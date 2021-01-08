package com.hp.springboot.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.hp.springboot"})
public class MySpringBootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApplication.class, args);
	}

}
