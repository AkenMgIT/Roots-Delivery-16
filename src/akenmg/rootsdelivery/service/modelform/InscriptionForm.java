package akenmg.rootsdelivery.service.modelform;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import akenmg.rootsdelivery.model.Client;

public class InscriptionForm {
	protected static final String CHAMP_NOM    = "nom";
	protected static final String CHAMP_PRENOM   = "prenom";
	protected static final String CHAMP_TEL   = "telephone";
	protected static final String CHAMP_EMAIL  = "email";
	protected static final String CHAMP_MDP   = "motdepasse";
	protected static final String CHAMP_CONF   = "confirmation";
    
	protected String              resultat;
	protected boolean 			valide;
	protected Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

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
    
    
	protected void validationNom( String nom ) throws Exception {
    	if ( nom != null && nom.length()>= 3) {
    		if (nom.length()>32 ) {
    			throw new Exception( "Le nom d'utilisateur ne doit pas dépasser les 32 caractères." );
    		}
    	} else {
    		throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères.");
    	}
    }
    
    protected void validationPrenom( String prenom ) throws Exception {
    	if ( prenom != null && prenom.length() >= 3) {
    		if (prenom.length()>32 ) {
    			throw new Exception( "Le prenom d'utilisateur ne doit pas dépasser les 32 caractères." );
    		}
    	} else {
    		throw new Exception( "Le prenom d'utilisateur doit contenir au moins 2 caractères.");
    	}
    }
    
    protected void validationTelephone( String telephone ) throws Exception {
    	if ( telephone != null) {
//    		+1 1234567890123 : true
//    		+12 123456789 : true
//    		+123 123456 : true
    		String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    		Pattern pattern = Pattern.compile(regex);
    		Matcher matcher = pattern.matcher(telephone);
    		if(!matcher.matches()){
    			throw new Exception( "Format du numéro non valide,veuillez suivre l'exemple : +261 xxxxxxxxx" );
    		}
    	} else {
//    		throw new Exception( "Merci de saisir un telephone" );
    	}
    }
    
    protected void validationEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    protected void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
        if ( motDePasse != null && confirmation != null ) {
            if ( !motDePasse.equals( confirmation ) ) {
                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
            } else if ( motDePasse.length() < 6 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    protected void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    protected static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
