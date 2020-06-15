package cct.ie.garage.entities;

import java.security.Timestamp;

import cct.ie.garage.enums.ServiceType;
import cct.ie.garage.enums.ServiceStatus;

public class Booking {
	private Integer id;
	private Enum<ServiceType> type;
	private Timestamp appointment;
	private Enum<ServiceStatus> status;
	private String description;
	private Staff staff;

	public String generateService(Booking booking) {
		
		return null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Enum<ServiceType> getType() {
		return type;
	}

	public void setType(Enum<ServiceType> type) {
		this.type = type;
	}

	public Timestamp getAppointment() {
		return appointment;
	}

	public void setAppointment(Timestamp appointment) {
		this.appointment = appointment;
	}

	public Enum<ServiceStatus> getStatus() {
		return status;
	}

	public void setStatus(Enum<ServiceStatus> status) {
		this.status = status;
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
	
	
}
