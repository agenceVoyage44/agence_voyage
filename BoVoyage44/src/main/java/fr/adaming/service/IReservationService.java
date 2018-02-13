package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Reservation;
/**
 * Interface de définition des méthodes métiers des objets de type Reservation
 *
 */

public interface IReservationService {

	/**
	 * Méthode pour ajouter une reservation
	 * 
	 * @param Reservation
	 * @return Reservation
	 */
	public Reservation addReservation(Reservation reservation);

	
	/**
	 * Méthode pour modifier une reservation
	 * 
	 * @param Reservation
	 * @return Reservation
	 */
	public Reservation updateReservation(Reservation reservation);

	
	/**
	 * Méthode pour rechercher une reservation
	 * 
	 * @param int
	 *            idReservation
	 * @return Reservation
	 */
	public Reservation getReservationByID(int idReservation);

	
	/**
	 * Méthode pour supprimer une reservation
	 * 
	 * @param int
	 *            idReservation
	 * @return Reservation
	 */
	public int deleteReservation(int idReservation);

	
	/**
	 * Méthode pour créer une liste de reservations
	 * 
	 * @return List<Reservation>
	 */
	public List<Reservation> getAllReservation();

}
