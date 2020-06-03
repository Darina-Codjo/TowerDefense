package TowerDefense.modele;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tours;

public class GrandeTour extends Tours {

	public GrandeTour(Terrain terrain, Jeu jeu) {
		super((terrain.indiceTuileFinChemin()%30)*16, (terrain.indiceTuileFinChemin()/30)*16, terrain, jeu);
		
	}
	
	public void agit() {
		
	}
	
	
	

}
