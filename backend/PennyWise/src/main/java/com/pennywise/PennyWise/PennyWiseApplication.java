package com.pennywise.PennyWise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PennyWiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PennyWiseApplication.class, args);
	}

}
