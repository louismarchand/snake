package Server;

import org.json.JSONObject;

public class AuthenticationController extends TreatmentController {

	private static AuthenticationController instance;
	
	static final String ID_WANT_CONNECTION = "connect";
	static final String ID_MDP = "mdp";

	public String treatJson( String username, JSONObject json_data) {
		JSONObject jsonTreatedMessage = new JSONObject();
		
		// On récupère la valeur du champs qui informe si la requête demande une connexion ou une déconnexion
		boolean wantConnection = json_data.getBoolean( ID_WANT_CONNECTION );
		
		// On récupère le mdp
		String mdp = json_data.getString( ID_MDP );
		
		try {
			
			// Demande la connexion
			if ( wantConnection ) {
				this.dataManager.login( username, mdp );
			}
			// Demande la déconnexion
			else {
				this.dataManager.logout( username );
			}
			// On informe que la requête a été effectuée
			jsonTreatedMessage.accumulate( TreatmentController.ID_RESPONSE, TreatmentController.CODE_REQUEST_DONE );
			
		} catch ( Exception e ) {
			// On informe que la requête n'a pas été effectuée
			jsonTreatedMessage.accumulate( TreatmentController.ID_RESPONSE, TreatmentController.CODE_BDD_FAILURE );			
		}
		
		return jsonTreatedMessage.toString();
	}

	public static AuthenticationController getInstance() {
		if ( instance == null ) {
			instance = new AuthenticationController();
		}
		return instance;
	}

}
