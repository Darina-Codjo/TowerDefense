package TowerDefense.modele.ennemis;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Acteur;
import TowerDefense.modele.ennemis.Scorpion;

public class ScorpionSpeciale extends Ennemis {

	
	public ScorpionSpeciale(Terrain terrain,Jeu jeu) {
		super(terrain, 100, 0.5, jeu);
	}
	
	public void dedoublement() {
		if(this.getPv()==20) {
			
			Terrain terrain=new Terrain();
			Acteur scorpionDouble = new Scorpion(terrain, getJeu());			
			getJeu().ajouterActeur(scorpionDouble);

		
		}
	}

}
