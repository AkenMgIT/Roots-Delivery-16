package akenmg.rootsdelivery.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande {
	public enum ETAT{
		ENCOURS,
		PAYEE,
		ANNULLEE
	};
	
	private int id;
	private Client client;
	private List<Plat> plat;
	private String adresse;
	private Date date;
	private ETAT etat;
	
	public Commande() {
		super();
		plat = new ArrayList<Plat>();
	}

	public Commande(int id, Client client, List<Plat> plat, String adresse,Date date, ETAT etat) {
		super();
		this.id = id;
		this.client = client;
		this.plat = plat;
		this.adresse = adresse;
		this.date = date;
		this.etat = etat;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Plat> getPlat() {
		return plat;
	}
	public void setPlat(List<Plat> plat) {
		this.plat = plat;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ETAT getEtat() {
		return etat;
	}
	public void setEtat(ETAT etat) {
		this.etat = etat;
	}
	
}	
