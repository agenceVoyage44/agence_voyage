package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientDao {

	/**
	 * Obtenir la liste de tous les clients
	 * 
	 * 
	 * @return la liste des clients
	 */
	public List<Client> getAllClient();

	/**
	 * Obtenir le client correspondant à une réservation
	 * 
	 * @param idRes
	 *            l'id de la réservation
	 * 
	 * 
	 * @return le client ayant réservé d'un voyage
	 */
	public Client getClientByReservation(int idRes);
	// client par réservation

	/**
	 * Ajouter un client
	 * 
	 * @param c
	 *            client à ajouter
	 * 
	 * 
	 * @return le client ajouté
	 */
	public Client addClient(Client c);

	/**
	 * Modifier un client
	 * 
	 * @param c
	 *            client à modifier
	 * 
	 * 
	 * @return le client modifié
	 */
	public Client updateClient(Client c);

	/**
	 * supprimer un client
	 * 
	 * @param id
	 *            id du client à supprimer
	 * 
	 * 
	 * @return 0 si la suppression a échoué, 1 si elle a abouti
	 */
	public int deleteClient(int id);

	/**
	 * Obtenir un client avec son id
	 * 
	 * @param id
	 *            id du client recherché
	 * 
	 * 
	 * @return le client recherché
	 */
	public Client getClientById(int id);

	/**
	 * Authentification du client : Obtenir un client avec son mail et son mot
	 * de passe
	 * 
	 * @param mail,
	 *            mdp
	 * 
	 * 
	 * 
	 * @return le client recherché
	 */
	public Client isExistClient(String mail, String mdp);

	public Client getClientByMail(String mail);

	public List<Client> getAllClientByReservation(int idResa);

}
