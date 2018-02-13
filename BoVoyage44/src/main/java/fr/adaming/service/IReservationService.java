package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Reservation;

public interface IReservationService {

	public Reservation addReservation(Reservation reservation);

	public Reservation updateReservation(Reservation reservation);

	public Reservation getReservationByID(int idReservation);

	public int deleteReservation(int idReservation);

	public List<Reservation> getAllReservation();

}
