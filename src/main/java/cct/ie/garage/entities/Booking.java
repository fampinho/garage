package cct.ie.garage.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import cct.ie.garage.enums.BookingStatus;
import cct.ie.garage.enums.ServiceType;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private ServiceType serviceType;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate appointment;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;

	private String description;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "staff_id", referencedColumnName = "id")
	private Staff staff;

	@Column(name = "vehicle_id")
	private Integer idVehicle;

	@Column(name = "customer_id")
	private Integer idCustomer;

	public Booking() {

	}

	public Booking(String serviceType, LocalDate appointment, String description, Integer idCustomer, Staff staff,
			Integer idVehicle) {
		switch (serviceType) {
		case "ANNUAL_SERVICE":
			this.serviceType = ServiceType.ANNUAL_SERVICE;
			break;
		case "MAJOR_REPAIR":
			this.serviceType = ServiceType.MAJOR_REPAIR;
			break;
		case "MAJOR_SERVICE":
			this.serviceType = ServiceType.MAJOR_SERVICE;
			break;
		case "REPAIR_FAULT":
			this.serviceType = ServiceType.REPAIR_FAULT;
			break;
		}

		this.appointment = appointment;
		this.bookingStatus = BookingStatus.BOOKED;
		this.description = description;
		this.idCustomer = idCustomer;
		this.staff = staff;
		this.idVehicle = idVehicle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public LocalDate getAppointment() {
		return appointment;
	}

	public void setAppointment(LocalDate appointment) {
		this.appointment = appointment;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Integer getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(Integer idVehicle) {
		this.idVehicle = idVehicle;
	}

}
