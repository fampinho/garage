package cct.ie.garage.application;

import org.springframework.data.repository.CrudRepository;

import cct.ie.garage.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

//	List<Vehicle> findByModel(String model);
}
