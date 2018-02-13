package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Participant;

/**
 * méthodes concernant les Participants, implémente l'Interface Participants DAO
 *
 */
@Repository
public class ParticipantDaoImpl implements IParticipantsDao {

	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Participant> getAllParticipant() {
		String req = "from Participant p";

		Query query = em.createQuery(req);

		@SuppressWarnings("unchecked")
		List<Participant> listeP = query.getResultList();
		return listeP;
	}

	@Override
	public List<Participant> getParticipantsByReservation(int idRes) {
		String req = "select p from Participant as p where p.reservation.id=:pId ";
		Query query = em.createQuery(req);

		query.setParameter("pId", idRes);

		@SuppressWarnings("unchecked")
		List<Participant> listeP = query.getResultList();

		return listeP;
	}

	@Override
	public Participant addParticipant(Participant p) {
		em.persist(p);
		return p;
	}

	@Override
	public Participant updateParticipant(Participant p) {
		em.merge(p);
		return p;
	}

	@Override
	public int deleteParticipant(int id) {

		String req = "delete from Participant as p where p.id =:pId";

		Query query = em.createQuery(req);

		query.setParameter("pId", id);

		return query.executeUpdate();
	}

	@Override
	public Participant getParticipantById(int id) {
		Participant pOut = em.find(Participant.class, id);
		return pOut;
	}

}
