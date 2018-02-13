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
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/agent/client")
public class ClientController {
	
	@Autowired
	private IClientService clientService;
	
	
	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public ModelAndView afficheListeClient() {
		// récupérer la liste de la bd
		List<Client> liste = clientService.getAllClient();
		return new ModelAndView("clientListe", "clientList", liste);
	}

	// ##############AJOUT CLIENT######################

	// La methode pour afficher le formulaire en GET

	@RequestMapping(value = "/afficheAdd", method = RequestMethod.GET)
	public ModelAndView afficheAjoutClient() {

		return new ModelAndView("clientAjouter", "clientAjout", new Client());
	}

	// La méthode pour soumettre le formulaire en Post

	@RequestMapping(value = "/soumettreAdd", method = RequestMethod.POST)
	public String soumettreFormClientA(Model modele, @ModelAttribute("clientAjout") Client c) {

		// appel de la methode service
		Client cOut = clientService.addClient(c);

		if (cOut.getId() != 0) {
		
			return "redirect:liste";
		} else {
		
			return "redirect:afficheAdd";
		}

	}

	// ################ SUPPRESSION CLIENT #############

	@RequestMapping(value = "/afficheDelete", method = RequestMethod.GET)
	public ModelAndView afficheSupprClient() {
		return new ModelAndView("clientSupprimer", "clientSuppr", new Client());
	}

	@RequestMapping(value = "/soumettreSupprClient", method = RequestMethod.POST)
	public String soumettreFormSupprClient(Model model, @RequestParam("pId") int id) {
		int verif = clientService.deleteClient(id);

		if (verif != 0) {
			return "redirect:liste";
		} else {

			return "redirect:afficheDelete";
		}

	}

	// ###########MODIFIER CLIENT#################

	@RequestMapping(value = "/afficheUpdate", method = RequestMethod.GET)
	public ModelAndView afficheModifClient() {

		return new ModelAndView("clientModifier", "clientModif", new Client());
	}

	// La méthode pour soumettre le formulaire en Post

	@RequestMapping(value = "/soumettreUpdate", method = RequestMethod.POST)
	public String soumettreFormClientM(Model modele, @ModelAttribute("clientModif") Client c) {

		// appel de la methode service
		Client cOut=clientService.updateClient(c);

		if (cOut != null) {
		
			return "redirect:liste";
		} else {
	
			return "redirect:afficheUpdate";
		}

	}

	// ##########RECHERCHE CLIENT##########""

	// La methode pour afficher le formulaire en GET

	@RequestMapping(value = "/afficheRechercheId", method = RequestMethod.GET)
	public String afficheRechercheClient(Model modele) {
		modele.addAttribute("clientRech", new Client());
		modele.addAttribute("indice", false);
		return "rechercheClient";
	}

	// La méthode pour soumettre le formulaire en Post

	@RequestMapping(value = "/soumettreRechId", method = RequestMethod.POST)
	public String soumettreRecherche(RedirectAttributes ra, Model modele, @ModelAttribute("clientRech") int pId) {

		// appel de la methode service
		Client cOut=clientService.getClientById(pId);

		if (cOut != null) {
			modele.addAttribute("client", cOut);
			modele.addAttribute("indice", true);
			return "rechercheClient";
		} else {
			// affichage message
			ra.addFlashAttribute("message", "Client inexistante");

			return "redirect:afficheRechercheId";
		}
	}

	// ##########RECHERCHE CLIENT par reservation##########""

		// La methode pour afficher le formulaire en GET

		@RequestMapping(value = "/afficheRechercheResa", method = RequestMethod.GET)
		public String afficheRechercheClientResa(Model modele) {
			modele.addAttribute("clientRechResa", new Client());
			modele.addAttribute("indice", false);
			return "rechercheClientResa";
		}

		// La méthode pour soumettre le formulaire en Post

		@RequestMapping(value = "/soumettreRechResa", method = RequestMethod.POST)
		public String soumettreRechercheResa(RedirectAttributes ra, Model modele, @ModelAttribute("clientRechResa") int idResa) {

			// appel de la methode service
			Client cOut=clientService.getClientByReservation(idResa);

			if (cOut != null) {
				modele.addAttribute("client", cOut);
				modele.addAttribute("indice", true);
				return "rechercheClientResa";
			} else {
				// affichage message
				ra.addFlashAttribute("message", "Client inexistant");

				return "redirect:afficheRechercheResa";
			}
		}


}
