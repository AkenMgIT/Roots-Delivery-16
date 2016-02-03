package akenmg.rootsdelivery.service.modelform;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class ModelForm {
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
	
	protected void validationNom( String nom ) throws Exception {
		if(nom != null){
			if(nom.length()>= 3){
				if (nom.length()>32 ) {
	    			throw new Exception( "Le nom d'utilisateur ne doit pas dépasser les 32 caractères." );
	    		}
			}else{
				throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères.");
			}
		}
	}
	
	protected void validationPrenom( String prenom ) throws Exception {
    	if(prenom != null){
    		if (prenom.length() >= 3) {
    			if (prenom.length()>32 ) {
    				throw new Exception( "Le prenom d'utilisateur ne doit pas dépasser les 32 caractères." );
    			}
    		} else {
    			throw new Exception( "Le prenom d'utilisateur doit contenir au moins 2 caractères.");
    		}
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
    	}
    }
	
	protected void validationLogin( String login ) throws Exception {
        if ( login != null) {
        	if(login.length()>= 3){
				if (login.length()>32 ) {
	    			throw new Exception( "Le login ne doit pas dépasser les 32 caractères." );
	    		}
			}else{
				throw new Exception( "Le login doit contenir au moins 3 caractères.");
			}
        } else {
            throw new Exception( "Merci de saisir un login" );
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
    
    protected void validationTitrePlat( String titre ) throws Exception {
		if(titre != null){
			if(titre.length()>= 3){
				if (titre.length()>32 ) {
	    			throw new Exception( "Le titre du plat ne doit pas dépasser les 32 caractères.");
	    		}
			}else{
				throw new Exception( "Le titre du plat doit contenir au moins 3 caractères.");
			}
		}else{
			throw new Exception( "Le titre du plat est obligatoir");
		}
	}
    protected void validationDescription( String description ) throws Exception {
    	if(description != null){
    		
    	}else{
    		
    	}
    }

	protected void validationPrix(String prix) throws Exception {
		String regex = "\\d+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(prix);
		if (prix != null) {
			if(prix.isEmpty()){
				throw new Exception("Le prix doit être spécifié");
			}
			if (!matcher.matches()) {
				throw new Exception("Le prix n'est pas un chiffre.");
			}
		} else {
			throw new Exception("Le prix doit être spécifié");
		}
	}
	
	protected void validationObligatoire(String prix) throws Exception {
		if(prix==null || prix.isEmpty()){
			throw new Exception("Le champ est obligatoire et doit être spécifié");
		}
		
		if (prix != null ) {
			
		} else {
			throw new Exception("Le prix doit être spécifié");
		}
	}

    protected void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    protected static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
