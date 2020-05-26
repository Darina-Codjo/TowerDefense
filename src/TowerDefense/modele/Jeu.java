package TowerDefense.modele;

import java.util.ArrayList;

public class Jeu {
	
	private Terrain monTerrain;
	private ArrayList<Acteur> listeActeur;
	
	
	public Jeu(Terrain terrain) {
		this.monTerrain = terrain;
		this.listeActeur = new ArrayList<Acteur>();
	}
	
	//parcours la liste pour faire agir les acteurs 
	public void tourDeJeu() {
        for(int i = 0; i < listeActeur.size(); i++) {
         Acteur acteur = listeActeur.get(i);
         acteur.agit();
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
	
	//utilisé pour trouvé un acteur a partir de son ID
	public Acteur getActeurId(String id) {
		for(Acteur a : this.listeActeur) {
			if(a.getId().equals(id)){
				return a;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	


}
