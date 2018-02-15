package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequestMapping("/boVoyage")
public class BoVoyageController {

	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String afficheAccueil() {
		return "accueil";
	}

	@RequestMapping(value = "/agent/accueil", method = RequestMethod.GET)
	public String afficheAccueilAgent(Model model) {
		// recuperer le context de spring security
		Authentication authAgent = SecurityContextHolder.getContext().getAuthentication();

		// recupération de l'identifiant de l'utilisateur connecté
		String mail = authAgent.getName();
		model.addAttribute("msg", "Accueil de l'Agent " + mail);

		return "accueilAgent";
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
