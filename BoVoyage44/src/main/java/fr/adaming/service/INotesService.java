package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Notes;

public interface INotesService {

	public Notes addNotes(Notes n);

	public List<Notes> getAllNotes();

}
