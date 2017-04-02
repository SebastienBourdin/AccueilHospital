package com.hopital.action;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.hopital.domain.Rdv;
import com.hopital.model.Rdvmdl;
import com.hopital.model.Rdvmdlimp;
import com.hopital.utility.*;

public class RdvAction extends ActionSupport  implements ModelDriven<Rdv> {

	private static final long serialVersionUID = 1L;
	private Rdv rdv = new Rdv();
	private List<Rdv> rdvList = new ArrayList<Rdv>();
	private Rdvmdl rdvmdl = new Rdvmdlimp();
	
	public Rdv getModel() {
		return rdv;
	}
	
	public String add()
	{	
		rdv.setHeure(new Time(rdv.getHour(),rdv.getMinute(), 0));
		rdv.setDate(DateUtil.getDate(rdv.getDaterdv()));
		 
		if(check(rdv)){
		rdvmdl.saveRdv(rdv); 
		return SUCCESS;
			}
		else{
		return NONE;
		}
	}
	public String get()
	{	
		if(rdv.getHour()!=00 && rdv.getMinute()!=00){
			rdv.setHeure(new Time(rdv.getHour(),rdv.getMinute(), 0));
		}
		
		System.out.println(rdv.getDaterdv());
		
		 
		if(!rdv.getDaterdv().isEmpty()){
		rdv.setDate(DateUtil.getDate(rdv.getDaterdv()));
			
		}
	
		rdvList = rdvmdl.listCustom(rdv);
		
		return SUCCESS;

	}
	
	
	public boolean check(Rdv rdv){
		boolean bool=true;
		List<Rdv> rdvlist=this.listcheck(rdv);
		for (Rdv rdvv : rdvlist) {
					if(rdvv.getHeure().after((rdv.getHeure()))){
						long diff=rdvv.getHeure().getTime()-rdv.getHeure().getTime();
						diff=Math.abs(diff)/60000;
						if(diff>=rdv.getDuree()){// 
							bool=true;
						}
						else{
							bool=false;
							break;
						}
					}
					else if(rdvv.getHeure().before((rdv.getHeure()))){
						long diff=rdvv.getHeure().getTime()-rdv.getHeure().getTime();
						diff=Math.abs(diff)/60000;
						if(diff>=rdvv.getDuree()){// 
							bool=true;
						}
						else{
							bool=false;
							break;
						}
					}
					else{
						bool=false;
						break;
					}
			
		}
			
		return bool;
	}
	public String list()
	{
		rdvList = rdvmdl.listRdv();
		
		return SUCCESS;
	}
		
	public List<Rdv> listcheck(Rdv rdv)
	{
		
		return  rdvmdl.listRdv(rdv);
	}
	
	public Rdv getRdv() {
		return rdv;
	}

	public void setRdv(Rdv rdv) {
		this.rdv = rdv;
	}

	public List<Rdv> getRdvList() {
		return rdvList;
	}

	public void setRdvList(List<Rdv> rdvList) {
		this.rdvList = rdvList;
	}

}
