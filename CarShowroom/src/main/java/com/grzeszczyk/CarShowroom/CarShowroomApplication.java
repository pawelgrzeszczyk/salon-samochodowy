package com.grzeszczyk.CarShowroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarShowroomApplication {

	public static void main(String[] args) {

		System.out.printf("Dziala");
		SpringApplication.run(CarShowroomApplication.class, args);
	}
}
