package TowerDefense.modele;

import java.util.Random;

import TowerDefense.modele.dijkstra.BreadthFirstSearch;


public class Ennemis extends Acteur{

	private int vitesse;
	private double directionX;
	private double directionY;
	private int pv;
	private Jeu jeu;
	
		
	public Ennemis(Terrain terrain, int pv, int v) {
		super((terrain.getIndiceTuileDebutChemin()%30)*16+8, (terrain.getIndiceTuileDebutChemin()/30)*16+8 , terrain);
		this.pv = pv;
		this.vitesse = v;
		this.directionX = 0;
		this.directionY = 0;
		this.directionX = 0;
		this.directionY = 0;
	}


//permet au ennemis de se péplacer aleatoirement 
//	private void directionAleatoire() {
//		Random random = new Random();
//
//		double randomInt = random.nextInt(3);
//		directionX = randomInt-1;
//
//		randomInt = random.nextInt(3);
//		directionY = randomInt-1;
//
//		while(!(this.terrain.dansChemin(this.terrain.getTuileSansClic(this.directionX*this.vitesse+this.getX(), this.directionY*this.vitesse + this.getY())) && 
//				this.terrain.dansTerrain(this.directionX*this.vitesse + this.getX(), this.directionY*this.vitesse + this.getY()))) {
//			this.seDeplacer();
//		}
//	}
//
//	public void seDeplacer() {
//		directionAleatoire();
//		double newPositionX = this.getX()+(this.vitesse*directionX);
//		double newPositionY = this.getY()+(this.vitesse*directionY);
//
//		this.setX(newPositionX);
//		this.setY(newPositionY);   
//	}

	public void seDeplacerDijkstra() {
		double posXCurrentEnnemi = this.getX();
		double posYCurrentEnnemi = this.getY();
		double currentDistance = 0;
		
		//recuperer la distace du node sur lequel se trouve l'ennemi
		for(int i = 0; i < this.terrain.getListeNode().size(); i++) {
			System.out.println("for 1 sedeplace");
			if(this.terrain.getListeNode().get(i).getX() == posXCurrentEnnemi && this.terrain.getListeNode().get(i).getY() == posYCurrentEnnemi) {
				currentDistance = this.terrain.getListeNode().get(i).getDistance();
				System.out.println("if 1 sedeplace");
			}
			if(this.terrain.getListeNode().get(i).getDistance() == currentDistance-1) {
				this.setX(this.terrain.getListeNode().get(i).getX()+this.vitesse);
				this.setY(this.terrain.getListeNode().get(i).getY()+this.vitesse);
				System.out.println("if 2 sedeplace");
			}
		}
		//parcourir la liste et trouver le node dont la distance est 1 cran inferieur aka currentNode.getDistance-1
//		for(int i = 0; i < this.terrain.getlistenode().size(); i++) {
//			if(this.terrain.getlistenode().get(i).getdistance() == currentdistance-1) {
//				this.setx(this.terrain.getlistenode().get(i).getx()+this.vitesse);
//				this.sety(this.terrain.getlistenode().get(i).gety()+this.vitesse);
//				system.out.println("if 2 sedeplace");
//			}
//		}
		
		
		this.terrain.getListeNode();
	}
	
	public void meurt(){
		this.pv = 0;
	}

	public boolean estVivant() {
		return this.pv > 0;
	}

	@Override
	public void agit() {
		//this.seDeplacer();
		System.out.println("agit ennemi");
		this.seDeplacerDijkstra();
	}


	public int getPv() {
		return this.pv;
	}

	public int getVitesse() {
		return vitesse;
	}

	public double getxSuivant() {
		return directionX;
	}

	public double getySuivant() {
		return directionY;
	}

	public void setPv(int newPv) {
		this.pv = newPv;
	}

	public void setPvDegat(int degatRecu) {
		this.pv -= degatRecu;
	}


	public void setVitesse(int v) {
		this.vitesse = v;
	}


	@Override
	public String toString() {
		return "Ennemis [pointsDeVie=" + this.pv + ", vitesse=" + vitesse + ", xSuivant=" + directionX + ", ySuivant="
				+ directionY + "]";
	}
}
