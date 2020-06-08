package TowerDefense.modele.tourelle;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tours;

public class Tourelle extends Tours {

	
	

	public Tourelle(double x, double y, Terrain terrain, Jeu jeu) {
		super(x, y, terrain,jeu);
	}
	

	
	public boolean ennemisProcheTirTourelleMultiple(double zoneAttaque, Ennemis e) {

				if(		(this.getY()-zoneAttaque<= e.getY() && e.getY()<=this.getY()+zoneAttaque) &&
						(this.getX()-zoneAttaque<= e.getX() && e.getX()<=this.getX()+zoneAttaque)  
						){
					return true;
				}		
		return false;
	}
	
	public Ennemis ennemieVisable(double zoneAttaque) {
		
		Ennemis ennemieVisable=null;
	
		for(Acteur a :getJeu().getListeActeurs()) {
			if(a instanceof Ennemis) {
				if(		(this.getY()-zoneAttaque<= a.getY() && a.getY()<=this.getY()+zoneAttaque) &&
						(this.getX()-zoneAttaque<= a.getX() && a.getX()<=this.getX()+zoneAttaque)  
						){
					ennemieVisable=(Ennemis) a;
					return ennemieVisable;
				}
			} 
		}
		return ennemieVisable;
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}

