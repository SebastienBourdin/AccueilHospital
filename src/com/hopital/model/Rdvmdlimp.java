package com.hopital.model;

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
		System.out.println(rdv.toString());
		String hql = "INSERT INTO rendezvous (id_user, id_patient, date, heure, duree) "  + 
	             "VALUES ('"+rdv.getIduser()+"', '"+rdv.getIdpatient()+"', '"+rdv.getDate()+"', '"+rdv.getHeure()+"', '"+rdv.getDuree()+"');";
	
		try {
			System.out.println(rdv.toString());
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
			courses = session.createSQLQuery("SELECT * from rendezvous").list();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return courses;
	}

}
