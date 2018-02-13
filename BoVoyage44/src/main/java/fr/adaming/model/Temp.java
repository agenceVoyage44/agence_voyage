package fr.adaming.model;

public class Temp extends Assurance{

	
	private int idResa;

	public Temp() {
		super();
	}

	public Temp(String type, double prix, int idResa) {
		super(type, prix);
		this.idResa = idResa;
	}

	public Temp(int id, String type, double prix, int idResa) {
		super(id, type, prix);
		this.idResa = idResa;
	}

	public int getIdResa() {
		return idResa;
	}

	public void setIdResa(int idResa) {
		this.idResa = idResa;
	}
	
	
}
