package akenmg.rootsdelivery.service.modelform;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import akenmg.rootsdelivery.model.Client;

public class UpdateClientForm extends CreateClientForm{
	private static final String CHAMP_ID    = "id";
    


	public Client updateClient( HttpServletRequest request ) {
		String id = getValeurChamp( request, CHAMP_ID );
    	String nom = getValeurChamp( request, CHAMP_NOM );
    	String prenom = getValeurChamp( request, CHAMP_PRENOM );
    	String telephone = getValeurChamp( request, CHAMP_TEL );
    	String email = getValeurChamp( request, CHAMP_EMAIL );
    	String mdp = getValeurChamp( request, CHAMP_MDP );
    	String confirmation = getValeurChamp( request, CHAMP_CONF );

    	Client client = new Client();

    	client.setId(Integer.parseInt(id));
    	
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
            resultat = "Update Form Valide";
            this.setValide(true);
        } else {
            resultat = "Update Form Valide invalide";
            this.setValide(false);
        }

        return client;
    }
    
    
//	private void validationId( String id ) throws Exception {
//		if ( id != null) {
//			if (nom.length()>32 ) {
//				throw new Exception( "Le nom d'utilisateur ne doit pas dépasser les 32 caractères." );
//			}
//		} else {
//			throw new Exception( "l'ID est null");
//		}
//	}
}
