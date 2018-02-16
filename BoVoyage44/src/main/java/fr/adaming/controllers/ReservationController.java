package fr.adaming.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.sound.midi.Synthesizer;
import javax.swing.plaf.synth.SynthSpinnerUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itextpdf.text.pdf.qrcode.Mode;

import fr.adaming.model.Assurance;
import fr.adaming.model.Client;
import fr.adaming.model.Formule;
import fr.adaming.model.Hebergement;
import fr.adaming.model.Participant;
import fr.adaming.model.Reservation;
import fr.adaming.model.Voyage;
import fr.adaming.service.IAssuranceService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IParticipantService;
import fr.adaming.service.IReservationService;
import fr.adaming.service.IVoitureService;
import fr.adaming.service.IVoyageService;

/**
 * Controller pour tous les objets de type Reservation
 */

@Controller
@RequestMapping("/boVoyage/reservation")
public class ReservationController {

	@Autowired
	private IReservationService reservationService;

	@Autowired
	private IAssuranceService assuranceService;

	@Autowired
	private IParticipantService participantService;

	@Autowired
	private IClientService clientService;

	@Autowired
	private IVoyageService voyageService;

	public void setReservationService(IReservationService reservationService) {
		this.reservationService = reservationService;
	}

	public void setAssuranceService(IAssuranceService assuranceService) {
		this.assuranceService = assuranceService;
	}

	public void setParticpantService(IParticipantService participantService) {
		this.participantService = participantService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public void setVoyageService(IVoyageService voyageService) {
		this.voyageService = voyageService;
	}

	@InitBinder // Pour transformer la date reçue de la page en une date java
	public void dataBinding(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	// ---------------------------Ajouter une Reservation -------------
	/**
	 * Méthode pour afficher le formulaire
	 * 
	 * @return ModelAndView
	 * 
	 */

	@RequestMapping(value = "/client/afficherAdd/{pID}", method = RequestMethod.GET)
	public String afficherAjouterReservation(Model modele, @PathVariable("pID") int idVoyage) {

		Voyage voyage = new Voyage();
		Voyage vOut = voyageService.getVoyageById(idVoyage);
		System.out.println("-----------voyage : " + vOut);

		Reservation reservation = new Reservation();
		reservation.setVoyage(vOut);
		System.out.println("-------------reservation id voyage :" + reservation.getVoyage());

		modele.addAttribute("resaAdd", reservation);

		// Récupérer la liste de toutes les assurances possibles
		List<Assurance> liste = assuranceService.getAllAssurance();
		System.out.println("--------------------------" + liste);
		modele.addAttribute("listeAssurance", liste);

		return "reservationAjouter";

	}

	/**
	 * Méthode pour afficher le formulaire
	 * 
	 * @param Reservation
	 * @return String redirection page
	 * @throws IOException
	 * @throws MessagingException
	 * @throws MalformedURLException
	 * @throws FileNotFoundException
	 * @throws AddressException
	 */
	@RequestMapping(value = "/client/soumettreAdd", method = RequestMethod.POST)
	public String soumettreAjoutEtudiant(RedirectAttributes ra, @ModelAttribute("resaAdd") Reservation reservation)
			throws AddressException, FileNotFoundException, MalformedURLException, MessagingException, IOException {
		System.out.println("--------------dans la methode post ; " + reservation + " " + reservation.getVoyage());

		// recupération du client pour setter l'id reservation
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String mail = auth.getName();
		Client client = clientService.getClientByMail(mail);
		System.out.println("---------client : " + client);

		if (client.getReservation() == null) {
			reservation.setNbPlaceReservees(0);
			reservation.setStatut("non validé par " + client.getCivilite() + " " + client.getNom());
			reservation.setDateReservation(new Date());
			Reservation rOut = reservationService.addReservation(reservation);
			System.out.println("----------rOut : " + rOut);

			// Donner la réservation au client qui paye
			client.setReservation(rOut);
			Client clOut = clientService.updateClient(client);
			System.err.println("-----------client updaté : " + clOut);
			if (rOut.getId() != 0) {

				return "redirect:afficherAddPart";
			} else {
				return "redirect:afficherAdd";
			}
		} else {
			return "reservationAjouter";
		}

	}

	// ---------------------------Modifier une Reservation -------------
	// Modification de l'agent (Seulement le statut
	@RequestMapping(value = "/agent/afficherUpdate/{pId}", method = RequestMethod.GET)
	public String afficherModifierReservationAgent(Model modele, @PathVariable("pId") int idResa) {
		System.out.println("----------je suis dans get");
		Reservation rOut = reservationService.getReservationByID(idResa);
		modele.addAttribute("resaUpdateA", rOut);
		System.out.println("---------modele : " + modele);
		return "reservationModifierAgent";
	}

	@RequestMapping(value = "/agent/soumettreUpdate", method = RequestMethod.POST)
	public String soumettreModifReservationAgent(@ModelAttribute("resaUpdateA") Reservation reservation) {
		System.out.println("----------je suis dans post");

		Reservation rOut = reservationService.getReservationByID(reservation.getId());
		reservationService.updateReservation(rOut);

		if (rOut.getId() != 0) {

			List<Reservation> listeResa = reservationService.getAllReservation();
			for (Reservation element : listeResa) {
				if (element.getStatut() == "Validée") {
					if (element.getNbPlaceReservees() > 1) {
						// suppression de tous les participants (avant la
						// reservation car FK)
						List<Participant> listeParticipant = participantService
								.getParticipantsByReservation(element.getId());
						for (Participant part : listeParticipant) {
							participantService.deleteParticipant(part.getId());
						}
					} else {
						Participant participant = participantService.getParticipantIDResa(element.getId());
						participantService.deleteParticipant(participant.getId());
					}
					// Puis suppression de la reservation
					reservationService.deleteReservation(element.getId());
				}
			}

			return "redirect:liste";
		} else {
			return "redirect:afficherUpdate";
		}
	}

	// ---------------------- Modification par le CLient --------------------
	// ------------ modifier(lien)-------------
	@RequestMapping(value = "/client/modifierLien", method = RequestMethod.GET)
	public String modifielienC(Model modele, @RequestParam("pId") int id) {

		Reservation reservation = new Reservation();
		reservation.setId(id);

		// recup resa de la bd
		Reservation rOut = reservationService.getReservationByID(id);
		System.err.println("-----------rOUt :" + rOut);
		modele.addAttribute("resaUpdateC", rOut);

		// Récupérer la liste de toutes les assurances possibles
		List<Assurance> liste = assuranceService.getAllAssurance();
		System.out.println("--------------------------" + liste);
		modele.addAttribute("listeAssurance", liste);

		// Prix Maximal du voyage selon nombre participant/formule/assurance
		double prixMax = rOut.getAssurance().getPrix() + (rOut.getNbPlaceReservees() * rOut.getVoyage().getPrixSolde());
		System.out.println("----------prix%ax:" + prixMax);
		modele.addAttribute("prixMax", prixMax);

		System.out.println("-------------modele :" + modele);

		return "reservationModifierClient";
	}

	@RequestMapping(value = "/client/soumettreUpdate", method = RequestMethod.POST)
	public String soumettreModifReservation(@ModelAttribute("resaUpdateC") Reservation reservation) {

		Reservation rOut = reservationService.getReservationByID(reservation.getId());
		System.out.println("----------------rOut : " + rOut);
		System.err.println("-----------------dans la methode soumettre update controller");

		// recupération du client pour setter l'id reservation
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String mail = auth.getName();
		Client client = clientService.getClientByMail(mail);

		rOut.setStatut("Validé par " + client.getCivilite() + " " + client.getNom());

		// ------Recalul du PRIX selon Participant Voyage Assurance----------

		// System.out.println(("-------------------date resa :" +
		// rOut.getDateReservation()));
		// System.err.println("-----------------date voyage : " +
		// rOut.getVoyage().getDateDepart());

		long dateResaMilliSec = rOut.getDateReservation().getTime();
		long age12Ans = 378691200000l;

		System.out.println("-----------dateResa Millisec ; " + dateResaMilliSec);

		List<Participant> listeParticipant = participantService.getParticipantsByReservation(rOut.getId());
		System.out.println("--------------liste participant :" + listeParticipant);
		double prixEnfant;
		double prixTotal = 0;

		// si des particpant ont moins de 12 ans
		for (Participant element : listeParticipant) {
			Date dateNaissance = element.getDateNaissance();
			long dateNaissanceMilliSec = dateNaissance.getTime();
			System.out.println("------------------if dateNaissance en ms : " + dateNaissanceMilliSec);
			if (dateResaMilliSec - dateNaissanceMilliSec <= age12Ans) {
				prixEnfant = rOut.getVoyage().getPrixSolde() - (rOut.getVoyage().getPrixSolde() * 0.6);
				System.out.println("------if Prix Enfant :" + prixEnfant);

				prixTotal += prixEnfant;
				System.out.println("------if Prix Total :" + prixTotal);
			} else { // Pour les adultes
				prixTotal += rOut.getVoyage().getPrixSolde();
				System.err.println("----------- else Prix Total" + prixTotal);
			}
		}

		// s'il y a une assurance
		if (rOut.getAssurance() != null) {
			double prixAssurance = rOut.getAssurance().getPrix();

			rOut.setPrix(prixTotal + prixAssurance);
			System.out.println("--------------------Prix total setter : " + (prixTotal + prixAssurance));
		} else {
			rOut.setPrix(prixTotal);
			;
		}

		// validation de la réservation
		Reservation rOut2 = reservationService.updateReservation(rOut);

		if (rOut2.getId() != 0) {

			return "redirect:liste";
		} else {
			return "redirect:afficherUpdate";
		}
	}

	// // *****afficher le formulaire de modif*******
	// @RequestMapping(value = "/client/afficheUpdate", method =
	// RequestMethod.GET)
	// public String updateHeberg(Model modele) {
	// modele.addAttribute("resaUpdateC", new Reservation());
	//
	// return "reservationModifierClient";
	// }

	// ---------------------------Supprimer une Reservation -------------
	// --------------------------Agent--------------------
	@RequestMapping(value = "/agent/afficherDelete", method = RequestMethod.GET)
	public ModelAndView afficheSupprimerReservationAgent() {
		return new ModelAndView("reservationSupprimerAgent", "resaDeleteA", new Reservation());
	}

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

	// -------------------------Client---------------
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
	@RequestMapping(value = "/agent/afficherGet", method = RequestMethod.GET)
	public String afficheRechercheReservation(Model modele) {
		modele.addAttribute("resaGet", new Reservation());
		modele.addAttribute("indice", false);
		return "reservationRechercher";

	}

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
	// ---------------------Agent-----------------------------
	@RequestMapping(value = "/agent/liste", method = RequestMethod.GET)
	public ModelAndView afficherListeReservation() {
		List<Reservation> liste = reservationService.getAllReservation();
		return new ModelAndView("reservationListeAgent", "resaListe", liste);
	}

	// ----------------------Client----------------------------
	@RequestMapping(value = "/client/liste", method = RequestMethod.GET)
	public ModelAndView afficherListeReservationClient() {
		// recupération du client pour setter l'id reservation
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String mail = auth.getName();
		Client client = clientService.getClientByMail(mail);

		Reservation resa = reservationService.getReservationByID(client.getReservation().getId());
		return new ModelAndView("reservationListeClient", "resa", resa);
	}

	// ---------------AJOUT PARTICIPANT----------------
	// La methode pour afficher le formulaire en GET

	@RequestMapping(value = "/client/afficherAddPart", method = RequestMethod.GET)
	public ModelAndView afficheAjoutParticipant() {
		System.out.println("******************Je suis dans afficherAddPart");
		return new ModelAndView("participantAjouter", "partAjout", new Participant());
	}

	// La méthode pour soumettre le formulaire en Post
	@RequestMapping(value = "/client/soumettreAddPart", method = RequestMethod.POST)
	public String soumettreFormPartA(RedirectAttributes ra, Model modele, @ModelAttribute("partAjout") Participant p) {
		System.out.println("******************Je suis dans soumettreAddPart");
		// recupération du client pour setter l'id reservation
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String mail = auth.getName();
		Client client = clientService.getClientByMail(mail);
		System.out.println("***********Get client by authentification addPart : " + client);

		// Donner la réservation au nouveau participant
		p.setReservation(client.getReservation());

		// incrémenter le nombre de place reservées
		Reservation rOut = reservationService.getReservationByID(client.getReservation().getId());

		// int placeReservee = rOut.getNbPlaceReservees() + 1;
		// rOut.setNbPlaceReservees(placeReservee);
		// reservationService.updateReservation(rOut);

		int placeReservee = rOut.getNbPlaceReservees() + 1;
		if (rOut.getVoyage().getNbPlaces() >= placeReservee) {

			// appel de la methode service pour ajouter un Particpant
			p.setTypeP("part");
			Participant pOut = participantService.addParticipant(p);
			System.out.println("****************Participant pOut ajouté : " + pOut);

			rOut.setNbPlaceReservees(placeReservee);
			reservationService.updateReservation(rOut);
			Voyage vOut = rOut.getVoyage();
			vOut.setNbPlaces(rOut.getVoyage().getNbPlaces() - placeReservee);
			voyageService.updateVoyage(vOut);

			// rediriger vers la méthode afficheListe
			return "reservationParticipantAjouter";
		} else {
			// rediriger vers la méthode afficheAjout
			ra.addFlashAttribute("msg", "Il n'y a plus de places diponibles pour ce voyage");
			return "participantAjouter";
		}

	}

	// --------Lien Tableau Pour Supprimer la résa----------

	// ----------------supprime(client)------------------
	@RequestMapping(value = "/client/supprimeLien/{pId}", method = RequestMethod.GET)
	public String supprimerlienClient(Model model, @PathVariable("pId") int id) {

		Reservation reservation = new Reservation();
		reservation = reservationService.getReservationByID(id);

		// recupération du client pour
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String mail = auth.getName();
		Client client = clientService.getClientByMail(mail);

		client.setReservation(null);
		clientService.updateClient(client);

		if (reservation.getNbPlaceReservees() > 1) {
			// suppression de tous les participants
			List<Participant> listeParticipant = participantService.getParticipantsByReservation(id);
			System.out.println("---------------" + listeParticipant);
			for (Participant element : listeParticipant) {
				participantService.deleteParticipant(element.getId());
			}
		} else {
			Participant part = participantService.getParticipantIDResa(reservation.getId());
			participantService.deleteParticipant(part.getId());
		}

		// appel de la methode service
		reservationService.deleteReservation(id);

		Reservation resa = reservationService.getReservationByID(id);

		model.addAttribute("resa", null);

		return "reservationListeClient";

	}

}
