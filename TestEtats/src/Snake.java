
public class Snake {
	
private Etats Game;
private Etats Menu;
private Etats NonAuthentifier;

private Etats courant;

public Snake(){
this.Game=new Game(this);
this.Menu=new Menu(this);
this.NonAuthentifier= new NonAuthentifier(this);
this.courant =NonAuthentifier;
}


public void jouer() {
	this.courant.jouer();
	
}


public void inventaire() {
	this.courant.inventaire();
	
}


public void quitter() {
	this.courant.quitter();
	
}


public void autentification() {
	this.courant.autentification();
	
}


public Etats getGame() {
	return Game;
}


public void setGame(Etats game) {
	Game = game;
}


public Etats getMenu() {
	return Menu;
}


public void setMenu(Etats menu) {
	Menu = menu;
}


public Etats getNonAuthentifier() {
	return NonAuthentifier;
}


public void setNonAuthentifier(Etats nonAuthentifier) {
	NonAuthentifier = nonAuthentifier;
}


public Etats getCourant() {
	return courant;
}


public void setCourant(Etats courant) {
	this.courant = courant;
}

public String ToString(){
	
	return "Etat : "+this.courant.toString();
}


}
