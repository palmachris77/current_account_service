package com.everis.currentaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CurrentAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrentAccountServiceApplication.class, args);
		System.out.println("Servicio de cuentas de ahorro activado.");
	}

}
