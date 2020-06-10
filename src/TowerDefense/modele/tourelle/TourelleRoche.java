package TowerDefense.modele.tourelle;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.projectile.ProjectileFeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.tourelle.TourelleBasique;

public class TourelleRoche extends TourelleBasique {

	public TourelleRoche(int x, int y, Terrain terrain,Jeu jeu) {
		super(x, y, terrain, jeu);
	}
	
	public void tir() {
		
		Ennemis ennemiViser= ennemieVisable(3);
		
		if (ennemiViser != null) {
			if(!getJeu().projectileExisteSurEnnemi(ennemiViser.getId())) {				
				getJeu().getListeProjectile().add(new ProjectileFeu(this,ennemiViser,getJeu()));	
			}			
		}
			
	}
}
