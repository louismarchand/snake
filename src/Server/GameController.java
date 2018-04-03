package Server;

import java.awt.event.KeyEvent;
import java.sql.SQLException;

import org.json.JSONObject;

public class GameController extends TreatmentController {

	private static GameController instance;

	@Override
	protected void specificTreatment(JSONObject jsonTreatedMessage, String username, JSONObject json_data) throws SQLException {
		
		// On récupère l'id de la touche appuyé par le joueur
		int idKey = json_data.getInt("idKey");
		
		// On appelle la méthode qui correspond à la touche
		switch(idKey) {
			case KeyEvent.VK_LEFT:
				System.out.println(username+ " veut tourner à gauche");
				break;
			case KeyEvent.VK_RIGHT:
				System.out.println(username+ " veut tourner à droite");
				break;
			case KeyEvent.VK_UP:
				System.out.println(username+ " veut tourner en haut");
				break;
			case KeyEvent.VK_DOWN:
				System.out.println(username+ " veut tourner en bas");
				break;
			default:
				System.out.println(username + " : a appuyé sur "+ idKey);
		}
	}

	public static GameController getInstance() {
		if ( instance == null ) {
			instance = new GameController();
		}
		return instance;
	}

}
