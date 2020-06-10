package TowerDefense.modele;

import TowerDefense.modele.Tours;

public class Tourelle extends Tours {

	public Tourelle(double x,double y, Terrain terrain, Jeu jeu) {
		super(x, y, terrain,jeu);
	}
	
	public boolean ennemisProche(double zoneAttaque, Ennemis e) {
		
		if(		(this.getY()-zoneAttaque<= e.getY() && e.getY()<=this.getY()+zoneAttaque) &&
				(this.getX()-zoneAttaque<= e.getX() && e.getX()<=this.getX()+zoneAttaque)  
				){
			return true;
		}
		return false;
	}
	

}

