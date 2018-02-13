package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {

	public List<Client> getAllClient();

	public Client getClientByReservation(int idRes);
	// client par réservation

	public Client addClient(Client c);

	public Client updateClient(Client c);

	public int deleteClient(int id);

	public Client getClientById(int id);
	
	public Client isExistClient(String mail,String mdp);

}
