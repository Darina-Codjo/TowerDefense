package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.dijkstra.Node;
import TowerDefense.modele.ennemis.Cactus;

class BFSTest {
	private Terrain terrain = new Terrain();
	private Jeu game = new Jeu(terrain);
	private Acteur ennemis = new Cactus(terrain, game);
	

	@Test
	public void testPlacerNodes() {
		int nbrTuileChemin = 0;
		terrain.placerNode();
		for(int i = 0; i < terrain.getMap().length; i++) {
			if(terrain.dansChemin(i)) {
				nbrTuileChemin++;
			}
		}
		assertTrue(nbrTuileChemin >= terrain.getListeNode().size(), "cas pour eviter de placer des node ailleurs que sur les tuiles du chemin");
	}

	@Test
	public void testDepartEnnemisCaseDepart() {
		
		int compteurCase = 0;

		double tuile1departX = 0;
		double tuile1departY = 0;

		double tuile2departX = 0;
		double tuile2departY = 0;

		double tuile3departX = 0;
		double tuile3departY = 0;

		//le code d'une tuile de depart est 50
		for(int i = 0; i < terrain.getMap().length; i++) {
			if(terrain.getMap()[i] == 50) { 
				compteurCase++;
			}
			if(terrain.getMap()[i] == 50 && compteurCase == 1) {
				tuile1departX = i %30;
				tuile1departY = i /30;
			}
			else if(terrain.getMap()[i] == 50 && compteurCase == 2) {
				tuile2departX = i %30;
				tuile2departY = i /30;
			}
			else if(terrain.getMap()[i] == 50 && compteurCase == 3) {
				tuile3departX = i %30;
				tuile3departY = i /30;
			}
		}
		assertTrue(ennemis.getX() == tuile1departX && ennemis.getY() == tuile1departY 
				|| ennemis.getX() == tuile2departX && ennemis.getY() == tuile2departY 
				|| ennemis.getX() == tuile3departX && ennemis.getY() == tuile3departY, 
				"verifier que les ennemis se place aux coordonnees d'une des cases de depart");

	}

}
