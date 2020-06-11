package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.ennemis.Serpent;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.tourelle.Tourelle;
import TowerDefense.modele.Tours;
import TowerDefense.modele.ennemis.Cactus;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.tourelle.TourelleFeu;
import TowerDefense.modele.tourelle.TourelleGlace;

class TourelleBasiquesEtSpecialesTest {

	@Test
	void testEnnemisProcheTirTourelleMultiple() {
	
		
		Terrain terrain1= new Terrain();
		Jeu jeu= new Jeu(terrain1);
		Tourelle tours = new TourelleFeu(10,30,terrain1,jeu);
		Tourelle tours2 = new TourelleGlace(160,140,terrain1, jeu);
		Cactus cactus = new Cactus(terrain1, jeu);
		cactus.setX(200);
		cactus.setY(130);
		
		assertFalse(tours.ennemisProcheTirTourelleMultiple(50,cactus));
		assertTrue(tours2.ennemisProcheTirTourelleMultiple(100, cactus));
		
	}
	
	@Test
	void testEnnemisVisable() {
		
		Terrain terrain1= new Terrain();
		Jeu jeu= new Jeu(terrain1);
		Tourelle tours = new TourelleGlace(160,140,terrain1, jeu);
		Cactus cactus= new Cactus(terrain1, jeu);
		cactus.setX(200);
		cactus.setY(130);	
		jeu.ajouterActeur(cactus);
		
		
		assertEquals(cactus,tours.ennemieVisable(100));
				
	}
	
	@Test
	void testEnnemisVisableNull() {
		Terrain terrain1= new Terrain();
		Jeu jeu= new Jeu(terrain1);
		Tourelle tours = new TourelleGlace(160,140,terrain1, jeu);
		
		Serpent serpent= new Serpent(terrain1, jeu);
		serpent.setX(2);
		serpent.setY(6);
		jeu.ajouterActeur(serpent);
		
		assertEquals(null,tours.ennemieVisable(50));
		
	}
	
	
}
