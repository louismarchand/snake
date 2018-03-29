package Server;

import java.sql.SQLException;

import org.json.JSONObject;

public class GameController extends TreatmentController {

	private static GameController instance;

	@Override
	protected void specificTreatment(JSONObject jsonTreatedMessage, String username, JSONObject json_data) throws SQLException {
		// TODO Auto-generated method stub
		String message = username + " " + json_data.getString("idArbre");
		
	}

	public static GameController getInstance() {
		if ( instance == null ) {
			instance = new GameController();
		}
		return instance;
	}

}
