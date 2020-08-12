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

import cct.ie.garage.entities.Login;
import cct.ie.garage.repositories.LoginRepository;
import cct.ie.responses.NotFoundResponse;
import cct.ie.responses.SuccessResponse;

@Controller // This means that this class is a Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/garage/login") // This means URL's start with /demo (after Application path)
@EntityScan("cct.ie.garage.*")
public class LoginController {
	// This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	@Autowired
	private LoginRepository loginRepository;

	@PostMapping(path = "/login") // Map ONLY POST Requests
	public @ResponseBody Login login(@RequestBody Login login) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Login authenticated = loginRepository.auth(login.getUsername(), login.getPassword());
		if (authenticated != null) {
			return authenticated;
		}
		throw new NotFoundResponse("Username or Password not found!");

	}

	@PostMapping(path = "/register")
	public @ResponseBody SuccessResponse register(@RequestBody Login login) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		loginRepository.createLogin(login.getUsername(), login.getPassword(), login.getRole().name(), login.getId());

		return new SuccessResponse("User " + login.getUsername() + " has been created!!");

	}

	@DeleteMapping(path = "/del")
	public @ResponseBody String deleteLogin(@RequestBody Login login) {
		String user = login.getUsername();
		loginRepository.delete(login);
		return ("User " + user + " has been deleted!!");

	}

	@PutMapping(path = "/update")
	public @ResponseBody String updateLogin(@RequestBody Login login) {
		String user = login.getUsername();
		loginRepository.update(login.getPassword(), login.getUsername());
		return ("User " + user + " has been updated!!");

	}

	@GetMapping(path = "/findAll")
	public @ResponseBody Iterable<Login> findAll(@RequestBody Login login) {

		Iterable<Login> it = loginRepository.findAll();
		return it;
	}

	@GetMapping(path = "/findById")
	public @ResponseBody Optional<Login> findById(@RequestParam int id) {

		return loginRepository.findById(id);

	}

}