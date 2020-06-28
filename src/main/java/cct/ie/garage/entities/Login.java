/**
 * 
 */
package cct.ie.garage.entities;

import cct.ie.garage.enums.Role;

/**
 *
 */
public class Login {

	private Integer id;
	private String username;
	private String password;
	private Enum<Role> role;

	public Login() {
		// TODO Auto-generated constructor stub
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

	public Enum<Role> getRole() {
		return role;
	}

	public void setRole(Enum<Role> role) {
		this.role = role;
	}

}
