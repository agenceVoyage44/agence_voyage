package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Formule;
import fr.adaming.model.Hebergement;
import fr.adaming.service.IFormuleService;

@Controller
@RequestMapping("/agent/formule")
public class FormuleController {

	@Autowired
	private IFormuleService formuleService;

	public void setFormuleService(IFormuleService formuleService) {
		this.formuleService = formuleService;
	}

	// OBTENIR TOUTES LES FORMULES

	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public ModelAndView getAllFormule() {

		// Récupérer la liste de la BDD
		List<Formule> listeFormules = formuleService.getAllFormule();

		return new ModelAndView("formuleListe", "formulesList", listeFormules);

	}

	// OBTENIR FORMULE PAR ID

	// Méthode pour afficher le formulaire en GET
	@RequestMapping(value = "/afficheGet", method = RequestMethod.GET)
	public ModelAndView afficheGetFormule() {
		return new ModelAndView("formuleById", "formule", new Formule());

	}

	// Méthode pour soumettre le formulaire en POST
	@RequestMapping(value = "/soumettreGet", method = RequestMethod.POST)
	public String soumettreGetFormule(Model modele, @ModelAttribute("formule") Formule formule) {

		// Appel de la méthode service

		Formule form = formuleService.getFormuleById(formule.getId());

		modele.addAttribute("formule", form);

		return "formuleRecherche";

	}

	// AJOUTER FORMULE

	// Méthode pour afficher le formulaire en GET
	@RequestMapping(value = "/afficheAdd", method = RequestMethod.GET)
	public ModelAndView afficheAddFormule() {
		return new ModelAndView("formuleAjouter", "formuleAjout", new Formule());

	}

	// Méthode pour soumettre le formulaire en POST
	@RequestMapping(value = "/soumettreAdd", method = RequestMethod.POST)
	public String soumettreAddFormule(Model modele, @ModelAttribute("formuleAjout") Formule formule) {

		// Appel de la méthode service

		Formule form = formuleService.addFormule(formule);

		modele.addAttribute("formule", form);

		return "redirect:/agent/formule/liste";

	}

	// MODIFIER FORMULE

	// Méthode pour afficher le formulaire en GET
	@RequestMapping(value = "/afficheUpdate", method = RequestMethod.GET)
	public ModelAndView afficheUpdateFormule() {
		return new ModelAndView("formuleModifier", "formuleModif", new Formule());

	}

	// Méthode pour soumettre le formulaire en POST
	@RequestMapping(value = "/soumettreUpdate", method = RequestMethod.POST)
	public String soumettreUpdateFormule(Model modele, @ModelAttribute("formuleModif") Formule formule) {

		// Appel de la méthode service

		Formule form = formuleService.updateFormule(formule);

		modele.addAttribute("formule", form);

		return "redirect:/agent/formule/liste";

	}

	// SUPPRIMER FORMULE

	// Méthode pour afficher le formulaire en GET
	@RequestMapping(value = "/afficheDelete", method = RequestMethod.GET)
	public ModelAndView afficheDeleteFormule() {
		return new ModelAndView("formuleSupprimer", "formuleSupprim", new Formule());

	}

	// Méthode pour soumettre le formulaire en POST
	@RequestMapping(value = "/soumettreDelete", method = RequestMethod.POST)
	public String soumettreDeleteFormule(Model modele, @ModelAttribute("formuleSupprim") Formule formule) {

		// Appel de la méthode service

		formuleService.deleteFormule(formule.getId());

		return "redirect:/agent/formule/liste";

	}

	// SUPPRIMER FORMULE LIEN

	// ----------------supprime(lien)-------------------
	@RequestMapping(value = "/supprimeLien/{pId}", method = RequestMethod.GET)
	public String supprimerlien(Model model, @PathVariable("pId") int id) {

		// appel de la methode service
		formuleService.deleteFormule(id);
	

		return "redirect:../liste";

	}

	// ----------------modifie(lien)-------------------
	@RequestMapping(value = "/modifieLien", method = RequestMethod.GET)
	public String modifierlien(Model model, @RequestParam("pId") int id) {

		Formule formuleOut = formuleService.getFormuleById(id);

		model.addAttribute("formuleModif", formuleOut);

		return "formuleModifier";

	}

}
