package com.binar.binar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//@EntityScan("com.binar.binar.entity")
@SpringBootApplication
public class BinarApplication {
	public static void main(String[] args) {
		SpringApplication.run(BinarApplication.class, args);
	}
}
