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
		List<User> Users = null;
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
		String hql = "INSERT INTO user (firstname, lastname, password, birthdate, type,admin) "  + 
				"VALUES ('"+user.getFirstname()+"', '"+user.getLastname()+"', '"+user.getPassword()+"', '"+user.getBirthdate()+"', '"+user.getType()+"', '0');";
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
			query.setParameter("lastname", user.getLastname());
			query.setParameter("firstname", user.getFirstname());
			query.setParameter("birthdate", user.getBirthdate());
			System.out.println(query.getQueryString());
			courses = query.list();
			
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} 
		return courses;
	}
	
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
		String hql = "UPDATE user SET "  + 
	             " firstname = '"+user.getFirstname()+"' , lastname = '"+user.getLastname()+"' , type = '"+user.getType()+"', admin= '"+user.isAdmin()+"', birthdate = '"+user.getBirthdate()+"' WHERE id='"+user.getId()+"'";
		
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