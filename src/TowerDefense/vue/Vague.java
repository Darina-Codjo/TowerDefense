package TowerDefense.vue;

import java.util.Random;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;

public class Vague {

	private int numVague;
	private Jeu game;
	private Random r=new Random();

	public Vague (Jeu game, int vague) {
		this.game = game ;
		this.numVague = vague;
	}

	public int getNumVague() {
		return numVague;
	}
	public void setNumVague(int numVague) {
		this.numVague = numVague;
	}
	public void LancementVague() {
		this.numVague++;
	}

	public int getVague() {
		return this.numVague;
	}

	public Jeu getPartie() {
		return this.game;
	}

	public String toString() {
		return "Vague : " + this.getVague() + "\n" +
				"Partie : " + this.getPartie();
	}
}

