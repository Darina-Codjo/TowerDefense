package TowerDefense.modele;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Terrain;

public class EnnemisSpeciales extends Ennemis {

	public EnnemisSpeciales(Terrain terrain) {
		super(terrain);
	}

	public EnnemisSpeciales(Terrain terrain, int pv, int v) {
		super(terrain, pv, v);
	}
	
	@Override
	public void agit() {
		double newPositionX = this.getX();
		double newPositionY = this.getY();
		this.seDeplacer();
	}

	@Override
	public String toString() {
		return "Cactus [getPointsDeVie()=" + getPointsDeVie() + ", getVitesse()=" + getVitesse() + ", getxSuivant()="
				+ getxSuivant() + ", getySuivant()=" + getySuivant() + ", getX()=" + getX() + ", getY()=" + getY()
				+ ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
