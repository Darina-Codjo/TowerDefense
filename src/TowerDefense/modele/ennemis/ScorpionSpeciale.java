package TowerDefense.modele.ennemis;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;

public class ScorpionSpeciale extends Ennemis {
	
	private int pv;
	private Terrain terrain;
	private Jeu jeu;
	
	public ScorpionSpeciale(Terrain terrain) {
		super(terrain, 100, 0.5);
	}
	
	public void dedoublement() {
		if(this.pv == 0) {
			Scorpion scorpionDouble = new Scorpion(terrain);
		}
	}

}
