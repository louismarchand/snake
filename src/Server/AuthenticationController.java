package Server;

import java.sql.SQLException;

import org.json.JSONObject;

public class AuthenticationController extends TreatmentController {

	private static AuthenticationController instance;
	
	static final String ID_WANT_CONNECTION = "connect";
	static final String ID_MDP = "mdp";

	@Override
	protected void specificTreatment(JSONObject jsonTreatedMessage, String username, JSONObject json_data) throws SQLException {

		// On récupère la valeur du champs qui informe si la requête demande une connexion ou une déconnexion
		boolean wantConnection = json_data.getBoolean( ID_WANT_CONNECTION );

		// Demande la connexion
		if ( wantConnection ) {
			// On récupère le mdp
			String mdp = json_data.getString( ID_MDP );
			
			this.dataManager.login( username, mdp );
		}
		// Demande la déconnexion
		else {
			this.dataManager.logout( username );
		}
		// On informe que la requête a été effectuée
		jsonTreatedMessage.accumulate( TreatmentController.ID_RESPONSE, TreatmentController.CODE_REQUEST_DONE );
		
		
	}
	
	public static AuthenticationController getInstance() {
		if ( instance == null ) {
			instance = new AuthenticationController();
		}
		return instance;
	}

}
