package TowerDefense.modele;

import java.util.ArrayList;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.projectile.Projectile;
import TowerDefense.modele.tourelle.Tourelle;
import TowerDefense.vue.AchatTourelleSpeciale;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Jeu {
	
	private Terrain monTerrain;
	private ObservableList<Acteur> listeActeur;
	private ObservableList<Projectile> listeProjectile;
	private SimpleIntegerProperty argent;
	
	
	public Jeu(Terrain terrain) {
		this.monTerrain = terrain;
		this.listeActeur= FXCollections.observableArrayList() ;
		this.listeProjectile= FXCollections.observableArrayList() ;
		this.argent=new SimpleIntegerProperty(0);
		
	}
	
	//Ces 2 m�thodes sont appel� dans la gameloop
	//
	//tourDeJeuActeur: parrcours la liste d'acteur compos�e d'ennemis et de tourelles et les font agir
	//Les ennemis se d�placent et les tourelles tirs sur les ennemis
	//
	//tourDeJeuProjectile:parocurs la liste de projectile et les fait agir
	//Chaque projectile part d'une tourelle et calcule la trajectoire d'un ennemis jusqu� le toucher
	public void tourDeJeuActeur() {
        for(int i = 0; i < listeActeur.size(); i++) {
        	Acteur a= listeActeur.get(i);
        	//System.out.println( listeActeur.get(i).getId()+ " va bouger");
        	a.agit();
        }
        
	}
	
	public void tourDeJeuProjectile() {
        
        for (int j=0; j< listeProjectile.size(); j++) {
    		
        	Projectile p= listeProjectile.get(j);
        	p.agit();
        }
    }
	
	
	
	
	
	//Toutes les m�thodes qui renvoit des liste : liste d'acteur (ennemis et tourelle ensemble), 
	//liste de tourelle, liste d'ennemis et la liste de projectile
	//les liste d'acteur et de projectiles sont des observableListe puisqu'elles sont li�s � la vue
	public ArrayList<Tourelle> listeTourelle(){
		ArrayList<Tourelle> listeTourelle = new ArrayList<Tourelle>();
		
		for(int i=0; i< getListeActeurs().size();i++) {
			if (getListeActeurs().get(i) instanceof Tourelle) {
				listeTourelle.add((Tourelle) getListeActeurs().get(i));
			}
		}
		
		return listeTourelle;
		
	}
	
	public 	ArrayList<Ennemis> listeEnnemis(){
		
		ArrayList<Ennemis> listeEnnemis = new ArrayList<Ennemis>();		
		for(int i=0; i< getListeActeurs().size();i++) {
			if (getListeActeurs().get(i) instanceof Ennemis) {
				listeEnnemis.add((Ennemis) getListeActeurs().get(i));
			}
		}		
		return listeEnnemis;	
	}
	
	public ObservableList<Acteur> getListeActeurs() {
		return listeActeur;
	}
	
	public ObservableList<Projectile> getListeProjectile(){
		return listeProjectile;
	}
	
	
	
	
	public void ajouterActeur(Acteur acteur){
		listeActeur.add(acteur);
	}
	
			
	public Terrain getMonTerrain() {
		return monTerrain;
	}
	


	
	//Cette m�thode re�oit en param�tre l'id un ennemi 
	//Elle parcourt la liste de projectile et v�rifie si un ennemis est d�j� vis�
	//si c'est le cas la m�thode renvoit "false" et le projectile n'est pas lanc�
	public boolean projectileExisteSurEnnemi(String idEnnemi) {
		
		for(int i=0; i< listeProjectile.size(); i++) {
			if (listeProjectile.get(i).getIdEnnemi()==idEnnemi) {
				return true;
			}
			
		}
		return false;
	}
	
	
	
	
	//les m�thodes get, set et achat relatives � l'argent
	//Achat: une m�thode v�rifie que nous avons assez d'argent pour qu'on puisse acheter une tourelle sp�ciale
	//       l'autre m�thode d�duit l'argent qu'on a utilis� pour acheter la tourelle sp�ciale
	public final int getArgent(){
		return this.argent.getValue() ;
	}
	
	public final void incrementerArgent(int argent){
		int nbArgent=getArgent()+argent;
		this.argent.setValue(nbArgent) ;
	}
	
	public void setArgent(int nbArgent) {
		this.argent.setValue(nbArgent) ;
	}
		
	public final IntegerProperty NbArgentProperty() {
		return argent ;
	}
	
	public void acheterTourelleSpeciale() {
		int nbArgent=getArgent()-50;
		this.setArgent(nbArgent);
		
	}
	
	public boolean achatTourelleSp�cialePossible() {
		if(getArgent()==50) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	


}
