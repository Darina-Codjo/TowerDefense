package TowerDefense.modele;

import java.util.ArrayList;
import TowerDefense.modele.Ennemis;

public class Jeu {
	
	private Terrain monTerrain;
	private ArrayList<Acteur> listeActeur;
	private ArrayList<Acteur> listeEnnemis;
	public Jeu(Terrain terrain) {
		this.monTerrain = terrain;
		this.listeActeur = new ArrayList<Acteur>();
	}
	
	public void tourDeJeu() {
        for(int i = 0; i < listeActeur.size(); i++) {
         Acteur a= listeActeur.get(i);
         //System.out.println( listeActeur.get(i).getId()+ " va bouger");
         a.agit();
        }
        
    }
	
	public void ajouterActeur(Acteur acteur){
		listeActeur.add(acteur);
	}
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
	
	
	
	public Acteur getActeur(Acteur a) {
		Acteur acteur=a;
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
