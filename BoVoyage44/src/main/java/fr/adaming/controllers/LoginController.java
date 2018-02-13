package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/loginAgent", method = RequestMethod.GET)
	public String afficheLoginAgent() {
		return "loginAgent";
	}
	
	@RequestMapping(value = "/loginClient", method = RequestMethod.GET)
	public String afficheLoginClient() {
		return "loginClient";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String SeDeconnecter() {
		return "accueil";
	}

	@RequestMapping(value = "/refus", method = RequestMethod.GET)
	public String accesRefuse() {
		return "pageDenied";
	}

	@RequestMapping(value = "/loginAgentEchec", method = RequestMethod.GET)
	public String echecLoginAgent(Model model) {
		model.addAttribute("msg", true);
		return "loginAgent";
	}
	
	@RequestMapping(value = "/loginClientEchec", method = RequestMethod.GET)
	public String echecLoginClient(Model model) {
		model.addAttribute("msg", true);
		return "loginClient";
	}


}
