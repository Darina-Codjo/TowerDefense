package TowerDefense.modele;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tourelle;

public class TourelleDestructible extends Tourelle {
	
	private int pv;

	public TourelleDestructible(double x, double y, Terrain terrain, Jeu jeu, int pv) {
		super(x, y, terrain, jeu);
		this.pv=pv;		
	}
	
	public int getPv() {
		return this.pv;
	}
	
	public void setPvDegat(int degatRecu) {
		this.pv -= degatRecu;
	}
	
	

}
