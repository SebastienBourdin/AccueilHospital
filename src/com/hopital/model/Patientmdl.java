package com.hopital.model;

import java.util.List;

import com.hopital.domain.Patient;

public interface Patientmdl {
   public List<Patient> getPatients();
   public void addPatient(Patient patient);
   public List<Patient> listPatient(Patient patient);
   public void delete(String patient_id);
   public void updatePatient(Patient patient);
}