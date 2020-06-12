package TowerDefense.modele;

import java.util.Random;

import TowerDefense.modele.ennemis.ScorpionSpeciale;
import TowerDefense.modele.Jeu;

public class Ennemis extends Acteur{

	private double vitesse;
	private int directionX;
	private int directionY;
	private int pv;
	private Jeu jeu;


	public Ennemis(Terrain terrain, int pv, double v, Jeu jeu) {
		super(terrain.getIndiceTuileDebutChemin()%30, terrain.getIndiceTuileDebutChemin()/30, terrain);
		this.pv = pv;
		this.vitesse = v;
		this.directionX = 0;
		this.directionY = 0;
		this.jeu=jeu;
	}

	public Jeu getJeu() {
		return this.jeu;
	}
	
	public void incrementerPv() {
		this.pv++;
	}
	
	public void seDeplacerDijkstra() {
		
		int posX = (int) this.getX();
		int posY = (int) this.getY();
		int currentIndicePosEnnemi = (posY*30 + posX); 
		int currentDistanceNode = this.terrain.getNodeInXY(posX,posY).getDistance();

		//a droite
		if(this.terrain.dansChemin(currentIndicePosEnnemi+1) && this.terrain.getIfContainsNodeXY(posX+1, posY) && this.terrain.getNodeInXY(posX+1,posY).getDistance() < currentDistanceNode) {
			this.directionX = 1;
			this.directionY = 0;
			this.setX(this.getX() + this.vitesse*this.directionX);
			this.setY(this.getY() + this.vitesse*this.directionY);
		}
		//a gauche
		else if(this.terrain.dansChemin(currentIndicePosEnnemi-1) && this.terrain.getIfContainsNodeXY(posX-1, posY) && this.terrain.getNodeInXY(posX-1, posY).getDistance() < currentDistanceNode) {
			this.directionX = -1;
			this.directionY = 0;
			this.setX(this.getX() + this.vitesse*this.directionX);
			this.setY(this.getY() + this.vitesse*this.directionY);
		}
		//en bas
		else if(this.terrain.dansChemin(currentIndicePosEnnemi+30) && this.terrain.getIfContainsNodeXY(posX, posY+1) && this.terrain.getNodeInXY(posX, posY+1).getDistance() < currentDistanceNode) {
			this.directionX = 0;
			this.directionY = 1;
			this.setX(this.getX() + this.vitesse*this.directionX);
			this.setY(this.getY() + this.vitesse*this.directionY);
		}
		//en haut
		else if(this.terrain.dansChemin(currentIndicePosEnnemi-30) && this.terrain.getIfContainsNodeXY(posX, posY-1) && this.terrain.getNodeInXY(posX, posY-1).getDistance() < currentDistanceNode) {
			this.directionX = 0;
			this.directionY = -1;
			this.setX(this.getX() + this.vitesse*this.directionX);
			this.setY(this.getY() + this.vitesse*this.directionY);
		}
	}


	@Override
	public void agit() {
		this.seDeplacerDijkstra();
		
		for(int i=0; i< jeu.listeEnnemis().size();i++) {
			if(jeu.listeEnnemis().get(i) instanceof ScorpionSpeciale) {
				((ScorpionSpeciale) jeu.listeEnnemis().get(i)).dedoublement();
			
			}		
		}
	}

	//Les méthodes get et set relatives au pv
	public int getPv() {
		return this.pv;
	}
	public void setPv(int newPv) {
		this.pv = newPv;
	}

	//Les méthodes get et set relatives à la vitesse
	public double getVitesse() {
		return vitesse;
	}
	public void setVitesse(int v) {
		this.vitesse = v;
	}

	//Les méthodes get et set relatives aux nouvelles coordonnées
	public double getXSuivant() {
		return directionX;
	}

	public double getYSuivant() {
		return directionY;
	}

	public void setPvDegat(int degatRecu) {
		this.pv -= degatRecu;
	}

	@Override
	public String toString() {
		return "Ennemis [pointsDeVie=" + this.pv + ", vitesse=" + vitesse + ", xSuivant=" + directionX + ", ySuivant="
				+ directionY + "]";
	}
}
