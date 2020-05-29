package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TowerDefense.modele.CactusSpeciale;
import TowerDefense.modele.Terrain;

class CactusSpecialeTest {

	@Test
	public final void testRechargement() {
		
		Terrain terrain=new Terrain();
		CactusSpeciale cactusSpec1 = new CactusSpeciale(terrain);
		cactusSpec1.setPvDegat(100);
		assertEquals(0, cactusSpec1.getPv(),"verification pv mis � 0");
		
		cactusSpec1.rechargement();
		assertEquals(100,cactusSpec1.getPv() );
		
	}

}
