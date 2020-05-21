package TowerDefense.vue;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.TourelleFeu;
import TowerDefense.modele.TourelleGlace;
import TowerDefense.modele.TourelleRoche;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CreerSprite {
	
	private Pane plateau;
	
	public CreerSprite(Pane plateau) {
		this.plateau = plateau;
	}
	
	public void acteurSprite(Acteur acteur) {
		Circle circle;
		if(acteur instanceof Ennemis) {
			circle = new Circle(3);
			circle.setFill(Color.GREEN);
			//Color.web("color en hexa")
		}
		else {
			circle = new Circle(5);
			circle.setFill(Color.RED);
			
		}
		circle.setId(acteur.getId());
		circle.setTranslateX(acteur.getX());
		circle.setTranslateY(acteur.getY());
		plateau.getChildren().add(circle);
	}
	
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
