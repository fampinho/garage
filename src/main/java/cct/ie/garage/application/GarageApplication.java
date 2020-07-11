package cct.ie.garage.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("cct.ie.garage.*")
@EnableJpaRepositories("cct.ie.garage.*")
public class GarageApplication {

	private static final Logger log = LoggerFactory.getLogger(GarageApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GarageApplication.class, args);
	}

}
