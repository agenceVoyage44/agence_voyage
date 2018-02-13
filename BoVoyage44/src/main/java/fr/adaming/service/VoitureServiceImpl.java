package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoitureDao;
import fr.adaming.model.Voiture;

@Transactional
@Service
public class VoitureServiceImpl implements IVoitureService {

	@Autowired
	private IVoitureDao voitureDao;

	public void setVoitureDao(IVoitureDao voitureDao) {
		this.voitureDao = voitureDao;
	}

	@Override
	public Voiture addVoiture(Voiture v) {
		return voitureDao.addVoiture(v);
	}

	@Override
	public List<Voiture> getAllVoiture() {
		return voitureDao.getAllVoiture();
	}

	@Override
	public int deleteVoiture(int id) {
		return voitureDao.deleteVoiture(id);
	}

	@Override
	public Voiture getVoitureById(int id) {
		return voitureDao.getVoitureById(id);
	}

	@Override
	public Voiture updateVoiture(Voiture v) {
		return voitureDao.updateVoiture(v);
	}

}
