package com.hopital.action;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.hopital.domain.Rdv;
import com.hopital.model.Rdvmdl;
import com.hopital.model.Rdvmdlimp;
import com.hopital.utility.*;

public class RdvAction extends ActionSupport  implements ModelDriven<Rdv> {
	private HttpServletRequest request = null;
	private static final long serialVersionUID = 1L;
	private Rdv rdv = new Rdv();
	private List<Rdv> rdvList = new ArrayList<Rdv>();
	private HashMap<String,String> valid = new HashMap<String,String>();
	private Rdvmdl rdvmdl = new Rdvmdlimp();
	private String viduser;
	private String vidpatient;
	private String vdate;
	private String vheure;
	private String vduree;
	
	
	
	
	public Rdv getModel() {
		return rdv;
	}
	
	public String add()
	{	
		if(this.valid()==INPUT){
			return INPUT;
		}
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
		if(rdv.getHour()!=00){
			rdv.setHeure(new Time(rdv.getHour(),rdv.getMinute(), 0));
		}
		 
		if(!rdv.getDaterdv().isEmpty()){
		rdv.setDate(DateUtil.getDate(rdv.getDaterdv()));
			
		}
	System.out.println(rdv.getHeure());
		rdvList = rdvmdl.listCustom(rdv);
		return SUCCESS;

	}
	public String set()
	{	
		
		if(this.valid()==INPUT){
			return INPUT;
		}
		rdv.setHeure(new Time(rdv.getHour(),rdv.getMinute(), 0));
		
		rdv.setDate(DateUtil.getDate(rdv.getDaterdv()));
		 
		if(check(rdv)){
		rdvmdl.updateRdv(rdv); 
		return SUCCESS;
			}
		else{
		return NONE;
		}
	}
	public String listset(){
		String get = ServletActionContext.getRequest().getParameter("id");
		Rdv rd=new Rdv();
		rd.setId(Integer.parseInt(get));
		System.out.println(rd.toString());
		rdvList = rdvmdl.listCustom(rd);
		System.out.println(rdvList.size());
		return SUCCESS;
		
	}
	public String delete(){
		String get = ServletActionContext.getRequest().getParameter("id");
		Rdv rd=new Rdv();
		rd.setId(Integer.parseInt(get));
		rdvList = rdvmdl.listCustom(rd);
if(!rdvList.isEmpty()){
	rdvmdl.delete(get);
	return SUCCESS;
}
else{
	return NONE;
}
	}
	
	public boolean check(Rdv rdv){
		boolean bool=true;
		List<Rdv> rdvlist=this.listcheck(rdv);
		for (Rdv rdvv : rdvlist) {
			if(rdvv.getId()!=rdv.getId()){
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
					else{
						bool=true;
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
	

	public HashMap getvalid() {
		return valid;
	}

	public void setRdvList(List<Rdv> rdvList) {
		this.rdvList = rdvList;
	}

	
public String getviduser() {
		return viduser;
	}

	public String getvidpatient() {
		return vidpatient;
	}

	public String getvdate() {
		return vdate;
	}

	public String getvheure() {
		return vheure;
	}

	public void setvduree(String vduree) {
		this.vduree = vduree;
	}

public String valid() {
	// TODO Auto-generated method stub
	boolean bool=false;
	if(rdv.getIduser()==0){
           viduser="Id user requis";
           bool=true;
	}
	if(rdv.getIdpatient()==0){
        vidpatient="Id patient requis";
        bool=true;
	}
	if(DateUtil.isValidDate(DateUtil.getDate(rdv.getDaterdv()).toString())==false || rdv.getDaterdv().equals("")){
        vdate="format date incorrect ou vide";
        bool=true;
	}
	if(rdv.getDuree()==0){
        vduree="Durée requis";
        bool=true;
	}
	if(rdv.getHour()==0){
        vheure="Heure requis";
        bool=true;
	}
	if(bool){
		return INPUT;
	}else{
return SUCCESS;			
	}
	}
	
}
