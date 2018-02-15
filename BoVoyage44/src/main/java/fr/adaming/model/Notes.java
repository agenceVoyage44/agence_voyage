package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_n")
	private int id;

	private double voyage;

	private double logement;

	private double transport;

	private double nourriture;

	private double agent;

	private double siteAspect;

	private double siteUtil;

	private String comm;

	public Notes() {
		super();
	}

	public Notes(double voyage, double logement, double transport, double nourriture, double agent, double siteAspect,
			double siteUtil, String comm) {
		super();
		this.voyage = voyage;
		this.logement = logement;
		this.transport = transport;
		this.nourriture = nourriture;
		this.agent = agent;
		this.siteAspect = siteAspect;
		this.siteUtil = siteUtil;
		this.comm = comm;
	}

	public Notes(int id, double voyage, double logement, double transport, double nourriture, double agent,
			double siteAspect, double siteUtil, String comm) {
		super();
		this.id = id;
		this.voyage = voyage;
		this.logement = logement;
		this.transport = transport;
		this.nourriture = nourriture;
		this.agent = agent;
		this.siteAspect = siteAspect;
		this.siteUtil = siteUtil;
		this.comm = comm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getVoyage() {
		return voyage;
	}

	public void setVoyage(double voyage) {
		this.voyage = voyage;
	}

	public double getLogement() {
		return logement;
	}

	public void setLogement(double logement) {
		this.logement = logement;
	}

	public double getTransport() {
		return transport;
	}

	public void setTransport(double transport) {
		this.transport = transport;
	}

	public double getNourriture() {
		return nourriture;
	}

	public void setNourriture(double nourriture) {
		this.nourriture = nourriture;
	}

	public double getAgent() {
		return agent;
	}

	public void setAgent(double agent) {
		this.agent = agent;
	}

	public double getSiteAspect() {
		return siteAspect;
	}

	public void setSiteAspect(double siteAspect) {
		this.siteAspect = siteAspect;
	}

	public double getSiteUtil() {
		return siteUtil;
	}

	public void setSiteUtil(double siteUtil) {
		this.siteUtil = siteUtil;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

}
