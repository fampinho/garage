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

}
