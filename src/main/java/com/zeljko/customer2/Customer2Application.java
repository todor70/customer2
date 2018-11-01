package com.zeljko.customer2;

import com.zeljko.customer2.entity.Customer;
import com.zeljko.customer2.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Customer2Application {

	public static void main(String[] args) {
		SpringApplication.run(Customer2Application.class, args);
	}

	@Bean
	CommandLineRunner runner(CustomerRepository customerRepository) {
		return args -> {

			Customer c1 = new Customer();
			c1.setFirstName("marko");
			c1.setLastName("markovic");
			c1.setEmail("marko@gmail.com");

			customerRepository.save(c1);

			Customer c2 = new Customer();
			c2.setFirstName("petar");
			c2.setLastName("petrovic");
			c2.setEmail("petar@gmail.com");

			customerRepository.save(c2);

		};
	}

}

