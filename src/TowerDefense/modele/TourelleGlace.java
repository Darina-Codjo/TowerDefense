package TowerDefense.modele;

import TowerDefense.modele.Terrain;
import TowerDefense.modele.TourelleBasique;

public class TourelleGlace extends TourelleBasique {

	public TourelleGlace(int x, int y, Terrain terrain /*char direction*/) {
		super(x, y, terrain/*direction*/);
	}


	public TourelleGlace(Terrain terrain) {
		super(terrain,100);
	}


	
	
	

}
