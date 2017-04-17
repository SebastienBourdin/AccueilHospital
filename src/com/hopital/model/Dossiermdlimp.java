package com.hopital.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.hopital.domain.Dossier;

public class Dossiermdlimp implements Dossiermdl {

	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	public List<Dossier> getDossiers()
	{
		List<Dossier> Dossiers = new ArrayList<Dossier>();
		try
		{
			Dossiers = session.createQuery("from Dossier").list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Dossiers;
	}

	public void addDossier(Dossier Dossier)
	{
		String hql = "INSERT INTO Dossier (firstname, lastname, birthdate, genre, historique) "  + 
				"VALUES ('"+Dossier.getFirstName()+"', '"+Dossier.getFirstName()+"', '"+Dossier.getBirthDate()+"', '"+Dossier.getGenre()+"', '"+Dossier.getHistorique()+"');";
		try {
			session.createSQLQuery(hql).executeUpdate();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	
	public List<Dossier> listDossier() {
		// TODO Auto-generated method stub
		List<Dossier> courses = null;
		try {

			courses = session.createQuery("from Dossier").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}
	@Override
	public List<Dossier> listDossier(Dossier Dossier) {
		// TODO Auto-generated method stub
		List<Dossier> courses = null;
		try {

			Query query = session.createQuery("from Dossier where lastname=:nom and (firstname=:firstname OR birthdate=:birthdate)");
			query.setParameter("lastname", Dossier.getLastName());
			query.setParameter("firstname", Dossier.getFirstName());
			query.setParameter("birthdate", Dossier.getBirthDate());
			query.setParameter("genre", Dossier.getGenre());
			System.out.println(query.getQueryString());
			courses = query.list();
			
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} 
		return courses;
	}
	
	@Override
	public void updateDossier(Dossier Dossier) {
		// TODO Auto-generated method stub
		
		String hql = "UPDATE dossier SET "  + 
	             " firstname = '"+Dossier.getFirstName()+"' , lastname = '"+Dossier.getLastName()+"' ,  birthdate = '"+Dossier.getBirthDate()+", genre = '"+Dossier.getGenre()+", historique = '"+Dossier.getHistorique()+"' WHERE id='"+Dossier.getId()+"'";
		try {
			session.createSQLQuery(hql).executeUpdate();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void delete(String dossier_id) {
		// TODO Auto-generated method stub
		String hql = "DELETE FROM dossier WHERE id ='"+dossier_id+"' ";
		
		try {
			session.createSQLQuery(hql).executeUpdate();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}	
	
}