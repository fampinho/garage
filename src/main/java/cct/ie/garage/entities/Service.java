package cct.ie.garage.entities;

import java.time.LocalDate;

public class Service {

	private Integer id;
	private String type;
	private LocalDate dateIn;
	private LocalDate dateOut;
	private Double price;
	private String extraService;
	private Double extraPrice;
	private Stock stock;

	public Service(Booking booking) {
		this.type = booking.getServiceType().toString();
		this.dateIn = booking.getAppointment();
		this.dateOut = null;
		this.price = null;
		this.extraPrice = null;
		this.extraService = null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getDateIn() {
		return dateIn;
	}

	public void setDateIn(LocalDate dateIn) {
		this.dateIn = dateIn;
	}

	public LocalDate getDateOut() {
		return dateOut;
	}

	public void setDateOut(LocalDate dateOut) {
		this.dateOut = dateOut;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getExtraService() {
		return extraService;
	}

	public void setExtraService(String extraService) {
		this.extraService = extraService;
	}

	public Double getExtraPrice() {
		return extraPrice;
	}

	public void setExtraPrice(Double extraPrice) {
		this.extraPrice = extraPrice;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
