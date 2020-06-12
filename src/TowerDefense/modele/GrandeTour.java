package TowerDefense.modele;

import TowerDefense.modele.Tours;
import TowerDefense.modele.ennemis.CactusSpeciale;
import TowerDefense.modele.ennemis.ScorpionSpeciale;
import TowerDefense.modele.ennemis.SerpentSpeciale;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.projectile.Projectile;

public class GrandeTour extends Tours {

	private int pv;
	public GrandeTour(Terrain terrain, Jeu jeu, int pv) {
		super(terrain.getIndiceTuileFinChemin()%30, terrain.getIndiceTuileFinChemin()/30, terrain, jeu);
		this.pv=pv;
	}
	
	public int getPv() {
		return this.pv;
	}
	
	public void setPvDegat(int pvDegat) {
		this.pv-=pvDegat;
		
	}
	public void agit() {
		Ennemis ennemiViser = ennemieVisable(5);
		
		if (ennemiViser != null) {
			if(!getJeu().projectileExisteSurEnnemi(ennemiViser.getId())) {				
				getJeu().getListeProjectile().add(new Projectile(this,ennemiViser,getJeu()));
//				if(ennemiViser instanceof ScorpionSpeciale ||
//				   ennemiViser instanceof SerpentSpeciale || 
//				   ennemiViser instanceof CactusSpeciale) {
//					
//					this.setPvDegat(20);
//					
//				}
				//else {
					this.setPvDegat(50);
					getJeu().getListeActeurs().remove(ennemiViser);
				//}
				
			}			
		}
		
	}
}
