package fr.adaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Role;

@Repository
public class RoleDaoImpl implements IRoleDao {

	@PersistenceContext(unitName = "BoVoyage44")
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Role addRole(Role r) {

		em.persist(r);

		return r;
	}

}
