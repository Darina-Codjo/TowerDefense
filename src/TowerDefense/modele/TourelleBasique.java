package TowerDefense.modele;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tourelle;
import TowerDefense.modele.Jeu;
public class TourelleBasique {
	private char direction;
	
	
	
	public TourelleBasique(int x, int y, Terrain terrain, char direction) {
		//super(x, y, terrain);
		this.direction='N';
		// TODO Auto-generated constructor stub
		
	}
	
	public char getDirection() {
		return direction;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}
	
	

}
