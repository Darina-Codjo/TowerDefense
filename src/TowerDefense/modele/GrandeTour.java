package TowerDefense.modele;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tours;

public class GrandeTour extends Tours {

	public GrandeTour(Terrain terrain, Jeu jeu) {
		super((terrain.getIndiceTuileFinChemin()%30)*16+8, (terrain.getIndiceTuileFinChemin()/30)*16+8, terrain, jeu);
		
	}
	
	public void agit() {
		
	}
	
	
	

}
