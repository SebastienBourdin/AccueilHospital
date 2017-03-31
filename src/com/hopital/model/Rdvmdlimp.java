package com.hopital.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.hopital.domain.Rdv;

public class Rdvmdlimp implements Rdvmdl{
	@SessionTarget
	Session session;
	@TransactionTarget
	Transaction transaction;
	@Override
	public void saveRdv(Rdv rdv) {
		// TODO Auto-generated method stub
		
		String hql = "INSERT INTO rendezvous (iduser, idpatient, date, heure, duree) "  + 
	             "VALUES ('"+rdv.getIduser()+"', '"+rdv.getIdpatient()+"', '"+rdv.getDate()+"', '"+rdv.getHeure()+"', '"+rdv.getDuree()+"');";
	
		try {
			session.createSQLQuery(hql).executeUpdate();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Rdv> listRdv() {
		// TODO Auto-generated method stub
		List<Rdv> courses = null;
		try {

			courses = session.createQuery("from Rdv").list();
			System.out.println(courses.get(0).toString());
		} catch (Exception e) {
			System.out.println("jjj");
			e.printStackTrace();
		} 
		return courses;
	}

}
