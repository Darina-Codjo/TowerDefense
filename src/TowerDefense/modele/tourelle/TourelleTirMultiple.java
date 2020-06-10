package TowerDefense.modele.tourelle;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.projectile.ProjectileRoche;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.tourelle.Tourelle;

public class TourelleTirMultiple extends Tourelle {

	public TourelleTirMultiple(int x, int y, Terrain terrain, Jeu jeu) {
		super(x, y, terrain, jeu);
	}
	
	
	//Parcours la liste d'ennemis, pour chaque ennemi, elle vérifie que celui-ci n'est pas déjà viser
	//si ce n'est pas le cas alors elle lui lance un projectile
	//sinon regarde la même chose pour le prochain ennemi de la liste
	public void tirMultiple() {
		for(int i=0; i<getJeu().listeEnnemis().size(); i++) {
			if(ennemisProcheTirTourelleMultiple(50,getJeu().listeEnnemis().get(i)) && !getJeu().projectileExisteSurEnnemi(getJeu().listeEnnemis().get(i).getId())) {
				getJeu().getListeProjectile().add(new ProjectileRoche(this,getJeu().listeEnnemis().get(i),getJeu()));
			}
		}	
	}
}
