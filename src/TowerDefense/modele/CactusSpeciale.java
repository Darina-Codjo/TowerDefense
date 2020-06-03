package TowerDefense.modele;

import TowerDefense.modele.EnnemisSpeciales;

public class CactusSpeciale extends EnnemisSpeciales{
	
	
	public CactusSpeciale(Terrain terrain) {
		super(terrain,100,10);
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
