package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Voyage;
import fr.adaming.service.IVoyageService;


/**
 * VoyageController est le controller qui gère la vue pour les mèthodes de la classe Voyage.
 * @author Larry Bambel
 *
 */
@Controller
@Scope("session")
@RequestMapping("/voyage")
public class VoyageController {
	
	@Autowired
	private IVoyageService voyageService;

	public void setVoyageService(IVoyageService voyageService) {
		this.voyageService = voyageService;
	}
	
	/**
	 * La méthode afficheListe gère l'affichage de la liste des voyage.
	 * @return La liste des voyages et la page dans laquelle ils sont affichés. 
	 */
	@RequestMapping(value = "/agent/liste", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		List<Voyage> liste = voyageService.getAllVoyage();

		return new ModelAndView("voyageListe", "voyageList", liste);
	}

	
	
	@RequestMapping(value = "/agent/afficheAdd", method = RequestMethod.GET)
	public ModelAndView afficheAjout() {

		return new ModelAndView("voyageAjout", "voyageAjout", new Voyage());
	}
	
	@RequestMapping(value = "/agent/soumettreAdd", method = RequestMethod.POST)
	public String soumettreAjouter(@ModelAttribute("voyageAjout") Voyage v) {

		Voyage vOut = voyageService.addVoyage(v);

		if (vOut.getId() != 0) {
			return "redirect:liste";
		} else {
			return "redirect:afficheAdd";
		}
	}
	
	
	@RequestMapping(value = "/agent/afficheUpdate", method = RequestMethod.GET)
	public ModelAndView afficheModif() {

		return new ModelAndView("voyageModifier", "voyageModif", new Voyage());
	}
	
	@RequestMapping(value = "/agent/soumettreUpdate", method = RequestMethod.POST)
	public String soumettreModif(@ModelAttribute("voyageModif") Voyage v) {
		Voyage vOut = voyageService.updateVoyage(v);

		if (vOut.getContinent() == v.getContinent()) {
			return "redirect:liste";
		} else {
			return "redirect:afficheUpdate";
		}
	}
	
	
	
	@RequestMapping(value = "/agent/afficheDelete", method = RequestMethod.GET)
	public ModelAndView afficheSupprim() {

		return new ModelAndView("voyageSupprimer", "voyageSupprim", new Voyage());
	}
	
	@RequestMapping(value = "/agent/soumettreDelete", method = RequestMethod.POST)
	public String soumettreSupprim(@ModelAttribute("voyageSupprim") Voyage v) {

		int verif = voyageService.deleteVoyage(v.getId());

		if (verif != 0) {
			return "redirect:liste";
		} else {
			return "redirect:afficheDelete";
		}
	}
	
	
	
	@RequestMapping(value = "/agent/afficheGet", method = RequestMethod.GET)
	public ModelAndView afficheRecherche() {
		return new ModelAndView("voyageRechercher", "voyageRecherche", new Voyage());
	}
	
	@RequestMapping(value = "/agent/soumettreGet", method = RequestMethod.POST)
	public ModelAndView soumettreRecherche(@ModelAttribute("voyageRecherche") Voyage v, RedirectAttributes ra) {

		Voyage vOut = voyageService.getVoyageById(v.getId());
		if (vOut != null) {
			return new ModelAndView("voyageRechercher", "voyage", vOut);
		} else {
			return afficheRecherche();
		}
	}
	
	
	
	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public ModelAndView afficheListeClient() {
		List<Voyage> liste = voyageService.getAllVoyage();

		return new ModelAndView("voyageListeClient", "voyageList", liste);
	}

	
}
