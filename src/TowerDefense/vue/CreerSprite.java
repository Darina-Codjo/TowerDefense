package TowerDefense.vue;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Scorpion;
import TowerDefense.modele.TourelleFeu;
import TowerDefense.modele.TourelleGlace;
import TowerDefense.modele.TourelleRoche;
import TowerDefense.modele.Cactus;
import TowerDefense.modele.ScorpionSpeciale;
import TowerDefense.modele.Serpent;
import TowerDefense.modele.SerpentSpeciale;
import TowerDefense.modele.TourelleDestructible;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CreerSprite {
	
	private Pane plateau;
	
	public CreerSprite(Pane plateau) {
		this.plateau = plateau;
	}
	
	
	public void tourelleSprite(Acteur acteur, double x, double y) {

		ImageView texture;
		
		if (acteur instanceof TourelleGlace ) {
			texture = new ImageView("textures/tourelleglace.png");
			texture.setFitWidth(16);
			texture.setPreserveRatio(true);
		}
		else if (acteur instanceof TourelleFeu) {
			texture = new ImageView("textures/tourellefeu.png");
			texture.setFitWidth(16);
			texture.setPreserveRatio(true);
		}
		else if (acteur instanceof TourelleRoche){
			texture = new ImageView("textures/tourelleroche.png");
			texture.setFitWidth(16);
			texture.setPreserveRatio(true);
		}
		
		else if (acteur instanceof TourelleDestructible) {
			texture = new ImageView("textures/tour.png");
			texture.setFitWidth(16);
			texture.setPreserveRatio(true);
		}
		else {
			texture = new ImageView("textures/toursnipe.png");
			texture.setFitWidth(16);
			texture.setPreserveRatio(true);
		}
		

		
		texture.setTranslateX(x);
		texture.setTranslateY(y);
		plateau.getChildren().add(texture);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
