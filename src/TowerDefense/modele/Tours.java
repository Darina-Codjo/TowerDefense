package TowerDefense.modele;

import java.util.ArrayList;
import java.util.Random;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.tourelle.TourelleFeu;
import TowerDefense.modele.tourelle.TourelleGlace;
import TowerDefense.modele.tourelle.TourelleRoche;
import TowerDefense.modele.tourelle.TourelleTirMultiple;
import TowerDefense.modele.Jeu;

public class Tours  extends Acteur{
	
	private Jeu jeu;
	
	public Tours(double x, double y, Terrain terrain, Jeu jeu) {
		super(x, y, terrain);
		this.jeu=jeu;
	}
	
	
	public Jeu getJeu() {
		return this.jeu;
	}
	
	public void tirerSurEnnemis(Ennemis ennemis) {
		ennemis.setPv(0);
		jeu.getListeActeurs().remove(ennemis);
	}
	
	public 	ArrayList<Ennemis> listeEnnemis(){
		
		ArrayList<Ennemis> listeEnnemis = new ArrayList<Ennemis>();
		
		for(int i=0; i< jeu.getListeActeurs().size();i++) {
			if (jeu.getListeActeurs().get(i) instanceof Ennemis) {
				listeEnnemis.add((Ennemis) jeu.getListeActeurs().get(i));
			}
		}
		
		return listeEnnemis;
		
		
	}
	

	
	@Override
	public void agit() {
		
		for(int i=0; i< jeu.listeTourelle().size();i++) {
			
			if (jeu.listeTourelle().get(i) instanceof TourelleFeu) {
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
			
			else {
				
			}
		}
			
			
		
		
	}

}
