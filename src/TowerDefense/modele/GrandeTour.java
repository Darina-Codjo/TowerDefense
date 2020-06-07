package TowerDefense.modele;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tours;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.projectile.Projectile;

public class GrandeTour extends Tours {

	public GrandeTour(Terrain terrain, Jeu jeu) {
		super((terrain.getIndiceTuileFinChemin()%30)*16+8, (terrain.getIndiceTuileFinChemin()/30)*16+8, terrain, jeu);
		
	}
	
	public void agit() {
		Ennemis ennemiViser= ennemieVisable(200);
		
		if (ennemiViser != null) {
			if(!getJeu().projectileExisteSurEnnemi(ennemiViser.getId())) {				
				getJeu().getListeProjectile().add(new Projectile(this,ennemiViser,getJeu()));
				
			}			
		}
		
	}
	
	
	

}
