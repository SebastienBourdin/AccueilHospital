package com.hopital.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.hopital.domain.Rdv;
import com.hopital.model.Rdvmdl;
import com.hopital.model.Rdvmdlimp;

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

		rdvmdl.saveRdv(rdv); 
		return SUCCESS;
	}
	
	public String list()
	{
		rdvList = rdvmdl.listRdv();


		return SUCCESS;
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
