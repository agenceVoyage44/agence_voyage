package fr.adaming.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

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
	 * @throws MessagingException 
	 * @throws AddressException 
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public Reservation addReservation(Reservation reservation) throws AddressException, MessagingException, FileNotFoundException, MalformedURLException, IOException;

	
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
