package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TowerDefense.modele.ennemis.Cactus;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.projectile.Projectile;
import TowerDefense.modele.ennemis.Serpent;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tours;
import TowerDefense.modele.tourelle.TourelleFeu;
import TowerDefense.modele.tourelle.TourelleGlace;

class JeuTest {

	@Test
	void testTuileDejaPrise() {
		Terrain terrain1= new Terrain();
		Jeu jeu= new Jeu(terrain1);
		Tours tours = new TourelleFeu(10,30,terrain1,jeu);
		jeu.ajouterActeur(tours);
		
//		assertTrue(jeu.tuileDejaPrise(terrain1.getTuileSansClic(10, 30)));
//		assertFalse(jeu.tuileDejaPrise(terrain1.getTuileSansClic(50, 80)));
				
	}
	
	@Test
	public final void projectileExisteSurEnnemi() {
		
		Terrain terrain = new Terrain();
		Jeu jeu= new Jeu(terrain);
		Cactus cactus = new Cactus(terrain,jeu);
		Serpent serpent= new Serpent(terrain,jeu);
		Tours tours = new TourelleGlace(160,140,terrain, jeu);
		Projectile projectile= new Projectile(tours,cactus,jeu);
		jeu.getListeProjectile().add(projectile);
		
		
		assertTrue(jeu.projectileExisteSurEnnemi(cactus.getId()));
	}

}
