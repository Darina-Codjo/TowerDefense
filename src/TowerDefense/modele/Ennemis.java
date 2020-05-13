package TowerDefense.modele;

import java.util.Random;

public abstract class Ennemis extends Acteur {

	private int pointsDeVie;
	private int vitesse;
	private int xSuivant;
	private int ySuivant;	
	private int x;
	private int y;
	
	public Ennemis(Terrain terrain, int pv, int v) {
		super(terrain);
		Random random=new Random();
		this.x = random.nextInt(terrain.getWidth()-1);
		this.y = random.nextInt(terrain.getHeight()-1);
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
		
		
       int newPositionX = this.getX()+(this.vitesse*xSuivant);
       int newPositionY = this.getY()+(this.vitesse*ySuivant);
        
       // while(!terrain.dansTerrain(newPositionX, newPositionY)){
 
        	directionAleatoire();
        	newPositionX = this.getX()+(this.vitesse*xSuivant);
        	newPositionY = this.getY()+(this.vitesse*ySuivant);
     //   }
            this.setX(newPositionX);
            this.setY(newPositionY);
	}
    
	public abstract void agit();
	
}
