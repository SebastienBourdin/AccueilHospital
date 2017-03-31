package com.hopital.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name="rendezvous")
	public class Rdv {

		private int id;
		private int iduser;
		private int idpatient;
		private String date;
		private String heure;
		private String duree;
		
		@Id
		@GeneratedValue
		@Column(name="id")
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		
		@Column(name="iduser")
		public int getIduser() {
			return iduser;
		}
		public void setIduser(int id) {
			this.iduser = id;
		}
		
		@Column(name="idpatient")
		public int getIdpatient() {
			return idpatient;
		}
		public void setIdpatient(int id) {
			this.idpatient = id;
		}
		@Column(name="date")
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		
		@Column(name="heure")
		public String getHeure() {
			return heure;
		}
		public void setHeure(String heure) {
			this.heure = heure;
		}
		
		@Column(name="duree")
		public String getDuree() {
			return duree;
		}
		public void setDuree(String durée) {
			this.duree = durée;
		}
		@Override
		public String toString() {
			return "Rdv [id_user=" + iduser + ", id_patient=" + idpatient
					+ ", date=" + date + ", heure=" + heure + ", durée="
					+ duree + "]";
		}
		
		}

