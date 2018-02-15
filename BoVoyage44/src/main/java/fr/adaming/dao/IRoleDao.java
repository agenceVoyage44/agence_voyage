package fr.adaming.dao;

import fr.adaming.model.Role;

public interface IRoleDao {

	/**
	 * Ajoute un role � la base de donn�e.
	 * 
	 * @param r
	 *            Il s'agit du role � ajouter.
	 * @return Retourne le role ajout�.
	 */
	public Role addRole(Role r);
}
