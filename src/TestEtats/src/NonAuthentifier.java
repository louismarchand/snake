
public class NonAuthentifier implements Etats{
	private Snake personnage;
	
	
	public NonAuthentifier(Snake perso) {
		this.personnage=perso;
	}
	
	@Override
	public void jouer() {
		System.out.println("Vous devez vous identifier avant de jouer !");
		
	}

	@Override
	public void inventaire() {
	System.out.println("l'iventaireest disponible uniquement pour les joueurs connecté");
		
	}

	@Override
	public void quitter() {
		System.out.println("Fermeture du client");
		
	}

	@Override
	public void autentification() {
	System.out.println("vous êtes bien autentifier !");
	this.personnage.setCourant(this.personnage.getMenu());
	}
	
	
	public String toString() {
		return " NonAuthentifier";
	}

}
