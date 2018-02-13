package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clientDao;

	@Override
	public List<Client> getAllClient() {

		return clientDao.getAllClient();
	}

	@Override
	public Client getClientByReservation(int idRes) {

		return clientDao.getClientByReservation(idRes);
	}

	@Override
	public Client addClient(Client c) {

		return clientDao.addClient(c);
	}

	@Override
	public Client updateClient(Client c) {

		return clientDao.updateClient(c);
	}

	@Override
	public int deleteClient(int id) {

		return clientDao.deleteClient(id);
	}

	@Override
	public Client getClientById(int id) {

		return clientDao.getClientById(id);
	}

}
