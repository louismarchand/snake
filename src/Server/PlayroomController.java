package Server;

import org.json.JSONObject;

public class PlayroomController extends TreatmentController {

	private static PlayroomController instance;

	public String treatJson( String username, JSONObject json_data) {
		String message = username + " " + json_data.getString("idArbre");
		return message;
	}

	public static PlayroomController getInstance() {
		if ( instance == null ) {
			instance = new PlayroomController();
		}
		return instance;
	}

}
