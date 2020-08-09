package cct.ie.garage.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import cct.ie.garage.entities.Staff;

public interface StaffRepository extends CrudRepository<Staff, Integer> {

	@Modifying
	@Query(value = "update Staff s set s.ppsn = :ppsn where s.id = :id", nativeQuery = true)
	@Transactional
	void update(@Param("ppsn") String ppsn, @Param("id") int id);

	@Modifying
	@Query(value = "update staff_name s set s.name = :name, s.mid_name = :midName, s.surname = :surname "
			+ "where s.staff_id = :id", nativeQuery = true)
	@Transactional
	void updateName(@Param("name") String name, @Param("midName") String midName, @Param("surname") String surname,
			@Param("id") int id);

	@Query("select min(s) from Staff s ")
	Staff getAvailableStaff();

	@Query("select sum(s) from Staff s ")
	Integer getServiceTotal();

	@Query(value = "select * from staff s join staff_name sn on (s.id = sn.staff_id) order by s.service_counter limit 1 ", nativeQuery = true)
	Staff getSmallerServCounter();
}
