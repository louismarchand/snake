package Server;

/**
 * Classe permettant de faire le lien entre le programme et la BDD
 * @author teddy
 */
public class DataManager {

	public static DataManager instance;
	
	/**
	 * Ajoute un nouveau joueur en base
	 * @param data
	 * @param mdp 
	 */
	public void register ( String data, String mdp ) {
		System.out.println("New player: "+ data +", mdp: "+ mdp);
	}
	
	/**
	 * Connecte le joueur
	 * @param data
	 * @param mdp 
	 */
	public void login ( String data, String mdp ) {
		System.out.println("Login: "+ data +", mdp: "+ mdp);
	}

	/**
	 * Déconnecte le joueur
	 * @param data
	 */
	public void logout ( String data ) {
		System.out.println("Logout: "+ data);
	}
	
	/**
	 * Récupère l'instance unique de la classe DataManager
	 * @return
	 */
	public static DataManager getInstance() {
		if ( instance == null ) {
			instance = new DataManager();
		}
		return instance;
	}
	
}
