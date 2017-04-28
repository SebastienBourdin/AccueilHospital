package com.hopital.domain;

import java.lang.String;
import java.sql.Date;
import javax.persistence.*;
import com.hopital.utility.PasswordSecure;


@Entity
@Table(name="User")
public class User {

	private int id;
	private String firstname;
	private String lastname;
	private String type;
	private String password;
	private int admin;
	private Date birthdate;


	public User(){
		this.admin=0;
	}
	
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

	@Column(name="type")
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}   
	
	@Column(name="password")
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		PasswordSecure passwordSecure=new PasswordSecure();
		try{
			this.password = passwordSecure.get_SHA_512_SecurePassword(password, "accueilhopital");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
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

	@Column(name="admin")
	public int isAdmin() {
		return this.admin;
	}
	public void setAdmin(int admin) {
		this.admin=admin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Firstname=" + firstname + ", Lastname=" + lastname + "]";
	}

}
