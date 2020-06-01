package TowerDefense.modele;

import TowerDefense.modele.Tours;
import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;

public class Tourelle extends Tours {

	
	

	public Tourelle(double x, double y, Terrain terrain, Jeu jeu) {
		super(x, y, terrain,jeu);
	}

	
	public boolean ennemisProche(double zoneAttaque) {
		for(Acteur a :getJeu().getListeActeurs()) {
			if(a instanceof Ennemis) {
				if(		(this.getY()-zoneAttaque<= a.getY() && a.getY()<=this.getY()+zoneAttaque) &&
						(this.getX()-zoneAttaque<= a.getX() && a.getX()<=this.getX()+zoneAttaque)  
						){
					return true;
				}
			}
			
			
		}
		return false;
	}
	

}

