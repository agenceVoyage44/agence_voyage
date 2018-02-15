package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Formule;
import fr.adaming.model.Voyage;
import fr.adaming.service.IFormuleService;
import fr.adaming.service.IVoyageService;


/**
 * VoyageController est le controller qui gère la vue pour les mèthodes de la classe Voyage.
 * @author Larry Bambel
 *
 */
@Controller
@Scope("session")
@RequestMapping("/voyage")
public class VoyageController {
	
	@Autowired
	private IVoyageService voyageService;

	public void setVoyageService(IVoyageService voyageService) {
		this.voyageService = voyageService;
	}
	
	@Autowired
	private IFormuleService formuleService;
	
	public void setFormuleService(IFormuleService formuleService) {
		this.formuleService = formuleService;
	}

	/**
	 * La méthode afficheListe gère l'affichage de la liste des voyage.
	 * @return La liste des voyages et la page dans laquelle ils sont affichés. 
	 */
	@RequestMapping(value = "/agent/liste", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		List<Voyage> liste = voyageService.getAllVoyage(); 

		return new ModelAndView("voyageListe", "voyageList", liste);
	}
	
	@RequestMapping(value = "/listeContinent/{pContinent}", method = RequestMethod.GET)
	public ModelAndView afficheListeContinent(Model modele,@PathVariable("pContinent") String continent) {
		List<Voyage> listeContinents=new ArrayList<Voyage>();
		
		List<Voyage> liste = voyageService.getAllVoyage();
		
		
		for (Voyage voyage : liste) {
			if(voyage.getContinent().equals(continent)){
				listeContinents.add(voyage);
			}
		}
		
		return new ModelAndView("voyageListeContinents", "voyageListContinent", listeContinents);
	}
	
	
	@RequestMapping(value = "/photoVoyage", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(int idV) throws IOException {
		Voyage v = voyageService.getVoyageById(idV);
		if (v.getPhoto() == null)
			return new byte[0];
		else
			return IOUtils.toByteArray(new ByteArrayInputStream(v.getPhoto()));
	}
	
	@RequestMapping(value = "/agent/afficheAdd", method = RequestMethod.GET)
	public ModelAndView afficheAjout(Model modele) {

		List<Formule> listeFormules = formuleService.getAllFormule();

		modele.addAttribute("listeFormules",listeFormules);
		
		return new ModelAndView("voyageAjout", "voyageAjout", new Voyage());
	}
	
	@RequestMapping(value = "/agent/soumettreAdd", method = RequestMethod.POST)
	public String soumettreAjouter(@ModelAttribute("voyageAjout") Voyage v) {
		
		if(v.getFormule()!=null){
			v.setFormule(formuleService.getFormuleById(v.getFormule().getId()));
		}
		
		if(v.getFile()!=null){
			
			try {
				v.setPhoto(v.getFile().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		v.setPrixSolde(v.getPrixDepart()*(1-v.getRemise()/100));
		
		v.setDispo(true);
		Voyage vOut = voyageService.addVoyage(v);

		if (vOut.getId() != 0) {
			return "redirect:liste";
		} else {
			return "redirect:afficheAdd";
		}
	}
	
	
	@RequestMapping(value = "/agent/afficheUpdate", method = RequestMethod.GET)
	public ModelAndView afficheModif(Model modele) {

		List<Formule> listeFormules = formuleService.getAllFormule();

		modele.addAttribute("listeFormules",listeFormules);
		
		return new ModelAndView("voyageModifier", "voyageModif", new Voyage());
	}
	
	@RequestMapping(value = "/agent/soumettreUpdate", method = RequestMethod.POST)
	public String soumettreModif(@ModelAttribute("voyageModif") Voyage v) {


		if(v.getFile()!=null){
			try {				
				v.setPhoto(v.getFile().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		v.setPrixSolde(v.getPrixDepart()*(1-v.getRemise()/100));

		Voyage vOut = voyageService.updateVoyage(v);

		if (vOut.getContinent() == v.getContinent()) {
			return "redirect:liste";
		} else {
			return "redirect:afficheUpdate";
		}
	}
	
	
	
	@RequestMapping(value = "/agent/afficheDelete", method = RequestMethod.GET)
	public ModelAndView afficheSupprim() {

		return new ModelAndView("voyageSupprimer", "voyageSupprim", new Voyage());
	}
	
	@RequestMapping(value = "/agent/soumettreDelete", method = RequestMethod.POST)
	public String soumettreSupprim(@ModelAttribute("voyageSupprim") Voyage v) {

		int verif = voyageService.deleteVoyage(v.getId());

		if (verif != 0) {
			return "redirect:liste";
		} else {
			return "redirect:afficheDelete";
		}
	}
	
	
	
	@RequestMapping(value = "/agent/afficheGet", method = RequestMethod.GET)
	public ModelAndView afficheRecherche() {
		return new ModelAndView("voyageRechercher", "voyageRecherche", new Voyage());
	}
	
	@RequestMapping(value = "/agent/soumettreGet", method = RequestMethod.POST)
	public ModelAndView soumettreRecherche(@ModelAttribute("voyageRecherche") Voyage v, RedirectAttributes ra) {

		Voyage vOut = voyageService.getVoyageById(v.getId());
		if (vOut != null) {
			return new ModelAndView("voyageRechercher", "voyage", vOut);
		} else {
			return afficheRecherche();
		}
	}
	
	
	
	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public ModelAndView afficheListeClient(Model modele) {
		List<Voyage> liste = voyageService.getAllVoyage();

		modele.addAttribute("voyageList", liste);
		
		return new ModelAndView("voyageListeClient", "voyagePays",new Voyage());
	}

	@RequestMapping(value = "/listePays", method = RequestMethod.POST)
	public ModelAndView afficheListePays(@ModelAttribute("voyagePays") Voyage v) {
		List<Voyage> listePays=new ArrayList<Voyage>();
		
		List<Voyage> liste = voyageService.getAllVoyage();
		
		for (Voyage voyage : liste) {
			if(voyage.getPays().startsWith(v.getPays())){
				listePays.add(voyage);
			}
		}

		return new ModelAndView("voyageListeClient", "voyageList", listePays);
	}
	
	
	@RequestMapping(value = "/agent/supprimerButton/{pId}", method = RequestMethod.GET)
	public String deletLien(Model model, @PathVariable("pId") int id) {
		
		voyageService.deleteVoyage(id);
		List<Voyage> liste = voyageService.getAllVoyage();
		model.addAttribute("voyageList", liste);
		return "voyageListe";
	}
	
	@RequestMapping(value = "/agent/modifierButton", method = RequestMethod.GET)
	public String updateLien(ModelMap model, @RequestParam("pId") int id) {
		Voyage v = voyageService.getVoyageById(id);
		model.addAttribute("voyageModif", v);
		
		List<Formule> listeFormules = formuleService.getAllFormule();

		model.addAttribute("listeFormules",listeFormules);
		
		return "voyageModifier";
	}
	
	@RequestMapping(value = "/lienDetail", method = RequestMethod.GET)
	public String voyageLienDetail(ModelMap model, @RequestParam("pId") int id) {
		Voyage v = voyageService.getVoyageById(id);
		if (v.getFormule()!=null){
			v.setFormule(formuleService.getFormuleById(v.getFormule().getId()));
		}
		model.addAttribute("voyage", v);
		return "voyageDetail";
	}
	
}
