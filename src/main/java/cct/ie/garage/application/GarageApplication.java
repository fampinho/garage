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

//	@Bean
//	public CommandLineRunner demo(VehicleRepository repository) {
//		return (args) -> {
//			// save a few customers
//			repository.save(new Vehicle("BMW", "SLX", Fuel.PETROL, "1025-542-1", "2002"));
//			repository.save(new Vehicle("Audi", "A4", Fuel.DIESEL, "1025-888-5", "2008"));
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Vehicle vehicle : repository.findAll()) {
//				log.info(vehicle.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
////	      Vehicle vehicle = repository.findById(1L);
////	      log.info("Customer found with findById(1L):");
////	      log.info("--------------------------------");
////	      log.info(vehicle.toString());
////	      log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByModel("Audi").forEach(audi -> {
//				log.info(audi.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			// log.info(bauer.toString());
//			// }
//			log.info("");
//		};
//	}

}
