package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Hebergement;

@Repository
public class HebergementDaoImpl implements IHebergementDao {

	
	@PersistenceContext(unitName = "BoVoyage44")
	private EntityManager em;

	// injectons Dépendances
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Hebergement addHebergement(Hebergement hebergement) {
		em.persist(hebergement);
		return hebergement;
	}

	@Override
	public Hebergement updateHebergement(Hebergement hebergement) {
		Hebergement hOut=em.find(Hebergement.class, hebergement.getId());
		
		hOut.setPrix(hebergement.getPrix());
		hOut.setType(hebergement.getType());
		hOut.setFormule(hebergement.getFormule());
		
		em.merge(hOut);
		return hOut;
	}

	@Override
	public Hebergement getHebergementByID(int idHebergement) {
		// creation d'une requete 
		String req = "SELECT h FROM Hebergement as h WHERE h.id=:pIdHeberg";
		// creation query
		Query query = em.createQuery(req);
		// assignation des param de la requete
		query.setParameter("pIdHeberg", idHebergement);
		
try{
		// envoyer requete et recup resultat
		Hebergement hFind = (Hebergement) query.getSingleResult();
		return hFind;
		}
catch(Exception e){
	e.printStackTrace();
}
return null;
	}

	@Override
	public int deleteHebergement(int idHebergement) {
		String req = "DELETE FROM Hebergement AS h WHERE h.id=:pId";

		Query query = em.createQuery(req);

		query.setParameter("pId", idHebergement);

		return query.executeUpdate();
	}

	
	@Override
	public List<Hebergement> getAllHebergement() {
		// construire la requete 
				String req = "FROM Hebergement";

				// creer la query
				Query query = em.createQuery(req);

				//recup resultat

				
				return query.getResultList();
			}

}
