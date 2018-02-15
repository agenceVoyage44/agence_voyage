package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Participant;

/**
 * méthodes concernant les clients, implémente l'Interface Client DAO
 *
 */

@Repository
public class ClientDaoImpl implements IClientDao {

	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Client> getAllClient() {
		String req = "from Client c";

		Query query = em.createQuery(req);

		@SuppressWarnings("unchecked")
		List<Client> listeC = query.getResultList();
		return listeC;

	}

	@Override
	public Client getClientByReservation(int idRes) {
		String req = "select c from Client as c where c.reservation.id=:pId ";
		Query query = em.createQuery(req);

		query.setParameter("pId", idRes);

		Client cOut = (Client) query.getSingleResult();

		return cOut;

	}

	@Override
	public Client addClient(Client c) {
		em.persist(c);
		return c;
	}

	@Override
	public Client updateClient(Client c) {
		em.merge(c);
		return c;
	}

	@Override
	public int deleteClient(int id) {
		String req = "delete from Client as c where c.id =:pId";

		Query query = em.createQuery(req);

		query.setParameter("pId", id);

		return query.executeUpdate();
	}

	@Override
	public Client getClientById(int id) {
		Client cOut = em.find(Client.class, id);
		return cOut;
	}

	@Override
	public Client isExistClient(String mail, String mdp) {
		String req = "select c from Client as c where c.mail=:pMail and c.mdp=:pMdp ";
		Query query = em.createQuery(req);

		query.setParameter("pMail", mail);
		query.setParameter("pMdp", mdp);

		Client cOut = (Client) query.getSingleResult();

		return cOut;
	}

	@Override
	public Client getClientByMail(String mail) {
		String req = "select c from Client as c where c.mail=:pMail";
		Query query = em.createQuery(req);

		query.setParameter("pMail", mail);

		Client cOut = (Client) query.getSingleResult();

		return cOut;

	}

	//Pour ne selectionner que les particpants, qui n'ont pas de mail
	@Override
	public List<Client> getAllClientByReservation(int idResa) {
		String req = "SELECT c FROM Client AS c WHERE c.reservation.id=:pID AND c.mail IS NULL";
		Query query = em.createQuery(req);
		
		query.setParameter("pID", idResa);

		@SuppressWarnings("unchecked")
		List<Client> listeP = query.getResultList();

		return listeP;
	}

}
