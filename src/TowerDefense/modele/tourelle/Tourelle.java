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
	
	
	//Prend en paramètre la zone d'attaque de la tourelle
	//parcours la liste d'ennemis et si un ennemis est dans cette zone 
	//alors elle est retourner par la méthode est se fera donc tirer dessus
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

