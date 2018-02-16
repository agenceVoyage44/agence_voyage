package fr.adaming.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sun.mail.smtp.SMTPTransport;

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

	@RequestMapping(value = "/client/afficherAdd", method = RequestMethod.GET)
	public String afficherAjouterReservation(Model modele, @RequestParam("pID") int idVoyage) {

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
			ra.addFlashAttribute("message","Vous avez déjà une reservation");
			return "reservationAjouter";
		}

	}

	// ---------------------------Modifier une Reservation -------------
	// Modification de l'agent (Seulement le statut
	@RequestMapping(value = "/agent/afficherUpdate", method = RequestMethod.GET)
	public String afficherModifierReservationAgent(Model modele, @RequestParam("pId") int idResa) {
		System.out.println("----------je suis dans get");
		Reservation rOut = reservationService.getReservationByID(idResa);
		modele.addAttribute("resaUpdateA", rOut);
		System.out.println("---------modele : " + modele);
		return "reservationModifierAgent";
	}

	@RequestMapping(value = "/agent/soumettreUpdate", method = RequestMethod.POST)
	public String soumettreModifReservationAgent(@ModelAttribute("resaUpdateA") Reservation reservation)
			throws AddressException, FileNotFoundException, MalformedURLException, MessagingException, IOException,
			DocumentException {
		System.out.println("----------je suis dans post");

		Reservation rOut = reservationService.getReservationByID(reservation.getId());
		System.out.println("--------reservation : " + reservation);
		System.out.println("--------reservation getID : " + reservation.getId());
		System.out.println("--------rOut : " + rOut);
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
	public String soumettreModifReservation(@ModelAttribute("resaUpdateC") Reservation reservation)
			throws AddressException, FileNotFoundException, MalformedURLException, MessagingException, IOException,
			DocumentException {

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

		Client cRes = clientService.getClientByReservation(rOut.getId());
		List<Participant> listePart = participantService.getParticipantsByReservation(rOut.getId());
		Reservation rOut2 = reservationService.updateReservation(rOut);
		Document document = new Document();

		try {

			PdfWriter.getInstance(document, new FileOutputStream(
					"C:/PDF_BoVoyage/Reservation_voyage_" + rOut2.getId() + ".pdf"));

			document.open();
			Font font = new Font(Font.HELVETICA, 14, Font.BOLD, Color.RED);

			Image image = Image.getInstance("C:/PDF_BoVoyage/logo.png");

			image.scalePercent((float) 10);
			System.out.println("---------------" + cRes);
			document.add(image);
			document.add(new Paragraph(" "));
			document.add(new Paragraph("N° de client : " + cRes.getId()));
			document.add(new Paragraph("Nom : " + cRes.getCivilite() + " " + cRes.getNom() + " " + cRes.getPrenom()));
			document.add(new Paragraph("E-mail : " + cRes.getMail()));
			document.add(new Paragraph("Adresse : " + cRes.getNumero() + " " + cRes.getRue() + " "
					+ cRes.getCodePostal() + " " + cRes.getVille() + " " + cRes.getPays()));
			document.add(new Paragraph("N° de téléphone : " + cRes.getTel()));
			document.add(new Paragraph("Date de naissance : " + cRes.getDateNaissance()));
			document.add(new Paragraph("Date de la réservation : " + rOut2.getDateReservation()));

			document.add(new Paragraph(" "));

			Paragraph para = new Paragraph("Description de votre voyage : ", font);
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);

			document.add(new Paragraph(" "));
			//
			//
			PdfPTable table = new PdfPTable(5);
			////
			//// //On créer l'objet cellule.
			PdfPCell cell;
			////
			Font font2 = new Font(Font.HELVETICA, 13, Font.BOLD, Color.BLACK);
			Phrase phrase = new Phrase("Récapitulatif de votre voyage", font2);

			cell = new PdfPCell(phrase);
			cell.setColspan(5);
			table.addCell(cell);
			//
			table.addCell("Destination");
			table.addCell("Nombre de places réservées");
			table.addCell("Date de départ");
			table.addCell("Date de retour");
			table.addCell("Prix");

			//
			table.addCell(rOut2.getVoyage().getPays());
			table.addCell(Integer.toString(rOut2.getNbPlaceReservees()));
			table.addCell(rOut2.getVoyage().getDateDepart().toString());
			table.addCell(rOut2.getVoyage().getDateRetour().toString());
			table.addCell(Double.toString(rOut2.getPrix()) + " €");

			document.add(table);

			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));

			PdfPTable table2 = new PdfPTable(4);

			Phrase phrase2 = new Phrase("Voyageurs :", font2);

			cell = new PdfPCell(phrase2);
			cell.setColspan(4);
			table2.addCell(cell);
			//
			table2.addCell("Nom");
			table2.addCell("Date de naissance");
			table2.addCell("Adresse");
			table2.addCell("N° de téléphone");

			for (int i = 0; i < listePart.size(); i++) {
				table2.addCell(listePart.get(i).getCivilite() + " " + listePart.get(i).getNom() + " "
						+ listePart.get(i).getPrenom());
				table2.addCell(listePart.get(i).getDateNaissance().toString());
				table2.addCell(listePart.get(i).getNumero() + " " + listePart.get(i).getRue() + " "
						+ listePart.get(i).getCodePostal() + " " + listePart.get(i).getVille());
				table2.addCell(Integer.toString(listePart.get(i).getTel()));
			}

			document.add(table2);

			System.out.println("pdf cree");
		} catch (DocumentException e) {

			System.err.println(e);
		} finally {

			document.close();

		}
		// document.close();

		// Envoi du mail contenant le pdf
		System.out.println("############test mail#############");

		Properties props = System.getProperties();
		props.put("mail.smtps.host", "smtp.gmail.com");
		props.put("mail.smtps.auth", "true");
		Session session = Session.getInstance(props, null);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("application.j2ee@gmail.com"));
		;
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(cRes.getMail(), false));
		msg.setSubject("BoVoyage44 - Votre réservation est validée");
		msg.setSentDate(new Date());

		String message="Votre réservation effectuée le " + rOut2.getDateReservation().toString() + " pour partir en "
				+ rOut2.getVoyage().getPays() + " du " + rOut2.getVoyage().getDateDepart().toString() + " au "
				+ rOut2.getVoyage().getDateRetour().toString()
				+ " est validée. L'équipe de BoVoyage44 vous souhaite un bon voyage !";
		msg.setText(message);
		
		System.out.println(message);
		
		Multipart multipart = new MimeMultipart();
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText(message);
		

		DataSource source = new FileDataSource(
				"C:/PDF_BoVoyage/Reservation_voyage_" + rOut2.getId() + ".pdf");
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName("reservation_" + rOut2.getId() + ".pdf");
		multipart.addBodyPart(messageBodyPart);
		msg.setContent(multipart);

		SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
		t.connect("smtp.gmail.com", "application.j2ee@gmail.com", "adamingintijee");
		t.sendMessage(msg, msg.getAllRecipients());
		System.out.println("Mail envoyé");
		t.close();
		// Reservation rOut2 = reservationService.updateReservation(rOut);

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
	public String soumettreFormPartA(RedirectAttributes ra, Model modele, @ModelAttribute("partAjout") Participant p)
			throws AddressException, FileNotFoundException, MalformedURLException, MessagingException, IOException,
			DocumentException {
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

			// On rajoute les places réservées de la réservation au nombre de
			// place dispo pour le voyage
			Voyage vOUt = reservation.getVoyage();
			vOUt.setNbPlaces(vOUt.getNbPlaces() + reservation.getNbPlaceReservees());
			voyageService.updateVoyage(vOUt);
		} else {
			Participant part = participantService.getParticipantIDResa(reservation.getId());
			participantService.deleteParticipant(part.getId());
			// On rajoute les places réservées de la réservation au nombre de
			// place dispo pour le voyage
			Voyage vOUt = reservation.getVoyage();
			vOUt.setNbPlaces(vOUt.getNbPlaces() + reservation.getNbPlaceReservees());
			voyageService.updateVoyage(vOUt);
		}

		// appel de la methode service
		reservationService.deleteReservation(id);

		Reservation resa = reservationService.getReservationByID(id);

		model.addAttribute("resa", null);

		return "reservationListeClient";

	}


}
