package cct.ie.garage.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import cct.ie.garage.entities.Vehicle;
import cct.ie.garage.enums.FuelType;
import cct.ie.garage.enums.VehicleType;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

//	@Modifying
//	@Query("update Vehicle v set v.licence_number = :licence and v.maker = :maker and  v.model = :model and  "
//			+ "v.fuel = :fuel and  v.type = :type and v.manufacture = :manufacture and  "
//			+ "where v.licence_number = :licence")

//	@Transactional
//	void update(@Param("licence") String licence, @Param("maker") String maker, @Param("model") String model,
//			@Param("fuel") FuelType fuel, @Param("manufacture") String manufacture, @Param("type") VehicleType type);

//	@Query("select v from Vehicle v join car_licence c on (v.id = c.vehicle_id) where c.licence_number = :licence")
//	@Query(value = "select v from Vehicle v join car_licence c on (v.id = c.vehicle_id) where c.licence_number = :licence", nativeQuery = true)
//	Vehicle findByLicence(@Param("licence") String licence);

	@Modifying
	@Query(value = "insert into Vehicle (maker, model, fuel, type) values (:maker, :model, :fuel, :type)", nativeQuery = true)
	@Transactional
	void createVehicle(@Param("maker") String maker, @Param("model") String model,
			@Param("fuel") String fuel, @Param("type") String type);

}
