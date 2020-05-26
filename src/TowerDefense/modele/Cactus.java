package TowerDefense.modele;

import TowerDefense.modele.Ennemis;

public class Cactus extends Ennemis {
	
	public Cactus(Terrain monTerrain){
		super(monTerrain, 100, 10);
	}
	

	@Override
	public String toString() {
		return "Cactus [getPointsDeVie()=" + getPv() + ", getVitesse()=" + getVitesse() + ", getxSuivant()="
				+ getxSuivant() + ", getySuivant()=" + getySuivant() + ", getX()=" + getX() + ", getY()=" + getY()
				+ ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}