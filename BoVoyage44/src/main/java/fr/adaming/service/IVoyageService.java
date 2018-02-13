package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Voyage;

/**
 * L'interface IVoyageService r�f�rence les m�thodes du pack Service de la classe Voyage.
 * @author Jean Michel apeupr�
 *
 */
public interface IVoyageService {

	public Voyage addVoyage(Voyage v);

	public List<Voyage> getAllVoyage();

	public Voyage updateVoyage(Voyage v);

	public int deleteVoyage(int id);

	public Voyage getVoyageById(int id);
}
