package fr.adaming.controllers;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.mail.smtp.SMTPTransport;

import fr.adaming.model.Client;
import fr.adaming.model.Role;
import fr.adaming.service.IClientService;
import fr.adaming.service.IRoleService;

@Controller
@RequestMapping("/agent/client")
public class ClientController {

	@Autowired
	private IClientService clientService;
	@Autowired
	private IRoleService roleService;

	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public ModelAndView afficheListeClient() {
		// récupérer la liste de la bd
		List<Client> liste = clientService.getAllClient();
		return new ModelAndView("clientListe", "clientList", liste);
	}

	// Supprimer avec le lien
	@RequestMapping(value = "/supprimLien", method = RequestMethod.GET)
	public String suprimerLienClient(Model model, @RequestParam("pId") int id) {

		// appel de la méthode service
		clientService.deleteClient(id);

		return "redirect:liste";

	}

	@RequestMapping(value = "/ModifLien", method = RequestMethod.GET)
	public String modifClientLien(Model model, @RequestParam("pId") int id) {

		Client clientOut = clientService.getClientById(id);
		model.addAttribute("clientModif", clientOut);

		return "clientModifier";
	}

	@RequestMapping(value = "/ModifLien2", method = RequestMethod.GET)
	public String modifClientLien2(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String mail = auth.getName();
		Client clientOut = clientService.getClientByMail(mail);

		model.addAttribute("clientModif", clientOut);

		return "clientModifier";
	}

	@RequestMapping(value = "/EnvoiFormulaire", method = RequestMethod.GET)
	public String envoiFormClient(Model model, @RequestParam("pId") int id)
			throws AddressException, MessagingException {

		Client clientOut = clientService.getClientById(id);

		model.addAttribute("clientModif", clientOut);

		System.out.println("#######test envoi Mail############" + clientOut.getNom());

		Properties props = System.getProperties();
		props.put("mail.smtps.host", "smtp.gmail.com");
		props.put("mail.smtps.auth", "true");
		Session session = Session.getInstance(props, null);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("application.j2ee@gmail.com"));
		;
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(clientOut.getMail(), false));
		msg.setSubject("BoVoyage44 - Formulaire de satisfaction ");

		msg.setText(
				"Bonjour, vous avez récemment effectué un voyage via notre agence. Afin de nous aider à offrir la meilleure prestation à nos clients, votre expérience nous intéresse. \n "
						+ "Voici un formulaire de satisfaction, qui ne vous prendra que 3 minutes!  "
						+ "http://localhost:8080/BoVoyage44/notes/afficheAdd " + "\n Merci de votre participation !");

		SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
		t.connect("smtp.gmail.com", "application.j2ee@gmail.com", "adamingintijee");
		t.sendMessage(msg, msg.getAllRecipients());
		System.out.println("Mail envoyé");
		t.close();

		return "redirect:liste";
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
		System.out.println("#######test ajout client############" + c);

		// Activation du client
		c.setActive(true);
		Client cOut = clientService.addClient(c);

		// Création du Role client et set du role au client cOut
		Role role = new Role("ROLE_CLIENT");
		role.setClient(cOut);
		roleService.addRole(role);

		if (cOut.getId() != 0) {

			return "redirect:../../boVoyage/accueil";
		} else {

			return "redirect:afficheAdd";
		}

	}

	// ################ SUPPRESSION CLIENT #############

	@RequestMapping(value = "/afficheDelete", method = RequestMethod.GET)
	public String afficheSupprClient(Model modele) {
		modele.addAttribute("clientSuppr", new Client());
		return "clientSupprimer";
	}

	@RequestMapping(value = "/soumettreSupprClient", method = RequestMethod.POST)
	public String soumettreFormSupprClient(Model model, @ModelAttribute("clientSuppr") Client c) {
		int verif = clientService.deleteClient(c.getId());

		if (verif != 0) {
			return "redirect:liste";
		} else {

			return "redirect:afficheDelete";
		}

	}

	// ###########MODIFIER CLIENT#################

	@RequestMapping(value = "/afficheUpdate", method = RequestMethod.GET)
	public String afficheModifClient(Model modele) {
		modele.addAttribute("clientModif", new Client());
		return "clientModifier";

	}

	// La méthode pour soumettre le formulaire en Post

	@RequestMapping(value = "/soumettreUpdate", method = RequestMethod.POST)
	public String soumettreFormClientM(Model modele, @ModelAttribute("clientModif") Client c) {

		// appel de la methode service
		Client cOut = clientService.updateClient(c);

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
		return "clientRechercher";
	}

	// La méthode pour soumettre le formulaire en Post

	@RequestMapping(value = "/soumettreRechId", method = RequestMethod.POST)
	public String soumettreRecherche(RedirectAttributes ra, Model modele, @ModelAttribute("clientRech") Client c) {

		// appel de la methode service
		Client cOut = clientService.getClientById(c.getId());

		if (cOut != null) {
			modele.addAttribute("client", cOut);
			modele.addAttribute("indice", true);
			return "clientRechercher";
		} else {
			// affichage message
			ra.addFlashAttribute("message", "Client inexistant");

			return "redirect:afficheRechercheId";
		}
	}

	// ##########RECHERCHE CLIENT par reservation##########""

	// La methode pour afficher le formulaire en GET

	@RequestMapping(value = "/afficheRechercheResa", method = RequestMethod.GET)
	public String afficheRechercheClientResa(Model modele) {
		modele.addAttribute("clientRechResa", new Client());
		modele.addAttribute("indice", false);
		return "clientRechercherResa";
	}

	// La méthode pour soumettre le formulaire en Post

	@RequestMapping(value = "/soumettreRechResa", method = RequestMethod.POST)
	public String soumettreRechercheResa(RedirectAttributes ra, Model modele,
			@ModelAttribute("clientRechResa") int idResa) {

		// appel de la methode service
		Client cOut = clientService.getClientByReservation(idResa);

		if (cOut != null) {
			modele.addAttribute("client", cOut);
			modele.addAttribute("indice", true);
			return "clientRechercherResa";
		} else {
			// affichage message
			ra.addFlashAttribute("message", "Client inexistant");

			return "redirect:afficheRechercheResa";
		}
	}

}
