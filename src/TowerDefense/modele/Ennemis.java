package TowerDefense.modele;

import java.util.Random;

import TowerDefense.modele.Terrain;

public class Ennemis extends Acteur{

	private int pv;
	private int vitesse;
	private double directionX;
	private double directionY;
	
	/*private Terrain terrain;
	private int rng = (int)(Math.random()*terrain.getTuileSpawn().size()+1);
	private int xSpawn = terrain.getXTuile(terrain.getTuileSpawn().get(rng-1));
	private int ySpawn = terrain.getXTuile(terrain.getTuileSpawn().get(rng-1));*/
	
//	public Ennemis(double x, double y, Terrain terrain, int pv, int v) {
//		super(x, y, terrain);
//		/*this.setX(xSpawn);
//		this.setY(ySpawn);*/
//		this.pointsDeVie = pv;
//		this.vitesse = v;
//
//	}

	public Ennemis(Terrain terrain, int pv, int v) {
		super((terrain.indiceTuileDebutChemin()%30)*16, (terrain.indiceTuileDebutChemin()/30)*16 , terrain);
		this.pv=pv;
		this.vitesse = v;
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
	
	public void setPv(int degatRecu) {
		this.pv -= degatRecu;
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
        
        while(!(this.terrain.dansChemin(this.terrain.getTuileSansClic(this.directionX*this.vitesse+this.getX(), this.directionY*this.vitesse + this.getY())) && this.terrain.dansTerrain(this.directionX*this.vitesse + this.getX(), this.directionY*this.vitesse + this.getY()))) {
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
		return "Ennemis [pointsDeVie=" + this.pv + ", vitesse=" + vitesse + ", xSuivant=" + directionX + ", ySuivant="
				+ directionY + "]";
	}
	
	public void meurt(){
		this.pv = 0;
	}
	
	public boolean estVivant() {
		return this.pv > 0;
	}

	@Override
	public void agit() {
		this.seDeplacer();
	}


	
}
