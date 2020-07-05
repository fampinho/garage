package cct.ie.garage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import org.hibernate.annotations.GenericGenerator;

@Entity
@SecondaryTable(name = "staff_name", pkJoinColumns = @PrimaryKeyJoinColumn(name = "staff_id"))
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;
	private String ppsn;

	@Column(name = "name", table = "staff_name")
	private String name;

	@Column(name = "mid_name", table = "staff_name", nullable = true)
	private String midName;

	@Column(name = "surname", table = "staff_name")
	private String surname;

	private Double salary;

	@Column(name = "is_available")
	private boolean isAvailable;

	@Column(name = "service_counter")
	private Integer counter;

	public Staff() {

	}

	public Staff(String ppsn, String name, String midName, String surname) {
		this.ppsn = ppsn;
		this.name = name;
		this.midName = midName;
		this.surname = surname;
		this.salary = 1800D;
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

}
