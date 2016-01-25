package akenmg.rootsdelivery.service.modelform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import akenmg.rootsdelivery.dao.DaoClient;
import akenmg.rootsdelivery.model.Client;

public class ConnexionForm {
	private static final String CHAMP_EMAIL    = "email";
	private static final String CHAMP_MDP   = "mdp";
	private boolean 			valide;
	private Map<String, String> erreurs      = new HashMap<String, String>();
	
	public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}
	
	public Client connexionClient(HttpServletRequest request){
		String email = getValeurChamp( request, CHAMP_EMAIL );
    	String mdp = getValeurChamp( request, CHAMP_MDP );
    	
    	Client client = new Client();
    	client.setEmail(email);
    	client.setMdp(mdp);
    	
    	this.setValide(false);
    	List<Client>clients = DaoClient.getAll();
		for(Client c : clients){
			if(c.getEmail().equals(client.getEmail())){
				if(c.getMdp().equals(client.getMdp())){
					this.setValide(true);
					client = c;
					break;
				}
			}
		}
		
		if(!this.isValide()){
			setErreur( "erreur", "login ou mot de passe incorrecte" );
		}
//    	if ( erreurs.isEmpty() ) {
//        } else {
//            this.setValide(false);
//        }
    	
    	return client;
	}
	
	
	
	private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
	
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
