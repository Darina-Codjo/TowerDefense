package TowerDefense.modele.ennemis;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;

public class SerpentSpeciale extends Ennemis {
	
	
	public SerpentSpeciale(Terrain terrain, Jeu jeu) {
		super(terrain,100,0.5, jeu);
	}
	
	public void destructeurs(int pvInflige) {
		setPvDegat(pvInflige);	
	}
}
