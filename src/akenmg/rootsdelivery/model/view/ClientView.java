package akenmg.rootsdelivery.model.view;

import akenmg.rootsdelivery.model.Client;

public class ClientView extends Client {
	
	public ClientView(Client c){
		this.setId(c.getId());
		this.setNom(c.getNom());
		this.setPrenom(c.getPrenom());
		this.setNumero(c.getNumero());
		this.setEmail(c.getEmail());
		this.setMdp(c.getMdp());
	}
	
}
