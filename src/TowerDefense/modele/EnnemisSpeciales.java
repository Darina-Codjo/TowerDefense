package TowerDefense.modele;

import TowerDefense.modele.Ennemis;

public class EnnemisSpeciales extends Ennemis {

	public EnnemisSpeciales(Terrain terrain, int pv, double v) {
		super(terrain, pv, v);
	}


	@Override
	public String toString() {
		return "Cactus [getPointsDeVie()=" + getPv() + ", getVitesse()=" + getVitesse() + ", getxSuivant()="
				+ getxSuivant() + ", getySuivant()=" + getySuivant() + ", getX()=" + getX() + ", getY()=" + getY()
				+ ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
