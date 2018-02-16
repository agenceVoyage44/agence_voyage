package fr.adaming.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.lowagie.text.DocumentException;

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
	 * @throws MessagingException 
	 * @throws AddressException 
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public Reservation addReservation(Reservation reservation) throws AddressException, MessagingException, FileNotFoundException, MalformedURLException, IOException;

	
	/**
	 * M�thode pour modifier une reservation
	 * 
	 * @param Reservation
	 * @return Reservation
	 * @throws MessagingException 
	 * @throws AddressException 
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws DocumentException 
	 */
	public Reservation updateReservation(Reservation reservation) throws AddressException, MessagingException, FileNotFoundException, MalformedURLException, IOException, DocumentException;

	
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
