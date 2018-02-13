package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Voyage;

/**
 * La classe VoyageDaoImpl implémente l'interface IVoyageDao.
 * @author intiformation
 *
 */
@Repository
public class VoyageDaoImpl implements IVoyageDao {

	@PersistenceContext(name="BoVoyage44")
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/* (non-Javadoc)
	 * @see fr.adaming.dao.IVoyageDao#addVoyage(fr.adaming.model.Voyage)
	 */
	@Override
	public Voyage addVoyage(Voyage v) {
		em.persist(v);
		return v;
	}

	/* (non-Javadoc)
	 * @see fr.adaming.dao.IVoyageDao#getAllVoyage()
	 */
	@Override
	public List<Voyage> getAllVoyage() {
		String req = "SELECT v FROM Voyage v";
		
		Query query = em.createQuery(req);
		
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see fr.adaming.dao.IVoyageDao#updateVoyage(fr.adaming.model.Voyage)
	 */
	@Override
	public Voyage updateVoyage(Voyage v) {
		Voyage vOut = this.getVoyageById(v.getId());
		
		vOut.setContinent(v.getContinent());
		vOut.setPays(v.getPays());
		vOut.setPrixDepart(v.getPrixDepart());
		vOut.setRemise(v.getRemise());
		vOut.setPrixSolde(v.getPrixSolde());
		vOut.setDateDepart(v.getDateDepart());
		vOut.setDateRetour(v.getDateRetour());
		vOut.setPhoto(v.getPhoto());
		vOut.setNbPlaces(v.getNbPlaces());
		vOut.setDispo(v.isDispo());
		vOut.setTitre(v.getTitre());
		vOut.setDescription(v.getDescription());
		vOut.setPriorite(v.isPriorite());
		
		em.merge(vOut);
		
		return vOut;
	}

	/* (non-Javadoc)
	 * @see fr.adaming.dao.IVoyageDao#deleteVoyage(int)
	 */
	@Override
	public int deleteVoyage(int id) {
		String req = "DELETE FROM Voyage v WHERE v.id=:pId";
		
		Query query = em.createQuery(req);
		
		query.setParameter("pId", id);
		
		return query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see fr.adaming.dao.IVoyageDao#getVoyageById(int)
	 */
	@Override
	public Voyage getVoyageById(int id) {
		String req = "SELECT v FROM Voyage v WHERE v.id=:pId";
		
		Query query = em.createQuery(req);
		
		query.setParameter("pId", id);
		
		return (Voyage) query.getSingleResult();
	}

}
