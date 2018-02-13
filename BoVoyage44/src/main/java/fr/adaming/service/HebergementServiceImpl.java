package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IHebergementDao;
import fr.adaming.model.Hebergement;

@Service
@Transactional
public class HebergementServiceImpl implements IHebergementService {

	
	@Autowired
	private IHebergementDao hebergementDao;
	

	//dependance
	public void setHebergementDao(IHebergementDao hebergementDao) {
		this.hebergementDao = hebergementDao;
	}

	@Override
	public Hebergement addHebergement(Hebergement hebergement) {
		
		return hebergementDao.addHebergement(hebergement);
	}

	@Override
	public Hebergement updateHebergement(Hebergement hebergement) {
		
		return hebergementDao.updateHebergement(hebergement);
	}

	@Override
	public Hebergement getHebergementByID(int idHebergement) {
		
		return hebergementDao.getHebergementByID(idHebergement);
	}

	@Override
	public int deleteHebergement(int idHebergement) {
		
		return hebergementDao.deleteHebergement(idHebergement);
	}

	@Override
	public List<Hebergement> getAllHebergement() {
		
		return hebergementDao.getAllHebergement();
	}

}
