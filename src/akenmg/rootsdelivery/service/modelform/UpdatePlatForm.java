package akenmg.rootsdelivery.service.modelform;

import javax.servlet.http.HttpServletRequest;

import akenmg.rootsdelivery.model.Plat;

public class UpdatePlatForm extends CreatePlatForm{
	private static final String CHAMP_ID    = "id";
	
	public Plat ajoutPlat( HttpServletRequest request ) { 
		String id = getValeurChamp( request, CHAMP_ID );
		String titre = getValeurChamp( request, CHAMP_TITRE );
    	String description = getValeurChamp( request, CHAMP_DESCRIPTION );
    	String prix = getValeurChamp( request, CHAMP_PRIX );
		
    	Plat plat = new Plat();
		plat.setId(Integer.parseInt(id));
		try {
    		validationTitrePlat(titre);
    	} catch ( Exception e ) {
    		setErreur( CHAMP_TITRE, e.getMessage() );
    	}
    	plat.setTitre(titre);
    	
    	try {
    		validationDescription(description);
    	} catch ( Exception e ) {
    		setErreur( CHAMP_DESCRIPTION, e.getMessage() );
    	}
    	plat.setDescription(description);
    	
    	boolean isNum = false;
    	try {
    		validationPrix(prix);
    		isNum=true;
    	} catch ( Exception e ) {
    		setErreur( CHAMP_PRIX, e.getMessage() );
    	}
    	
    	if(isNum){
    		plat.setPrix(Integer.parseInt(prix));
    	}
    	
    	if ( erreurs.isEmpty() ) {
            resultat = "Update Plat Valide";
            this.setValide(true);
        } else {
            resultat = "Update Plat invalide";
            this.setValide(false);
        }
		
		return plat;
	}
	
}
