package cct.ie.garage.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import org.hibernate.annotations.GenericGenerator;

import cct.ie.garage.enums.Fuel;

@Entity
@SecondaryTable(name = "customer_name", pkJoinColumns = @PrimaryKeyJoinColumn(name = "customer_id"))
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
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

	@OneToMany(targetEntity = Vehicle.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", referencedColumnName ="id")
//	@Transient
	private List<Vehicle> vehicles;
//	private Booking booking;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "login_id", referencedColumnName = "id")
//	private Login login;

	public Customer() {
//		this.name = "Fabio";
//		this.surname = "Pimentel";
//		this.phone = "000";
//		this.email = "test@gmail.com";
//		this.vehicle.add(new Vehicle("Honda", "Civic", Fuel.ELETRIC, "354adasda", "2018"));
	}

	public Customer(String ppsn, String name, String midName, String surname, String phone, String email,
			List<Vehicle> vehicles) {
		this.vehicles = new ArrayList<Vehicle>();
//		this.login = new Login();
//		this.ppsn = ppsn;
//		this.name = name;
//		this.midName = midName; 
//		this.surname = surname;
//		this.phone = phone;
//		this.email = email;
//		this.vehicle.addAll(vehicles);

		this.ppsn = "354354sa";
		this.name = "Fabio";
		this.midName = midName;
		this.surname = "Pimentel";
		this.phone = "000";
		this.email = "test@gmail.com";
		this.vehicles.add(new Vehicle("Honda", "Civic", Fuel.ELETRIC, "354adasda", "2018"));
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

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
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
