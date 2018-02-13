package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Formule;

public interface IFormuleService {
	
	public List<Formule> getAllFormule();
	
	public Formule getFormuleById(int id);
	
	public Formule addFormule(Formule formule);
	
	public Formule updateFormule(Formule formule);
	
	public int deleteFormule(int id);

}
