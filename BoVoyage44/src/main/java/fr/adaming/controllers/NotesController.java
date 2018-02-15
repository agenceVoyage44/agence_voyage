package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Notes;
import fr.adaming.service.INotesService;

@Controller
@RequestMapping("/notes")
public class NotesController {

	@Autowired
	private INotesService notesService;

	public INotesService getNotesService() {
		return notesService;
	}

	public void setNotesService(INotesService notesService) {
		this.notesService = notesService;
	}

	// ##############AJOUT Note######################

	// La methode pour afficher le formulaire en GET

	@RequestMapping(value = "/afficheAdd", method = RequestMethod.GET)
	public ModelAndView afficheAjoutClient() {

		return new ModelAndView("noteAjouter", "noteAjout", new Notes());
	}

	// La méthode pour soumettre le formulaire en Post

	@RequestMapping(value = "/soumettreAdd", method = RequestMethod.POST)
	public String soumettreFormClientA(Model modele, @ModelAttribute("noteAjout") Notes n) {
		System.out.println("#######test ajout note############" + n);
		// appel de la methode service
		Notes nOut = notesService.addNotes(n);

		if (nOut.getId() != 0) {

			return "afficheAdd";
		} else {

			return "afficheAdd";
		}

	}

}
