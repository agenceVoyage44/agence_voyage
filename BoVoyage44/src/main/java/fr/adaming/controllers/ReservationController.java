package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Reservation;
import fr.adaming.service.IReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private IReservationService reservationService;

	public void setReservationService(IReservationService reservationService) {
		this.reservationService = reservationService;
	}

	// ---------------------------Ajouter une Reservation -------------
	// Pour afficher le formulaire
	@RequestMapping(value = "/afficherAjout", method = RequestMethod.GET)
	public ModelAndView afficherAjouterReservation() {

		return new ModelAndView("ajouterReservation", "resaAjout", new Reservation());
	}

	// Pour soumettre le formulaire
	@RequestMapping(value = "/soumettreAjout", method = RequestMethod.POST)
	public String soumettreAjoutEtudiant(@ModelAttribute("resaAjout") Reservation reservation) {

		Reservation rOut = reservationService.addReservation(reservation);

		if (rOut.getId() != 0) {

			return "redirect:liste";
		} else {
			return "redirect:afficherAjout";
		}

	}

	// ---------------------------Modifier une Reservation -------------
	// Pour afficher le formulaire
	@RequestMapping(value = "/afficherModif", method = RequestMethod.GET)
	public ModelAndView afficherModifierReservation() {
		return new ModelAndView("modifierReservation", "resaModif", new Reservation());
	}

	// Pour soumettre le formulaire
	@RequestMapping(value = "/soumettreModif", method = RequestMethod.POST)
	public String soumettreModifReservation(@ModelAttribute("resaModif") Reservation reservation) {

		Reservation rOut = reservationService.updateReservation(reservation);
		

		if (rOut.getId() != 0) {

			return "redirect:liste";
		} else {
			return "redirect:afficherModif";
		}
	}
	
	
	// ---------------------------Rechercher une Reservation -------------
	
	
	
}
