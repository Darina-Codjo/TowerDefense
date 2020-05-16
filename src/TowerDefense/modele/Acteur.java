package TowerDefense.modele;
import java.util.Random;

public abstract class Acteur {
	
	private double x;
	private double y;
	protected String id;
	protected Terrain terrain;
	static private int compteur=0;
	
	public Acteur(double x, double y, Terrain terrain) {
		Random random = new Random();
		this.x = x;//random.nextInt(terrain.getWidth()-1);
		this.y = y;//random.nextInt(terrain.getHeight()-1);
		this.terrain = terrain;
		this.id ="A"+compteur;
		compteur++;
	}
	public Acteur(Terrain terrain) {
		//random de position dans tab[][][][]
		this.terrain = terrain;	
		this.id="A"+compteur;
		compteur++;
	}
	public double getX() {
		return x;
	}
	public void setX(double newPositionX) {
		this.x = newPositionX;
	}
	public double getY() {
		return y;
	}
	public void setY(double newPositionY) {
		this.y = newPositionY;
	}
	public String getId() {
		return id;
	}
	
	public abstract void agit();
}
