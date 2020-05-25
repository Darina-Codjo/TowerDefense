package TowerDefense.modele;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Terrain;

public class Tours  extends Acteur{
	
	public Tours(int x, int y, Terrain terrain) {
		super(x, y, terrain);
	}
	
	
	public String getId() {
		return id;
	}


	@Override
	public void agit() {
		// TODO Auto-generated method stub
		
	}
}
