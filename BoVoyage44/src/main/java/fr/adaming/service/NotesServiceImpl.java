package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.INotesDao;
import fr.adaming.model.Notes;

@Service
@Transactional
public class NotesServiceImpl implements INotesService {

	@Autowired
	private INotesDao notesDao;

	@Override
	public Notes addNotes(Notes n) {

		return notesDao.addNotes(n);
	}

	@Override
	public List<Notes> getAllNotes() {
		return notesDao.getAllNotes();
	}

	@Override
	public List<Notes> getMoyennes() {
		List<Notes>listeN=notesDao.getAllNotes();
		List<Notes>listeMoyennes=new ArrayList<>();
		double voyage=0;
		double logement=0;
		double food=0;
		double transport=0;
		double agent=0;
		double siteAspect=0;
		double siteUtil=0;
		for (Notes n : listeN) {
			voyage=voyage+n.getVoyage();
			logement=logement+n.getLogement();
			food=food+n.getNourriture();
			transport=transport+n.getTransport();
			agent=agent+n.getAgent();
			siteAspect=siteAspect+n.getSiteAspect();
			siteUtil=siteUtil+n.getSiteUtil();
		}
		voyage=voyage/listeN.size();
		
		
		
		
		listeMoyennes.add(voyage)
		return s;
	}

}
