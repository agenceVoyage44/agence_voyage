package fr.adaming.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * La classe Formule permet de g�rer les diff�rentes formules associ�es aux
 * voyages, aux hebergements et aux voitures. Cette classe a pour attribut un
 * String 'type', ainsi qu'un double 'prix'.
 * 
 * @author Bouddha
 *
 */
@Entity
@Table(name = "formules")
public class Formule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_f")
	private int id;

	private String type;

	private double prix;

	// associations UML en java
	@OneToMany(mappedBy = "formule")
	private List<Voyage> listeVoyages;

	@OneToMany(mappedBy = "formule")
	private List<Hebergement> listeHebergements;

	@OneToMany(mappedBy = "formule")
	private List<Voiture> listeVoitures;

	public Formule() {
		super();
	}

	public Formule(String type, double prix) {
		super();
		this.type = type;
		this.prix = prix;
	}

	public Formule(int id, String type, double prix) {
		super();
		this.id = id;
		this.type = type;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public List<Voyage> getListeVoyages() {
		return listeVoyages;
	}

	public void setListeVoyages(List<Voyage> listeVoyages) {
		this.listeVoyages = listeVoyages;
	}

	public List<Hebergement> getListeHebergements() {
		return listeHebergements;
	}

	public void setListeHebergements(List<Hebergement> listeHebergements) {
		this.listeHebergements = listeHebergements;
	}

	public List<Voiture> getListeVoitures() {
		return listeVoitures;
	}

	public void setListeVoitures(List<Voiture> listeVoitures) {
		this.listeVoitures = listeVoitures;
	}

	@Override
	public String toString() {
		return "Formule [id=" + id + ", type=" + type + ", prix=" + prix + "]";
	}



}
