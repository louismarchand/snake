package Server;


public class ControllerFactory {
	
	/**
	 * METTRE LES CONTROLLEURS EN SINGLETON
	 */

	static final String ID_REGISTRATION = "registration";
	static final String ID_AUTHENTICATION = "authentication";
	static final String ID_SKILL = "skill";
	static final String ID_PLAYROOM = "playroom";
	static final String ID_GAME = "game";
	
	public TreatmentController create ( String type ) {
		TreatmentController controller = null;

		if ( type.equals( ID_REGISTRATION ) ) {
			controller = RegistrationController.getInstance();
		}
		else if ( type.equals( ID_AUTHENTICATION ) ) {
			controller = AuthenticationController.getInstance();
		}
		else if ( type.equals( ID_SKILL ) ) {
			controller = SkillController.getInstance();
		}
		else if ( type.equals( ID_PLAYROOM ) ) {
			controller = PlayroomController.getInstance();
		}
		else if ( type.equals( ID_GAME ) ) {
			controller = GameController.getInstance();
		}
		
		return controller;
	}
	
}
