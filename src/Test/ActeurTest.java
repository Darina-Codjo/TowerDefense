package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;

class ActeurTest {

	Jeu jeu;
	Terrain terrain1 = new Terrain();
	Ennemis acteur1 = new Ennemis(terrain1,5,6, jeu);
	Ennemis acteur2 = new Ennemis(terrain1, 12,16, jeu);
	

	@Test
	public final void testSetXetSetY() {
	
		acteur1.setX(5);
		acteur1.setY(8);
		
		assertEquals(5,acteur1.getX(),"cas modification de la position en X");
		assertEquals(8, acteur1.getY(),"cas modification de la position en Y");
	
	}
	
	@Test
	public final void testIncrementationId() {
		
		assertEquals("A0",acteur1.getId(),"verification que l'id du premier acteur crée est bien A0");
		assertEquals("A1", acteur2.getId(), "verification que l'id incrémente bien lors de la création d'un deuxième acteur");		
		
	}
}
