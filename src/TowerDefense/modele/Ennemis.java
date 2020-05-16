package TowerDefense.modele;

import java.util.Random;

public class Ennemis extends Acteur{

	private int pointsDeVie;
	private int vitesse;
	private double directionX;
	private double directionY;
	
	public Ennemis(double x, double y, Terrain terrain, int pv, int v) {
		super(x, y, terrain);
		this.pointsDeVie = pv;
		this.vitesse = v;

	}

	public Ennemis(Terrain terrain, int pv, int v) {
		super(terrain);
		this.pointsDeVie = pv;
		this.vitesse = 10;
	}
	
	public Ennemis(Terrain terrain) {
		super(terrain);
		this.directionX = 0;
		this.directionY = 0;
		this.vitesse = 10;
		this.pointsDeVie = 100;
	}
	
	public int getPointsDeVie() {
		return pointsDeVie;
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
	
	public String getId() {
		return id;
	}

	public void setPointsDeVie(int pv) {
		this.pointsDeVie = pv;
	}

	public void setVitesse(int v) {
		this.vitesse = v;
	}

	private void directionAleatoire() {
        Random random = new Random();
        
        double randomInt = random.nextInt(3);
        directionX = randomInt-1;
        
        randomInt = random.nextInt(3);
        directionY = randomInt-1;
        
        while(!this.terrain.dansTerrain(this.directionX + this.getX(), this.directionY + this.getY())) {
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
    
	@Override
	public String toString() {
		return "Ennemis [pointsDeVie=" + pointsDeVie + ", vitesse=" + vitesse + ", xSuivant=" + directionX + ", ySuivant="
				+ directionY + "]";
	}

	@Override
	public void agit() {
		seDeplacer();
	}


	
}
