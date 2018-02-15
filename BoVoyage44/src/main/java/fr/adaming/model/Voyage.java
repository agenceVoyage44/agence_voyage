package fr.adaming.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author inti-0257
 *
 */
@Entity
@Table(name = "voyages")
public class Voyage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_voy")
	private int id;

	private String continent;

	private String pays;

	private double prixDepart;

	private double remise;

	private double prixSolde;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dateDepart;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dateRetour;

	@Lob
	private byte[] photo;

	@Transient
	private MultipartFile file;
	
	private int nbPlaces;

	private boolean dispo;

	private String titre;

	private String description;

	private boolean priorite;

	// association UML en java
	@OneToMany(mappedBy = "voyage")
	private List<Reservation> listeReservations;

	@ManyToOne
	@JoinColumn(name = "f_id", referencedColumnName = "id_f")
	private Formule formule;

	public Voyage() {
		super();
	}

	public Voyage(String continent, String pays, double prixDepart, double remise, double prixSolde, Date dateDepart,
			Date dateRetour, byte[] photo, int nbPlaces, boolean dispo, String titre, String description,
			boolean priorite) {
		super();
		this.continent = continent;
		this.pays = pays;
		this.prixDepart = prixDepart;
		this.remise = remise;
		this.prixSolde = prixSolde;
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.photo = photo;
		this.nbPlaces = nbPlaces;
		this.dispo = dispo;
		this.titre = titre;
		this.description = description;
		this.priorite = priorite;
	}

	public Voyage(int id, String continent, String pays, double prixDepart, double remise, double prixSolde,
			Date dateDepart, Date dateRetour, byte[] photo, int nbPlaces, boolean dispo, String titre,
			String description, boolean priorite) {
		super();
		this.id = id;
		this.continent = continent;
		this.pays = pays;
		this.prixDepart = prixDepart;
		this.remise = remise;
		this.prixSolde = prixSolde;
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.photo = photo;
		this.nbPlaces = nbPlaces;
		this.dispo = dispo;
		this.titre = titre;
		this.description = description;
		this.priorite = priorite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public double getPrixDepart() {
		return prixDepart;
	}

	public void setPrixDepart(double prixDepart) {
		this.prixDepart = prixDepart;
	}

	public double getRemise() {
		return remise;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public double getPrixSolde() {
		return prixSolde;
	}

	public void setPrixSolde(double prixSolde) {
		this.prixSolde = prixSolde;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public boolean isDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPriorite() {
		return priorite;
	}

	public void setPriorite(boolean priorite) {
		this.priorite = priorite;
	}

	public List<Reservation> getListeReservations() {
		return listeReservations;
	}

	public void setListeReservations(List<Reservation> listeReservations) {
		this.listeReservations = listeReservations;
	}

	public Formule getFormule() {
		return formule;
	}

	public void setFormule(Formule formule) {
		this.formule = formule;
	}
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Voyage [id=" + id + ", continent=" + continent + ", pays=" + pays + ", prixDepart=" + prixDepart
				+ ", remise=" + remise + ", prixSolde=" + prixSolde + ", dateDepart=" + dateDepart + ", dateRetour="
				+ dateRetour + ", photo=" + Arrays.toString(photo) + ", nbPlaces=" + nbPlaces + ", dispo=" + dispo
				+ ", titre=" + titre + ", description=" + description + ", priorite=" + priorite
				+ ", listeReservations=" + listeReservations + ", formule=" + formule + "]";
	}

}
