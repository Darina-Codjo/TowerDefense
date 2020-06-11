package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tours;
import TowerDefense.modele.ennemis.Cactus;
import TowerDefense.modele.tourelle.TourelleFeu;

class TourelleTest {

	@Test
	void testEnnemisProche() {
	
		
		Terrain terrain1= new Terrain();
		Jeu jeu= new Jeu(terrain1);
		Tours tours = new TourelleFeu(10,30,terrain1,jeu);
		Cactus cactus = new Cactus(terrain1, jeu);
		cactus.setX(200);
		cactus.setY(130);
		
		//assertFalse(tours.ennemisProche(50,cactus));
		
	}

}
