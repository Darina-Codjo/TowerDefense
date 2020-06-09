package TowerDefense.modele.tourelle;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.projectile.ProjectileRoche;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.tourelle.Tourelle;

public class TourelleTirMultiple extends Tourelle {

	public TourelleTirMultiple(int x, int y, Terrain terrain, Jeu jeu) {
		super(x, y, terrain, jeu);
	}
	
	public void tirMultiple() {
		
		for(int i=0; i<listeEnnemis().size(); i++) {
			if(ennemisProcheTirTourelleMultiple(3,listeEnnemis().get(i)) && !getJeu().projectileExisteSurEnnemi(listeEnnemis().get(i).getId())) {
				getJeu().getListeProjectile().add(new ProjectileRoche(this,listeEnnemis().get(i),getJeu()));
			}
		}
		
		
	}

}
