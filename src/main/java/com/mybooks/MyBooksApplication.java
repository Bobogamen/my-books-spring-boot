package com.mybooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBooksApplication.class, args);
		System.out.println("My Books is started successfully!");
	}

}
