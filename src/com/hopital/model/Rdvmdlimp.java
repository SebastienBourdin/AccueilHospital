package com.hopital.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return courses;
	}
	@Override
	public List<Rdv> listRdv(Rdv rd) {
		// TODO Auto-generated method stub
		List<Rdv> courses = null;
		try {

			Query query = session.createQuery("from Rdv where date=:date and (idpatient=:idpatient OR iduser=:iduser)");
			query.setParameter("date", rd.getDate());
			query.setParameter("idpatient", rd.getIdpatient());
			query.setParameter("iduser", rd.getIduser());
			System.out.println(query.getQueryString());
			courses = query.list();
			
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} 
		return courses;
	}
	@Override
	public List<Rdv> listCustom(Rdv rdv) {
		// TODO Auto-generated method stub
		List<Rdv> courses = null;
		ArrayList<String> rq=new ArrayList<String>();
		String sql="from Rdv";
		System.out.println(rdv.toString());
		try {
			
			if(rdv.getDate()!=null){
				rq.add(" date="+rdv.getDate().toString()+" ");
			
			}
			if(rdv.getHeure()!=null){
				rq.add(" heure="+rdv.getHeure().toString()+" ");
			}
			if(rdv.getDuree()!=null){
				rq.add(" duree="+rdv.getDuree()+" ");
			}
			if(rdv.getIdpatient()!=0){
				rq.add(" idpatient="+rdv.getIdpatient()+" ");
			}
			if(rdv.getIduser()!=0){
				rq.add(" iduser="+rdv.getIduser()+" ");
			}
			if(!rq.isEmpty()){
				 sql+=" where ";
			}
			for (int i = 0; i < rq.size(); i++) {
				sql+=rq.get(i);
				if(i!=rq.size()-1){
					sql+=" AND ";
				}
			}
			Query query = session.createQuery(sql);
//			if(rdv.getDate()!=null){
//			query.setParameter("date", rdv.getDate().toString());
//			}
//			
//			if(rdv.getHeure()!=null){
//				query.setParameter("heure", rdv.getHeure().toString());
//			}
//			if(rdv.getDuree()!=null){
//				query.setParameter("duree", rdv.getDuree().toString());
//			}
//			if(rdv.getIdpatient()!=0){
//				query.setParameter("idpatient", rdv.getIdpatient());
//			}
//			if(rdv.getIduser()!=0){
//				query.setParameter("iduser", rdv.getIduser());
//			}
//			
			courses = query.list();
			
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} 
		return courses;
	}

}
