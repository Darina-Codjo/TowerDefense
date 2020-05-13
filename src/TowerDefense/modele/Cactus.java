package TowerDefense.modele;

public class Cactus extends Ennemis {
	
	public Cactus(Terrain monTerrain){
		super(monTerrain, 100, 10);
	}
	
	@Override
	public void agit() {
		int newPositionX = this.getX();
		int newPositionY = this.getY();
		this.seDeplacer();
	}
	
}
