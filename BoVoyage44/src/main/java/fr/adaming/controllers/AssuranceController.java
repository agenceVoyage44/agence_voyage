package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Assurance;
import fr.adaming.model.Hebergement;
import fr.adaming.model.Reservation;
import fr.adaming.model.Temp;
import fr.adaming.service.IAssuranceService;
import fr.adaming.service.IReservationService;
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
	@Autowired
	IReservationService reservationService;
	
	public void setAssuranceService(IAssuranceService assuranceService) {
		this.assuranceService = assuranceService;
	}
	
	public void setReservationService(IReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@RequestMapping(value="/liste", method = RequestMethod.GET)
	public ModelAndView listeA(){
		List<Assurance>liste=assuranceService.getAllAssurance();
		return new ModelAndView("AssuranceListe", "ListeAssurance", liste);
		
	}
	//******************* AJOUT **********************************************************************************
	@RequestMapping(value="afficheAdd", method = RequestMethod.GET)
	public ModelAndView afficheAjout(){
		
		return new ModelAndView("AssuranceAjout", "AssurAjout", new Assurance());
		
	}
	@RequestMapping(value="soumettreAdd", method = RequestMethod.POST)
	public String soumettreAjouter(Model modele,@ModelAttribute("AssurAjout") Assurance assurance){
		
		assuranceService.addAssurance(assurance);
		
		//rediriger vers la methode afficheliste
		return "redirect:liste";
		
		
	}
	
	//******************* DELETE **********************************************************************************
	@RequestMapping(value="afficheDelete", method = RequestMethod.GET)
	public ModelAndView afficheSupprimer(){
		
		return new ModelAndView("AssuranceDelete", "AssurSuppr", new Assurance());
		
	}
	@RequestMapping(value="soumettreDelete", method = RequestMethod.POST)
	public String soumettreSupprimer(Model modele,@ModelAttribute("AssurSuppr") Assurance assurance){
		
		assuranceService.deleteAssurance(assurance.getId());
		
		//rediriger vers la methode afficheliste
		return "redirect:liste";
		
		
	}
	
	//******************* UPDATE **********************************************************************************
		@RequestMapping(value="afficheUpdate", method = RequestMethod.GET)
		public ModelAndView afficheModifier(){
			
			return new ModelAndView("AssuranceUpdate", "AssurModif", new Assurance());
			
		}
		@RequestMapping(value="soumettreUpdate", method = RequestMethod.POST)
		public String soumettreModifier(Model modele,@ModelAttribute("AssurModif") Assurance assurance){
			
			assuranceService.updateAssurance(assurance);
			
			//rediriger vers la methode afficheliste
			return "redirect:liste";
			
			
		}
	
		//******************* GET BY ID **********************************************************************************
		@RequestMapping(value="afficheGet", method = RequestMethod.GET)
		public ModelAndView afficheRecherche(){
			
			return new ModelAndView("AssuranceGet", "AssurRecherche", new Assurance());
			
		}
		@RequestMapping(value="soumettreGet", method = RequestMethod.POST)
		public String soumettreRecherche(RedirectAttributes ra,Model modele,@ModelAttribute("AssurRecherche") Assurance assurance){
			
			Assurance aOut=assuranceService.updateAssurance(assurance);
			 modele.addAttribute("assurance",aOut);
			//rediriger vers la methode afficheliste
			return "redirect:afficheGet";
			
			
		}
		// --------Lien Tableau Pour Supprimer ou Modifier----------

		// ----------------supprime(lien)-------------------
		@RequestMapping(value = "/supprimeLien/{pId}", method = RequestMethod.GET)
		public String supprimerlien(Model model, @PathVariable("pId") int id) {
			Assurance a = new Assurance();

			a.setId(id);

			// appel de la methode service
			assuranceService.deleteAssurance(id);

			// recuperer la liste de la bd
			List<Assurance> liste = assuranceService.getAllAssurance();

			model.addAttribute("aList", liste);

			return "AssuranceListe";

		}
		
		// ------------ modifier(lien)-------------
		@RequestMapping(value = "/modifieLien", method = RequestMethod.GET)
		public String modifielien(ModelMap model, @RequestParam("pId") int id) {

			// @PathVariable: prend pId est la stock dans le int id

			Assurance aIn = new Assurance();

			aIn.setId(id);

			// recup hebergment de la bd
			Assurance aOut=assuranceService.getAssuranceById(id);

			model.addAttribute("AssurModif", aOut);

			return "AssuranceUpdate";
		}
		
}
