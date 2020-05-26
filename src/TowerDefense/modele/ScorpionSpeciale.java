package TowerDefense.modele;

import TowerDefense.modele.EnnemisSpeciales;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Scorpion;
import TowerDefense.modele.Terrain;

public class ScorpionSpeciale extends EnnemisSpeciales {
	
	private int pv;
	private Terrain terrain;
	private int v;
	private Jeu jeu;
	
	public ScorpionSpeciale(Terrain terrain) {
		super(terrain,100,10);
	}

	public ScorpionSpeciale(Terrain terrain, int pv, int v) {
		super(terrain, pv, v);
	}
	
	public void dedoublement() {
		if(this.pv==0) {
			Scorpion scorpionDouble = new Scorpion(terrain);
			this.jeu.getListeActeurs().add(scorpionDouble);
		}
	}

}
