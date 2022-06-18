package com.example.UserRegistration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userDetails")
public class UserDetails {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "first_name", nullable = false, length = 20)
	private String firstname;
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastname;
	@Column(nullable = false, unique = true, length = 45)
	private String email_id;
	@Column(nullable = false, length = 64)
	private String phone_no;
	
	public UserDetails() {
		
	}

	public UserDetails(long id, String firstname, String lastname, String email_id, String phone_no) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email_id = email_id;
		this.phone_no = phone_no;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	
	
}
