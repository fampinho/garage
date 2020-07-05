package cct.ie.garage.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cct.ie.garage.entities.Login;

public interface LoginRepository extends CrudRepository<Login, Integer> {

//	List<Customer> findAll();
	
	@Query("select l from Login l where l.username = :user and l.password = :key")
	Login auth(@Param("user") String user, @Param("key") String key);
}
