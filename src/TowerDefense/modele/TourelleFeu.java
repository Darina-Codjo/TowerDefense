package TowerDefense.modele;

import TowerDefense.modele.Terrain;
import TowerDefense.modele.TourelleBasique;

public class TourelleFeu extends TourelleBasique{

	public TourelleFeu(int x, int y, Terrain terrain, char direction) {
		super(x, y, terrain, direction);
		// TODO Auto-generated constructor stub
	}

	public TourelleFeu(Terrain terrain) {
		super(terrain);
	}


}
