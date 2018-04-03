package Server;

import java.sql.SQLException;

import org.json.JSONObject;

public class SkillController extends TreatmentController {

	private static SkillController instance;

	static final String ID_IDSNAKE = "idSnake";
	static final String ID_IDSKILL= "idSkill";
	static final String ID_ADD = "add";

	@Override
	protected void specificTreatment(JSONObject jsonTreatedMessage, String username, JSONObject json_data) throws SQLException {
		
		// On récupère la valeur du champs qui informe si la requête demande un ajout ou une suppression
		boolean wantToAdd = json_data.getBoolean( ID_ADD );
		
		// On récupère l'id du snake et du skill
		String idSnake = json_data.getString( ID_IDSNAKE );
		String idSkill = json_data.getString( ID_IDSKILL );

		this.dataManager.getSkills(idSnake);
		// Demande l'ajout d'une compétence
//		if ( wantToAdd ) {
//			this.dataManager.addSkill( idSnake, idSkill );
//		}
//		// Demande la suppression d'une compétence
//		else {
//			this.dataManager.removeSkill( idSnake, idSkill );
//		}
		// On informe que la requête a été effectuée
		jsonTreatedMessage.accumulate( TreatmentController.ID_RESPONSE, TreatmentController.CODE_REQUEST_DONE );
		
	}

	public static SkillController getInstance() {
		if ( instance == null ) {
			instance = new SkillController();
		}
		return instance;
	}

}
