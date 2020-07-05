package cct.ie.garage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import org.hibernate.annotations.GenericGenerator;

import cct.ie.garage.enums.Fuel;

@Entity
@SecondaryTable(name = "car_licence", pkJoinColumns = @PrimaryKeyJoinColumn(name = "vehicle_id"))
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;
	private String maker;
	private String model;
	private Fuel fuel;

	@Column(name = "licence_number", table = "car_licence")
	private String licenceNumber;

	@Column(table = "car_licence")
	private String manufacture;

//	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//	@JoinColumn(name = "customer_id")
//	private Customer customer;

	public Vehicle() {

	}

	public Vehicle(String maker, String model, Fuel fuel, String licenceNumber, String manufacture) {
//		this.customer = new Customer();
		this.maker = maker;
		this.model = model;
		this.fuel = fuel;
		this.licenceNumber = licenceNumber;
		this.manufacture = manufacture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

}
