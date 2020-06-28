package cct.ie.garage.application;

import org.springframework.data.repository.CrudRepository;

import cct.ie.garage.entities.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

//	List<Vehicle> findByModel(String model);
}
