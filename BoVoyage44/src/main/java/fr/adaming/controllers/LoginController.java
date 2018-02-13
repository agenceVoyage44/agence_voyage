package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String afficheLogin() {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String SeDeconnecter() {
		return "accueil";
	}

	@RequestMapping(value = "/refus", method = RequestMethod.GET)
	public String accesRefuse() {
		return "pageDenied";
	}

	@RequestMapping(value = "/loginEchec", method = RequestMethod.GET)
	public String echecLogin(Model model) {
		model.addAttribute("msg", true);
		return "login";
	}

}
