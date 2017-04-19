package com.hopital.domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


	@Entity
	@Table(name="rendezvous")
	public class Rdv {

		private int id;
		private int iduser;
		private int idpatient;
		private Date date;
		private Time heure;
		private int minute;
		private Long duree;
		private String daterdv;
		private int Hour;
		
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
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		

		@Column(name="duree")
		public Long getDuree() {
			return duree;
		}
		public void setDuree(Long duree) {
			this.duree = duree;
		}
		
		@Column(name="heure")
		public Time getHeure() {
			return heure;
		}
		public void setHeure(Time string) {
			this.heure = string;
		}

		@Transient
		public int getMinute() {
			return minute;
		}
		public void setMinute(int minute) {
			this.minute = minute;
		}
		
		@Transient
		public int getHour() {
			return Hour;
		}
		public void setHour(int hour) {
			this.Hour = hour;
		}
		
		@Transient
		public String getDaterdv() {
			return daterdv;
		}
		public void setDaterdv(String daterdv) {
			this.daterdv = daterdv;
		}
		
		}

