package TowerDefense.modele.tourelle;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tours;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.projectile.Projectile;

public class TourelleDestructible extends Tours {
	
	private int pv;

	public TourelleDestructible(int x, int y, Terrain terrain, Jeu jeu, int pv) {
		super(x, y, terrain, jeu);
		this.pv = pv;		
	}
	
	public int getPv() {
		return this.pv;
	}
	
	public void setPvDegat(int degatRecu) {
		this.pv -= degatRecu;
	}
	
	public void tir() {	
		
		Ennemis ennemiViser= ennemieVisable(100);
		if (ennemiViser != null) {
			if(!getJeu().projectileExisteSurEnnemi(ennemiViser.getId())) {				
				getJeu().getListeProjectile().add(new Projectile(this,ennemiViser,getJeu()));
				
			}			
		}			
	}
}
	
