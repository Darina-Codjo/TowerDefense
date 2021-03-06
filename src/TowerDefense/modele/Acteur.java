package TowerDefense.modele;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Acteur {
	
	private DoubleProperty xProperty ;
	private DoubleProperty yProperty ;
	private String id;
	protected Terrain terrain;
	public static int compteur=0;
	
	public Acteur(double x, double y, Terrain terrain) {
		this.terrain = terrain;	
		this.xProperty = new SimpleDoubleProperty(x) ;
		this.yProperty = new SimpleDoubleProperty(y) ;
		this.id="A"+compteur;
		compteur++;
	}
	
	
	public int getCompteur() {
		return compteur;
	}
	
	public void setCompteur(int newCompteur) {
		this.compteur = newCompteur;
	}
	
	
	
	public double getX() {
		return this.xProperty.getValue();
	}
	
	public void setX(double newPositionX) {
		this.xProperty.setValue(newPositionX) ;
	}
	
	public DoubleProperty xProperty() {
		return this.xProperty ;
	}
	
	public double getY() {
		return this.yProperty.getValue() ;
	}
	
	public void setY(double newPositionY) {
		this.yProperty.setValue(newPositionY) ;
	}
	
	public final DoubleProperty yProperty(){
		return this.yProperty ;
	}
	
	
	
	
	public String getId() {
		return id;
	}
	
		
	public abstract void agit();
	
	public String toString() {
		return "Position: x="+ this.xProperty + " y="+ this.yProperty+ "\n Id:" + this.id;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
