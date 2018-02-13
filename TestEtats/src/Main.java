
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Snake perso = new Snake();
		 
		 System.out.println(perso.ToString());
		 
		 perso.jouer();
		 perso.inventaire();
		 perso.autentification();
		 System.out.println(perso.ToString());
		 
		 perso.inventaire();
		 perso.autentification();
		 perso.jouer();
		 System.out.println(perso.ToString());
		 perso.inventaire();
		 perso.autentification();
		 perso.jouer();
		 perso.quitter();
		 System.out.println(perso.ToString());
		 perso.quitter();
		 System.out.println(perso.ToString());
		 perso.quitter();
		 System.out.println(perso.ToString());
	}

}
