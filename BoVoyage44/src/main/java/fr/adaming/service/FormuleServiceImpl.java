package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IFormuleDao;
import fr.adaming.model.Formule;

@Repository
@Transactional
public class FormuleServiceImpl implements IFormuleService{

	@Autowired
	IFormuleDao formuleDao;
	
	public void setFormuleDao(IFormuleDao formuleDao) {
		this.formuleDao = formuleDao;
	}

	
	// METHODES
	
	@Override
	public List<Formule> getAllFormule() {
		return formuleDao.getAllFormule();
	}

	@Override
	public Formule getFormuleById(int id) {
		return formuleDao.getFormuleById(id);
	}

	@Override
	public Formule addFormule(Formule formule) {
		return formuleDao.addFormule(formule);
	}

	@Override
	public Formule updateFormule(Formule formule) {
		return formuleDao.updateFormule(formule);
	}

	@Override
	public int deleteFormule(int id) {
		return formuleDao.deleteFormule(id);
	}

}
