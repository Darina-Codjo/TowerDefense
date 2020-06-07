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
	

	//Booléen qui prend en paramètre la zone d'attaque de la tourelle (à tant de pixel) et un ennemi
	//vérifie si cette ennemi est à la portée de la tourelle et peut donc se faire tirer dessus par celui-ci
	public boolean ennemisProcheTirTourelleMultiple(double zoneAttaque, Ennemis e) {

				if(		(this.getY()-zoneAttaque<= e.getY() && e.getY()<=this.getY()+zoneAttaque) &&
						(this.getX()-zoneAttaque<= e.getX() && e.getX()<=this.getX()+zoneAttaque)  
						){
					return true;
				}		
		return false;
	}
	
	
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}

