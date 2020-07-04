/**
 * 
 */
package cct.ie.garage.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import cct.ie.garage.enums.Role;

/**
 *
 */
@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;
	private String username;
	private String password;
	private Role role;

	public Login() {
		this.username = "famp";
		this.password = "123";
		this.role = Role.CUSTOMER;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
