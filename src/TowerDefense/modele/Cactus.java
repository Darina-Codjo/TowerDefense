package TowerDefense.modele;

import TowerDefense.modele.Ennemis;

public class Cactus extends Ennemis {
	
	public Cactus(Terrain monTerrain){
		super(monTerrain, 100, 10);
	}
	
	@SuppressWarnings("unused")
	@Override
	public void agit() {
		double newPositionX = this.getX();
		double newPositionY = this.getY();
		this.seDeplacer();
	}

	@Override
	public String toString() {
		return "Cactus [getPointsDeVie()=" + getPv() + ", getVitesse()=" + getVitesse() + ", getxSuivant()="
				+ getxSuivant() + ", getySuivant()=" + getySuivant() + ", getX()=" + getX() + ", getY()=" + getY()
				+ ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}