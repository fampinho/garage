package cct.ie.garage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cct.ie.garage.entities.Vehicle;
import cct.ie.garage.repositories.VehicleRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/garage/vehicle") // This means URL's start with /demo (after Application path)
@CrossOrigin(origins = "*")
@EntityScan("cct.ie.garage.*")
public class VehicleController {
	// This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	@Autowired
	private VehicleRepository vehicleRepository;

	@PostMapping(path = "/addVehicle") // Map ONLY POST Requests
	public @ResponseBody String addVehicle(@RequestBody Vehicle vehicle) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		vehicleRepository.create(vehicle.getMaker(), vehicle.getModel(), vehicle.getFuel().name(),
				vehicle.getType().name(), 38/** TESTE - HARD CODE - ID CUSTOMER **/
		);
		return "Saved";
	}

	@DeleteMapping(path = "/deleteVehicle")
	public @ResponseBody String deleteVehicle(@RequestBody Vehicle vehicle) {
		vehicleRepository.delete(vehicle.getId());
		return ("Vehicle has been deleted!!");

	}

	@PutMapping(path = "/updateVehicle")
	public @ResponseBody String updateVehicle(@RequestBody Vehicle vehicle) {
		vehicleRepository.update(vehicle.getMaker(), vehicle.getModel(), vehicle.getFuel().name(),
				vehicle.getType().name(), 32/** TESTE - HARD CODE - ID VEHICLE **/
		);
		return ("Vehicle has been updated!!");

	}

	@GetMapping(path = "/findByLicence")
	public @ResponseBody Vehicle findByLicence(@RequestBody Vehicle vehicle) {

		return vehicleRepository.findByLicence(vehicle.getLicenceNumber());

	}

	@GetMapping(path = "/findAll")
	public @ResponseBody Iterable<Vehicle> getAllVehicles() {
		// This returns a JSON or XML with the users
		return vehicleRepository.findAll();
	}
}