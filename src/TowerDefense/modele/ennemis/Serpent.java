package TowerDefense.modele.ennemis;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Terrain;

public class Serpent extends Ennemis{
	
	public Serpent (Terrain monTerrain){
		super(monTerrain, 100, 0.5);
	}

	@Override
	public String toString() {
		return "Cactus [getPointsDeVie()=" + getPv() + ", getVitesse()=" + getVitesse() + ", getxSuivant()="
				+ getxSuivant() + ", getySuivant()=" + getySuivant() + ", getX()=" + getX() + ", getY()=" + getY()
				+ ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
