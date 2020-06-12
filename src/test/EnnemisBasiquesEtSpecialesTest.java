package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.ennemis.ScorpionSpeciale;
import TowerDefense.modele.Terrain;

class EnnemisBasiquesEtSpecialesTest {
	
	Terrain terrain= new Terrain();	
	Jeu jeu= new Jeu(terrain);
	//Méthode scorpion spéciale
	@Test
	public final void testDedoublement() {
		
		ScorpionSpeciale scorpSpeciale1= new ScorpionSpeciale(terrain, jeu);
		jeu.ajouterActeur(scorpSpeciale1);
		scorpSpeciale1.setPv(20);
		
		assertEquals(20, scorpSpeciale1.getPv(), "verification que les pv ont été mis à 0");
		assertEquals(1, jeu.getListeActeurs().size(), "verification que la liste n'est composée que d'une acteur : scorpSpeciale");
		
		//appel de la méthode
		scorpSpeciale1.dedoublement();
		
		assertEquals(2,jeu.getListeActeurs().size(), "verification que la liste est maintenant composée de 2 acteur : scorpSpeciale s'est dédoublé");
			
		
	}
	

		
		
}
