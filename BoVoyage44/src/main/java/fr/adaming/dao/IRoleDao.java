package fr.adaming.dao;

import fr.adaming.model.Role;

public interface IRoleDao {

	/**
	 * Ajoute un role à la base de donnée.
	 * 
	 * @param r
	 *            Il s'agit du role à ajouter.
	 * @return Retourne le role ajouté.
	 */
	public Role addRole(Role r);
}
