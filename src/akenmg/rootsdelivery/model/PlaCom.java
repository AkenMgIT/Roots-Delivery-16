package akenmg.rootsdelivery.model;

public class PlaCom {
	private Plat plat;
	private Commande commande;
	private int quantite;
	
	
	public PlaCom() {
		super();
		this.setQuantite(0);
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Plat getPlat() {
		return plat;
	}
	public void setPlat(Plat plat) {
		this.plat = plat;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	public void addQuantite(int nbr){
		this.setQuantite(this.getQuantite()+nbr);
	}
	public void removeQuantite(int nbr){
		this.setQuantite(this.getQuantite()-nbr);
	}
}
