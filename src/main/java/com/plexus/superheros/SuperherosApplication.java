package com.plexus.superheros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperherosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperherosApplication.class, args);
		System.out.println("Hola super heroes!!");
	}

}
