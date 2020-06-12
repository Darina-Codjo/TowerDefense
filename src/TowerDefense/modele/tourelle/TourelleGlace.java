package TowerDefense.modele.tourelle;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tours;
import TowerDefense.modele.projectile.ProjectileFeu;
import TowerDefense.modele.projectile.ProjectileGlace;

public class TourelleGlace extends Tours {

	public TourelleGlace(int x, int y, Terrain terrain,Jeu jeu) {
		super(x, y, terrain,jeu);
	}
	
	
	//Regarde si un ennemi est à sa portée (ici de 50 pixels), si c'est le cas, elle tir un projectile de glace sur l'ennemi
	public void tir() {
		
		Ennemis ennemiViser= ennemieVisable(3);
		
		if (ennemiViser != null) {
			if(!getJeu().projectileExisteSurEnnemi(ennemiViser.getId())) {				
				getJeu().getListeProjectile().add(new ProjectileGlace(this,ennemiViser,getJeu()));
			}			
		}		
	}
}
