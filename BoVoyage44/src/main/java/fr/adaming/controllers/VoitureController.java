package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Voiture;
import fr.adaming.service.IVoitureService;

@Controller
@RequestMapping("/agent/Voiture")
public class VoitureController {

	@Autowired
	private IVoitureService voitureService;

	public void setVoitureService(IVoitureService voitureService) {
		this.voitureService = voitureService;
	}

	// ******* Liste des Voitures **********
	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// Récupérer la liste de la bd
		List<Voiture> listeV = voitureService.getAllVoiture();

		return new ModelAndView("voitureListe", "vListe", listeV);
	}

	// ******* Ajout Voiture **********
	// Méthode get pour afficher le form d'ajout
	@RequestMapping(value = "/afficheAdd", method = RequestMethod.GET)
	public ModelAndView afficherAjouter() {
		return new ModelAndView("voiureAjouter", "voitureAjout", new Voiture());
	}

	// Méthode post pour soumettre le formulaire d'ajout
	@RequestMapping(value = "/soumettreAdd", method = RequestMethod.POST)
	public String soumettreAjouter(@ModelAttribute("voitureAjout") Voiture v) {

		Voiture vOut = voitureService.addVoiture(v);

		if (vOut.getId() != 0) {
			return "redirect:liste";
		} else {
			return "redirect:afficheAdd";
		}
	}

}
