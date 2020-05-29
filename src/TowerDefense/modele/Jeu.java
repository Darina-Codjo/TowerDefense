package TowerDefense.modele;

import java.util.ArrayList;

import TowerDefense.modele.Acteur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Jeu {
	
	private Terrain monTerrain;
	private ObservableList<Acteur> listeActeur;
	private ObservableList<Projectile> listeProjectile;
	
	public Jeu(Terrain terrain) {
		this.monTerrain = terrain;
		//this.listeActeur = new ArrayList<Acteur>();
		this.listeActeur= FXCollections.observableArrayList() ;
		this.listeProjectile= FXCollections.observableArrayList() ;
	}
	
	public void tourDeJeu() {
        for(int i = 0; i < listeActeur.size(); i++) {
        	Acteur a= listeActeur.get(i);
        	//System.out.println( listeActeur.get(i).getId()+ " va bouger");
        	a.agit();
        }
        
        for (int j=0; j< listeProjectile.size(); j++) {
        	Projectile p= listeProjectile.get(j);
        	p.agit();
        }
    }
	
	public void ajouterActeur(Acteur acteur){
		listeActeur.add(acteur);
	}
	
//	public ArrayList<Acteur> getListeActeurs() {
//		return listeActeur;
//	}
	
	
	public ObservableList<Acteur> getListeActeurs() {
		return listeActeur;
	}
		
	
	public Terrain getMonTerrain() {
		return monTerrain;
	}
	
	public ObservableList<Projectile> getListeProjectile(){
		return listeProjectile;
	}

//	public Acteur getActeur(Acteur a) {
//		Acteur acteur=a;
//		for(int i=0; i< listeActeur.size();i++) {
//			if(a instanceof Ennemis) {
//				acteur= (Ennemis) listeActeur.get(i);
//			}
//			else
//				acteur= (Tourelle) listeActeur.get(i);
//		}
//		return acteur;		
//	}
	
	public Acteur getActeur(String id) {
		for(Acteur a:this.listeActeur){
			if(a.getId().equals(id)){
				return a;
			}
		}
		return null;
	}
	
	

	


}
