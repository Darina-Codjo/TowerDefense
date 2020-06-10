package TowerDefense.modele;

import TowerDefense.modele.Tours;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.projectile.Projectile;

public class GrandeTour extends Tours {

	public GrandeTour(Terrain terrain, Jeu jeu) {
		super(terrain.getIndiceTuileFinChemin()%30, terrain.getIndiceTuileFinChemin()/30, terrain, jeu);
		
	}
	
	public void agit() {
		Ennemis ennemiViser = ennemieVisable(5);
		
		if (ennemiViser != null) {
			if(!getJeu().projectileExisteSurEnnemi(ennemiViser.getId())) {				
				getJeu().getListeProjectile().add(new Projectile(this,ennemiViser,getJeu()));
				
			}			
		}
		
	}
}
