package Server;

import org.json.JSONObject;

public class SkillController extends TreatmentController {

	private static SkillController instance;

	public String treatJson( String username, JSONObject json_data) {
		String message = username + " " + json_data.getString("idArbre");
		return message;
	}

	public static SkillController getInstance() {
		if ( instance == null ) {
			instance = new SkillController();
		}
		return instance;
	}

}
