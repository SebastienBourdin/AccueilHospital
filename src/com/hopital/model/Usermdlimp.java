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
import com.hopital.domain.User;

public class Usermdlimp implements Usermdl {

	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	public List<User> getUsers()
	{
		List<User> Users = new ArrayList<User>();
		try
		{
			Users = session.createQuery("from User").list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Users;
	}

	public void addUser(User user)
	{
		String hql = "INSERT INTO user (firstname, lastname, password, birthdate, type) "  + 
				"VALUES ('"+user.getFirstName()+"', '"+user.getFirstName()+"', '"+user.getPassword()+"', '"+user.getBirthDate()+"', '"+user.getType()+"');";
		try {
			session.createSQLQuery(hql).executeUpdate();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	
	public List<User> listUser() {
		// TODO Auto-generated method stub
		List<User> courses = null;
		try {

			courses = session.createQuery("from user").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}
	@Override
	public List<User> listUser(User user) {
		// TODO Auto-generated method stub
		List<User> courses = null;
		try {

			Query query = session.createQuery("from user where lastname=:nom and (firstname=:firstname OR birthdate=:birthdate)");
			query.setParameter("lastname", user.getLastName());
			query.setParameter("firstname", user.getFirstName());
			query.setParameter("birthdate", user.getBirthDate());
			System.out.println(query.getQueryString());
			courses = query.list();
			
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} 
		return courses;
	}
	public void updateRdv(Rdv rdv) {
		// TODO Auto-generated method stub
		
		String hql = "UPDATE rendezvous SET "  + 
	             " date = '"+rdv.getDate()+"' , idpatient = '"+rdv.getIdpatient()+"' , iduser = '"+rdv.getIduser()+"', heure= '"+rdv.getHeure()+"', duree = '"+rdv.getDuree()+"' WHERE id='"+rdv.getId()+"'";
		
		try {
			session.createSQLQuery(hql).executeUpdate();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
		String hql = "UPDATE rendezvous SET "  + 
	             " firstname = '"+user.getFirstName()+"' , lastname = '"+user.getLastName()+"' , type = '"+user.getType()+"', admin= '"+user.isAdmin()+"', birthdate = '"+user.getBirthDate()+"' WHERE id='"+user.getId()+"'";
		
		try {
			session.createSQLQuery(hql).executeUpdate();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void delete(String user_id) {
		// TODO Auto-generated method stub
		String hql = "DELETE FROM user WHERE id ='"+user_id+"' ";
		
		try {
			session.createSQLQuery(hql).executeUpdate();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}	
	
}