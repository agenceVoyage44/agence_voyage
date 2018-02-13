package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Reservation;

public interface IReservationDao {

	public Reservation addReservation(Reservation reservation);

	public Reservation updateReservation(Reservation reservation);

	public Reservation getReservationByID(int idReservation);

	public int deleteReservation(int idReservation);

	public List<Reservation> getAllReservation();

}
