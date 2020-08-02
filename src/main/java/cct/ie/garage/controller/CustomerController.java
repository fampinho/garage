package cct.ie.garage.controller;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cct.ie.garage.entities.Customer;
import cct.ie.garage.repositories.CustomerRepository;
import cct.ie.responses.SuccessResponse;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/garage/customer") // This means URL's start with /demo (after Application path)
@CrossOrigin(origins = "http://localhost:8100")
@EntityScan("cct.ie.garage.*")
public class CustomerController {
	// This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody SuccessResponse add(@RequestBody Customer customer) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Customer n = new Customer(customer.getPpsn(), customer.getName(), customer.getMidName(), customer.getSurname(),
				customer.getPhone(), customer.getEmail(), customer.getVehicles());
		customerRepository.save(n);
		return new SuccessResponse("Customer "+ customer.getName() + " has been created!!");
	}

	@DeleteMapping(path = "/del")
	public @ResponseBody String delete(@RequestBody Customer customer) {
		customerRepository.deleteById(customer.getId());
		return ("Customer has been deleted!!");

	}

	@PutMapping(path = "/update")
	public @ResponseBody SuccessResponse updateCustomer(@RequestBody Customer customer) {
		customerRepository.update(customer.getPpsn(), customer.getPhone(), customer.getEmail(), customer.getId());
		customerRepository.updateName(customer.getName(), customer.getMidName(), customer.getSurname(),
				customer.getId());
		return new SuccessResponse("Customer "+ customer.getName() + " has been updated!!");

	}

	@GetMapping(path = "/findByPPSN")
	public @ResponseBody Optional<Customer> findByPPSN(@RequestParam String ppsn) {

		return customerRepository.findByPPSN(ppsn);

	}

	@GetMapping(path = "/findAll")
	public @ResponseBody Iterable<Customer> findAll() {
		// This returns a JSON or XML with the users
		return customerRepository.findAll();
	}
}