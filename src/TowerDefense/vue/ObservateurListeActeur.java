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
		Circle circle = new Circle(3);
		
		/*ImageView texture = new ImageView("textures/tour.png");*/
		
			
		
		
		if(acteur instanceof Cactus)
			circle.setFill(Color.LIGHTGREEN);
		else if (acteur instanceof Scorpion) 
			circle.setFill(Color.BROWN);
		else if (acteur instanceof Serpent) 
			circle.setFill(Color.ORANGE);
		else if (acteur instanceof CactusSpeciale)
			circle.setFill(Color.PURPLE);
		else if (acteur instanceof ScorpionSpeciale)
			circle.setFill(Color.RED);
		else if (acteur instanceof SerpentSpeciale)
			circle.setFill(Color.GREEN);
		/*else if(acteur instanceof GrandeTour) {
			texture.setTranslateX(acteur.getX()+16);
			texture.setTranslateY(acteur.getY()+16);
			plateau.getChildren().add(texture);
		}*/
		else
			circle.setOpacity(0);
		
		
		
		
		circle.setId(acteur.getId());
		circle.translateXProperty().bind(acteur.xProperty()) ;
		circle.translateYProperty().bind(acteur.yProperty()) ;
		plateau.getChildren().add(circle);
		
		
	}
	
	
	
	private void enleverSprite (Acteur mort) {
		this.plateau.getChildren().remove(this.plateau.lookup("#" + mort.getId()));
	}
	
	
	@Override
	public void onChanged(Change<? extends Acteur> c) {
		
		while(c.next()){
		
			// on cree leur sprite d�s qu'un ennemis est ajouter � la liste .
			for (Acteur nouveau: c.getAddedSubList()){
				acteurSprite(nouveau);
			}
			// gestion des ennemis morts
			// on enleve leur sprite d�s qu'un ennemis est retirer de la liste .
			for (Acteur mort: c.getRemoved()){
				enleverSprite (mort);
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
