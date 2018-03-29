package Server;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Classe permettant de faire le lien entre le programme et la BDD
 * @author teddy
 */
public class DataManager {

	public static DataManager instance;
	
	private String url;
	private String user;
	private String mdp;
	private String db;
	private Connection connector;
	
	private DataManager() {
		String address = "127.0.0.1";
		user = "UA-user";
		mdp = "ua-user";
		db = "snakeRPG";
		this.url = "jdbc:mysql://"+ address +"/"+ this.db;
	}
	
	/**
	 * Permet de lancer une connexion à la BDD
	 * @param adresse - L'ip ou hostname de la BDD
	 * @param usr - Le nom d'utilisateur de la BDD
	 * @param db - Le nom de la base
	 * @param mdp - Le mdp de l'utilisateur de la BDD
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void connect() throws ClassNotFoundException, SQLException{
		this.connector = DriverManager.getConnection(this.url, this.user, this.mdp);
	}
	
	/**
	 * Permet de fermer la connexion
	 * @throws SQLException
	 */
	public void disconnect() throws SQLException{
		// stmt.close(); -> est fermé après chaque utilisation
		connector.close();
	}
	
	/**
	 * Ajoute un nouveau joueur en base
	 * @param data
	 * @param mdp 
	 * @throws SQLException 
	 */
	public boolean register ( String username, String mdp ) throws SQLException {
		Statement stmt = connector.createStatement();
		String request = "insert into player values ('"+ username +"','"+ mdp +"');";
		System.out.println(request);
		boolean ret = stmt.execute(request);
		stmt.close();
		
		return ret;
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
