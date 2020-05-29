package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Terrain;

class EnnemisTest {

	
	Terrain terrain1 = new Terrain();
	Ennemis ennemis1 = new Ennemis(terrain1,50,18);

	@Test
	public final void testSetPvetSetVitesse() {
		
		ennemis1.setPvDegat(40);
		ennemis1.setVitesse(80);
		
		assertEquals(10,ennemis1.getPv(),"cas ou un ennemis recoit des d�gats");
		assertEquals(80, ennemis1.getVitesse(),"cas o� la vitesse d'un ennemis augmente");
		
	}
	
	@Test
	public final void testdirectionAleatoire() {
		
		assertEquals(0,ennemis1.getxSuivant(), " avant appel de la m�thode directionAleatoire directionX � 0");
		assertEquals(0, ennemis1.getySuivant()," avant appel de la m�thode directionAleatoire directionX � 0");
	}

}
