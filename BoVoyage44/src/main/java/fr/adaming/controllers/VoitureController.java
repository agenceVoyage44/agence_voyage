package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Voiture;
import fr.adaming.service.IVoitureService;

@Controller
@RequestMapping("/agent/Voiture")
public class VoitureController {

	@Autowired
	private IVoitureService voitureService;

	public void setVoitureService(IVoitureService voitureService) {
		this.voitureService = voitureService;
	}

	// ******* Liste des Voitures **********
	/**
	 * Affiche la liste des Voitures
	 * 
	 * @return Retourne la liste des voitures
	 */
	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// R�cup�rer la liste de la bd
		List<Voiture> listeV = voitureService.getAllVoiture();

		return new ModelAndView("voitureListe", "vListe", listeV);
	}

	/**
	 * R�cup�re la photo de la voiture d'id 'idV', puis la convertie en tableau
	 * de byte.
	 * 
	 * @param idV
	 *            Il s'agit de l'id de la voiture.
	 * @return Rtourne la photo en tableau de byte.
	 * @throws IOException
	 */
	@RequestMapping(value = "/photoVoiture", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(int idV) throws IOException {
		Voiture v = voitureService.getVoitureById(idV);
		if (v.getPhoto() == null)
			return new byte[0];
		else
			return IOUtils.toByteArray(new ByteArrayInputStream(v.getPhoto()));
	}

	// ********* Ajout Voiture **********
	/**
	 * Affiche le formulaire d'ajout de Voiture
	 * 
	 * @return Retourne la page d'ajout de Voiture.
	 */
	@RequestMapping(value = "/afficheAdd", method = RequestMethod.GET)
	public ModelAndView afficherAjouter() {
		return new ModelAndView("voitureAjouter", "vAjout", new Voiture());
	}

	/**
	 * Soumet le formulaire d'ajout de Voiture.
	 * 
	 * @param v
	 *            Il s'agit de la Voiture du formulaire une fois rempli.
	 * @return Retourne la liste des voitures si l'ajout est effect�e, sinon,
	 *         retourne le formulaire d'ajout.
	 */
	@RequestMapping(value = "/soumettreAdd", method = RequestMethod.POST)
	public String soumettreAjouter(@ModelAttribute("vAjout") Voiture v) {

		// R�cup�re le fichier image, et set la photo de l'objet
		MultipartFile file = v.getFile();
		if (null != file) {
			try {
				v.setPhoto(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Voiture vOut = voitureService.addVoiture(v);

		if (vOut.getId() != 0) {
			return "redirect:liste";
		} else {
			return "redirect:afficheAdd";
		}
	}

	// ******* Modifier Voiture **********
	/**
	 * R�cup�re la voiture s�lectionn�e et renvoie les informations de celle-ci
	 * dans le formulaire de modification de voiture.
	 * 
	 * @param modele
	 * @param id
	 *            Il s'agit de l'id de la voiture s�lectionn�e.
	 * @return Retourn le formulaire de modification.
	 */
	@RequestMapping(value = "updateLien", method = RequestMethod.GET)
	public String updateLien(ModelMap modele, @RequestParam(value = "pId") int id) {
		Voiture vIn = new Voiture();
		vIn.setId(id);
		// R�cup�rer la voiture de la BD
		Voiture vOut = voitureService.getVoitureById(id);
		modele.addAttribute("vUpdate", vOut);
		return "voitureUpdate";
	}

	/**
	 * Affiche le formulaire de modification de Voiture
	 * 
	 * @return Retourne la page de modification de Voiture.
	 */
	@RequestMapping(value = "/afficheUpdate", method = RequestMethod.GET)
	public ModelAndView afficherUpdate() {
		return new ModelAndView("voitureUpdate", "vUpdate", new Voiture());
	}

	/**
	 * Soumet le formulaire de modification de Voiture.
	 * 
	 * @param v
	 *            Il s'agit de la Voiture du formulaire une fois rempli.
	 * @return Retourne la liste des voitures si la modification est effect�e,
	 *         sinon, retourne le formulaire de modification.
	 */
	@RequestMapping(value = "/soumettreUpdate", method = RequestMethod.POST)
	public String soumettreUpdate(@ModelAttribute("vUpdate") Voiture v) {
		// R�cup�re le fichier image, et set la photo de l'objet
		MultipartFile file = v.getFile();
		if (null != file) {
			try {
				v.setPhoto(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Voiture vOut = voitureService.updateVoiture(v);

		if (vOut != null) {
			return "redirect:liste";
		} else {
			return "redirect:afficheUpdate";
		}
	}

	// ******* Suppression Voiture **********
	/**
	 * Supprime la voiture selectionn�e et actualise la liste des voitures.
	 * 
	 * @param modele
	 * @param id
	 *            Il s'agit de l'id de la voiture s�lectionn�e.
	 * @return Retourne la nouvelle liste de voitures.
	 */
	@RequestMapping(value = "deleteLien/{pId}", method = RequestMethod.GET)
	public String supprLien(Model modele, @PathVariable("pId") int id) {
		// Appel de la m�thode service
		voitureService.deleteVoiture(id);
		return "redirect:../liste";
	}

}
