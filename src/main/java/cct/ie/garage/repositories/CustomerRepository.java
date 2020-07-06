package cct.ie.garage.repositories;

import org.springframework.data.repository.CrudRepository;

import cct.ie.garage.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
