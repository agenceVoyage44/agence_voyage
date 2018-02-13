package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Assurance;

public interface IAssuranceDao {
	
	/**
	 * Methode Ajouter Assurance
	 * @param assurance
	 * @return retourne un objet Assurance
	 */
	public Assurance addAssurance(Assurance assurance);
	/**
	 * Methode Afficher la liste des assurances
	 * @return retourne une List<Assurance>
	 */
	public List<Assurance> getAllAssurance();
	/**
	 * Methode Supprimer Assurance
	 * @param id
	 * @return retourne un int
	 */
	public int deleteAssurance(int id);
	/**
	 * Methode Afficher une assurance par son id
	 * @param id
	 * @return retourne un objet Assurance
	 */
	public Assurance getAssuranceById(int id);
	/**
	 * Methode Modifier Assurance
	 * @param assurance
	 * @return retourne un objet Assurance
	 */
	public Assurance updateAssurance (Assurance assurance);
}
