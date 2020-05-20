package TowerDefense.modele;

import TowerDefense.modele.Tours;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Ennemis;
import TowerDefense.vue.CreerSprite;
public class Tourelle extends Tours {
	

	private Object Jeu;
	

	public Tourelle(int x, int y, Terrain terrain) {
		super(x, y, terrain);
	}
	
	public Tourelle(Terrain terrain) {
		super(0,2,terrain);

	}
	
	public boolean tireSurEnnemis(Acteur acteur) {
		if (acteur instanceof Ennemis) {
			if ( this.getY()<acteur.getY()&& this.getX()== acteur.getX()) {
			((Ennemis) acteur).setPointsDeVie(((Ennemis) acteur).getPointsDeVie());
				if (((Ennemis) acteur).getPointsDeVie()<=0 )
					 ((TowerDefense.modele.Jeu) this.Jeu).suppEnnemis(acteur);
				return true;
			}		
		}
		return false;
	}
	
	public void agit(Acteur acteur) {
		double x ;
		double y ; 
		/* if(acteur instanceof Ennemis) {   
			 if (tireSurEnnemis(acteur) == true)
				CreerSprite.projectileSprite(x, y);*/
			 
	}
}
	
	

