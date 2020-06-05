package TowerDefense.modele;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.projectile.ProjectileRoche;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.tourelle.Tourelle;

public class TourelleRoche extends Tourelle {

	public TourelleRoche(double x, double y, Terrain terrain,Jeu jeu) {
		super(x, y, terrain, jeu);
	}
	
	public void tir() {
		
		Ennemis ennemiViser= ennemieVisable(50);
		
		if (ennemiViser != null) {
			if(!getJeu().projectileExisteSurEnnemi(ennemiViser.getId())) {				
				getJeu().getListeProjectile().add(new ProjectileRoche(this,ennemiViser,getJeu()));
				
			}			
		}
			
	}



}
