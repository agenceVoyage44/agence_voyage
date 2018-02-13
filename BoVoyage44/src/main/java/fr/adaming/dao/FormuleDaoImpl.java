package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Formule;

@Repository
public class FormuleDaoImpl implements IFormuleDao {

	// Injection de l'entity manager
	@PersistenceContext(unitName = "BoVoyage44")
	private EntityManager em;

	// Setter pour l'injection d�pendance
	public void setEm(EntityManager em) {
		this.em = em;
	}

	// METHODES CRUD

	@Override
	public List<Formule> getAllFormule() {

		// Requete HQL
		String req = "FROM Formule";

		// Query
		Query query = em.createQuery(req);

		return query.getResultList();
	}

	@Override
	public Formule getFormuleById(int id) {

		// Requete HQL
		String req = "FROM Formule f WHERE f.id=:pId";

		// Query
		Query query = em.createQuery(req);

		// Param�tres de la requete
		query.setParameter("pId", id);

		return (Formule) query.getSingleResult();
	}

	@Override
	public Formule addFormule(Formule formule) {

		// Ajouter la formule (sans id)
		em.persist(formule);

		return formule;
	}

	@Override
	public Formule updateFormule(Formule formule) {

		// R�cup�rer la formule
		Formule fOut = em.find(Formule.class, formule.getId());

		// Passer les nouveaux param�tres
		fOut.setType(formule.getType());
		fOut.setPrix(formule.getPrix());

		// Mettre � jour la formule
		em.merge(fOut);

		return fOut;
	}

	@Override
	public int deleteFormule(int id) {

		// R�cup�rer la formule
		Formule fOut = em.find(Formule.class, id);
		
		// Supprimer la formule trouv�e
		em.remove(fOut);

		return 1;
	}

}
