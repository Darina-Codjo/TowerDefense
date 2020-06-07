package TowerDefense.modele.ennemis;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;

public class ScorpionSpeciale extends Ennemis {
	
	private int pv;
	private Terrain terrain;
	private Jeu jeu;
	
	public ScorpionSpeciale(Terrain terrain) {
		super(terrain,100,10);
		this.jeu=new Jeu(terrain);
	}
	
	public void dedoublement() {
		//if(this.pv==0) {
			Ennemis scorpionDouble = new Scorpion(this.terrain);
			jeu.ajouterActeur(scorpionDouble);
		//}
	}

}
