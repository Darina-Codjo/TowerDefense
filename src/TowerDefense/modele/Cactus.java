package TowerDefense.modele;

public class Cactus extends Ennemis {
	
	private int pointsVie;
	private int vitesse;	
	
	
	public Cactus(Terrain monTerrain) {
		super(monTerrain, 100, 10);
	}



	@Override
	public void agit() {
		this.getX();
		this.getY();
		this.seDeplacer();
		System.out.println("M" + this.getId());
	}
	
}
