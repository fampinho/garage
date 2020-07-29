package cct.ie.garage.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import cct.ie.garage.entities.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

	@Modifying
	@Query(value = "update Vehicle v set v.maker = :maker,  v.model = :model,  " + "v.fuel = :fuel,  v.type = :type "
			+ "where v.id = :id", nativeQuery = true)
	@Transactional
	void update(@Param("maker") String maker, @Param("model") String model, @Param("fuel") String fuel,
			@Param("type") String type, @Param("id") int id);

	@Modifying
	@Query(value = "delete from Vehicle v where v.id = :id", nativeQuery = true)
	@Transactional
	void delete(@Param("id") int id);

//	@Query("select v from Vehicle v join car_licence c on (v.id = c.vehicle_id) where c.licence_number = :licence")
	@Query(value = "select * from Vehicle v join car_licence c on (v.id = c.vehicle_id) where c.licence_number = :licence", nativeQuery = true)
	Vehicle findByLicence(@Param("licence") String licence);

	@Modifying
	@Query(value = "insert into Vehicle (maker, model, fuel, type, customer_id) values (:maker, :model, :fuel, :type, :idCust)", nativeQuery = true)
	@Transactional
	void create(@Param("maker") String maker, @Param("model") String model, @Param("fuel") String fuel,
			@Param("type") String type, @Param("idCust") int idCust);

}
