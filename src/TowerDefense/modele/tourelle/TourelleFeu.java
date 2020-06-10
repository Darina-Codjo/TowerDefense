package TowerDefense.modele.tourelle;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.projectile.ProjectileFeu;
import TowerDefense.modele.tourelle.Tourelle;

public class TourelleFeu extends Tourelle{

	public TourelleFeu(int x, int y, Terrain terrain, Jeu jeu ) {
		super(x, y, terrain, jeu);
	}
	
	//Regarde si un ennemi est à sa portée (ici de 50 pixels), si c'est le cas, elle tir un projectile de feu sur l'ennemis
	public void tir() {	
		
		Ennemis ennemiViser = ennemieVisable(3);
		
		if (ennemiViser != null) {
			if(!getJeu().projectileExisteSurEnnemi(ennemiViser.getId())) {				
				getJeu().getListeProjectile().add(new ProjectileFeu(this,ennemiViser,getJeu()));
			}			
		}			
	}
}
