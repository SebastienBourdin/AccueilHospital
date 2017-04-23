package com.hopital.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.hopital.domain.Rdv;
import com.hopital.domain.Patient;

public class Patientmdlimp implements Patientmdl {

	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	public List<Patient> getPatients()
	{
		List<Patient> Patients = new ArrayList<Patient>();
		try
		{
			Patients = session.createQuery("from Patient").list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Patients;
	}

	public void addPatient(Patient Patient)
	{
		String hql = "INSERT INTO Patient (firstname, lastname, birthdate) "  + 
				"VALUES ('"+Patient.getFirstname()+"', '"+Patient.getLastname()+"', '"+Patient.getBirthdate()+"');";
		try {
			session.createSQLQuery(hql).executeUpdate();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	
	public List<Patient> listPatient() {
		// TODO Auto-generated method stub
		List<Patient> courses = null;
		try {

			courses = session.createQuery("from Patient").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}
	@Override
	public List<Patient> listPatient(Patient Patient) {
		// TODO Auto-generated method stub
		List<Patient> courses = null;
		try {

			Query query = session.createQuery("from Patient where lastname=:nom and (firstname=:firstname OR birthdate=:birthdate)");
			query.setParameter("lastname", Patient.getLastname());
			query.setParameter("firstname", Patient.getFirstname());
			query.setParameter("birthdate", Patient.getBirthdate());
			System.out.println(query.getQueryString());
			courses = query.list();
			
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} 
		return courses;
	}
	
	@Override
	public void updatePatient(Patient Patient) {
		// TODO Auto-generated method stub
		
		String hql = "UPDATE patient SET "  + 
	             " firstname = '"+Patient.getFirstname()+"' , lastname = '"+Patient.getLastname()+"' ,  birthdate = '"+Patient.getBirthdate()+"' WHERE id='"+Patient.getId()+"'";
		try {
			session.createSQLQuery(hql).executeUpdate();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void delete(String patient_id) {
		// TODO Auto-generated method stub
		String hql = "DELETE FROM Patient WHERE id ='"+patient_id+"' ";
		
		try {
			session.createSQLQuery(hql).executeUpdate();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}	
	
}