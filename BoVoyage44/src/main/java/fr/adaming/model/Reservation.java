package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
/**
 * 
 * @author inti-0257
 *
 */
@Entity
@Table(name = "reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_res")
	private int id;

	private String statut;

	private double prix;

	private Date dateReservation;

	private int nbPlaceReservees;

	// association UML en Java

	@OneToMany(mappedBy = "reservation")
	private List<Participant> listeParticipants;

	@OneToOne
	@JoinColumn(name = "p_id", referencedColumnName = "id_p")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "voy_id", referencedColumnName = "id_voy")
	private Voyage voyage;

	@ManyToMany
	@JoinTable(name = "reservation_assurances", joinColumns = @JoinColumn(name = "res_id"), inverseJoinColumns = @JoinColumn(name = "assu_id"))
	private List<Assurance> listeAssurances;

	public Reservation() {
		super();
	}

	public Reservation(String statut, double prix, Date dateReservation, int nbPlaceReservees) {
		super();
		this.statut = statut;
		this.prix = prix;
		this.dateReservation = dateReservation;
		this.nbPlaceReservees = nbPlaceReservees;
	}

	public Reservation(int id, String statut, double prix, Date dateReservation, int nbPlaceReservees) {
		super();
		this.id = id;
		this.statut = statut;
		this.prix = prix;
		this.dateReservation = dateReservation;
		this.nbPlaceReservees = nbPlaceReservees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public int getNbPlaceReservees() {
		return nbPlaceReservees;
	}

	public void setNbPlaceReservees(int nbPlaceReservees) {
		this.nbPlaceReservees = nbPlaceReservees;
	}

	public List<Participant> getListeParticipants() {
		return listeParticipants;
	}

	public void setListeParticipants(List<Participant> listeParticipants) {
		this.listeParticipants = listeParticipants;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

	public List<Assurance> getListeAssurances() {
		return listeAssurances;
	}

	public void setListeAssurances(List<Assurance> listeAssurances) {
		this.listeAssurances = listeAssurances;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", statut=" + statut + ", prix=" + prix + ", dateReservation="
				+ dateReservation + ", nbPlaceReservees=" + nbPlaceReservees + ", listeParticipants="
				+ listeParticipants + ", client=" + client + ", voyage=" + voyage + ", listeAssurances="
				+ listeAssurances + "]";
	}

}
