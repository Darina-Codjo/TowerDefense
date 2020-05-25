package TowerDefense.modele;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Terrain;

public class Scorpion extends Ennemis{
	
	public Scorpion (Terrain monTerrain){
		super(monTerrain, 100, 10);
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
