package TowerDefense.modele.ennemis;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;

public class CactusSpeciale extends Ennemis{


	public CactusSpeciale(Terrain terrain,Jeu jeu) {
		super(terrain,100,0.5, jeu);
	}

	public void rechargement() {
		int temps=0;
		int newPV=0;

		while(newPV != 100) {
			temps++;
			newPV++;
			if (temps%10==0)
				this.setPv(newPV);
		}
	}
}
