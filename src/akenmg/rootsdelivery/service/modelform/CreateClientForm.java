package akenmg.rootsdelivery.service.modelform;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import akenmg.rootsdelivery.model.Client;

public class CreateClientForm extends ModelForm{
	protected static final String CHAMP_NOM    = "nom";
	protected static final String CHAMP_PRENOM   = "prenom";
	protected static final String CHAMP_TEL   = "telephone";
	protected static final String CHAMP_EMAIL  = "email";
	protected static final String CHAMP_MDP   = "motdepasse";
	protected static final String CHAMP_CONF   = "confirmation";
    

	public Client inscrireUtilisateur( HttpServletRequest request ) {
    	String nom = getValeurChamp( request, CHAMP_NOM );
    	String prenom = getValeurChamp( request, CHAMP_PRENOM );
    	String telephone = getValeurChamp( request, CHAMP_TEL );
    	String email = getValeurChamp( request, CHAMP_EMAIL );
    	String mdp = getValeurChamp( request, CHAMP_MDP );
    	String confirmation = getValeurChamp( request, CHAMP_CONF );

    	Client client = new Client();

    	try {
    		validationNom( nom );
    	} catch ( Exception e ) {
    		setErreur( CHAMP_NOM, e.getMessage() );
    	}
    	client.setNom( nom );
    	
    	try {
    		validationPrenom( prenom );
    	} catch ( Exception e ) {
    		setErreur( CHAMP_PRENOM, e.getMessage() );
    	}
    	client.setPrenom(prenom);

    	try {
    		validationTelephone( telephone );
    	} catch ( Exception e ) {
    		setErreur( CHAMP_TEL, e.getMessage() );
    	}
    	client.setNumero(telephone);

    	try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        client.setEmail( email );

        try {
            validationMotsDePasse( mdp, confirmation );
        } catch ( Exception e ) {
            setErreur( CHAMP_MDP, e.getMessage() );
            setErreur( CHAMP_CONF, null );
        }
        client.setMdp(mdp);


        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription. Veuillez vous connectez maintenant.";
            this.setValide(true);
        } else {
            resultat = "Échec de l'inscription.";
            this.setValide(false);
        }

        return client;
    }
    
    
	
		
    
    
    
    
    
    

    

    
}
