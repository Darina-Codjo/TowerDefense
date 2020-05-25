package TowerDefense.modele;

import TowerDefense.modele.Terrain;

public class TourelleRoche extends TourelleBasique{

	public TourelleRoche(int x, int y, Terrain terrain /*char direction*/) {
		super(x, y, terrain/*direction*/);
	}
	
	public TourelleRoche(Terrain terrain) {
		super(terrain,100);
	}

}
