package TowerDefense.modele.ennemis;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;

public class SerpentSpeciale extends Ennemis {
	
	
	public SerpentSpeciale(Terrain terrain,Jeu jeu) {
		super(terrain, 250,0.5,jeu);
	}
	
}
