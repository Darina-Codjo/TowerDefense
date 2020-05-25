package TowerDefense.modele;

public class TourelleRoche extends TourelleBasique{

	public TourelleRoche(Terrain terrain) {
		super(terrain);
		
	}

	public TourelleRoche(int x, int y, Terrain terrain, char direction) {
		super(x, y, terrain, direction);
	}

}
