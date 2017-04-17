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
	private int numdossier;

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
	public Date getBirthDate() {
		return this.birthdate;
	}
	public void setBirthDate(Date birthdate) {
		this.birthdate = birthdate;
	}   

	@Column(name="firstname")
	public String getFirstName() {
		return this.firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	@Column(name="lastname")
	public String getLastName() {
		return this.lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", Firstname=" + firstname + ", Lastname=" + lastname + "]";
	}

	@Column(name="numdossier")
	public int getNumdossier() {
		return numdossier;
	}
	public void setNumdossier(int numdossier) {
		this.numdossier = numdossier;
	}
	

}
