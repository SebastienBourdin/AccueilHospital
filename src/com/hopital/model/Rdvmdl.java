package com.hopital.model;

import java.util.List;

import com.hopital.domain.Rdv;


public interface Rdvmdl {
	public void saveRdv(Rdv rdv);
	public List<Rdv> listRdv();
	public List<Rdv> listRdv(Rdv rd);
	List<Rdv> listCustom(Rdv rd);
	public void updateRdv(Rdv rdv);
}
