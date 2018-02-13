package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Hebergement;
import fr.adaming.model.Reservation;
import fr.adaming.service.IHebergementService;

@Controller
@RequestMapping("/agent/hebergement")
public class HebergementController {

	@Autowired
	private IHebergementService hebergementService;

	public void setHebergementService(IHebergementService hebergementService) {
		this.hebergementService = hebergementService;
	}
	
	// -----------------------Affiche Liste Hebergement----------------------------
		@RequestMapping(value = "/liste", method = RequestMethod.GET)
		public ModelAndView afficheListe() {
			// recuperer la liste de la bd
			List<Hebergement> liste = hebergementService.getAllHebergement();

			return new ModelAndView("HebergementListe", "hList", liste);
		}
	
	// ---------------------------Ajouter un Hebergement --------------------
	// *****Pour afficher le formulaire******
	@RequestMapping(value = "/afficheAdd", method = RequestMethod.GET)
	public ModelAndView addHebergement() {

		return new ModelAndView("ajouterHebergement", "addHebergement", new Hebergement());
	}

	// *****Pour soumettre le formulaire*****
	@RequestMapping(value = "/soumettreAdd", method = RequestMethod.POST)
	public String soumettreaddHebergement(RedirectAttributes rs,@ModelAttribute("addHebergement") Hebergement hebergement) {

		//appel de la methode service
		Hebergement hOut = hebergementService.addHebergement(hebergement);

		if (hOut.getId() != 0) {

			return "redirect:liste";
		} else {
			rs.addFlashAttribute("message", "L'hebergement en question n'a pas pu être ajoutée");
			return "redirect:afficheAdd";
		}

	}
	
	// ---------------------------------Modif------------------------------
		// *****afficher le formulaire de modif*******
		@RequestMapping(value = "/afficheUpdate", method = RequestMethod.GET)
		public String updateHeberg(Model modele) {
			modele.addAttribute("hebergUpdate", new Hebergement());
			return "afficheUpdate";
		}

		// ******soumettre le formulaire update******
		@RequestMapping(value = "/soumettreUpdate", method = RequestMethod.POST)
		public String soumettreUpdateHebergement(@ModelAttribute("hebergUpdate") Hebergement h) {

			// appelle de la methode service
			Hebergement hOut = hebergementService.updateHebergement(h);

			if (hOut.getId() != 0) {

				return "redirect:liste";
			} else {
				return "redirect:afficheUpdate";
			}
		}
	
		// ---------------------------------DELETE-----------------------------
		// ******afficher le formulaire de supression*******
		@RequestMapping(value = "/afficheDelete", method = RequestMethod.GET)
		public String deleteHeberg(Model modele) {
			modele.addAttribute("hebergDelete", new Hebergement());
			return "afficheDelete";
		}

		// *****soumettre le formulaire ******
		@RequestMapping(value = "/soumettreDelete", method = RequestMethod.POST)
		public String soumettreDeleteHebergement(@ModelAttribute("hebergDelete") Hebergement h) {

			// appelle de la methode service
			Hebergement hOut = hebergementService.updateHebergement(h);;

			if (hOut.getId() != 0) {

				return "redirect:liste";
			} else {
				return "redirect:afficheDelete";
			}

		}
		
		// ----------------------------Recherche--------------------------
		// ******afficher le formulaire de recherche*******
		@RequestMapping(value = "/afficheGet", method = RequestMethod.GET)
		public String searchHeberg(Model modele) {
			modele.addAttribute("hebergSearch", new Hebergement());
			modele.addAttribute("indice", false);
			return "afficheGet";
		}

		// ******soumettre le formulaire *********
		@RequestMapping(value = "/soumettreGet", method = RequestMethod.POST)
		public String soumettreGetHebergement(RedirectAttributes rs, Model model, @ModelAttribute("hebergSearch") int idHeberg) {

			
			// appelle de la methode service
			  Hebergement hOut=hebergementService.getHebergementByID(idHeberg);

			if (hOut != null) {

				model.addAttribute("hebergement", hOut);
				model.addAttribute("indice", true);
				return "afficheGet";
			} else {

				rs.addFlashAttribute("message", "L'hebergement souhaité n'existe pas");

				// rediriger vers la methode ajout
				return "redirect:afficheGet";
			}

		}
	
}
