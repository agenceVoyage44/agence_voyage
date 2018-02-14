package fr.adaming.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

/**
 * <b>Classe voiture</b> comprenant le modèle du véhicule, le nom du loueur, le
 * nombre de place et la photo du modèle. Plusieurs voitures peuvent être
 * associées à une formule.
 * 
 * @author inti-0257
 *
 */
@Entity
@Table(name = "voitures")
public class Voiture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_voit")
	private int id;

	private String modele;

	private String loueur;

	private int nbPlaces;

	@Lob
	private byte[] photo;

	@Transient
	private MultipartFile file;

	// association UML en java

	@ManyToOne
	@JoinColumn(name = "f_id", referencedColumnName = "id_f")
	private Formule formule;

	public Voiture() {
		super();
	}

	public Voiture(String modele, String loueur, int nbPlaces, byte[] photo) {
		super();
		this.modele = modele;
		this.loueur = loueur;
		this.nbPlaces = nbPlaces;
		this.photo = photo;
	}

	public Voiture(int id, String modele, String loueur, int nbPlaces, byte[] photo) {
		super();
		this.id = id;
		this.modele = modele;
		this.loueur = loueur;
		this.nbPlaces = nbPlaces;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getLoueur() {
		return loueur;
	}

	public void setLoueur(String loueur) {
		this.loueur = loueur;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public Formule getFormule() {
		return formule;
	}

	public void setFormule(Formule formule) {
		this.formule = formule;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", modele=" + modele + ", loueur=" + loueur + ", nbPlaces=" + nbPlaces + ", photo="
				+ Arrays.toString(photo) + ", file=" + file + ", formule=" + formule + "]";
	}

}
