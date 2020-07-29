package cct.ie.garage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import cct.ie.garage.enums.FuelType;
import cct.ie.garage.enums.VehicleType;

@Entity
@SecondaryTable(name = "car_licence", pkJoinColumns = @PrimaryKeyJoinColumn(name = "vehicle_id"))
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
//	@JsonDeserialize(using = LocalDateDeserializer.class)
//	@JsonSerialize(using = LocalDateSerializer.class)
	private Integer id;
	private String maker;
	private String model;
	@Enumerated(EnumType.STRING)
	private FuelType fuel;
	@Enumerated(EnumType.STRING)
	private VehicleType type;

	@Column(name = "licence_number", table = "car_licence")
	private String licenceNumber;

	@Column(table = "car_licence")
	private String manufacture;	
	
	public Vehicle(String maker, String model, FuelType fuel, String licenceNumber, String manufacture,
			VehicleType vehicleType) {
		this.maker = maker;
		this.model = model;
		this.fuel = fuel;
		this.licenceNumber = licenceNumber;
		this.manufacture = manufacture;
		this.type = vehicleType;

	}

	public Vehicle() {

	}

	public Vehicle(String maker, String model, FuelType fuel, VehicleType type) {
		this.maker = maker;
		this.model = model;
		this.fuel = fuel;
		this.type = type;
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

	public FuelType getFuel() {
		return fuel;
	}

	public void setFuel(FuelType fuel) {
		this.fuel = fuel;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
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
