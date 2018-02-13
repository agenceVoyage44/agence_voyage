package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Hebergement;


public interface IHebergementDao {

	/**
	 * Méthode permettant d'ajouter un Hebergement
	 * @param hebergement
	 * @return retourne un objet de type hebergement
	 */
	public Hebergement addHebergement(Hebergement hebergement);

	
	/**
	 * Méthode permettant de modifier un hebergement
	 * @param hebergement
	 * @return retourne un objet hebergement mis à jour
	 */
	public Hebergement updateHebergement(Hebergement hebergement);

	
	/**
	 * Méthode permettant de rechercher un hebergement pr son id
	 * @param idHebergement
	 * @return l'hebergement recherché par son id
	 */
	public Hebergement getHebergementByID(int idHebergement);

	
	/**
	 * Méthode permettant de supprimer un hebergement
	 * @param idHebergement
	 * @return 0 si la suppression a échoué, 1 si cette dernière est réussi
	 */
	public int deleteHebergement(int idHebergement);

	
	/**
	 * Méthode pour récupérer toutes les hebergements
	 * @return retourne une liste des hebergements
	 */
	public List<Hebergement> getAllHebergement();
}
