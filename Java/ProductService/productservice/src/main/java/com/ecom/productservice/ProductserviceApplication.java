package com.ecom.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ecom.configs", 
	"com.ecom.controllers", 
	"com.ecom.productservice", 
	"com.ecom.advices"})
@EnableJpaRepositories(basePackages={"com.ecom.repositories"})
@EntityScan(basePackages = {"com.ecom.models"})
public class ProductserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

}
