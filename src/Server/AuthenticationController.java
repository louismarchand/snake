package Server;

import org.json.JSONObject;

public class AuthenticationController extends TreatmentController {

	private static AuthenticationController instance;

	public String treatJson( String username, JSONObject json_data) {
		String message = username + " " + json_data.getString("idArbre");
		return message;
	}

	public static AuthenticationController getInstance() {
		if ( instance == null ) {
			instance = new AuthenticationController();
		}
		return instance;
	}

}
