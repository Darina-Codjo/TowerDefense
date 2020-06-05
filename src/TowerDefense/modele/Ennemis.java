package TowerDefense.modele;

import java.util.Random;


import TowerDefense.modele.Terrain;
import TowerDefense.modele.Jeu;

public class Ennemis extends Acteur{

	private int vitesse;
	private double directionX;
	private double directionY;
	private int pv;
	
	public Ennemis(Terrain terrain, int pv, int v) {
		super((terrain.getIndiceTuileDebutChemin()%30)*16+8, (terrain.getIndiceTuileDebutChemin()/30)*16+8 , terrain);
		this.pv=pv;
		this.vitesse = v;
		this.directionX=0;
		this.directionY=0;
	}

	
	
	//Permet au ennemis de se déplacer aleatoirement 
	private void directionAleatoire() {
		Random random = new Random();

		double randomInt = random.nextInt(3);
		directionX = randomInt-1;

		randomInt = random.nextInt(3);
		directionY = randomInt-1;

		while(!(this.terrain.dansChemin(this.terrain.getTuileSansClic(this.directionX*this.vitesse+this.getX(), this.directionY*this.vitesse + this.getY())) && 
				this.terrain.dansTerrain(this.directionX*this.vitesse + this.getX(), this.directionY*this.vitesse + this.getY()))) {
			this.seDeplacer();
		}
	}

	public void seDeplacer() {

		directionAleatoire();
		double newPositionX = this.getX()+(this.vitesse*directionX);
		double newPositionY = this.getY()+(this.vitesse*directionY);

		this.setX(newPositionX);
		this.setY(newPositionY);   
	}



	//Les méthodes get et set relatives au pv
	public int getPv() {
		return this.pv;
	}
	
	public void setPv(int newPv) {
		this.pv=newPv;
	}

	public void setPvDegat(int degatRecu) {
		this.pv -= degatRecu;
	}

	
	
	//Les méthodes get et set relatives à la vitesse
	public int getVitesse() {
		return vitesse;
	}
	
	public void setVitesse(int v) {
		this.vitesse = v;
	}
	
	
	
	
	//Les méthodes get et set relatives aux nouvelles coordonnées
	public double getxSuivant() {
		return directionX;
	}

	public double getySuivant() {
		return directionY;
	}



	
	@Override
	public void agit() {
		this.seDeplacer();
	}

	@Override
	public String toString() {
		return "Ennemis [pointsDeVie=" + this.pv + ", vitesse=" + vitesse + ", xSuivant=" + directionX + ", ySuivant="
				+ directionY + "]";
	}







}
