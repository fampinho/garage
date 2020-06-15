package cct.ie.garage.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cct.ie.garage.repositories.VehicleRepository;

@SpringBootApplication
@ComponentScan("cct.ie.garage.*")
@EnableAutoConfiguration
@Configuration
public class GarageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarageApplication.class, args);
	}

}
