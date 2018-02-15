package fr.adaming.controllers;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.mail.smtp.SMTPTransport;

import fr.adaming.model.Client;
import fr.adaming.model.Notes;
import fr.adaming.service.IClientService;
import fr.adaming.service.INotesService;

@Controller
@RequestMapping("/notes")
public class NotesController {

	@Autowired
	private INotesService notesService;

	@Autowired
	private IClientService clientService;

	// ##############AJOUT Note######################

	// La methode pour afficher le formulaire en GET

	@RequestMapping(value = "/afficheAdd", method = RequestMethod.GET)
	public ModelAndView afficheAjoutNote() {

		return new ModelAndView("noteAjouter", "noteAjout", new Notes());
	}

	// La méthode pour soumettre le formulaire en Post

	@RequestMapping(value = "/soumettreAdd", method = RequestMethod.POST)
	public String soumettreFormNoteAjout(RedirectAttributes ra, Model modele, @ModelAttribute("noteAjout") Notes n) {
		System.out.println("#######test ajout note############" + n);
		// appel de la methode service
		Notes nOut = notesService.addNotes(n);

		if (nOut.getId() != 0) {
			ra.addFlashAttribute("message", "Formulaire envoyé. Merci de votre participation !");
			return "accueil";
		} else {
			ra.addFlashAttribute("message", "Problème d'envoi - Veuillez réessayer plus tard");
			return "redirect:afficheAdd";
		}

	}
	
	

}
