package TowerDefense.vue;


//import TowerDefense.modele.Projectile;

import TowerDefense.modele.projectile.Projectile;
import TowerDefense.modele.projectile.ProjectileFeu;
import TowerDefense.modele.projectile.ProjectileGlace;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ObservateurListeProjectile implements ListChangeListener<Projectile> {
	
	private Pane plateau;
	
	public ObservateurListeProjectile(Pane plateau) {
		super();
		this.plateau = plateau;
	}
	
	public void spriteProjectile(Projectile projectile) {	
		Circle p;
		if (projectile instanceof ProjectileFeu) {
			p = new Circle(2, Color.RED);
		}
		else if (projectile instanceof ProjectileGlace) {
			p = new Circle(2, Color.LIGHTBLUE);		
		}
		else {
			p = new Circle(2, Color.GRAY);
		}
		p.setId(projectile.getId());
		p.translateXProperty().bind(projectile.xProperty().multiply(16).add(8)) ;
		p.translateYProperty().bind(projectile.yProperty().multiply(16).add(8)) ;
		plateau.getChildren().add(p);
	}
	
	public void supprimerProjectile(Projectile projectile) {
		this.plateau.getChildren().remove(this.plateau.lookup("#" + projectile.getId()));
	}

	@Override
	public void onChanged(Change<? extends Projectile> c) {
		while(c.next()){
			// on cree leur sprite .
			for (Projectile nouveau: c.getAddedSubList()){
				spriteProjectile(nouveau);
			}
			// on enleve leur sprite .
			for (Projectile project: c.getRemoved()){
				supprimerProjectile(project);
			}
		}
	}
}
