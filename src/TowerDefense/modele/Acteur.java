package TowerDefense.modele;
import java.util.Random;

import TowerDefense.modele.Terrain;

public abstract class Acteur extends Jeu {
	
	private int x;
	private int y;
	protected String id;
	protected Terrain terrain;
	static private int compteur=0;
	
	public Acteur(int x, int y, Terrain terrain) {
		super();
		Random random=new Random();
		this.x = random.nextInt(terrain.getWidth()-1);
		this.y = random.nextInt(terrain.getHeight()-1);
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
	public int getX() {
		return x;
	}
	public void setX(int newX) {
		this.x = newX;
	}
	public int getY() {
		return y;
	}
	public void setY(int newY) {
		this.y = newY;
	}
	public String getId() {
		return id;
	}
	
	public abstract void agit();
}
