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
	 * Obtenir la liste des participants inscrits dans une réservation
	 * 
	 * @param idRes
	 *            l'id de la réservation
	 * 
	 * 
	 * @return la liste des participants d'un voyage
	 */
	public List<Participant> getParticipantsByReservation(int idRes);
	// participants par réservation

	/**
	 * Ajouter un participant
	 * 
	 * @param p
	 *            participant à ajouter
	 * 
	 * 
	 * @return le participant ajouté
	 */
	public Participant addParticipant(Participant p);

	/**
	 * Modifier un participant
	 * 
	 * @param p
	 *            participant à modifier
	 * 
	 * 
	 * @return le participant modifié
	 */
	public Participant updateParticipant(Participant p);

	/**
	 * supprimer un participant
	 * 
	 * @param id
	 *            id du participant à supprimer
	 * 
	 * 
	 * @return 0 si la suppression a échoué, 1 si elle a abouti
	 */
	public int deleteParticipant(int id);

	/**
	 * Obtenir un participant avec son id
	 * 
	 * @param id
	 *            id du participant recherché
	 * 
	 * 
	 * @return le participant recherché
	 */
	public Participant getParticipantById(int id);
	
	public List<Participant> getAllParticpantIDResaNULL();
	
	public Participant getParticipantIDResaNull();
	
	
}
