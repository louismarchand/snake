package Server;

import java.sql.SQLException;

import org.json.JSONObject;

public class PlayroomController extends TreatmentController {

	private static PlayroomController instance;

	@Override
	protected void specificTreatment(JSONObject jsonTreatedMessage, String username, JSONObject json_data) throws SQLException {
		// TODO Auto-generated method stub
		String message = username + " " + json_data.getString("idArbre");
		
	}

	public static PlayroomController getInstance() {
		if ( instance == null ) {
			instance = new PlayroomController();
		}
		return instance;
	}

}
