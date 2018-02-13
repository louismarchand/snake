package Server;

import org.json.JSONObject;

abstract public class TreatmentController {

	// ID dans le json envoyé
	static final String ID_RESPONSE = "response";
	// Valeur des codes de retours
	static final String CODE_REQUEST_DONE = "1";
	static final String CODE_REQUEST_NOT_DONE = "2";
	static final String CODE_REQUEST_UNRECOGNIZE = "3";
	static final String CODE_MDP_NON_WELL_FORMED = "4";
	static final String CODE_BDD_FAILURE = "5";
	
	// ID dans le json reçu
	static final String ID_HEADER = "header";
	static final String ID_TYPE = "typeEvent";
	static final String ID_USERNAME = "username";
	static final String ID_DATA = "data";
	
	DataManager dataManager;
	
	public TreatmentController () {
		dataManager = DataManager.getInstance();
	}

	public String treatJson( String username, JSONObject json_data) {
		// TODO Auto-generated method stub
		return username+" ko";
	}

	
	
}
