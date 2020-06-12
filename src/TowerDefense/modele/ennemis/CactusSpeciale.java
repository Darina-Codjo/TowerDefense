package TowerDefense.modele.ennemis;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;

public class CactusSpeciale extends Ennemis{


	public CactusSpeciale(Terrain terrain,Jeu jeu) {
		super(terrain,200,0.5, jeu);
	}

}
