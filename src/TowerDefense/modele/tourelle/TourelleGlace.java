package TowerDefense.modele.tourelle;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.projectile.ProjectileFeu;
import TowerDefense.modele.tourelle.Tourelle;

public class TourelleGlace extends Tourelle {

	public TourelleGlace(int x, int y, Terrain terrain,Jeu jeu) {
		super(x, y, terrain,jeu);
	}
	
	
	//Regarde si un ennemi est � sa port�e (ici de 50 pixels), si c'est le cas, elle tir un projectile de glace sur l'ennemi
	public void tir() {
		
		Ennemis ennemiViser= ennemieVisable(3);
		
		if (ennemiViser != null) {
			if(!getJeu().projectileExisteSurEnnemi(ennemiViser.getId())) {				
				getJeu().getListeProjectile().add(new ProjectileFeu(this,ennemiViser,getJeu()));
			}			
		}		
	}
}
