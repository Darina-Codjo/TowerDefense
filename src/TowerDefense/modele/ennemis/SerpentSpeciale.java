package TowerDefense.modele.ennemis;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Terrain;

public class SerpentSpeciale extends Ennemis {
	
	
	public SerpentSpeciale(Terrain terrain) {
		super(terrain,100,0.5);
	}
	
	public void destructeurs(int pvInflige) {
		setPvDegat(pvInflige);	
	}
}
