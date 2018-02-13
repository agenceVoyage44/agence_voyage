package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Voiture;

public interface IVoitureDao {

	/**
	 * Ajoute une voiture � la base de donn�e.
	 * 
	 * @param v
	 *            Il s'agit de la voiture � ajouter.
	 * @return Retourne la voiture ajout�e avec sont id.
	 */
	public Voiture addVoiture(Voiture v);

	/**
	 * R�cup�re toutes les voitures disponible dans la base de donn�e.
	 * 
	 * @return Retourne la liste des voitures.
	 */
	public List<Voiture> getAllVoiture();

	/**
	 * Supprime une voiture � partir de son id.
	 * 
	 * @param id
	 *            Il s'agit de l'id de la voiture � supprimer.
	 * @return Retourne 0 si la suppression a �chou�, et 1 si la suppression de
	 *         la voiture a r�ussi.
	 */
	public int deleteVoiture(int id);

	/**
	 * R�cup�re une voiture � partir de son id.
	 * 
	 * @param id
	 *            Il s'agit de l'id de la voiture � r�cup�rer.
	 * @return Retourne la voiture trouv�e dans la base de donn�e.
	 */
	public Voiture getVoitureById(int id);

	/**
	 * Met � jour les valeurs des attributs d'une voiture.
	 * 
	 * @param v
	 *            Il s'agit de la voiture � mettre � jour.
	 * @return Retourne la voiture mise � jour.
	 */
	public Voiture updateVoiture(Voiture v);

}
