package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Reservation;

/**
 * Classe de défintion des méthodes, des objets de type Reservation en utilisant des reqûetes communiquant
 * directment avec la base de données
 *
 */

@Repository
public class ReservationDaoImpl implements IReservationDao {

	@PersistenceContext(unitName="BoVoyage44")
	private EntityManager em;

	// injectons Dépendances
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Reservation addReservation(Reservation reservation) {

		em.persist(reservation);

		return reservation;
	}



	@Override
	public Reservation updateReservation(Reservation reservation) {

		em.merge(reservation);

		return reservation;
	}

	@Override
	public Reservation getReservationByID(int idReservation) {

		Reservation rOut = em.find(Reservation.class, idReservation);

		return rOut;

	}


	@Override
	public int deleteReservation(int idReservation) {

		String req = "DELETE FROM Reservation AS r WHERE r.id=:pId";

		Query query = em.createQuery(req);

		query.setParameter("pId", idReservation);

		return query.executeUpdate();
	}

	@Override
	public List<Reservation> getAllReservation() {
		String req = "SELECT r FROM Reservation AS r";

		Query query = em.createQuery(req);

		return query.getResultList();
	}

}
