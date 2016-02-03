package akenmg.rootsdelivery.service.modelform;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import akenmg.rootsdelivery.dao.DaoClient;
import akenmg.rootsdelivery.dao.DaoCommande;
import akenmg.rootsdelivery.model.Admin;
import akenmg.rootsdelivery.model.Client;
import akenmg.rootsdelivery.model.Commande;

public class CreateCommandeForm extends ModelForm{
	protected static final String CHAMP_IDCLI   = "idClient";
	protected static final String CHAMP_ADR   = "adresse";
	protected static final String CHAMP_COMPLA   = "commande";
	
	public Commande ajoutCommande( HttpServletRequest request ) {
		Commande commande = null;
		String adresse = getValeurChamp( request, CHAMP_ADR );
		String idClient = getValeurChamp( request, CHAMP_IDCLI );
		int id = Integer.parseInt(idClient);
		commande = (Commande)request.getSession().getAttribute(CHAMP_COMPLA);

		if(commande!=null ){
			if(!commande.getPlacoms().isEmpty()){
				commande.setClient(DaoClient.find(id));
				commande.setDate(new Date());
				commande.setEtat(Commande.ETAT.ENCOURS);
			}else{
				setErreur( CHAMP_COMPLA, "La commande ne peut être vide.");
			}
			
//			DaoCommande.create(commande);
		}else{
			commande = new Commande();
			setErreur( CHAMP_COMPLA, "La commande n'est pas initialisée");
		}
		
		try {
			validationObligatoire(adresse);
		} catch ( Exception e ) {
			setErreur( CHAMP_ADR, e.getMessage() );
		}
		commande.setAdresse(adresse);
    	
    	
    	if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'insertion.";
            this.setValide(true);
        } else {
            resultat = "Échec de l'insertion.";
            this.setValide(false);
        }
    	
		return commande;
	}
}
