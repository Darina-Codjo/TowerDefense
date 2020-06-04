package TowerDefense.modele.tourelle;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.projectile.ProjectileFeu;

public class TourelleFeu extends TourelleBasique{

	public TourelleFeu(double x, double y, Terrain terrain, Jeu jeu ) {
		super(x, y, terrain, jeu);
	}
	
	public void tir() {


		for(int i=0; i<listeEnnemis().size(); i++) {
			
			if(ennemisProche(50)) {
				getJeu().getListeProjectile().add(new ProjectileFeu(this,listeEnnemis().get(i),getJeu()));
			}
				
			
		}
		
			
	}
	



}
