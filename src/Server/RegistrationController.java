package Server;

import org.json.JSONObject;

public class RegistrationController extends TreatmentController {

	private static RegistrationController instance;
	
	static final String ID_MDP = "mdp";

	public String treatJson( String username, JSONObject json_data) {
		JSONObject jsonTreatedMessage = new JSONObject();
		
		// Récupération du mot de passe
		String mdp = json_data.getString( ID_MDP );
		
		try {
			
			// Vérification de la construction du mot de passe
			if ( Service.isMdpWellFormed( mdp ) ) {
				// On persist le nouvel utilisateur
				this.dataManager.register( username, mdp );
				// On informe que la requête a été effectuée
				jsonTreatedMessage.accumulate( TreatmentController.ID_RESPONSE, TreatmentController.CODE_REQUEST_DONE );
			} else {
				// Renvoie de l'erreur
				jsonTreatedMessage.accumulate( TreatmentController.ID_RESPONSE, TreatmentController.CODE_MDP_NON_WELL_FORMED );
			}
			
		} catch ( Exception e ) {
			// On informe que la requête n'a pas été effectuée
			jsonTreatedMessage.accumulate( TreatmentController.ID_RESPONSE, TreatmentController.CODE_BDD_FAILURE );		
		}
		
		// On renvoit la chaine de caractères du json
		return jsonTreatedMessage.toString();
	}
	
	public static RegistrationController getInstance() {
		if ( instance == null ) {
			instance = new RegistrationController();
		}
		return instance;
	}
}
