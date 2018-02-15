package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Notes;
import fr.adaming.service.INotesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequestMapping("/boVoyage")
public class BoVoyageController {

	@Autowired
	private INotesService notesService;

	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String afficheAccueil() {
		return "accueil";
	}

	@RequestMapping(value = "/agent/accueil", method = RequestMethod.GET)
	public ModelAndView afficheMoyenneNotes() {
		// récupérer la liste de la bd
		List<Notes> liste = notesService.getMoyennes();
		return new ModelAndView("accueilAgent", "moyenneList", liste);

	}

	@RequestMapping(value = "/client/accueil", method = RequestMethod.GET)
	public String afficheAcuueilClient(Model model) {
		// recuperer le context de spring security
		Authentication authClient = SecurityContextHolder.getContext().getAuthentication();

		// recup l'identifiant de l'utilisateur connecté
		String mail = authClient.getName();
		model.addAttribute("msg", "Accueil Client " + mail);

		return "accueilClient";
	}

}
