
public class Game implements Etats{
	private Snake personnage;
	
	public Game(Snake perso) {
		this.personnage=perso;
	}
	@Override
	public void jouer() {
		System.out.println("Vous êtes dejas en plein jeux ! quittez votre partie avant d\'en lencer une autre");
		
	}

	@Override
	public void inventaire() {
		System.out.println("Vous ne pouvez pas ouvrir votre inventire en plein jeux");
		
	}

	@Override
	public void quitter() {
		System.out.println("Retour au menu principal");
		this.personnage.setCourant(this.personnage.getMenu());
		
	}

	@Override
	public void autentification() {
		System.out.println("Vous êtes dejas identifier et en jeu !");
		
	}
	
	public String toString() {
		return " Game";
	}

}
