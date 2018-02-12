package fr.adaming.model;

import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author inti-0257
 *
 */
@Entity
@Table(name = "agents")
public class Agent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_a")
	private int id;

	private String mail;

	private String mdp;

	private boolean active;

	// associations UML en java

	@OneToMany(mappedBy = "agent")
	List<Role> listeRoles;

	public Agent() {
		super();
	}

	public Agent(String mail, String mdp, boolean active) {
		super();
		this.mail = mail;
		this.mdp = mdp;
		this.active = active;
	}

	public Agent(int id, String mail, String mdp, boolean active) {
		super();
		this.id = id;
		this.mail = mail;
		this.mdp = mdp;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Role> getListeRoles() {
		return listeRoles;
	}

	public void setListeRoles(List<Role> listeRoles) {
		this.listeRoles = listeRoles;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", mail=" + mail + ", mdp=" + mdp + ", active=" + active + ", listeRoles="
				+ listeRoles + "]";
	}

}
