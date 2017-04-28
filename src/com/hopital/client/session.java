package com.hopital.client;


import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class session extends ActionSupport implements SessionAware{
  
  // modèle
  private String nom;
  // session
  private Map<String, Object> session;
  
  // getters et setters

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  @Override
  public void setSession(Map<String, Object> session) {
    this.session=session;
  }
  
  public String sessionstart(){
    // on met le nom dans la session
    session.put("nom",nom);
    // navigation
    return SUCCESS;
  }
  public String sessionstop() {
	    // on récupère le nom dans la session
	    String nom=(String)session.get("nom");
	    // on l'enlève de la session si besoin est
	    if(nom!=null){
	      session.remove("nom");
	    }
	    // navigation
	    return SUCCESS;
	  }
  @Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
}