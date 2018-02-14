package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Voyage;


/**
 * L'interface IVoyageDao r�f�rence les m�thodes du pack DAO de la classe Voyage.
 * 
 * @author Sarah Croche
 *
 */
public interface IVoyageDao {

	/**
	 * La m�thode addVoyage va persister des objets de type voyage dans la BDD.
	 * @param v l'objet voiture � persister.
	 * @return l'objet voiture persist�e.
	 */
	public Voyage addVoyage(Voyage v);
	
	/**
	 * La m�thode getAllVoyage va r�cuperer tous les objets de type voyage de la BDD.
	 * @return une liste d'objet voiture
	 */
	public List<Voyage> getAllVoyage();
	
	/**
	 * La m�thode updateVoyage va modifier des objets persistants de type voyage dans la BDD.
	 * @param v l'objet voiture avec les modifications.
	 * @return l'objet voiture modifi�.
	 */
	public Voyage updateVoyage(Voyage v);
	
	/**
	 * La m�thode deleteVoyage va supprimer des objets persistants de type voyage de la BDD.
	 * @param id l'entier qui sert de valeur pour la cl� primaire de l'objet voyage � supprimer. 
	 * @return 1 si r�ussite et 0 sinon.
	 */
	public int deleteVoyage(int id);
	
	/**
	 * La m�thode getAllVoyage va r�cuperer l'objet de type voyage dont l'id correspond.
	 * @param id l'entier qui sert de valeur pour la cl� primaire de l'objet voyage � rechercher.
	 * @returnl'objet voiture recherch�.
	 */
	public Voyage getVoyageById(int id);
	
}
