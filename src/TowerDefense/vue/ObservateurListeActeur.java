package TowerDefense.vue;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Cactus;
import TowerDefense.modele.Scorpion;
import TowerDefense.modele.ScorpionSpeciale;
import TowerDefense.modele.Serpent;
import TowerDefense.modele.SerpentSpeciale;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ObservateurListeActeur implements ListChangeListener<Acteur> {

	private Pane plateau;
	
	public ObservateurListeActeur(Pane plateau) {
		super();
		this.plateau = plateau;
	}
	
	public void acteurSprite(Acteur acteur) {
		Circle circle = new Circle(3);
		
		if(acteur instanceof Cactus)
			circle.setFill(Color.LIGHTGREEN);
			//Color.web("color en hexa")
		else if (acteur instanceof Scorpion) 
			circle.setFill(Color.BROWN);
		else if (acteur instanceof Serpent) 
			circle.setFill(Color.ORANGE);
		else if (acteur instanceof ScorpionSpeciale)
			circle.setFill(Color.RED);
		else if (acteur instanceof SerpentSpeciale)
			circle.setFill(Color.GREEN);
		else
			circle.setFill(Color.PURPLE);
		
		circle.setId(acteur.getId());
		circle.translateXProperty().bind(acteur.xProperty()) ;
		circle.translateYProperty().bind(acteur.yProperty()) ;
		plateau.getChildren().add(circle);
	}
	
	
	
	private void enleverSprite (Acteur mort) {
		//System.out.println(”enlever sprite ”);
		this.plateau.getChildren().remove(this.plateau.lookup("#" + mort.getId()));
	}
	
	
	@Override
	public void onChanged(Change<? extends Acteur> c) {
		
		while(c.next()){
		
			// on cree leur sprite .
			for (Acteur nouveau: c.getAddedSubList()){
				acteurSprite(nouveau);
			}
			// gestion des morts
			// on enleve leur sprite .
			for (Acteur mort: c.getRemoved()){
				enleverSprite (mort);
			}
		}
		
	}
	
}
