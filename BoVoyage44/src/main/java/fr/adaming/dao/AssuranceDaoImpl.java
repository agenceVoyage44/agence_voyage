package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Assurance;
/**
 * Classe Assurance Dao implementé par l'interface IAssuranceDao
 * @author Adaming
 *
 */
@Repository
public class AssuranceDaoImpl implements IAssuranceDao{
	
	//injection d'un entityManager
		@PersistenceContext(unitName="BoVoyage44")
		private EntityManager em;
	
	
	public EntityManager getEm() {
			return em;
		}

		public void setEm(EntityManager em) {
			this.em = em;
		}
		
	/**
	 * Methode Ajouter Assurance 
	 * 
	 */
	public Assurance addAssurance(Assurance assurance) {
		em.persist(assurance);		
		
		return assurance;
	}

	/**
	 * Methode Afficher la liste des Assurances 
	 * 
	 */
	public List<Assurance> getAllAssurance() {
		//requete JPQL
		String req="SELECT a FROM Assurance as a";
		//creer query
		Query query=em.createQuery(req);
		
		List<Assurance> liste=query.getResultList();
		return liste;
	}

	/**
	 * Methode Supprimer Assurance 
	 * 
	 */
	public int deleteAssurance(int id) {
		// requete
		String req="DELETE FROM Assurance as a WHERE a.id=:pId";
		//creer query
		Query query=em.createQuery(req);
		
		//passage des param
		query.setParameter("pId", id);
		int verif=query.executeUpdate();
		return verif;
	}

	/**
	 * Methode Afficher une Assurance via son id
	 * 
	 *
	 */
	public Assurance getAssuranceById(int id) {
		// requete
		String req="SELECT a FROM Assurance as a WHERE a.id=:pId";
		
		//creer query
		Query query=em.createQuery(req);
				
		//passage des param
		query.setParameter("pId", id);
		
		//resulat
		Assurance a=(Assurance) query.getSingleResult();
		
		return a;
	}

	/**
	 * Methode Modifier Assurance 
	 * 
	 * 
	 */
	public Assurance updateAssurance(Assurance assurance) {
		em.merge(assurance);
		return assurance;
	}
	
	

}
