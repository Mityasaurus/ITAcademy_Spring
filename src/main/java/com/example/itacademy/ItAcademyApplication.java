package com.example.itacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ItAcademyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItAcademyApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void applicationReady(){
		System.err.println("Started");
	}

}
