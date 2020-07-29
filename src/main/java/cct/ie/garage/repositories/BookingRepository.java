package cct.ie.garage.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import cct.ie.garage.entities.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

	@Modifying
	@Query(value = "update Booking b set b.type = ?1, b.appointment = ?2, b.description = ?3, b.status = ?4 where b.id = ?5 ", nativeQuery = true)
	@Transactional
	void update(String serviceType, LocalDate appointment, String description, String Status, Integer id);

	@Modifying
	@Query(value = "update Booking b set b.status = ?1 where b.id = ?2 ", nativeQuery = true)
	@Transactional
	void cancel(String status, Integer id);

}
