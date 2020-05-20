package TowerDefense.modele;

import java.util.ArrayList;

public class Jeu {
	
	private Terrain monTerrain;
	private ArrayList<Acteur> listeActeur;
	
	
	public Jeu(Terrain terrain) {
		this.monTerrain = terrain;
		this.listeActeur = new ArrayList<Acteur>();
	}
	
	public void tourDeJeu() {
        for(int i = 0; i < listeActeur.size(); i++) {
         Acteur acteur = listeActeur.get(i);
         //System.out.println( listeActeur.get(i).getId()+ " va bouger");
         acteur.agit();
        }
//        for(int i = listeActeur.size()-1; i >= 0; i--) {
//        	Acteur acteur = listeActeur.get(i);
//        	if( ! (((Ennemis) acteur).estVivant()) ){
//        		listeActeur.remove(i);
//         	}
//        }
    }
	
	public void ajouterActeur(Acteur acteur){
		listeActeur.add(acteur);
	}
	
//	public void tuerActeur(Acteur acteur) {
//		listeActeur.remove(acteur);
//	}
	
	public void suppEnnemis(Acteur acteur ) {
		if(acteur instanceof Ennemis) {
		listeActeur.remove(acteur);
		}
		
	}
	public ArrayList<Acteur> getListeActeurs() {
		return listeActeur;
	}
		
	
	public Terrain getMonTerrain() {
		return monTerrain;
	}
	
	public Acteur getActeurId(String id) {
		for(Acteur a : this.listeActeur) {
			if(a.getId().equals(id)){
				return a;
			}
		}
		return null;
	}
	
	
	public Acteur getActeur(Acteur a) {
		Acteur acteur = a;
		for(int i=0; i< listeActeur.size();i++) {
			if(a instanceof Ennemis) {
				acteur= (Ennemis) listeActeur.get(i);
			}
			else
				acteur= (Tourelle) listeActeur.get(i);
		}
		return acteur;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	


}
