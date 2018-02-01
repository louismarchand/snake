package Server;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ServerTreatment {
	
	static final String ID_HEADER = "header";
	static final String ID_DATA = "data";
	static final String ID_TYPE = "typeEvent";
	static final String ID_USERNAME = "username";
	
	
	private TreatmentController controller;
	private ControllerFactory controllerFactory;
	
	public ServerTreatment() {
		controllerFactory = new ControllerFactory();
	}

	public String treat( String message ) {

		String res = "ERROR- ";
		
		// Si le JSON est invalide
		if ( ! this.isValidJson(message) ) {
			res += "JSON non valide";
		} else {
			
			// On récupère les objets JSON
			JSONObject json_object = new JSONObject( message );
			try {
				JSONObject json_header = json_object.getJSONObject( ID_HEADER );
				JSONObject json_data= json_object.getJSONObject( ID_DATA );

				// On récupère le controller adequat pour répondre à l'action
				String type = json_header.getString( ID_TYPE );
				controller = controllerFactory.create(type);
				
				// On récupère l'utilisateur
				String username = json_header.getString( ID_USERNAME );
				
				// On récupère la réponse au format String 
				res = controller.treatJson( username, json_data );
			} catch (JSONException ex1) {
				// On n'arrive pas à parser le JSON
				res += "JSON mal formé";
	        }
			
		}
		
		return res;
	}
	
	private boolean isValidJson (String text) {
	    try {
	        new JSONObject(text);
	    } catch (JSONException ex) {
	        // in case JSONArray is valid as well...
	        try {
	            new JSONArray(text);
	        } catch (JSONException ex1) {
	            return false;
	        }
	    }
	    return true;
	}
	
}