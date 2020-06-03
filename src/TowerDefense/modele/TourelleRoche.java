package TowerDefense.modele;

import TowerDefense.modele.ProjectileRoche;

public class TourelleRoche extends TourelleBasique {

	public TourelleRoche(double x, double y, Terrain terrain,Jeu jeu) {
		super(x, y, terrain, jeu);
	}
	
	public void tir() {
		
		for(int i=0; i<listeEnnemis().size(); i++) {
			if(ennemisProche(50)) {
				getJeu().getListeProjectile().add(new ProjectileRoche(this,listeEnnemis().get(i),getJeu()));
			}
		}
			
	}



}
