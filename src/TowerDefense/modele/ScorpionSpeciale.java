package TowerDefense.modele;

import TowerDefense.modele.EnnemisSpeciales;

public class ScorpionSpeciale extends EnnemisSpeciales {
	
	private int pv;
	private Terrain terrain;
	@SuppressWarnings("unused")
	private int v;
	@SuppressWarnings("unused")
	private Jeu jeu;
	
	public ScorpionSpeciale(Terrain terrain) {
		super(terrain,100,10);
	}

	public ScorpionSpeciale(Terrain terrain, int pv, int v) {
		super(terrain, pv, v);
	}
	
	@SuppressWarnings("unused")
	public void dedoublement() {
		if(this.pv==0) {
			Scorpion scorpionDouble = new Scorpion(terrain);
			//jeu.ajouterActeur(scorpionDouble);
		}
	}

}
