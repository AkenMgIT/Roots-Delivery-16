package akenmg.rootsdelivery.service.modelform;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import akenmg.rootsdelivery.model.Admin;
import akenmg.rootsdelivery.model.Client;

public class UpdateAdminForm extends ModelForm{
	protected static final String CHAMP_ID    = "id";
	protected static final String CHAMP_LOGIN    = "login";
	protected static final String CHAMP_MDP   = "motdepasse";
	protected static final String CHAMP_CONFIRM   = "confirmation";
	
	public Admin updateAdmin( HttpServletRequest request ) {    
		Admin admin = new Admin();
		
		String id = getValeurChamp( request, CHAMP_ID );
    	String login = getValeurChamp( request, CHAMP_LOGIN );
    	String mdp = getValeurChamp( request, CHAMP_MDP );
    	String confirmation = getValeurChamp( request, CHAMP_CONFIRM );
		
    	admin.setId(Integer.parseInt(id));
    	
    	try {
    		validationLogin(login);
    	} catch ( Exception e ) {
    		setErreur( CHAMP_LOGIN, e.getMessage() );
    	}
    	admin.setLogin(login);
    	try {
    		validationMotsDePasse(mdp, confirmation);
    	} catch ( Exception e ) {
    		setErreur( CHAMP_MDP, e.getMessage() );
            setErreur( CHAMP_CONFIRM, null );
    	}
    	admin.setMdp(mdp);
    	
    	if ( erreurs.isEmpty() ) {
            resultat = "Update Admin Valide";
            this.setValide(true);
        } else {
            resultat = "Update Admin invalide";
            this.setValide(false);
        }
    	
		return admin;
	}
}
