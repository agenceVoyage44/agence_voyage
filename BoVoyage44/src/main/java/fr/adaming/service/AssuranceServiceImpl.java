package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAssuranceDao;
import fr.adaming.dao.IReservationDao;
import fr.adaming.model.Assurance;
import fr.adaming.model.Reservation;
/**
 * Classe Assurance Service implementé par l'interface IAssuranceService
 * @author Adaming
 *
 */
@Service
@Transactional
public class AssuranceServiceImpl implements IAssuranceService {
	@Autowired
	IAssuranceDao assuranceDao;
	@Autowired
	IReservationDao resaDao;
	
	public void setAssuranceDao(IAssuranceDao assuranceDao) {
		this.assuranceDao = assuranceDao;
	}

	@Override
	public Assurance addAssurance(Assurance assurance) {
		
		return assuranceDao.addAssurance(assurance);
	}

	@Override
	public List<Assurance> getAllAssurance() {
		
		return assuranceDao.getAllAssurance();
	}

	@Override
	public int deleteAssurance(int id) {
		
		return assuranceDao.deleteAssurance(id);
	}

	@Override
	public Assurance getAssuranceById(int id) {
		
		return assuranceDao.getAssuranceById(id);
	}

	@Override
	public Assurance updateAssurance(Assurance assurance) {
		
		return assuranceDao.updateAssurance(assurance);
	}

	@Override
	public Assurance setResa(int idResa, int idAssur) {
		Assurance a = assuranceDao.getAssuranceById(idAssur);
		List<Reservation>liste=a.getListeReservations();
		liste.add(resaDao.getReservationByID(idResa));
		a.setListeReservations(liste);
		return a;
	}

}
