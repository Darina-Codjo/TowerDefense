package TowerDefense.modele;



import java.util.ArrayList;
import TowerDefense.modele.projectile.Projectile;
import TowerDefense.modele.tourelle.Tourelle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Jeu {
	
	private Terrain monTerrain;
	private ObservableList<Acteur> listeActeur;
	private ObservableList<Projectile> listeProjectile;
	private SimpleIntegerProperty argent;
	
	public Jeu(Terrain terrain) {
		this.monTerrain = terrain;
		this.listeActeur = FXCollections.observableArrayList() ;
		this.listeProjectile = FXCollections.observableArrayList() ;
		this.argent = new SimpleIntegerProperty(0);
		
	}
	
	
	public void tourDeJeuActeur() {
        for(int i = 0; i < listeActeur.size(); i++) {
        	Acteur a= listeActeur.get(i);
        	a.agit();
        }
	}
	
	public void acheterTourelleSpeciale() {
		int nbArgent=getArgent()-50;
		this.setArgent(nbArgent);
		
	}
	public boolean achatTourelleSpécialePossible() {
		if(getArgent()==50) {
			return true;
		}
		return false;
	}
	public void tourDeJeuProjectile() {
        for (int j = 0; j < listeProjectile.size(); j++) {
    		
        	Projectile p = listeProjectile.get(j);
        	p.agit();
        }
    }
	
	public boolean projectileExisteSurEnnemi(String idEnnemi) {
		for(int i=0; i< listeProjectile.size(); i++) {
			if (listeProjectile.get(i).getIdEnnemi()==idEnnemi) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Tourelle> listeTourelle(){
		ArrayList<Tourelle> listeTourelle = new ArrayList<Tourelle>();
		for(int i=0; i< getListeActeurs().size();i++) {
			if (getListeActeurs().get(i) instanceof Tourelle) {
				listeTourelle.add((Tourelle) getListeActeurs().get(i));
			}
		}
		return listeTourelle;
	}
	
	public void ajouterActeur(Acteur acteur){
		listeActeur.add(acteur);
	}	
	
	public ObservableList<Acteur> getListeActeurs() {
		return listeActeur;
	}
	
	public Terrain getMonTerrain() {
		return monTerrain;
	}
	
	public ObservableList<Projectile> getListeProjectile(){
		return listeProjectile;
	}

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
	
	public Acteur getActeur(String id) {
		for(Acteur a:this.listeActeur){
			if(a.getId().equals(id)){
				return a;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	


}
