package com.realdolmen.freshlypressed.backend;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.realdolmen.freshlypressed" })
@SpringBootApplication
public class Application {	
	
	public static void main(String[] args) {		
		SpringApplication.run(Application.class, args);
	}
	
	@PreDestroy
	public void exit(){
		System.out.println("Exit Freshlypressed Backend");
	}
}
