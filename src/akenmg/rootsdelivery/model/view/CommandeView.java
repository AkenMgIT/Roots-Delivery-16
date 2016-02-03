package akenmg.rootsdelivery.model.view;

import akenmg.rootsdelivery.model.Commande;
import akenmg.rootsdelivery.model.PlaCom;

public class CommandeView extends Commande{
	
	public CommandeView(Commande c){
		super();
		if(c!=null){
			this.setAdresse(c.getAdresse());
			this.setClient(c.getClient());
			this.setDate(c.getDate());
			this.setEtat(c.getEtat());
			this.setId(c.getId());
			this.setPlacoms(c.getPlacoms());
			this.setPlat(c.getPlat());
		}
	}
	
	public int getPrixTotal(){
		int result = 0 ;
		if(this.getPlacoms()!=null){
			if(!this.getPlacoms().isEmpty()){
				for(PlaCom p : this.getPlacoms()){
					result += p.getQuantite() * p.getPlat().getPrix();
				}
			}
		}
		return result;
	}
	
}
