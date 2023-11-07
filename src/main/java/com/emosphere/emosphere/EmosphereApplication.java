package com.emosphere.emosphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class EmosphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmosphereApplication.class, args);
	}

}
