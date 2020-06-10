package TowerDefense.modele;

import java.util.Random;

public class Ennemis extends Acteur{

	private double vitesse;
	private int directionX;
	private int directionY;
	private int pv;
	private Jeu jeu;


	public Ennemis(Terrain terrain, int pv, double v) {
		super(terrain.getIndiceTuileDebutChemin()%30, terrain.getIndiceTuileDebutChemin()/30, terrain);
		this.pv = pv;
		this.vitesse = v;
		this.directionX = 0;
		this.directionY = 0;
	}

	public void plusieurCheminDijkstra(){
		
		Random random = new Random();
		int alea = random.nextInt(4);
		if (alea == 0) {
			
		}
		if (alea == 1) {
			
		}
		if (alea == 2) {
		
		}
		if (alea == 3) {
			
		}
		
		int posX = (int) this.getX();
		int posY = (int) this.getY();
		int currentIndicePosEnnemi = (posY*30 + posX); 
		int currentDistanceNode = this.terrain.getNodeInXY(posX,posY).getDistance();

		//a droite
		if(this.terrain.dansCheminV2(currentIndicePosEnnemi+1) && this.terrain.getIfContainsNodeXY(posX+1, posY) && this.terrain.getNodeInXY(posX+1,posY).getDistance() < currentDistanceNode) {
			this.directionX = 1;
			this.directionY = 0;
			this.setX(this.getX() + this.vitesse*this.directionX);
			this.setY(this.getY() + this.vitesse*this.directionY);
		}
		//a gauche
		else if(this.terrain.dansCheminV2(currentIndicePosEnnemi-1) && this.terrain.getIfContainsNodeXY(posX-1, posY) && this.terrain.getNodeInXY(posX-1, posY).getDistance() < currentDistanceNode) {
			this.directionX = -1;
			this.directionY = 0;
			this.setX(this.getX() + this.vitesse*this.directionX);
			this.setY(this.getY() + this.vitesse*this.directionY);
		}
		//en bas
		else if(this.terrain.dansCheminV2(currentIndicePosEnnemi+30) && this.terrain.getIfContainsNodeXY(posX, posY+1) && this.terrain.getNodeInXY(posX, posY+1).getDistance() < currentDistanceNode) {
			this.directionX = 0;
			this.directionY = 1;
			this.setX(this.getX() + this.vitesse*this.directionX);
			this.setY(this.getY() + this.vitesse*this.directionY);
		}
		//en haut
		else if(this.terrain.dansCheminV2(currentIndicePosEnnemi-30) && this.terrain.getIfContainsNodeXY(posX, posY-1) && this.terrain.getNodeInXY(posX, posY-1).getDistance() < currentDistanceNode) {
			this.directionX = 0;
			this.directionY = -1;
			this.setX(this.getX() + this.vitesse*this.directionX);
			this.setY(this.getY() + this.vitesse*this.directionY);
		}
	}
	
	public void seDeplacerDijkstra() {
		
		int posX = (int) this.getX();
		int posY = (int) this.getY();
		int currentIndicePosEnnemi = (posY*30 + posX); 
		int currentDistanceNode = this.terrain.getNodeInXY(posX,posY).getDistance();

		//a droite
		if(this.terrain.dansCheminV2(currentIndicePosEnnemi+1) && this.terrain.getIfContainsNodeXY(posX+1, posY) && this.terrain.getNodeInXY(posX+1,posY).getDistance() < currentDistanceNode) {
			this.directionX = 1;
			this.directionY = 0;
			this.setX(this.getX() + this.vitesse*this.directionX);
			this.setY(this.getY() + this.vitesse*this.directionY);
		}
		//a gauche
		else if(this.terrain.dansCheminV2(currentIndicePosEnnemi-1) && this.terrain.getIfContainsNodeXY(posX-1, posY) && this.terrain.getNodeInXY(posX-1, posY).getDistance() < currentDistanceNode) {
			this.directionX = -1;
			this.directionY = 0;
			this.setX(this.getX() + this.vitesse*this.directionX);
			this.setY(this.getY() + this.vitesse*this.directionY);
		}
		//en bas
		else if(this.terrain.dansCheminV2(currentIndicePosEnnemi+30) && this.terrain.getIfContainsNodeXY(posX, posY+1) && this.terrain.getNodeInXY(posX, posY+1).getDistance() < currentDistanceNode) {
			this.directionX = 0;
			this.directionY = 1;
			this.setX(this.getX() + this.vitesse*this.directionX);
			this.setY(this.getY() + this.vitesse*this.directionY);
		}
		//en haut
		else if(this.terrain.dansCheminV2(currentIndicePosEnnemi-30) && this.terrain.getIfContainsNodeXY(posX, posY-1) && this.terrain.getNodeInXY(posX, posY-1).getDistance() < currentDistanceNode) {
			this.directionX = 0;
			this.directionY = -1;
			this.setX(this.getX() + this.vitesse*this.directionX);
			this.setY(this.getY() + this.vitesse*this.directionY);
		}
	}



	@Override
	public void agit() {
		this.seDeplacerDijkstra();
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
