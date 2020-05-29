package TowerDefense.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Projectile {
	
	private  Tours positionTourelle;
    private Ennemis positionEnnemis;
    private String id;
    private static int compteur=0;
	private DoubleProperty xProperty ;
	private DoubleProperty yProperty ;
    public Jeu jeu;
    
	

	public Projectile(Tours tourelleDepart, Ennemis ennemisArrivee, Jeu jeu) {

		this.jeu=jeu;
		this.positionTourelle=tourelleDepart;
		this.positionEnnemis=ennemisArrivee;
		this.xProperty =new SimpleDoubleProperty(tourelleDepart.getX()) ;
		this.yProperty =new SimpleDoubleProperty(tourelleDepart.getY()) ;
		this.id="A"+compteur;
		compteur++;
		
	}
	
	
	public double getX() {
		return xProperty.getValue();
	}
	
	public void setX(double newPositionX) {
		xProperty.setValue(newPositionX) ;
	}
	
	public DoubleProperty xProperty() {
		return this.xProperty ;
	}
	
	public double getY() {
		return yProperty.getValue() ;
	}
	
	public void setY(double newPositionY) {
		yProperty.setValue(newPositionY) ;
	}
	
	public final DoubleProperty yProperty(){
		return this.yProperty ;
	}
		
	
	public String getId() {
		return this.id;
	}
	

	
	
	
	public void agit() {
		
		double variablex= this.getX() - positionEnnemis.getX();
		double variabley = this.getY() - positionEnnemis.getY();
		
		if (variablex >0) { 
			this.setX(this.getX()-1);
		}
		else if (variablex <0) {
			this.setX(this.getX()+1);
			//System.out.println("Test2");
		}
		//System.out.println(variablex);
		
		if (variabley >0) {
			this.setY(this.getY()-1);
		}
		else if (variabley <0) {
			this.setY(this.getY()+1);
			
		}
		
		//System.out.println(variabley);
		
		if (variablex==0 && variabley==0) {
			//System.out.println("bien arrivé");
			jeu.getListeActeurs().remove(positionEnnemis);
			jeu.getListeProjectile().remove(positionTourelle);
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	


}
