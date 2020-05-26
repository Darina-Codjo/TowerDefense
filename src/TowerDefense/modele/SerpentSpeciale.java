package TowerDefense.modele;

import TowerDefense.modele.EnnemisSpeciales;

public class SerpentSpeciale extends EnnemisSpeciales {
	
	
	public SerpentSpeciale(Terrain terrain) {
		super(terrain,100,10);
	}
	
	public void destructeurs(int pvInflige) {
		setPvDegat(pvInflige);	
	}

}
