package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Le Classe contenant le modèle d'Hébergement avec les différents attributs associés tel que le type et le prix.
 * Cette classe possède une association ManyToOne avec la classe Formule.
 * Elle contient aussi trois constructeurs un vide,un sans id et un avec id.
 * @author Folo7
 *
 */
@Entity
@Table(name = "hebergements")
public class Hebergement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_h")
	private int id;

	private String type;

	private double prix;

	// associations UML en java
	@ManyToOne
	@JoinColumn(name = "f_id", referencedColumnName = "id_f")
	private Formule formule;

	public Hebergement() {
		super();
	}

	public Hebergement(String type, double prix) {
		super();
		this.type = type;
		this.prix = prix;
	}

	public Hebergement(int id, String type, double prix) {
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

	public Formule getFormule() {
		return formule;
	}

	public void setFormule(Formule formule) {
		this.formule = formule;
	}

	@Override
	public String toString() {
		return "Hebergement [id=" + id + ", type=" + type + ", prix=" + prix + ", formule=" + formule + "]";
	}

}
