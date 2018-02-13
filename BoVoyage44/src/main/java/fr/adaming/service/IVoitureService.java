package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Voiture;

public interface IVoitureService {

	public Voiture addVoiture(Voiture v);

	public List<Voiture> getAllVoiture();

	public int deleteVoiture(int id);

	public Voiture getVoitureById(int id);

	public Voiture updateVoiture(Voiture v);
}
