package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	private String username;
	private String firsrtName;
	private String lastName;
	private String password;
	private String mobileNumber;
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirsrtName() {
		return firsrtName;
	}
	public void setFirsrtName(String firsrtName) {
		this.firsrtName = firsrtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "AbstractUser [username=" + username + ", firsrtName=" + firsrtName + ", lastName=" + lastName
				+ ", password=" + password + ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}
	
	

}
