package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public ModelAndView afficheAjoutParticipant() {

			return new ModelAndView("participantAjouter", "partAjout", new Participant());
		}

		// La méthode pour soumettre le formulaire en Post

		@RequestMapping(value = "/soumettreAdd", method = RequestMethod.POST)
		public String soumettreFormR(Model modele, @ModelAttribute("partAjout") Participant p) {

			// appel de la methode service
			Participant pOut = participantService.addParticipant(p);

			if (pOut.getId() != 0) {
				// rediriger vers la méthode afficheListe
				return "redirect:liste";
			} else {
				// rediriger vers la méthode afficheAjout
				return "redirect:soumettreAdd";
			}

		}


}
