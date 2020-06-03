package TowerDefense.modele;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Projectile;
import TowerDefense.modele.Tours;

public class ProjectileGlace extends Projectile {

	public ProjectileGlace(Tours tourelleDepart, Ennemis ennemisArrivee, Jeu jeu) {
		super(tourelleDepart, ennemisArrivee, jeu);
	}

}
