package TowerDefense.modele;

import java.util.ArrayList;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.tourelle.TourelleFeu;
import TowerDefense.modele.tourelle.TourelleGlace;
import TowerDefense.modele.tourelle.TourelleRoche;

import TowerDefense.modele.tourelle.TourelleTirMultiple;

public class Tours  extends Acteur{

	private Jeu jeu;

	public Tours(int x, int y, Terrain terrain, Jeu jeu) {
		super(x, y, terrain);
		this.jeu = jeu;
	}

	public Jeu getJeu() {
		return this.jeu;
	}


	//Parcours de la liste de tourelle et leur fait tirer leur attaque respective
	//Chaque tir à son projectile qui luicest propre. 
	//Exemple: TourelleFeu tire un projectile de feu / TourelleGlace tire un projectile de glace
	@Override
	public void agit() {

		for(int i=0; i< jeu.listeTourelle().size();i++) {
			if(jeu.listeTourelle().get(i) instanceof TourelleFeu) {
				((TourelleFeu) jeu.listeTourelle().get(i)).tir();			
			}
			else if (jeu.listeTourelle().get(i) instanceof TourelleGlace) {
				((TourelleGlace) jeu.listeTourelle().get(i)).tir();
			}
			else if(jeu.listeTourelle().get(i) instanceof TourelleRoche) {
				((TourelleRoche) jeu.listeTourelle().get(i)).tir();	
			}
			else if(jeu.listeTourelle().get(i) instanceof TourelleTirMultiple){
				((TourelleTirMultiple) jeu.listeTourelle().get(i)).tirMultiple();
			}
		}
	}

	//Prend en paramètre la zone d'attaque de la tourelle
	//parcours la liste d'ennemis et si un ennemis est dans cette zone 
	//alors elle est retourner par la méthode est se fera donc tirer dessus
	public Ennemis ennemieVisable(double zoneAttaque) {
		
		Ennemis ennemieVisable = null;
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
