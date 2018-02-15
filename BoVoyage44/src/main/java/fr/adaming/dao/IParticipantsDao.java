package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Participant;

/**
 * Interface Participants DAO
 *
 */
public interface IParticipantsDao {
	/**
	 * Obtenir la liste de tous les participants
	 * 
	 * 
	 * @return la liste des participants
	 */
	public List<Participant> getAllParticipant();

	/**
	 * Obtenir la liste des participants inscrits dans une r�servation
	 * 
	 * @param idRes
	 *            l'id de la r�servation
	 * 
	 * 
	 * @return la liste des participants d'un voyage
	 */
	public List<Participant> getParticipantsByReservation(int idRes);
	// participants par r�servation

	/**
	 * Ajouter un participant
	 * 
	 * @param p
	 *            participant � ajouter
	 * 
	 * 
	 * @return le participant ajout�
	 */
	public Participant addParticipant(Participant p);

	/**
	 * Modifier un participant
	 * 
	 * @param p
	 *            participant � modifier
	 * 
	 * 
	 * @return le participant modifi�
	 */
	public Participant updateParticipant(Participant p);

	/**
	 * supprimer un participant
	 * 
	 * @param id
	 *            id du participant � supprimer
	 * 
	 * 
	 * @return 0 si la suppression a �chou�, 1 si elle a abouti
	 */
	public int deleteParticipant(int id);

	/**
	 * Obtenir un participant avec son id
	 * 
	 * @param id
	 *            id du participant recherch�
	 * 
	 * 
	 * @return le participant recherch�
	 */
	public Participant getParticipantById(int id);
	
	public List<Participant> getAllParticpantIDResaNULL();
	
	public Participant getParticipantIDResaNull();
	
	
}
