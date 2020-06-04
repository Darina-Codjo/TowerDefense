package TowerDefense.modele.projectile;

import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Tours;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Projectile {
	
	private  Tours positionTourelle;
    private Ennemis positionEnnemis;
    private String id;
    private static int compteur=0;
	private DoubleProperty xProperty ;
	private DoubleProperty yProperty ;
    private Jeu jeu;
    
    
	

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
				
			}
				
			if (variabley >0) {
				this.setY(this.getY()-1);
			}
			else if (variabley <0) {
				this.setY(this.getY()+1);
				
			}
					
			if (variablex==0 && variabley==0) {
				jeu.getListeActeurs().remove(positionEnnemis);
				jeu.getListeProjectile().remove(this);
			}

		

		
	
	
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	


}
