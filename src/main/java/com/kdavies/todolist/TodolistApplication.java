package com.kdavies.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistApplication {

	/**
	 * Uses Spring Boot’s SpringApplication.run() method to launch
	 * the To Do List application.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}
}

