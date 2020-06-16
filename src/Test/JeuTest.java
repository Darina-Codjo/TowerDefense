package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TowerDefense.modele.ennemis.Cactus;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.projectile.Projectile;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tours;
import TowerDefense.modele.tourelle.TourelleGlace;
import TowerDefense.modele.ennemis.CactusSpeciale;

class JeuTest {

	Terrain terrain = new Terrain();
	Jeu jeu= new Jeu(terrain);
	Cactus cactus = new Cactus(terrain, jeu);
	Tours tours = new TourelleGlace(160,140,terrain, jeu);
	Projectile projectile= new Projectile(tours,cactus,jeu);
	CactusSpeciale cactusSpec = new CactusSpeciale(terrain,jeu);
	
	@Test
	public final void projectileExisteSurEnnemi() {
		
		jeu.getListeProjectile().add(projectile);		
		assertTrue(jeu.projectileExisteSurEnnemi(cactus.getId()));
	}

	
	@Test
	public final void rechargement() {
		jeu.ajouterActeur(cactusSpec);
		cactusSpec.setPv(0);
		
		assertEquals(0, cactusSpec.getPv(), "verification que les pv ont été mis à 0");
		
		while(cactusSpec.getPv()!=100) {
			jeu.rechargement();
		}
		
		assertEquals(100,cactusSpec.getPv(),"la méthode rechargement() doit incrémenter les pv du cactus spéciale");
	}

}
