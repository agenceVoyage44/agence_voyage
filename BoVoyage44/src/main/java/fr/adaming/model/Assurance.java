package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author inti-0257
 *
 */

@Entity
@Table(name = "assurances")
public class Assurance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_assu")
	private int id;

	private String type;

	private double prix;
	
	//associations UML en java
	@ManyToMany(mappedBy="listeAssurances")
	private List<Reservation>listeReservations;

	public Assurance() {
		super();
	}

	public Assurance(String type, double prix) {
		super();
		this.type = type;
		this.prix = prix;
	}

	public Assurance(int id, String type, double prix) {
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

	public List<Reservation> getListeReservations() {
		return listeReservations;
	}

	public void setListeReservations(List<Reservation> listeReservations) {
		this.listeReservations = listeReservations;
	}

	@Override
	public String toString() {
		return "Assurance [id=" + id + ", type=" + type + ", prix=" + prix + ", listeReservations=" + listeReservations
				+ "]";
	}

	
}
