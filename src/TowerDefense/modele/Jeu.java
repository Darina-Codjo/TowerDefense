package TowerDefense.modele;

import java.util.ArrayList;
import java.util.Random;
import TowerDefense.modele.projectile.Projectile;
import TowerDefense.modele.Acteur;
import TowerDefense.modele.ennemis.Cactus;
import TowerDefense.modele.ennemis.CactusSpeciale;
import TowerDefense.modele.ennemis.Scorpion;
import TowerDefense.modele.ennemis.ScorpionSpeciale;
import TowerDefense.modele.ennemis.Serpent;
import TowerDefense.modele.ennemis.SerpentSpeciale;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Jeu {
	
	private Terrain monTerrain;
	private static ObservableList<Acteur> listeActeur;
	private ObservableList<Projectile> listeProjectile;
	private SimpleIntegerProperty argent;
	private int nbVagues;
	
	
	public Jeu(Terrain terrain) {
		this.monTerrain = terrain;
		this.listeActeur = FXCollections.observableArrayList() ;
		this.listeProjectile = FXCollections.observableArrayList() ;
		this.argent = new SimpleIntegerProperty(0);
		this.nbVagues=0;
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
        	a.agit();
        }
	}
	
	public void tourDeJeuProjectile() {
        for (int j = 0; j < listeProjectile.size(); j++) {
    		
        	Projectile p = listeProjectile.get(j);
        	p.agit();
        }
    }
	
	
	//Toutes les m�thodes qui renvoit des liste : liste d'acteur (ennemis et tourelle ensemble), 
	//liste de tourelle, liste d'ennemis et la liste de projectile
	//les liste d'acteur et de projectiles sont des observableListe puisqu'elles sont li�s � la vue
	public static ArrayList<Tours> listeTourelle(){
		ArrayList<Tours> listeTourelle = new ArrayList<Tours>();
		for(int i=0; i< getListeActeurs().size();i++) {
			if (getListeActeurs().get(i) instanceof Tours) {
				listeTourelle.add((Tours) getListeActeurs().get(i));
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
	
	public static ObservableList<Acteur> getListeActeurs() {
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
	
	public int getNbVagues() {
		return this.nbVagues;
	}
	
	public void setNbVagues(int nbVague) {
		this.nbVagues=nbVague;
	}
	public void incrementerVagues() {
		this.nbVagues++;
	}
	
	
	
	//Ces 2 m�thodes g�rent l'achat d'une tourelle sp�ciale
	//La premi�re fait l'achat et la deuxi�me v�rifie que l'achat est possible
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
	
	
	
	
	public Acteur tourelleProche(double x, double y) {

		Acteur tours=null;
		
		for(int i=0; i<listeTourelle().size();i++) {
			if(		(y-1<= listeTourelle().get(i).getY() && listeTourelle().get(i).getY()<=y+1) &&
					(x-1<= listeTourelle().get(i).getX() && listeTourelle().get(i).getX()<=x+1)  
					){
				tours=listeTourelle().get(i);
				return tours;
			}
		}
		return tours ;
	}
	
	
	public void vagueEnnemis() {
		if(getNbVagues()<=20) {
			Acteur cactus = new Cactus(monTerrain,this);
			Acteur serpent= new Serpent(monTerrain,this);
			Acteur scorpion= new Scorpion(monTerrain,this);
			Acteur scorpionSpeciale= new ScorpionSpeciale(monTerrain,this);
			Acteur serpentSpeciale= new SerpentSpeciale(monTerrain,this);
			Acteur cactusSpeciale=new CactusSpeciale(monTerrain,this);
			
			ArrayList<Ennemis> liste = new ArrayList<Ennemis>();
			liste.add((Ennemis) cactus);
			liste.add((Ennemis) serpent);
			liste.add((Ennemis) scorpion);
			liste.add((Ennemis) scorpionSpeciale);
			liste.add((Ennemis) cactusSpeciale);
			liste.add((Ennemis) serpentSpeciale);
			
			Random random = new Random();      
	        int randomInt = random.nextInt(liste.size());      
	        	listeActeur.add(liste.get(randomInt));
	  
	        incrementerVagues();
	        
		}
	}
	
	
	public boolean partieEnCours() {
		if(listeActeur.size()!=0 || listeProjectile.size()!=0) {
			return true;
		}
		return false;
	}
	
	public Acteur getActeur(String id) {
		for(Acteur a:listeActeur){
			if(a.getId().equals(id)){
				return a;
			}
		}
		return null;
	}
	
	
	//Au cours du jeu si il y a un cactus sp�ciale, ses pv s'incr�mentent
	public void rechargement() {
		
		for(int i=0;i<listeEnnemis().size(); i++) {
			if(listeEnnemis().get(i) instanceof CactusSpeciale) {
				listeEnnemis().get(i).incrementerPv();
			}
		}
	}
	
	//Si la grande tour a perdu tout ses pv alors return true et donc la partie s'arr�te
	public boolean partiePerdue() {
		
		for(int i=0; i<listeActeur.size();i++) {
			if(listeActeur.get(i) instanceof GrandeTour) {
				if(((GrandeTour) listeActeur.get(i)).getPv() <= 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
