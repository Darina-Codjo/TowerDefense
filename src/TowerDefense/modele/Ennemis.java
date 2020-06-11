package TowerDefense.modele;

import java.util.Random;

import TowerDefense.modele.ennemis.CactusSpeciale;
import TowerDefense.modele.ennemis.SerpentSpeciale;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;

public class Ennemis extends Acteur{

	private double vitesse;
	private int directionX;
	private int directionY;
	private int pv;
	private Jeu jeu;


	public Ennemis(Terrain terrain, int pv, double v,Jeu jeu) {
		super(terrain.getIndiceTuileDebutChemin()%30, terrain.getIndiceTuileDebutChemin()/30, terrain);
		this.pv = pv;
		this.vitesse = v;
		this.directionX = 0;
		this.directionY = 0;
		this.jeu=jeu;
	}
	
	public Ennemis(double x, double y,Terrain terrain,int pv, int v, Jeu jeu) {
		super(x,y,terrain);
		this.vitesse = v;
		this.directionX=0;
		this.directionY=0;
		this.jeu=jeu;
		
		
	}
	
	public Jeu getJeu() {
		return this.jeu;
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
		
		for(int i=0; i< jeu.listeEnnemis().size();i++) {
			if(jeu.listeEnnemis().get(i) instanceof CactusSpeciale) {
				((CactusSpeciale) jeu.listeEnnemis().get(i)).rechargement();
			}
			else if(jeu.listeEnnemis().get(i) instanceof SerpentSpeciale) {
				((SerpentSpeciale) jeu.listeEnnemis().get(i)).destructeurs(5);
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
