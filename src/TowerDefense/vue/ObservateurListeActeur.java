package TowerDefense.vue;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.GrandeTour;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.ennemis.Cactus;
import TowerDefense.modele.ennemis.CactusSpeciale;
import TowerDefense.modele.ennemis.Scorpion;
import TowerDefense.modele.ennemis.ScorpionSpeciale;
import TowerDefense.modele.ennemis.Serpent;
import TowerDefense.modele.ennemis.SerpentSpeciale;
import TowerDefense.modele.tourelle.TourelleFeu;
import TowerDefense.modele.tourelle.TourelleGlace;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.image.ImageView;

public class ObservateurListeActeur implements ListChangeListener<Acteur> {

	private Pane plateau;
	
	public ObservateurListeActeur(Pane plateau) {
		super();
		this.plateau = plateau;
	}
	
	public void acteurSprite(Acteur acteur) {
		/*Circle circle = new Circle(3);*/
		
		ImageView texture;
			
		if(acteur instanceof Cactus)
			texture = new ImageView("textures/cactus.png");
		else if (acteur instanceof Scorpion) 
			texture = new ImageView("textures/scorpion.png");
		else if (acteur instanceof Serpent) 
			texture = new ImageView("textures/serpent.png");
		else if (acteur instanceof CactusSpeciale)
			texture = new ImageView("textures/cactusspecial.png");
		else if (acteur instanceof ScorpionSpeciale)
			texture = new ImageView("textures/scorpionspecial.png");
		else if (acteur instanceof SerpentSpeciale)
			texture = new ImageView("textures/serpentspecial.png");
		else if (acteur instanceof GrandeTour) {
			texture = new ImageView("textures/tour.png");
		}
		else {
			texture = new ImageView("textures/tour.png");
			texture.setOpacity(0);
		}
		
		texture.setId(acteur.getId());
		texture.setFitWidth(32);
		texture.setFitHeight(32);
		texture.translateXProperty().bind(acteur.xProperty().multiply(16).add(-24));
		texture.translateYProperty().bind(acteur.yProperty().multiply(16).add(-24));
		plateau.getChildren().add(texture);
		
		
		/*circle.setId(acteur.getId()); 
		circle.translateXProperty().bind(acteur.xProperty()) ;
		circle.translateYProperty().bind(acteur.yProperty()) ;
		plateau.getChildren().add(circle);*/

	}
	
	
	
	private void enleverSprite (Acteur mort) {
		this.plateau.getChildren().remove(this.plateau.lookup("#" + mort.getId()));
	}
	
	
	@Override
	public void onChanged(Change<? extends Acteur> c) {
		while(c.next()) {		
			// on cree leur sprite dès qu'un ennemis est ajouter à la liste .
			for (Acteur nouveau: c.getAddedSubList()){
				acteurSprite(nouveau);
			}
			// gestion des ennemis morts
			// on enleve leur sprite dès qu'un ennemis est retirer de la liste .
			for (Acteur mort: c.getRemoved()){
				enleverSprite (mort);
			}
		}
		
	}
}
