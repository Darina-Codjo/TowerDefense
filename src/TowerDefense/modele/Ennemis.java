package TowerDefense.modele;

import java.util.Random;

public abstract class Ennemis extends Acteur {

	private int pointsDeVie;
	private int vitesse;
	private int xSuivant;
	private int ySuivant;

	
	
	public Ennemis(int x, int y, Terrain terrain, int pv, int v) {
		super(x, y, terrain);
		this.pointsDeVie = pv;
		this.vitesse = v;
	}

	public Ennemis(Terrain terrain, int pv, int v) {
		super(terrain);
		this.pointsDeVie = pv;
		this.vitesse = v;
	}
	
	public int getPointsDeVie() {
		return pointsDeVie;
	}

	public int getVitesse() {
		return vitesse;
	}

	public int getxSuivant() {
		return xSuivant;
	}

	public int getySuivant() {
		return ySuivant;
	}

	public void setPointsDeVie(int pv) {
		this.pointsDeVie = pv;
	}

	public void setVitesse(int v) {
		this.vitesse = v;
	}

	private void directionAleatoire() {
        Random random = new Random();
        int randomInt = random.nextInt(3);
        xSuivant = randomInt-1;
        
        if(xSuivant == 0){
            randomInt = random.nextInt(2)-1;
            if(randomInt == 0){
                ySuivant = -1;
            }
            else{
                ySuivant = 1;
            }
        }
        else{
            ySuivant = random.nextInt(3)-1;
        }
    }
	

	public void seDeplacer() {
		
		//System.out.println("Avant déplacemetn:" +toString());
       int newPositionX = this.getX()+(this.vitesse*xSuivant);
       int newPositionY = this.getY()+(this.vitesse*ySuivant);
        
       // while(!terrain.dansTerrain(newPositionX, newPositionY)){
 
        	directionAleatoire();
        	newPositionX = this.getX()+(this.vitesse*xSuivant);
        	newPositionY = this.getY()+(this.vitesse*ySuivant);
     //   }
            this.setX(newPositionX);
            this.setY(newPositionY);
            //System.out.println("Après déplacemetn:" +toString());
	}
    
	@Override
	public String toString() {
		return "Ennemis [pointsDeVie=" + pointsDeVie + ", vitesse=" + vitesse + ", xSuivant=" + xSuivant + ", ySuivant="
				+ ySuivant + "]";
	}

	public abstract void agit();
	
}
