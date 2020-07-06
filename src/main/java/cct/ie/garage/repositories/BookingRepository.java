package cct.ie.garage.repositories;

import org.springframework.data.repository.CrudRepository;

import cct.ie.garage.entities.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

}
