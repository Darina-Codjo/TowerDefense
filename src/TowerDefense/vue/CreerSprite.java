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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CreerSprite {
	
	private Pane plateau;
	
	public CreerSprite(Pane plateau) {
		this.plateau = plateau;
	}
	
	
	public void tourelleSprite(Acteur acteur, double x, double y) {

		Circle circle = new Circle(5);
		
		if (acteur instanceof TourelleGlace ) {
			circle.setFill(Color.BLUE);
		}
		else if (acteur instanceof TourelleFeu) {
			circle.setFill(Color.RED);
		}
		else if (acteur instanceof TourelleRoche){
			circle.setFill(Color.BLACK);			
		}
		else if (acteur instanceof TourelleDestructible) {
			circle.setFill(Color.LIGHTGREEN);
		}
		else {
			circle.setFill(Color.PINK);
		}
		
		circle.setTranslateX(x);
		circle.setTranslateY(y);
		plateau.getChildren().add(circle);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
