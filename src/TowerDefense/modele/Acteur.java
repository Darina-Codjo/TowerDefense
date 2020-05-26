package TowerDefense.modele;

public abstract class Acteur {
	
	
	private double x;
	private double y;
	private String id;
	protected Terrain terrain;
	static private int compteur=0;
	
	//constructeur 
	public Acteur(double x, double y, Terrain terrain) {
		this.x = x;
		this.y = y;
		this.terrain = terrain;
		this.id ="A"+compteur;
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
	
	//m�thode cod�e dans Ennemis et tourelle pour que les acteurs puissent agir diff�rement 
	public abstract void agit();
	
	public String toString() {
		return "Position: x="+ this.x + " y="+ this.y+ "\n Id:" + this.id;
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
