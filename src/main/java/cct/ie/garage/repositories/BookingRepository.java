package cct.ie.garage.repositories;

import java.time.LocalDate;
import java.util.List;

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

	@Query(value = "select * from booking b where b.appointment = ?1", nativeQuery = true)
	List<Booking> getAvailableStaff(LocalDate appointment);

	@Query(value = "select * from booking b join customer c on (c.id = b.customer_id) join vehicle v on (v.customer_id = b.customer_id) where c.id = ?1	 order by b.id desc limit 1", nativeQuery = true)
	Booking getCurrentBooking(String idCust);

	@Query(value = "select * from booking where appointment = ?1", nativeQuery = true)
	List<Booking> getTotalPerDay(LocalDate appointment);

}
