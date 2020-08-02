package cct.ie.garage.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import cct.ie.garage.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	@Modifying
	@Query(value = "update Customer c set c.ppsn = :ppsn, c.phone = :phone, c.email = :email "
			+ "where c.id = :id", nativeQuery = true)
	@Transactional
	void update(@Param("ppsn") String ppsn, @Param("phone") String phone, @Param("email") String email,
			@Param("id") int id);

	@Modifying
	@Query(value = "update customer_name c set c.name = :name, c.mid_name = :midName, c.surname = :surname "
			+ "where c.customer_id = :id", nativeQuery = true)
	@Transactional
	void updateName(@Param("name") String name, @Param("midName") String midName, @Param("surname") String surname,
			@Param("id") int id);

	@Query("select c from Customer c where c.ppsn = :ppsn")
	Optional<Customer> findByPPSN(@Param("ppsn") String ppsn);

}
