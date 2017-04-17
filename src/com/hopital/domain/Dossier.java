package com.hopital.domain;

import java.lang.String;
import java.sql.Date;
import javax.persistence.*;


@Entity
@Table(name="Dossier")
public class Dossier {

	private int id;
	private String firstname;
	private String lastname;
	private Date birthdate;
	private String genre;
	//Pour l'historique, je pense faire un champ text auquel on ajoute une ligne pour chaque rdv avec la date et un commentaire du medecin
	private String historique;

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
		return "Dossier [id=" + id + ", Firstname=" + firstname + ", Lastname=" + lastname + "]";
	}
	@Column(name="genre")
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Column(name="historique")
	public String getHistorique() {
		return historique;
	}
	public void setHistorique(String historique) {
		this.historique = historique;
	}


}
