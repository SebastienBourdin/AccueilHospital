package com.hopital.model;

import java.util.List;

import com.hopital.domain.Dossier;

public interface Dossiermdl {
   public List<Dossier> getDossiers();
   public void addDossier(Dossier dossier);
   public List<Dossier> listDossier(Dossier dossier);
   public void delete(String dossier_id);
   public void updateDossier(Dossier dossier);
}