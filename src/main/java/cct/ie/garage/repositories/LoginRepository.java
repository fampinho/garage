package cct.ie.garage.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import cct.ie.garage.entities.Login;

public interface LoginRepository extends CrudRepository<Login, Integer> {

	@Query("select l from Login l where l.username = :user and l.password = :key")
	Login auth(@Param("user") String user, @Param("key") String key);

	@Modifying
	@Query("update Login l set l.password = :key where l.username = :user")
	@Transactional
	void update(@Param("key") String key, @Param("user") String user);

	@Query("select l from Login l where l.username = :user")
	Login findByUser(@Param("user") String user);

	@Modifying
	@Query(value = "insert into Login (username, password, role) values (:user, :key, :role)", nativeQuery = true)
	@Transactional
	void createLogin(@Param("user") String user, @Param("key") String key, @Param("role") String role);
}
