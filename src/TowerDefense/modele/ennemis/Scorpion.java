package TowerDefense.modele.ennemis;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;

public class Scorpion extends Ennemis{
	
	public Scorpion (Terrain monTerrain,Jeu jeu){
		super(monTerrain, 150, 0.5, jeu);
	}
	
	@Override
	public String toString() {
		return "Cactus [getPointsDeVie()=" + getPv() + ", getVitesse()=" + getVitesse() + ", getxSuivant()="
				+ getXSuivant() + ", getySuivant()=" + getYSuivant() + ", getX()=" + getX() + ", getY()=" + getY()
				+ ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
