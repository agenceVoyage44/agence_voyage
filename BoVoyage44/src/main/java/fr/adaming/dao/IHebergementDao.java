package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Hebergement;


public interface IHebergementDao {

	/**
	 * M�thode permettant d'ajouter un Hebergement
	 * @param hebergement
	 * @return retourne un objet de type hebergement
	 */
	public Hebergement addHebergement(Hebergement hebergement);

	
	/**
	 * M�thode permettant de modifier un hebergement
	 * @param hebergement
	 * @return retourne un objet hebergement mis � jour
	 */
	public Hebergement updateHebergement(Hebergement hebergement);

	
	/**
	 * M�thode permettant de rechercher un hebergement pr son id
	 * @param idHebergement
	 * @return l'hebergement recherch� par son id
	 */
	public Hebergement getHebergementByID(int idHebergement);

	
	/**
	 * M�thode permettant de supprimer un hebergement
	 * @param idHebergement
	 * @return 0 si la suppression a �chou�, 1 si cette derni�re est r�ussi
	 */
	public int deleteHebergement(int idHebergement);

	
	/**
	 * M�thode pour r�cup�rer toutes les hebergements
	 * @return retourne une liste des hebergements
	 */
	public List<Hebergement> getAllHebergement();
}
