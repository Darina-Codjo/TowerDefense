package TowerDefense.modele.ennemis;

import TowerDefense.modele.EnnemisSpeciales;
import TowerDefense.modele.Terrain;

public class SerpentSpeciale extends EnnemisSpeciales {
	
	
	public SerpentSpeciale(Terrain terrain) {
		super(terrain,100,10);
	}
	
	public void destructeurs(int pvInflige) {
		setPvDegat(pvInflige);	
	}

}
