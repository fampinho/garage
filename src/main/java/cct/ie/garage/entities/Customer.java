package cct.ie.garage.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name = "customer_name", pkJoinColumns = @PrimaryKeyJoinColumn(name = "customer_id"))
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ppsn;
	
	@Column(name = "name", table = "customer_name")
	private String name;
	
	@Column(name = "mid_name", table = "customer_name", nullable = true)
	private String midName;

	@Column(name = "surname", table = "customer_name")
	private String surname;
	private String phone;
	private String email;

	@OneToMany(mappedBy = "customer",targetEntity = Vehicle.class)
	private List<Vehicle> vehicle;
//	private Booking booking;
//	private Login login;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPpsn() {
		return ppsn;
	}

	public void setPpsn(String ppsn) {
		this.ppsn = ppsn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

//	public Booking getBooking() {
//		return booking;
//	}
//
//	public void setBooking(Booking booking) {
//		this.booking = booking;
//	}
//
//	public Login getLogin() {
//		return login;
//	}
//
//	public void setLogin(Login login) {
//		this.login = login;
//	}

}
