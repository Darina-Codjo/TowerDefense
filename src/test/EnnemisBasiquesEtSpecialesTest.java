package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.ennemis.ScorpionSpeciale;
import TowerDefense.modele.Terrain;

class EnnemisBasiquesEtSpecialesTest {
	
	Terrain terrain= new Terrain();	
	Jeu jeu= new Jeu(terrain);
	//M�thode scorpion sp�ciale
	@Test
	public final void testDedoublement() {
		
		ScorpionSpeciale scorpSpeciale1= new ScorpionSpeciale(terrain, jeu);
		jeu.ajouterActeur(scorpSpeciale1);
		scorpSpeciale1.setPv(20);
		
		assertEquals(20, scorpSpeciale1.getPv(), "verification que les pv ont �t� mis � 0");
		assertEquals(1, jeu.getListeActeurs().size(), "verification que la liste n'est compos�e que d'une acteur : scorpSpeciale");
		
		//appel de la m�thode
		scorpSpeciale1.dedoublement();
		
		assertEquals(2,jeu.getListeActeurs().size(), "verification que la liste est maintenant compos�e de 2 acteur : scorpSpeciale s'est d�doubl�");
			
		
	}
	

		
		
}
