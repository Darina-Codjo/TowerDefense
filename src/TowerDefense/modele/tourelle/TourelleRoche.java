package TowerDefense.modele.tourelle;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.projectile.ProjectileRoche;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tours;

public class TourelleRoche extends Tours {

	public TourelleRoche(int x, int y, Terrain terrain,Jeu jeu) {
		super(x, y, terrain, jeu);
	}


	//Regarde si un ennemi est � sa port�e (ici de 50 pixels), si c'est le cas, elle tir un projectile de roche sur l'ennemi
	public void tir() {

		Ennemis ennemiViser= ennemieVisable(3);

		if (ennemiViser != null) {
			if(!getJeu().projectileExisteSurEnnemi(ennemiViser.getId())) {				
				getJeu().getListeProjectile().add(new ProjectileRoche(this,ennemiViser,getJeu()));
			}			
		}

	}
}
