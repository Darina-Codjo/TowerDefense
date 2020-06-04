package TowerDefense.modele.tourelle;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.projectile.ProjectileGlace;

public class TourelleGlace extends TourelleBasique {

	public TourelleGlace(double x, double y, Terrain terrain,Jeu jeu) {
		super(x, y, terrain,jeu);
	}
	
	public void tir() {
		
		for(int i=0; i<listeEnnemis().size(); i++) {
			if(ennemisProche(50)) {
				getJeu().getListeProjectile().add(new ProjectileGlace(this,listeEnnemis().get(i),getJeu()));
			}
		}
			
	}


	
	
	

}
