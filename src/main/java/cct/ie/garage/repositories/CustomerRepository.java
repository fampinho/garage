package cct.ie.garage.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cct.ie.garage.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

//	List<Customer> findAll();
}
