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
	 * Obtenir le client correspondant � une r�servation
	 * 
	 * @param idRes
	 *            l'id de la r�servation
	 * 
	 * 
	 * @return le client ayant r�serv� d'un voyage
	 */
	public Client getClientByReservation(int idRes);
	// client par r�servation

	/**
	 * Ajouter un client
	 * 
	 * @param c
	 *            client � ajouter
	 * 
	 * 
	 * @return le client ajout�
	 */
	public Client addClient(Client c);

	/**
	 * Modifier un client
	 * 
	 * @param c
	 *            client � modifier
	 * 
	 * 
	 * @return le client modifi�
	 */
	public Client updateClient(Client c);

	/**
	 * supprimer un client
	 * 
	 * @param id
	 *            id du client � supprimer
	 * 
	 * 
	 * @return 0 si la suppression a �chou�, 1 si elle a abouti
	 */
	public int deleteClient(int id);

	/**
	 * Obtenir un client avec son id
	 * 
	 * @param id
	 *            id du client recherch�
	 * 
	 * 
	 * @return le client recherch�
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
	 * @return le client recherch�
	 */
	public Client isExistClient(String mail, String mdp);

	public Client getClientByMail(String mail);

	public List<Client> getAllClientByReservation(int idResa);

}
