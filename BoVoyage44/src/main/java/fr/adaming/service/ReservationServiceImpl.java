package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IReservationDao;
import fr.adaming.model.Reservation;

@Transactional

public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IReservationDao reservationDao;

	// Injection Dépendance
	public void setReservationDao(IReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	@Override
	public Reservation addReservation(Reservation reservation) {
		return reservationDao.addReservation(reservation);
	}

	@Override
	public Reservation updateReservation(Reservation reservation) {
		return reservationDao.updateReservation(reservation);
	}

	@Override
	public Reservation getReservationByID(int idReservation) {
		return reservationDao.getReservationByID(idReservation);
	}

	@Override
	public int deleteReservation(int idReservation) {
		return reservationDao.deleteReservation(idReservation);
	}

	@Override
	public List<Reservation> getAllReservation() {
		return reservationDao.getAllReservation();
	}

}
