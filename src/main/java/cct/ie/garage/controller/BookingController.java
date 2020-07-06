package cct.ie.garage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cct.ie.garage.entities.Booking;
import cct.ie.garage.repositories.BookingRepository;

@Controller // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/garage") // This means URL's start with /demo (after Application path)
@EntityScan("cct.ie.garage.*")
public class BookingController {
	// This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	@Autowired
	private BookingRepository bookingRepository;

	@PostMapping(path = "/addBooking") // Map ONLY POST Requests
	public @ResponseBody String addCustomer(@RequestBody Booking booking) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Booking n = new Booking(booking.getServiceType(), booking.getAppointment(), booking.getDescription(),
				booking.getCustomer());
		bookingRepository.save(n);
		return "Saved";
	}

	@GetMapping(path = "/allBookings")
	public @ResponseBody Iterable<Booking> getAllBookings() {
		// This returns a JSON or XML with the users
		return bookingRepository.findAll();
	}

	public String generateService(Booking booking) {

		return null;
	}

}