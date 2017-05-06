package com.hopital.action;

import java.util.ArrayList;
import java.util.List;


import com.hopital.domain.Patient;
import com.hopital.model.Patientmdl;
import com.hopital.model.Patientmdlimp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PatientAction extends ActionSupport implements ModelDriven<Patient>{


	private static final long serialVersionUID = 1L;
	private Patient Patient  = new Patient();
	private List<Patient> patientList = new ArrayList<Patient>();
	private Patientmdl dao = new Patientmdlimp();
	
	@Override
	public Patient getModel() {
		return Patient;
	}

	public String addPatient()
	{
		dao.addPatient(Patient);
		return "success";
	}

	public String listPatients()
	{
		patientList = dao.getPatients();
		return "success";
	}

	public Patient getPatient() {
		return Patient;
	}

	public void setPatient(Patient Patient) {
		this.Patient = Patient;
	}

	public List<Patient> getPatients() {
		return patientList;
	}

	public void setPatients(List<Patient> Patients) {
		this.patientList = Patients;
	}
	
	public String deletePatient(){

		//Je n'ai pas compris tu fonction customList, donc je n'ai pas fait cette fonction qui l'utilise.
			return NONE;
	}
	

}