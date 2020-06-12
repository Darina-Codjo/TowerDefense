package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.ennemis.Cactus;

class BFSTest {

	private Terrain terrain = new Terrain();
	private Acteur ennemis = new Cactus(terrain);
	

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
	
	@Test
	public void testArriveeEnnemiCaseArrivee() {
		terrain.placerNode();

		int compteurCase = 0;
		
		double tuile1arriveX = 0;
		double tuile1arriveY = 0;

		double tuile2arriveX = 0;
		double tuile2arriveY = 0;

		double tuile3arriveX = 0;
		double tuile3arriveY = 0;
		
		double posXNode = 0;
		double posYNode = 0;
		
		double indiceCurrentNodeAZero = 0;
		double indiceCurrentEnnemis = 0;
		
		//on recupere les coordonnees du node qui a sa distance a zero : le node qui se situe sur la tuile d'arrivee
		for(int indiceNode = 0; indiceNode < terrain.getListeNode().size(); indiceNode++) {
			if(terrain.getListeNode().get(indiceNode).getDistance() == 0) {
				posXNode = terrain.getListeNode().get(indiceNode).getX();
				posYNode = terrain.getListeNode().get(indiceNode).getY();
				//recuperation de l'indice dans la map du node a 0
				indiceCurrentNodeAZero = posYNode*30+posXNode;
			}
		}
		
		//tant que l'ennemis n'est pas sur la tuile qui se trouve aux memes coordonnees du node qui a sa distance a zero (node de la tuile d'arrivee), il se deplace
		while(ennemis.getY()*30+ennemis.getX() != indiceCurrentNodeAZero) {
			this.ennemis.agit();
		}
		
		for(int i = 0; i < terrain.getMap().length; i++) {
			if(terrain.getMap()[i] == 51) { 
				compteurCase++;
			}
			if(terrain.getMap()[i] == 51 && compteurCase == 1) {
				tuile1arriveX = i %30;
				tuile1arriveY = i /30;
			}
			else if(terrain.getMap()[i] == 51 && compteurCase == 2) {
				tuile2arriveX = i %30;
				tuile2arriveY = i /30;
			}
			else if(terrain.getMap()[i] == 51 && compteurCase == 3) {
				tuile3arriveX = i %30;
				tuile3arriveY = i /30;
			}
		}
		assertTrue(ennemis.getX() == tuile1arriveX && ennemis.getY() == tuile1arriveY 
				|| ennemis.getX() == tuile2arriveX && ennemis.getY() == tuile2arriveY 
				|| ennemis.getX() == tuile3arriveX && ennemis.getY() == tuile3arriveY, 
				"verifier que les ennemis arruvent a se deplacer jusqu'aux coordonnees d'une des cases d'arrivee");
	}

}
