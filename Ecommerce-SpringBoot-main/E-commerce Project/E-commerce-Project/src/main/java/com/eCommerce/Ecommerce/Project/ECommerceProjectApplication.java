package com.eCommerce.Ecommerce.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.eCommerce.Ecommerce.Project"})
public class ECommerceProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(ECommerceProjectApplication.class, args);
	}

}
