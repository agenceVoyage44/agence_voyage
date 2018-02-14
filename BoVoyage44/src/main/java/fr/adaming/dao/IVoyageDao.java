package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Voyage;


/**
 * L'interface IVoyageDao référence les méthodes du pack DAO de la classe Voyage.
 * 
 * @author Sarah Croche
 *
 */
public interface IVoyageDao {

	/**
	 * La méthode addVoyage va persister des objets de type voyage dans la BDD.
	 * @param v l'objet voiture à persister.
	 * @return l'objet voiture persistée.
	 */
	public Voyage addVoyage(Voyage v);
	
	/**
	 * La méthode getAllVoyage va récuperer tous les objets de type voyage de la BDD.
	 * @return une liste d'objet voiture
	 */
	public List<Voyage> getAllVoyage();
	
	/**
	 * La méthode updateVoyage va modifier des objets persistants de type voyage dans la BDD.
	 * @param v l'objet voiture avec les modifications.
	 * @return l'objet voiture modifié.
	 */
	public Voyage updateVoyage(Voyage v);
	
	/**
	 * La méthode deleteVoyage va supprimer des objets persistants de type voyage de la BDD.
	 * @param id l'entier qui sert de valeur pour la clé primaire de l'objet voyage à supprimer. 
	 * @return 1 si réussite et 0 sinon.
	 */
	public int deleteVoyage(int id);
	
	/**
	 * La méthode getAllVoyage va récuperer l'objet de type voyage dont l'id correspond.
	 * @param id l'entier qui sert de valeur pour la clé primaire de l'objet voyage à rechercher.
	 * @returnl'objet voiture recherché.
	 */
	public Voyage getVoyageById(int id);
	
}
