package Server;

import java.sql.SQLException;

import org.json.JSONObject;

public class SkillController extends TreatmentController {

	private static SkillController instance;

	@Override
	protected void specificTreatment(JSONObject jsonTreatedMessage, String username, JSONObject json_data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public static SkillController getInstance() {
		if ( instance == null ) {
			instance = new SkillController();
		}
		return instance;
	}

}
