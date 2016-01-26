package akenmg.rootsdelivery.service.modelform;

import javax.servlet.http.HttpServletRequest;

import akenmg.rootsdelivery.model.Admin;

public class CreateAdminForm extends ModelForm{
	protected static final String CHAMP_LOGIN    = "login";
	protected static final String CHAMP_MDP   = "motdepasse";
	protected static final String CHAMP_CONFIRM   = "confirmation";
	
	public Admin inscriptionAdmin( HttpServletRequest request ) { 
		String login = getValeurChamp( request, CHAMP_LOGIN );
    	String mdp = getValeurChamp( request, CHAMP_MDP );
    	String confirmation = getValeurChamp( request, CHAMP_CONFIRM );
		
		Admin admin = new Admin();
		
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
            resultat = "Insertion Admin Valide";
            this.setValide(true);
        } else {
            resultat = "Insertion Admin invalide";
            this.setValide(false);
        }
		
		return admin;
	}
}
