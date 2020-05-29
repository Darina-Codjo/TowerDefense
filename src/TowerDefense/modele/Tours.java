package TowerDefense.modele;

import java.util.ArrayList;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Jeu;

public class Tours  extends Acteur{
	
	private Jeu jeu;
	
	public Tours(double x, double y, Terrain terrain, Jeu jeu) {
		super(x, y, terrain);
		this.jeu=jeu;
	}
	
	public void tirerSurEnnemis(Ennemis ennemis) {
		ennemis.setPv(0);
		jeu.getListeActeurs().remove(ennemis);
	}
	
	public 	ArrayList<Ennemis> projectile(){
		
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
		System.out.println(projectile().size());
		
		for(int j=0; j< projectile().size(); j++) {
			jeu.getListeProjectile().add(new Projectile(this, projectile().get(j), jeu));
		}
			
		
	}

}
