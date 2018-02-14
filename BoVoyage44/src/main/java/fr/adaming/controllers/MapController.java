package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapController {
	@RequestMapping(value="/map",method=RequestMethod.GET)
	public String mapView(Model modele){
		return "map";
		
		
	}
	
	@RequestMapping(value="/galerie",method=RequestMethod.GET)
	public String galerieView(Model modele){
		return "galerie";
		
		
	}
	@RequestMapping(value="/accueilClient",method=RequestMethod.GET)
	public String client(Model modele){
		return "accueilClient";
		
		
	}
	@RequestMapping(value="/accueilAgent",method=RequestMethod.GET)
	public String agent(Model modele){
		return "accueilAgent";
		
		
	}
}
