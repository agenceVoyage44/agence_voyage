package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Voiture;

public interface IVoitureDao {

	/**
	 * Ajoute une voiture à la base de donnée.
	 * 
	 * @param v
	 *            Il s'agit de la voiture à ajouter.
	 * @return Retourne la voiture ajoutée avec sont id.
	 */
	public Voiture addVoiture(Voiture v);

	/**
	 * Récupère toutes les voitures disponible dans la base de donnée.
	 * 
	 * @return Retourne la liste des voitures.
	 */
	public List<Voiture> getAllVoiture();

	/**
	 * Supprime une voiture à partir de son id.
	 * 
	 * @param id
	 *            Il s'agit de l'id de la voiture à supprimer.
	 * @return Retourne 0 si la suppression a échoué, et 1 si la suppression de
	 *         la voiture a réussi.
	 */
	public int deleteVoiture(int id);

	/**
	 * Récupère une voiture à partir de son id.
	 * 
	 * @param id
	 *            Il s'agit de l'id de la voiture à récupérer.
	 * @return Retourne la voiture trouvée dans la base de donnée.
	 */
	public Voiture getVoitureById(int id);

	/**
	 * Met à jour les valeurs des attributs d'une voiture.
	 * 
	 * @param v
	 *            Il s'agit de la voiture à mettre à jour.
	 * @return Retourne la voiture mise à jour.
	 */
	public Voiture updateVoiture(Voiture v);

}
