package com.example.dataAccessWithJPA;

import com.example.dataAccessWithJPA.domain.Client;
import com.example.dataAccessWithJPA.repository.ClientRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
import java.util.logging.Logger;

@SpringBootApplication
public class DataAccessWithJpaApplication {

	private static final Logger log = (Logger) LoggerFactory.getLogger(DataAccessWithJpaApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(DataAccessWithJpaApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(ClientRepository repository) {
		return (args) -> {

			repository.save(new Client("Jack", "Bauer"));
			repository.save(new Client("Chloe", "O'Brian"));
			repository.save(new Client("Kim", "Bauer"));
			repository.save(new Client("David", "Palmer"));
			repository.save(new Client("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// fetch an individual customer by ID
			Optional<Client> client = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(client.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}

}
