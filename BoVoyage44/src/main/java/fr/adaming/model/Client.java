package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.OneToOne;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author inti-0257
 *
 */
@Entity
@DiscriminatorValue(value = "client")
public class Client extends Participant {

	private long numCB;

	private String mail;

	private String mdp;

	private boolean active;

	// associations UML en java

	@OneToOne(mappedBy = "client")
	Role role;

	public Client() {
		super();
	}

	public Client(String nom, String prenom, int tel, String civilite, int numero, String rue, int codePostal,
			String ville, String pays, Date dateNaissance, long numCB, String mail, String mdp, boolean active) {
		super(nom, prenom, tel, civilite, numero, rue, codePostal, ville, pays, dateNaissance);
		this.numCB = numCB;
		this.mail = mail;
		this.mdp = mdp;
		this.active = active;

	}

	public Client(int id, String nom, String prenom, int tel, String civilite, int numero, String rue, int codePostal,
			String ville, String pays, Date dateNaissance, long numCB, String mail, String mdp, boolean active) {
		super(id, nom, prenom, tel, civilite, numero, rue, codePostal, ville, pays, dateNaissance);
		this.numCB = numCB;
		this.mail = mail;
		this.mdp = mdp;
		this.active = active;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
