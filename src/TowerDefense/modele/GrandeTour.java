package TowerDefense.modele;

import TowerDefense.modele.Tours;

public class GrandeTour extends Tours {

	public GrandeTour(Terrain terrain, Jeu jeu) {
		super(terrain.getIndiceTuileFinChemin()%30, terrain.getIndiceTuileFinChemin()/30, terrain, jeu);
		
	}
	
	public void agit() {
		
	}
	
	
	

}
