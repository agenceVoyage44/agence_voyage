package fr.adaming.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Assurance;
import fr.adaming.model.Formule;
import fr.adaming.model.Hebergement;
import fr.adaming.model.Participant;
import fr.adaming.model.Reservation;
import fr.adaming.service.IAssuranceService;
import fr.adaming.service.IParticipantService;
import fr.adaming.service.IReservationService;

/**
 * Controller pour tous les objets de type Reservation
 */

@Controller
@RequestMapping("/boVoyage/reservation")
public class ReservationController {

	@Autowired
	private IReservationService reservationService;

	private IAssuranceService assuranceService;

	private IParticipantService particpantService;

	public void setReservationService(IReservationService reservationService) {
		this.reservationService = reservationService;
	}

	public void setAssuranceService(IAssuranceService assuranceService) {
		this.assuranceService = assuranceService;
	}

	public void setParticpantService(IParticipantService particpantService) {
		this.particpantService = particpantService;
	}

	// ---------------------------Ajouter une Reservation -------------
	/**
	 * Méthode pour afficher le formulaire
	 * 
	 * @return ModelAndView
	 * 
	 */
	@RequestMapping(value = "/client/afficherAdd", method = RequestMethod.GET)
	public String afficherAjouterReservation(Model modele) {

		modele.addAttribute("resaAdd", new Reservation());

		// Récupérer la liste de toutes les assurances possibles
		List<Assurance> listeAssurance = assuranceService.getAllAssurance();

		modele.addAttribute("listeAssurance", listeAssurance);

		return "reservationAjouter";

	}

	/**
	 * Méthode pour afficher le formulaire
	 * 
	 * @param Reservation
	 * @return String redirection page
	 */
	@RequestMapping(value = "/client/soumettreAdd", method = RequestMethod.POST)
	public String soumettreAjoutEtudiant(@ModelAttribute("resaAdd") Reservation reservation) {
		reservation.setStatut("en cours de traitement");
		reservation.setDateReservation(new Date());

		long dateResaMilliSec = reservation.getDateReservation().getTime();
		long age12Ans = 378691200000l;

		List<Participant> listeParticipant = particpantService.getAllParticpantIDResaNULL();

		double prixEnfant;
		double prixTotal = 0;

		// ----- Calcul Prix Voyage (avec/sans Formule, avec/sans assurances)
		// -----
		// Si le voyage de la réservatio présente une formule
		if (reservation.getVoyage().getFormule() != null) {
			double prixVoyageFormule = reservation.getVoyage().getFormule().getPrix();

			// si des particpant ont moins de 12 ans
			for (Participant element : listeParticipant) {
				Date dateNaissance = element.getDateNaissance();
				long dateNaissanceMilliSec = dateNaissance.getTime();
				if (dateResaMilliSec - dateNaissanceMilliSec <= age12Ans) {
					prixEnfant = prixVoyageFormule - (prixVoyageFormule * 0.6);
					prixTotal += prixEnfant;
				} else { // Pour les adultes
					prixTotal += prixVoyageFormule;
				}
			}

			// s'il y a une ou plusieurs assurances
			if (reservation.getAssurance() != null) {
				double prixAssurance = reservation.getAssurance().getPrix();

				// Le prix de la réservation est le prix de la formule et le
				// prix de/des assurance/s
				reservation.setPrix(prixTotal + prixAssurance);
			} else {
				// Le prix de la réservation est seulement celui de la formule
				reservation.setPrix(prixTotal);
				;
			}

		} else {
			// Prix du voyage seul
			double prixVoyageSeul = reservation.getVoyage().getPrixSolde();

			// si des particpant ont moins de 12 ans
			for (Participant element : listeParticipant) {
				Date dateNaissance = element.getDateNaissance();
				long dateNaissanceMilliSec = dateNaissance.getTime();
				if (dateResaMilliSec - dateNaissanceMilliSec <= age12Ans) {
					prixEnfant = prixVoyageSeul - (prixVoyageSeul * 0.6);
					prixTotal += prixEnfant;
				} else { // Pour les adultes
					prixTotal += prixVoyageSeul;
				}
			}

			// S'il y a une ou plusieurs assurances
			if (reservation.getAssurance() != null) {
				double prixAssurance = reservation.getAssurance().getPrix();

				// Prix de la réservation
				reservation.setPrix(prixTotal + prixAssurance);

			} else {
				// Si ni assurance ni formule
				reservation.setPrix(prixTotal);
			}
		}

		Reservation rOut = reservationService.addReservation(reservation);

		// Donner l'id de la réservation aux particpants
		for (Participant element : listeParticipant) {
			element.setReservation(reservation);
		}

		if (rOut.getId() != 0) {

			return "redirect:liste";
		} else {
			return "redirect:afficherAdd";
		}

	}

	// ---------------------------Modifier une Reservation -------------
	// Modification de l'agent (Seulement le statut
	/**
	 * Méthode pour afficher le formulaire
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/agent/afficherUpdate", method = RequestMethod.GET)
	public ModelAndView afficherModifierReservationAgent() {
		return new ModelAndView("reservationModifierAgent", "resaUpdateA", new Reservation());
	}

	/**
	 * Méthode pour soumettre le formulaire
	 * 
	 * @param Reservation
	 * @return String redirection page
	 */
	@RequestMapping(value = "/agent/soumettreUpdate", method = RequestMethod.POST)
	public String soumettreModifReservationAgent(@ModelAttribute("resaUpdateA") Reservation reservation) {
		Reservation rOut = reservationService.updateReservation(reservation);

		if (rOut.getId() != 0) {

			return "redirect:liste";
		} else {
			return "redirect:afficherUpdate";
		}
	}

	// Modification du client (Formule, Voyage, Assurance, NbrPlace)
	/**
	 * Méthode pour afficher le formulaire
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/client/afficherUpdate", method = RequestMethod.GET)
	public ModelAndView afficherModifierReservationClient() {
		return new ModelAndView("reservationModifierClient", "resaUpdateC", new Reservation());
	}

	/**
	 * Méthode pour soumettre le formulaire
	 * 
	 * @param Reservation
	 * @return String redirection page
	 */
	@RequestMapping(value = "/client/soumettreUpdate", method = RequestMethod.POST)
	public String soumettreModifReservation(@ModelAttribute("resaUpdateC") Reservation reservation) {
		reservation.setDateReservation(new Date());

		// ------Recalul du PRIX selon Formule Voyage Assurance----------

		Reservation rOut = reservationService.updateReservation(reservation);

		if (rOut.getId() != 0) {

			return "redirect:listeReservation";
		} else {
			return "redirect:afficherUpdate";
		}
	}

	// ---------------------------Supprimer une Reservation -------------
	// Pour l'agent
	/**
	 * Methode pour afficher le formualire
	 * 
	 * @return ModelAndView prend en compte un objet Reservation dans un model
	 *         attribute resaDelete, et redirige vers la page
	 *         reservationSupprimer
	 */
	@RequestMapping(value = "/agent/afficherDelete", method = RequestMethod.GET)
	public ModelAndView afficheSupprimerReservationAgent() {
		return new ModelAndView("reservationSupprimerAgent", "resaDeleteA", new Reservation());
	}

	/**
	 * Méthode pour soumettre le formulaire
	 * 
	 * @param ra
	 *            lors de la redirectionn les objets dans ra seront pris en
	 *            compte
	 * @param modele
	 *            pour transmetre l'objet Reservation à la méthode afficher
	 * @param reservation
	 *            de type Reservation
	 * @return String pour la redirection
	 */
	@RequestMapping(value = "/agent/soumettreDelete", method = RequestMethod.POST)
	public String soumettreSupprimerReservationAgent(RedirectAttributes ra, Model modele,
			@ModelAttribute("resaDeleteA") Reservation reservation) {

		// Appel de la méthode
		int verif = reservationService.deleteReservation(reservation.getId());

		if (verif != 0) {
			ra.addFlashAttribute("message", "La Reservation a été supprimée");
			return "redirect:liste";
		} else {
			ra.addFlashAttribute("message", "La Reservation n'a pas été supprimée");
			return "redirect:afficherDelete";
		}

	}

	// Pour le client
	@RequestMapping(value = "/client/afficherDelete", method = RequestMethod.GET)
	public ModelAndView afficheSupprimerReservationClient() {
		return new ModelAndView("reservationSupprimerClient", "resaDeleteC", new Reservation());
	}

	@RequestMapping(value = "/client/soumettreDelete", method = RequestMethod.POST)
	public String soumettreSupprimerReservationClient(RedirectAttributes ra, Model modele,
			@ModelAttribute("resaDeleteC") Reservation reservation) {

		// Appel de la méthode
		int verif = reservationService.deleteReservation(reservation.getId());

		if (verif != 0) {
			ra.addFlashAttribute("message", "La Reservation a été supprimée");
			return "redirect:listeReservation";
		} else {
			ra.addFlashAttribute("message", "La Reservation n'a pas été supprimée");
			return "redirect:afficherDelete";
		}

	}

	// ---------------------------Rechercher une Reservation -------------

	/**
	 * Méthode pourafficher le formulaire
	 * 
	 * @param modele
	 *            avec deux objets, un de type Reservation et un second de type
	 *            oolean
	 * @return String pour la redirection
	 */
	@RequestMapping(value = "/agent/afficherGet", method = RequestMethod.GET)
	public String afficheRechercheReservation(Model modele) {
		modele.addAttribute("resaGet", new Reservation());
		modele.addAttribute("indice", false);
		return "reservationRechercher";

	}

	/**
	 * Méthode pour soumettre un formualire
	 * 
	 * @param ra
	 *            lors de la redirectionn les objets dans ra seront pris en
	 *            compte
	 * @param modele
	 *            pour transmetre l'objet Reservation à la méthode afficher
	 * @param reservation
	 *            de type Reservation
	 * @return String pour la redirection
	 */
	@RequestMapping(value = "/agent/soumettreGet", method = RequestMethod.POST)
	public String soumettreRechercheReservation(RedirectAttributes ra, Model modele,
			@ModelAttribute("resaGet") Reservation reservation) {

		// appel dela methode service
		Reservation rOut = reservationService.getReservationByID(reservation.getId());

		modele.addAttribute("resaGet", rOut);

		modele.addAttribute("indice", true);

		return "reservationRechercher";

	}

	// -------------- Liste des Resrvations -----------------
	/**
	 * Méthode pour afficher la liste
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/agent/liste", method = RequestMethod.GET)
	public ModelAndView afficherListeReservation() {
		List<Reservation> liste = reservationService.getAllReservation();
		return new ModelAndView("reservationListe", "resaListe", liste);
	}

}
