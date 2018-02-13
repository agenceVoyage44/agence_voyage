package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IReservationDao;
import fr.adaming.model.Reservation;

/**
 * Classe de d�finition des m�thodes m�tiers des objets de type Reservation
 *
 */

@Transactional
@Service
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IReservationDao reservationDao;

	// Injection D�pendance
	public void setReservationDao(IReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	/**
	 * M�thode pour ajouter une reservation
	 * 
	 * @param Reservation
	 * @return Reservation
	 */
	@Override
	public Reservation addReservation(Reservation reservation) {
		return reservationDao.addReservation(reservation);
	}

	/**
	 * M�thode pour modifier une reservation
	 * 
	 * @param Reservation
	 * @return Reservation
	 */
	@Override
	public Reservation updateReservation(Reservation reservation) {
		return reservationDao.updateReservation(reservation);
	}

	/**
	 * M�thode pour rechercher une reservation
	 * 
	 * @param int
	 *            idReservation
	 * @return Reservation
	 */
	@Override
	public Reservation getReservationByID(int idReservation) {
		return reservationDao.getReservationByID(idReservation);
	}

	/**
	 * M�thode pour supprimer une reservation
	 * 
	 * @param int
	 *            idReservation
	 * @return Reservation
	 */
	@Override
	public int deleteReservation(int idReservation) {
		return reservationDao.deleteReservation(idReservation);
	}

	/**
	 * M�thode pour cr�er une liste de reservations
	 * 
	 * @return List<Reservation>
	 */
	@Override
	public List<Reservation> getAllReservation() {
		return reservationDao.getAllReservation();
	}

}
