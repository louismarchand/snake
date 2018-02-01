package Server;

import org.json.JSONObject;

public class GameController extends TreatmentController {

	private static GameController instance;

	public String treatJson( String username, JSONObject json_data) {
		String message = username + " " + json_data.getString("idArbre");
		return message;
	}

	public static GameController getInstance() {
		if ( instance == null ) {
			instance = new GameController();
		}
		return instance;
	}

}
