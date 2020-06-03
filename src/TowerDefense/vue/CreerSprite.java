package TowerDefense.vue;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Scorpion;
import TowerDefense.modele.TourelleFeu;
import TowerDefense.modele.TourelleGlace;
import TowerDefense.modele.Cactus;
import TowerDefense.modele.ScorpionSpeciale;
import TowerDefense.modele.Serpent;
import TowerDefense.modele.SerpentSpeciale;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CreerSprite {
	
	private Pane plateau;
	
	public CreerSprite(Pane plateau) {
		this.plateau = plateau;
	}
	
	// en fonction du type d'ennemi, créer pour l'instant des sprites sous forme de cercle de différentes couleurs par ennemi
	public void acteurSprite(Acteur acteur, double x, double y) {
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
		else {
			texture = new ImageView("textures/tourelleroche.png");
			texture.setFitWidth(16);
			texture.setPreserveRatio(true);
		}
	
		texture.setTranslateX(x);
		texture.setTranslateY(y);
		plateau.getChildren().add(texture);
	}
	
	
	//idem mais pour les tourelles
	public void tourelleSprite(Acteur acteur, double x, double y) {

		Circle circle = new Circle(5);
		
		if (acteur instanceof TourelleGlace ) {
			circle.setFill(Color.BLUE);
		}
		else if (acteur instanceof TourelleFeu) {
			circle.setFill(Color.RED);
		}
		else {
			circle.setFill(Color.BLACK);			
		}
		
		circle.setTranslateX(x);
		circle.setTranslateY(y);
		plateau.getChildren().add(circle);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
