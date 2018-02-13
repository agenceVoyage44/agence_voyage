package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.model.Participant;
import fr.adaming.service.IParticipantService;

@Controller
@RequestMapping("/agent/participant")
public class ParticipantController {

	@Autowired
	private IParticipantService participantService;

	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public ModelAndView afficheListeParticipant() {
		// récupérer la liste de la bd
		List<Participant> liste = participantService.getAllParticipant();
		return new ModelAndView("participantAfficher", "participantList", liste);
	}

	// ##############AJOUT PARTICIPANT######################

	// La methode pour afficher le formulaire en GET

	@RequestMapping(value = "/afficheAdd", method = RequestMethod.GET)
	public ModelAndView afficheAjoutParticipant() {

		return new ModelAndView("participantAjouter", "partAjout", new Participant());
	}

	// La méthode pour soumettre le formulaire en Post

	@RequestMapping(value = "/soumettreAdd", method = RequestMethod.POST)
	public String soumettreFormPartA(Model modele, @ModelAttribute("partAjout") Participant p) {

		// appel de la methode service
		Participant pOut = participantService.addParticipant(p);

		if (pOut.getId() != 0) {
			// rediriger vers la méthode afficheListe
			return "redirect:liste";
		} else {
			// rediriger vers la méthode afficheAjout
			return "redirect:afficheAdd";
		}

	}

	// ################ SUPPRESSION PARTICIPANT #############

	@RequestMapping(value = "/afficheDelete", method = RequestMethod.GET)
	public ModelAndView afficheSupprParticipant() {
		return new ModelAndView("participantSupprimer", "partSuppr", new Participant());
	}

	@RequestMapping(value = "/soumettreSupprParticipant", method = RequestMethod.POST)
	public String soumettreFormSupprParticipant(Model model, @RequestParam("pId") int id) {
		int verif = participantService.deleteParticipant(id);

		if (verif != 0) {
			return "redirect:liste";
		} else {

			return "redirect:afficheDelete";
		}

	}

	// ###########MODIFIER PARTICIPANT#################

	@RequestMapping(value = "/afficheUpdate", method = RequestMethod.GET)
	public ModelAndView afficheModifParticipant() {

		return new ModelAndView("participantModifier", "partModif", new Participant());
	}

	// La méthode pour soumettre le formulaire en Post

	@RequestMapping(value = "/soumettreUpdate", method = RequestMethod.POST)
	public String soumettreFormPartM(Model modele, @ModelAttribute("partModif") Participant p) {

		// appel de la methode service
		Participant pOut = participantService.updateParticipant(p);

		if (pOut != null) {
			// rediriger vers la méthode afficheListe
			return "redirect:liste";
		} else {
			// rediriger vers la méthode afficheAjout
			return "redirect:afficheUpdate";
		}

	}

	// ##########RECHERCHE PARTICIPANT##########""

	// La methode pour afficher le formulaire en GET

	@RequestMapping(value = "/afficheRechercheId", method = RequestMethod.GET)
	public String afficheRecherchePart(Model modele) {
		modele.addAttribute("partRech", new Participant());
		modele.addAttribute("indice", false);
		return "rechercheParticipant";
	}

	// La méthode pour soumettre le formulaire en Post

	@RequestMapping(value = "/soumettreRechId", method = RequestMethod.POST)
	public String soumettreRecherche(RedirectAttributes ra, Model modele, @ModelAttribute("partRech") int pId) {

		// appel de la methode service
		Participant pOut = participantService.getParticipantById(pId);

		if (pOut != null) {
			modele.addAttribute("part", pOut);
			modele.addAttribute("indice", true);
			return "rechercheParticipant";
		} else {
			// affichage message
			ra.addFlashAttribute("message", "Participant inexistante");

			return "redirect:afficheRechercheId";
		}
	}

	// ##########RECHERCHE Participants par reservation##########""

	// La methode pour afficher le formulaire en GET

	@RequestMapping(value = "/afficheRechercheResa", method = RequestMethod.GET)
	public String afficheRecherchePartResa(Model modele) {
		modele.addAttribute("PartRechResa", new Participant());
		modele.addAttribute("indice", false);
		return "rechercheParticipantResa";
	}

	// La méthode pour soumettre le formulaire en Post

	@RequestMapping(value = "/soumettreRechResa", method = RequestMethod.POST)
	public String soumettreRechercheResa(RedirectAttributes ra, Model modele,
			@ModelAttribute("PartRechResa") int idResa) {

		// appel de la methode service
		List<Participant> listeP = participantService.getParticipantsByReservation(idResa);

		if (listeP != null) {
			modele.addAttribute("listePart", listeP);
			modele.addAttribute("indice", true);
			return "rechercheParticipantResa";
		} else {
			// affichage message
			ra.addFlashAttribute("message", "participant inexistant");

			return "redirect:afficheRechercheResa";
		}
	}

}
