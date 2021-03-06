package cct.ie.garage.controller;

import java.util.List;
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

import cct.ie.garage.entities.Booking;
import cct.ie.garage.entities.Staff;
import cct.ie.garage.enums.BookingStatus;
import cct.ie.garage.enums.ServiceType;
import cct.ie.garage.repositories.BookingRepository;
import cct.ie.garage.repositories.StaffRepository;
import cct.ie.responses.BookingServiceResponse;
import cct.ie.responses.SuccessResponse;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/garage/booking") // This means URL's start with (after Application path)
@CrossOrigin(origins = "*") // Using (*) it allows request from any origin
@EntityScan("cct.ie.garage.*")
public class BookingController {
	// This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private StaffRepository staffRepository;

	private static final int BOOKING_DAY_LIMIT = 16;
	private static final int BOOKING_MAJOR_REPAIR_LIMIT = 15;

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody SuccessResponse add(@RequestBody Booking booking) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

//		Get all bookings per day
		List<Booking> listBooking = bookingRepository.getTotalPerDay(booking.getAppointment());

		if (listBooking != null) {
			int bCounter = 0;
			for (Booking b : listBooking) {
//				IF MAJOR_REPAIR ADD 2 as MAJOR_REPAIR IS A DOUBLE service
				if (b.getServiceType() == ServiceType.MAJOR_REPAIR) {
					bCounter = bCounter + 2;
				} else {
					bCounter++;
				}
			}
//			VERIFY Service Type: in case bCounter(booking counter) > = BOOKING_DAY_LIMIT or 
//			bCounter >= BOOKING_MAJOR_REPAIR_LIMIT and ServiceType = MAJOR_REPAIR,
//			 as MAJOR_REPAIR count as 2 services instead 1,
//			it means the service limit daily has been reached and throws  BookingServiceException
			if (bCounter >= BOOKING_DAY_LIMIT || (bCounter >= BOOKING_MAJOR_REPAIR_LIMIT
					&& booking.getServiceType() == ServiceType.MAJOR_REPAIR)) {
				throw new BookingServiceResponse("Limit of booking's been reached for the date selected "
						+ booking.getAppointment() + ". Try booking another day.");
			}
		}

		//GET THE STAFF WITH THE SMALLER AMOUNT OF SERVICE COUNTER
		Staff smallerServCounter = staffRepository.getSmallerServCounter();

		// INCREASE STAFF SERVICE COUNTER. ADD 2 IN CASE MAJOR REPAIR OTHERWISE ADD 1
		if (booking.getServiceType().name().equalsIgnoreCase("MAJOR_REPAIR")) {
			smallerServCounter.setCounter(smallerServCounter.getCounter() + 2);

		} else {
			smallerServCounter.setCounter(smallerServCounter.getCounter() + 1);

		}
		
		Booking n = new Booking(booking.getServiceType().name(), booking.getAppointment(), booking.getDescription(),
				booking.getIdCustomer(), smallerServCounter, booking.getIdVehicle());
		bookingRepository.save(n);

		return new SuccessResponse("Saved");
	}

	@DeleteMapping(path = "/cancel")
	public @ResponseBody SuccessResponse cancel(@RequestBody Booking booking) {
		bookingRepository.cancel(BookingStatus.CANCELED.name(), booking.getId());
		return new SuccessResponse("Booking has been deleted!!");

	}

	@PutMapping(path = "/update")
	public @ResponseBody String updateBooking(@RequestBody Booking booking) {
		bookingRepository.update(booking.getServiceType().name(), booking.getAppointment(), booking.getDescription(),
				booking.getBookingStatus().name(), booking.getId());
		return ("Booking has been updated!!");

	}

	@GetMapping(path = "/findById")
	public @ResponseBody Optional<Booking> findById(@RequestParam String id) {

		return bookingRepository.findById(Integer.parseInt(id));

	}

	@GetMapping(path = "/currentBooking")
	public @ResponseBody Booking currentBooking(@RequestParam String appointment, String idCustomer) {

		return bookingRepository.getCurrentBooking(idCustomer);

	}

	@GetMapping(path = "/findAll")
	public @ResponseBody Iterable<Booking> findAll() {
		// This returns a JSON or XML with the users
		return bookingRepository.findAll();
	}

	public String generateService(Booking booking) {

		return null;
	}

}