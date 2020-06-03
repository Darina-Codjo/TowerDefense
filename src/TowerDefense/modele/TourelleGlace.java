package TowerDefense.modele;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.TourelleBasique;
import TowerDefense.modele.Projectile;

public class TourelleGlace extends TourelleBasique {

	public TourelleGlace(double x, double y, Terrain terrain,Jeu jeu) {
		super(x, y, terrain,jeu);
	}
	
	public void tir() {
		
		for(int i=0; i<listeEnnemis().size(); i++) {
			if(ennemisProche(50,listeEnnemis().get(i))&& !getJeu().projectileExisteSurEnnemi(listeEnnemis().get(i).getId())) {
				getJeu().getListeProjectile().add(new ProjectileGlace(this,listeEnnemis().get(i),getJeu()));
			}
		}
			
	}


	
	
	

}
