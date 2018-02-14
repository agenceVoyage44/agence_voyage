package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Formule;
import fr.adaming.model.Voiture;

/**
 * Classe qui implémente l'interface IVoitureDao contenant les méthodes CRUD des
 * objets Voiture.
 * 
 * @author Alexy
 *
 */
@Repository
public class VoitureDaoImpl implements IVoitureDao {

	@PersistenceContext(unitName = "BoVoyage44")
	private EntityManager em;

	// Injection Dépendance
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Voiture addVoiture(Voiture v) {
		em.persist(v);
		return v;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> getAllVoiture() {
		// Construire la requête
		String req = "FROM Voiture";

		// Création de query
		Query query = em.createQuery(req);

		// Envoyé et récupérer
		return query.getResultList();
	}

	@Override
	public int deleteVoiture(int id) {
		// Construire la requête en JPQL
		String req = "DELETE FROM Voiture as v WHERE v.id=:pId";

		Query query = em.createQuery(req);

		// Passage des paramètres
		query.setParameter("pId", id);

		int verif = query.executeUpdate();

		return verif;
	}

	@Override
	public Voiture getVoitureById(int id) {
		// Construire la requête en JPQL
		String req = "SELECT v FROM Voiture as v WHERE v.id=:pId";

		Query query = em.createQuery(req);

		// Passage des paramètres
		query.setParameter("pId", id);

		try {
			Voiture vIn = (Voiture) query.getSingleResult();
			return vIn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Voiture updateVoiture(Voiture v) {
		// Récupérer la voiture
		Voiture vOut = em.find(Voiture.class, v.getId());

		// Passer les nouveaux paramètres
		vOut.setLoueur(v.getLoueur());
		vOut.setModele(v.getModele());
		vOut.setNbPlaces(v.getNbPlaces());
		vOut.setPhoto(v.getPhoto());

		// Mettre à jour la voiture
		em.merge(vOut);
		return v;
	}

}
