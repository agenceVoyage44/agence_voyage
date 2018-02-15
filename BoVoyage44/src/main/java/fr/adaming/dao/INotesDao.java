package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Notes;

/**
 * Interface Notes DAO pour le formulaire de satisfaction
 *
 */

public interface INotesDao {

	/**
	 * Ajouter une ligne de notes
	 * 
	 * 
	 * @return les notes ajoutées
	 */
	public Notes addNotes(Notes n);

	/**
	 * Obtenir la liste de toutes les notes
	 * 
	 * 
	 * @return la liste des notes
	 */
	public List<Notes> getAllNotes();

}
