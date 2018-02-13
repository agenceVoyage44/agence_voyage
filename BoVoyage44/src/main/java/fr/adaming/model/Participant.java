package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Entity;

import javax.persistence.Table;

/**
 * @author inti-0257
 *
 */

@Entity
@Table(name = "participants")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
@DiscriminatorValue(value="part")
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_p")
	protected int id;

	protected String nom;

	protected String prenom;

	protected int tel;

	protected String civilite;

	protected int numero;

	protected String rue;

	protected int codePostal;

	protected String ville;

	protected String pays;

	protected Date dateNaissance;
	
	

	// association UML en java
	@ManyToOne
	@JoinColumn(name = "res_id", referencedColumnName = "id_res")
	private Reservation reservation;

	public Participant() {
		super();
	}

	public Participant(String nom, String prenom, int tel, String civilite, int numero, String rue, int codePostal,
			String ville, String pays, Date dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.civilite = civilite;
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.dateNaissance = dateNaissance;
	}

	public Participant(int id, String nom, String prenom, int tel, String civilite, int numero, String rue,
			int codePostal, String ville, String pays, Date dateNaissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.civilite = civilite;
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.dateNaissance = dateNaissance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", civilite="
				+ civilite + ", numero=" + numero + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", pays=" + pays + ", dateNaissance=" + dateNaissance + ", reservation=" + reservation + "]";
	}

}
