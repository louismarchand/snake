package Server;

import java.util.ArrayList;

public class UserLogged extends ArrayList<String> {
	
	private static final long serialVersionUID = 1L;
	
	static UserLogged instance;
	
	private UserLogged() {
		
	}
	
	static UserLogged getInstance() {
		if ( instance == null ) {
			instance = new UserLogged();
		}
		return instance;
	}

}
