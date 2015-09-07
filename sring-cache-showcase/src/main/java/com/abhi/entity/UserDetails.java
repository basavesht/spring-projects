package com.abhi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
@NamedQueries
(
		{       
			@NamedQuery(name = "UserDetails.findUserByEmailId", 
					query = "SELECT user FROM UserDetails user WHERE user.email = :emailId")
		}
		)
public class UserDetails
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;

	@Column(name="FIRST_NAME")
	private String firstname;

	@Column(name="LAST_NAME")
	private String lastname;

	@Column(name="EMAIL_ID")
	private String email;

	@Column(name="PHONE_NUMBER")
	private String telephone;

	public String getEmail() {
		return email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}