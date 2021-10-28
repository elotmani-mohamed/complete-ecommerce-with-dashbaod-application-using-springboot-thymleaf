package com.ecommerce.doa;

import java.util.List;

public class UserDto {

	
	private String firstName;;
	
	
	private String lastName;
	
	
	private String email;
	
	
	private String password;
	
	
	private List<RoleDto> roles;


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<RoleDto> getRoles() {
		return roles;
	}


	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}



	
}
