package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Formule;

public interface IFormuleDao {

	/**
	 * Methode permettant de r�cup�rer toutes les formules existantes. Elle ne
	 * prends aucun param�tre en entr�e et retourne une liste de formules.
	 * 
	 * @return La liste des formules existantes
	 */
	public List<Formule> getAllFormule();

	/**
	 * Methode permettant de r�cup�rer une formule � partir de son ID.
	 * 
	 * @param id
	 *            L'ID de la formule � r�cup�rer
	 * @return La formule r�cup�ree
	 */
	public Formule getFormuleById(int id);

	/**
	 * Methode permettant d'ajouter une formule.
	 * 
	 * @param formule
	 *            La formule � ajouter, ne poss�dant pas d'ID.
	 * @return La formule ajout�e, avec son ID.
	 */
	public Formule addFormule(Formule formule);

	/**
	 * Methode permettant de mettre a jour le prix ainsi que le type de la
	 * formule.
	 * 
	 * @param formule
	 *            La formule avec les nouveaux param�tres.
	 * @return La formule mise � jour.
	 */
	public Formule updateFormule(Formule formule);

	/**
	 * Methode permettant de supprimer une formule � partir de son ID.
	 * 
	 * @param id
	 *            L'ID de la formule � supprimer
	 * @return 1 si la suppression a �t� effective, 0 sinon.
	 */
	public int deleteFormule(int id);

}
