package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Hebergement;

public interface IHebergementService {

	public Hebergement addHebergement(Hebergement hebergement);

	public Hebergement updateHebergement(Hebergement hebergement);

	public Hebergement getHebergementByID(int idHebergement);

	public int deleteHebergement(int idHebergement);

	public List<Hebergement> getAllHebergement();
	
}
