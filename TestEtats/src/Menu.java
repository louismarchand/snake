
public class Menu implements Etats{
	private Snake personnage;
	
	public Menu(Snake perso) {
		this.personnage=perso;
	}
	
	@Override
	public void jouer() {
		System.out.println("Lancement de la partie");
		this.personnage.setCourant(this.personnage.getGame());
	}

	@Override
	public void inventaire() {
		System.out.println("ouverture inventaire");
		
	}

	@Override
	public void quitter() {
		System.out.println("Au revoir");
		this.personnage.setCourant(this.personnage.getNonAuthentifier());
	}

	@Override
	public void autentification() {
		System.out.println("Attention vous ne povez pas vous identifier deux fois !");
		
	}
	
	public String toString() {
		return " Menu";
	}

}
