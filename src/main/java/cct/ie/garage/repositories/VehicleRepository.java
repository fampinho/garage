package cct.ie.garage.repositories;

import org.springframework.data.repository.CrudRepository;

import cct.ie.garage.entities.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

}
