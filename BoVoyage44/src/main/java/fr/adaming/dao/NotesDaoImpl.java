package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Notes;

/**
 * Classe NotesDaoImpl qui mimplémente l'interface INotesDao
 *
 */
@Repository
public class NotesDaoImpl implements INotesDao {

	@PersistenceContext(unitName = "BoVoyage44")
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Notes addNotes(Notes n) {

		em.persist(n);

		return n;
	}

	@Override
	public List<Notes> getAllNotes() {

		String req = "SELECT n FROM Notes as n";
		// creer query
		Query query = em.createQuery(req);

		@SuppressWarnings("unchecked")
		List<Notes> listeNotes = query.getResultList();
		return listeNotes;
	}

}
