package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TowerDefense.modele.ennemis.CactusSpeciale;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.ennemis.ScorpionSpeciale;
import TowerDefense.modele.Terrain;

class EnnemisBasiquesEtSpecialesTest {
	
	Jeu jeu;
	Terrain terrain1 = new Terrain();
	Ennemis ennemis1 = new Ennemis(terrain1,50,18,jeu);

	@Test
	public final void testSetPvetSetVitesse() {
		
		ennemis1.setPvDegat(40);
		ennemis1.setVitesse(80);
		
		assertEquals(10,ennemis1.getPv(),"cas ou un ennemis recoit des d�gats");
		assertEquals(80, ennemis1.getVitesse(),"cas o� la vitesse d'un ennemis augmente");
		
	}
	
	@Test
	public final void testdirectionAleatoire() {
		
		assertEquals(0,ennemis1.getXSuivant(), " avant appel de la m�thode directionAleatoire directionX � 0");
		assertEquals(0, ennemis1.getYSuivant()," avant appel de la m�thode directionAleatoire directionX � 0");
	}

	//M�thode de cactus sp�ciale
	@Test
	public final void testRechargement() {
		
		Terrain terrain=new Terrain();
		CactusSpeciale cactusSpec1 = new CactusSpeciale(terrain,jeu);
		cactusSpec1.setPvDegat(100);
		assertEquals(0, cactusSpec1.getPv(),"verification pv mis � 0");
		
		cactusSpec1.rechargement();
		assertEquals(100,cactusSpec1.getPv() );
		
	}
	
	//M�thode scorpion sp�ciale
	@Test
	public final void testDedoublement() {
		
		Terrain terrain= new Terrain();	
		Jeu jeu= new Jeu(terrain);
		ScorpionSpeciale scorpSpeciale1= new ScorpionSpeciale(terrain,jeu);
		jeu.ajouterActeur(scorpSpeciale1);
		scorpSpeciale1.setPv(0);
		
		assertEquals(0, scorpSpeciale1.getPv(), "verification que les pv ont �t� mis � 0");
		assertEquals(1, jeu.getListeActeurs().size(), "verification que la liste n'est compos�e que d'une acteur : scorpSpeciale");
		
		//appel de la m�thode
		//scorpSpeciale1.dedoublement();
		
		//assertEquals(2,jeu.getListeActeurs().size(), "verification que la liste est maintenant compos�e de 2 acteur : scorpSpeciale s'est d�doubl�");
			
		
	}
	
	//Il faut d'abord cr�e la tourelle qui poss�de des pv pour pouvoir tester cette m�thode

		@Test
		public final void testDestructeurs() {
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
