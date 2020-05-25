package TowerDefense.modele;

import TowerDefense.modele.EnnemisSpeciales;
import TowerDefense.modele.Terrain;

public class CactusSpeciale extends EnnemisSpeciales{
	
	
	private int pv;
	
	public CactusSpeciale(Terrain terrain) {
		super(terrain,100,10);
	}

	public CactusSpeciale(Terrain terrain, int pv, int v) {
		super(terrain, pv, v);
	}
	
	
	public void rechargement() {
		int temps=0;
		int newPV=0;
		
		while(newPV != pv) {
			if (temps%10==0)
				pv=newPV;
			else
				temps++;
				newPV++;
		}
	}
	
	

}
