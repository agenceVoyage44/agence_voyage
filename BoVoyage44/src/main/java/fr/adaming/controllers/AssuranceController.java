package fr.adaming.controllers;

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
import fr.adaming.service.IAssuranceService;
/**
 * Classe Assurance Controller
 * @author Adaming
 *
 */
@Controller
@RequestMapping(value="/agent/assurance")
public class AssuranceController {
	
	@Autowired
	IAssuranceService assuranceService;

	public void setAssuranceService(IAssuranceService assuranceService) {
		this.assuranceService = assuranceService;
	}
	
	@RequestMapping(value="liste", method = RequestMethod.GET)
	public ModelAndView listeA(){
		List<Assurance>liste=assuranceService.getAllAssurance();
		return new ModelAndView("AssuranceListe", "ListeAssurance", liste);
		
	}
	//******************* AJOUT **********************************************************************************
	@RequestMapping(value="afficheAdd", method = RequestMethod.GET)
	public ModelAndView afficheAjout(){
		
		return new ModelAndView("AssuranceAjout", "AssurAjout", new Assurance());
		
	}
	@RequestMapping(value="soummettreAdd", method = RequestMethod.POST)
	public String soumettreAjouter(Model modele,@ModelAttribute("AssurAjout") Assurance assurance){
		
		assuranceService.addAssurance(assurance);
		
		//rediriger vers la methode afficheliste
		return "redirect:AssuranceListe";
		
		
	}
	
	//******************* DELETE **********************************************************************************
	@RequestMapping(value="afficheDelete", method = RequestMethod.GET)
	public ModelAndView afficheSupprimer(){
		
		return new ModelAndView("AssuranceSupprimer", "AssurSuppr", new Assurance());
		
	}
	@RequestMapping(value="soummettreDelete", method = RequestMethod.DELETE)
	public String soumettreSupprimer(Model modele,@ModelAttribute("AssurSuppr") Assurance assurance){
		
		assuranceService.deleteAssurance(assurance.getId());
		
		//rediriger vers la methode afficheliste
		return "redirect:AssuranceList";
		
		
	}
	
	//******************* UPDATE **********************************************************************************
		@RequestMapping(value="afficheUpdate", method = RequestMethod.GET)
		public ModelAndView afficheModifier(){
			
			return new ModelAndView("AssuranceUpdate", "AssurModif", new Assurance());
			
		}
		@RequestMapping(value="soummettreUpdate", method = RequestMethod.PUT)
		public String soumettreModifier(Model modele,@ModelAttribute("AssurModif") Assurance assurance){
			
			assuranceService.updateAssurance(assurance);
			
			//rediriger vers la methode afficheliste
			return "redirect:AssuranceList";
			
			
		}
	
		//******************* GET BY ID **********************************************************************************
		@RequestMapping(value="afficheGet", method = RequestMethod.GET)
		public ModelAndView afficheRecherche(){
			
			return new ModelAndView("AssuranceGet", "AssurRecherche", new Assurance());
			
		}
		@RequestMapping(value="soummettreGet", method = RequestMethod.PUT)
		public String soumettreRecherche(RedirectAttributes ra,Model modele,@ModelAttribute("AssurRecherche") Assurance assurance){
			
			Assurance aOut=assuranceService.updateAssurance(assurance);
			 modele.addAttribute("assurance",aOut);
			//rediriger vers la methode afficheliste
			return "redirect:AssuranceGet";
			
			
		}
		
}
