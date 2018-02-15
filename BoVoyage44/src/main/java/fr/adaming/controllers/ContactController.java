package fr.adaming.controllers;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.mail.smtp.SMTPTransport;

import fr.adaming.model.Client;


@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@RequestMapping(value = "/envoiMail", method = RequestMethod.GET)
	public ModelAndView afficheAjoutClient() {

		return new ModelAndView("userContact", "user", new Client());
	}

	// La méthode pour soumettre le formulaire en Post

	@RequestMapping(value = "/soumettreEnvoi", method = RequestMethod.POST)
	public String soumettreFormClientA(RedirectAttributes ra,Model modele, @ModelAttribute("user") Client c) throws AddressException, MessagingException {
		System.out.println("#######test envoi Mail############" + c.getNom());
		
		
		Properties props = System.getProperties();
		props.put("mail.smtps.host", "smtp.gmail.com");
		props.put("mail.smtps.auth", "true");
		Session session = Session.getInstance(props, null);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("application.j2ee@gmail.com"));
		;
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jegonday.solene@gmail.com", false));
		msg.setSubject("BoVoyage44 - Nouvelle demande d'informations ");
		msg.setSentDate(new Date());

		msg.setText("Message de :"+c.getNom()+" "+c.getPrenom()+"\nMail "+ c.getMail()+"\nMessage :"+c.getRue());
		msg.setText("Mail "+ c.getMail());
		msg.setText(c.getRue());

		SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
		t.connect("smtp.gmail.com", "application.j2ee@gmail.com", "adamingintijee");
		t.sendMessage(msg, msg.getAllRecipients());
		System.out.println("Mail envoyé");
		t.close();

		ra.addFlashAttribute("message", "Message envoyé !");
		
		return "userContact";

	}

}
