package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Formule;
import fr.adaming.model.Voiture;

/**
 * Classe qui impl�mente l'interface IVoitureDao contenant les m�thodes CRUD des
 * objets Voiture.
 * 
 * @author Alexy
 *
 */
@Repository
public class VoitureDaoImpl implements IVoitureDao {

	@PersistenceContext(unitName = "BoVoyage44")
	private EntityManager em;

	// Injection D�pendance
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
		// Construire la requ�te
		String req = "FROM Voiture";

		// Cr�ation de query
		Query query = em.createQuery(req);

		// Envoy� et r�cup�rer
		return query.getResultList();
	}

	@Override
	public int deleteVoiture(int id) {
		// Construire la requ�te en JPQL
		String req = "DELETE FROM Voiture as v WHERE v.id=:pId";

		Query query = em.createQuery(req);

		// Passage des param�tres
		query.setParameter("pId", id);

		int verif = query.executeUpdate();

		return verif;
	}

	@Override
	public Voiture getVoitureById(int id) {
		// Construire la requ�te en JPQL
		String req = "SELECT v FROM Voiture as v WHERE v.id=:pId";

		Query query = em.createQuery(req);

		// Passage des param�tres
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
		// R�cup�rer la voiture
		Voiture vOut = em.find(Voiture.class, v.getId());

		// Passer les nouveaux param�tres
		vOut.setLoueur(v.getLoueur());
		vOut.setModele(v.getModele());
		vOut.setNbPlaces(v.getNbPlaces());
		vOut.setPhoto(v.getPhoto());

		// Mettre � jour la voiture
		em.merge(vOut);
		return v;
	}

}
