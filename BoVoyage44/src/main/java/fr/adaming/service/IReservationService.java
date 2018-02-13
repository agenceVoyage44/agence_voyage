package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Reservation;
/**
 * Interface de d�finition des m�thodes m�tiers des objets de type Reservation
 *
 */

public interface IReservationService {

	/**
	 * M�thode pour ajouter une reservation
	 * 
	 * @param Reservation
	 * @return Reservation
	 */
	public Reservation addReservation(Reservation reservation);

	
	/**
	 * M�thode pour modifier une reservation
	 * 
	 * @param Reservation
	 * @return Reservation
	 */
	public Reservation updateReservation(Reservation reservation);

	
	/**
	 * M�thode pour rechercher une reservation
	 * 
	 * @param int
	 *            idReservation
	 * @return Reservation
	 */
	public Reservation getReservationByID(int idReservation);

	
	/**
	 * M�thode pour supprimer une reservation
	 * 
	 * @param int
	 *            idReservation
	 * @return Reservation
	 */
	public int deleteReservation(int idReservation);

	
	/**
	 * M�thode pour cr�er une liste de reservations
	 * 
	 * @return List<Reservation>
	 */
	public List<Reservation> getAllReservation();

}
