package com.hopital.domain;

import java.lang.String;
import java.sql.Date;
import javax.persistence.*;


@Entity
@Table(name="Patient")
public class Patient {

	private int id;
	private String firstname;
	private String lastname;
	private Date birthdate;

	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}   

	@Column(name="birthdate")
	public Date getBirthdate() {
		return this.birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}   

	@Column(name="firstname")
	public String getFirstname() {
		return this.firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name="lastname")
	public String getLastname() {
		return this.lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", Firstname=" + firstname + ", Lastname=" + lastname + "]";
	}
	

}
