package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Entity;

import javax.persistence.Table;

/**
 * @author inti-0257
 *
 */
@Entity
@Table(name = "clients")
public class Client extends Participant {

	private long numCB;

	private String mail;

	private String mdp;

	// associations UML en java
	@OneToOne
	@JoinColumn(name = "resa_id", referencedColumnName = "id_res")
	private Reservation reservation;

	@OneToMany(mappedBy = "client")
	List<Role> listeRoles;

	public Client() {
		super();
	}

	public Client(String nom, String prenom, int tel, String civilite, int numero, String rue, int codePostal,
			String ville, String pays, Date dateNaissance, long numCB, String mail, String mdp) {
		super(nom, prenom, tel, civilite, numero, rue, codePostal, ville, pays, dateNaissance);
		this.numCB = numCB;
		this.mail = mail;
		this.mdp = mdp;
	}

	public Client(int id, String nom, String prenom, int tel, String civilite, int numero, String rue, int codePostal,
			String ville, String pays, Date dateNaissance, long numCB, String mail, String mdp) {
		super(id, nom, prenom, tel, civilite, numero, rue, codePostal, ville, pays, dateNaissance);
		this.numCB = numCB;
		this.mail = mail;
		this.mdp = mdp;
	}

	public long getNumCB() {
		return numCB;
	}

	public void setNumCB(long numCB) {
		this.numCB = numCB;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public List<Role> getListeRoles() {
		return listeRoles;
	}

	public void setListeRoles(List<Role> listeRoles) {
		this.listeRoles = listeRoles;
	}

	@Override
	public String toString() {
		return "Client [numCB=" + numCB + ", mail=" + mail + ", mdp=" + mdp + ", reservation=" + reservation
				+ ", listeRoles=" + listeRoles + "]";
	}

}
