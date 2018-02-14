package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Formule;
import fr.adaming.model.Hebergement;
import fr.adaming.service.IFormuleService;
import fr.adaming.service.IHebergementService;

@Controller
@RequestMapping("/agent/hebergement")
public class HebergementController {

	@Autowired
	private IHebergementService hebergementService;

	@Autowired
	private IFormuleService formuleService;

	public void setHebergementService(IHebergementService hebergementService) {
		this.hebergementService = hebergementService;
	}

	public void setFormuleService(IFormuleService formuleService) {
		this.formuleService = formuleService;
	}

	// -----------------------Affiche Liste
	// Hebergement----------------------------
	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// recuperer la liste de la bd
		List<Hebergement> liste = hebergementService.getAllHebergement();

		return new ModelAndView("hebergementListe", "hList", liste);
	}

	// ---------------------------Ajouter un Hebergement --------------------
	// *****Pour afficher le formulaire******
	@RequestMapping(value = "/afficheAdd", method = RequestMethod.GET)
	public String addHebergement(Model modele) {

		modele.addAttribute("addHebergement", new Hebergement());

		// Récupérer la liste de la BDD (formule)
		List<Formule> listeFormules = formuleService.getAllFormule();

		modele.addAttribute("listeFormules",listeFormules);
		
		return "hebergementAjout";

	}

	// *****Pour soumettre le formulaire*****
	@RequestMapping(value = "/soumettreAdd", method = RequestMethod.POST)
	public String soumettreaddHebergement(RedirectAttributes rs,
			@ModelAttribute("addHebergement") Hebergement hebergement) {

		// appel de la methode service
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
		
		// Récupérer la liste de la BDD (formule)
		List<Formule> listeFormules = formuleService.getAllFormule();

		modele.addAttribute("listeFormules",listeFormules);
		
		return "hebergementUpdate";
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
		return "hebergementDelete";
	}

	// *****soumettre le formulaire ******
	@RequestMapping(value = "/soumettreDelete", method = RequestMethod.POST)
	public String soumettreDeleteHebergement(@ModelAttribute("hebergDelete") Hebergement h) {

		// appelle de la methode service
		Hebergement hOut = hebergementService.updateHebergement(h);

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
		return "hebergementGet";
	}

	// ******soumettre le formulaire *********
	@RequestMapping(value = "/soumettreGet", method = RequestMethod.POST)
	public String soumettreGetHebergement(RedirectAttributes rs, Model model,
			@ModelAttribute("hebergSearch") Hebergement h) {

		// appelle de la methode service
		Hebergement hOut = hebergementService.getHebergementByID(h.getId());

		if (hOut != null) {

			model.addAttribute("hebergement", hOut);
			model.addAttribute("indice", true);
			return "hebergementGet";
		} else {

			rs.addFlashAttribute("message", "L'hebergement souhaité n'existe pas");

			// rediriger vers la methode ajout
			return "redirect:afficheGet";
		}

	}

	// --------Lien Tableau Pour Supprimer ou Modifier l'Hebergement----------

	// ----------------supprime(lien)-------------------
	@RequestMapping(value = "/supprimeLien/{pId}", method = RequestMethod.GET)
	public String supprimerlien(Model model, @PathVariable("pId") int id) {
		Hebergement h = new Hebergement();

		h.setId(id);

		// appel de la methode service
		hebergementService.deleteHebergement(id);

		// recuperer la liste de la bd
		List<Hebergement> liste = hebergementService.getAllHebergement();

		model.addAttribute("hList", liste);

		return "hebergementListe";

	}

	// ------------ modifier(lien)-------------
	@RequestMapping(value = "/modifieLien", method = RequestMethod.GET)
	public String modifielien(ModelMap model, @RequestParam("pId") int id) {

		// @PathVariable: prend pId est la stock dans le int id

		Hebergement hIn = new Hebergement();

		hIn.setId(id);

		// recup hebergment de la bd
		Hebergement hOut = hebergementService.getHebergementByID(id);

		model.addAttribute("hebergUpdate", hOut);
		
		
		


		return "hebergementUpdate";
	}

}
