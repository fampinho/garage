package cct.ie.garage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cct.ie.garage.entities.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

}
