package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Voyage;

/**
 * La classe VoyageServiceImpl implémente l'interface IVoyageService.
 * @author intiformation
 *
 */
@Transactional
@Service
public class VoyageServiceImpl implements IVoyageService {

	@Autowired
	private IVoyageDao voyageDao;
	
	public void setVoyageDao(IVoyageDao voyageDao) {
		this.voyageDao = voyageDao;
	}

	@Override
	public Voyage addVoyage(Voyage v) {
		return voyageDao.addVoyage(v);
	}

	@Override
	public List<Voyage> getAllVoyage() {
		return voyageDao.getAllVoyage();
	}

	@Override
	public Voyage updateVoyage(Voyage v) {
		return voyageDao.updateVoyage(v);
	}

	@Override
	public int deleteVoyage(int id) {
		return voyageDao.deleteVoyage(id);
	}

	@Override
	public Voyage getVoyageById(int id) {
		return voyageDao.getVoyageById(id);
	}

}
