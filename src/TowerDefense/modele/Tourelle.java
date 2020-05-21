package TowerDefense.modele;

import TowerDefense.modele.Tours;

public class Tourelle extends Tours {
	
	private Jeu game;

	public Tourelle(int x, int y, Terrain terrain/*,Jeu jeu*/) {
		super(x, y, terrain);
		//this.game = jeu;
	}
	
	public Tourelle(Terrain terrain /*,Jeu jeu*/) {
		super(0,2,terrain);
		//this.game = jeu;
	}
	

/*	
	private Ennemis tirerEnnemis(){
//zone...
		if(this.game.getListeActeurs().size() == 0) {
			System.out.println("liste vide");
			return null;
		}
		else {
			for(Acteur acteur : this.game.getListeActeurs()) {
				if(acteur instanceof Ennemis) {
					
	//				if(		(this.getX()-zone.getRadius()<=acteur.getX() && acteur.getX()<= this.getX()+zone.getRadius()) &&
	//						(this.getY()-zone.getRadius()<=acteur.getY() && acteur.getY()<= this.getY()+zone.getRadius()))
					if(		(this.getX()-10<=acteur.getX() && acteur.getX()<= this.getX()+10) &&
							(this.getY()-10<=acteur.getY() && acteur.getY()<= this.getY()+10))				
					{
						return (Ennemis) acteur;
					}
				}
			}
			return null;
		}
	}
	
	@Override
	public void agit() {
		Acteur acteur = this.tirerEnnemis();		
		if(acteur instanceof Ennemis && acteur != null) {
			((Ennemis)acteur).meurt();
			System.out.println(acteur.toString());
		}
	}
	
//	//creer une zone de tire de 10pixel de rayon et la superposer sur le sprite de la tourelle 
//	Circle zone = new Circle(10);
//	zone.setId(this.id);
//	zone.setTranslateX(this.getX());
//	zone.setTranslateY(this.getY());
//	plateau.getChildren().add(zone);
//	
//	//verification : si un ennemis est dans le rayon de la tourelle il meure
	
//Doonia
//	public boolean tireSurEnnemis(Acteur acteur) {
//	if (acteur instanceof Ennemis) {
//		if ( this.getY()<acteur.getY()&& this.getX()== acteur.getX()) {
//		((Ennemis) acteur).setPointsDeVie(((Ennemis) acteur).getPointsDeVie());
//			if (((Ennemis) acteur).getPointsDeVie()<=0 )
//				 ((TowerDefense.modele.Jeu) this.Jeu).suppEnnemis(acteur);
//			return true;
//		}		
//	}
//	return false;
//}

//public void agit(Acteur acteur) {
//	double x ;
//	double y ; 
//	/* if(acteur instanceof Ennemis) {   
//		 if (tireSurEnnemis(acteur) == true)
//			CreerSprite.projectileSprite(x, y);*/
//		 
//}
}
	
	

