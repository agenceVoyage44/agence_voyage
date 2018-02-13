package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Formule;

public interface IFormuleDao {

	/**
	 * Methode permettant de récupérer toutes les formules existantes. Elle ne
	 * prends aucun paramètre en entrée et retourne une liste de formules.
	 * 
	 * @return La liste des formules existantes
	 */
	public List<Formule> getAllFormule();

	/**
	 * Methode permettant de récupérer une formule à partir de son ID.
	 * 
	 * @param id
	 *            L'ID de la formule à récupérer
	 * @return La formule récupéree
	 */
	public Formule getFormuleById(int id);

	/**
	 * Methode permettant d'ajouter une formule.
	 * 
	 * @param formule
	 *            La formule à ajouter, ne possédant pas d'ID.
	 * @return La formule ajoutée, avec son ID.
	 */
	public Formule addFormule(Formule formule);

	/**
	 * Methode permettant de mettre a jour le prix ainsi que le type de la
	 * formule.
	 * 
	 * @param formule
	 *            La formule avec les nouveaux paramètres.
	 * @return La formule mise à jour.
	 */
	public Formule updateFormule(Formule formule);

	/**
	 * Methode permettant de supprimer une formule à partir de son ID.
	 * 
	 * @param id
	 *            L'ID de la formule à supprimer
	 * @return 1 si la suppression a été effective, 0 sinon.
	 */
	public int deleteFormule(int id);

}
