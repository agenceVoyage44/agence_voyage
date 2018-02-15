package fr.adaming.service;

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

}
