package akenmg.rootsdelivery.model.view;

import akenmg.rootsdelivery.model.Commande;

public class CommandeView extends Commande{
	public CommandeView(Commande c){
		this.setAdresse(c.getAdresse());
		this.setClient(c.getClient());
		this.setDate(c.getDate());
		this.setEtat(c.getEtat());
		this.setId(c.getId());
		this.setPlacoms(c.getPlacoms());
		this.setPlat(c.getPlat());
	}
}
