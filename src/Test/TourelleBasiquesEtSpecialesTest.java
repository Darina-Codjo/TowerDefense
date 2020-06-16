package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.ennemis.Serpent;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tours;
import TowerDefense.modele.ennemis.Cactus;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.tourelle.TourelleFeu;
import TowerDefense.modele.tourelle.TourelleGlace;

class TourelleBasiquesEtSpecialesTest {

	Terrain terrain= new Terrain();
	Jeu jeu= new Jeu(terrain);
	Tours tours = new TourelleGlace(160,140,terrain, jeu);
	Tours tours2 = new TourelleFeu(10,30,terrain,jeu);
	Cactus cactus = new Cactus(terrain,jeu);
	Serpent serpent= new Serpent(terrain,jeu);
	
	@Test
	void testEnnemisProcheTirTourelleMultiple() {

		cactus.setX(200);
		cactus.setY(130);
		
		assertFalse(tours2.ennemisProcheTirTourelleMultiple(50,cactus));
		assertTrue(tours.ennemisProcheTirTourelleMultiple(100, cactus));
		
	}
	
	@Test
	void testEnnemisVisable() {

		cactus.setX(200);
		cactus.setY(130);	
		jeu.ajouterActeur(cactus);
		
		
		assertEquals(cactus,tours.ennemieVisable(100));
				
	}
	
	@Test
	void testEnnemisVisableNull() {

		serpent.setX(2);
		serpent.setY(6);
		jeu.ajouterActeur(serpent);
		
		assertEquals(null,tours.ennemieVisable(50));
		
	}
	
	
}
