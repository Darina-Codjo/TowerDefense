package TowerDefense.modele;

import TowerDefense.modele.EnnemisSpeciales;
import TowerDefense.modele.Terrain;

public class SerpentSpeciale extends EnnemisSpeciales {
	
	
	public SerpentSpeciale(Terrain terrain) {
		super(terrain);
	
	}

	public SerpentSpeciale(Terrain terrain, int pv, int v) {
		super(terrain, pv, v);
	}
	
	public void destructeurs(int pvInflige) {
		
		//setPVTourelle(pvInflige);
		
	}

}
