package com.binar.binar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@EntityScan("com.binar.binar.entity")
@SpringBootApplication
public class BinarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BinarApplication.class, args);
	}

}
