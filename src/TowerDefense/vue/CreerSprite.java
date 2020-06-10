package TowerDefense.vue;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.tourelle.TourelleDestructible;
import TowerDefense.modele.tourelle.TourelleFeu;
import TowerDefense.modele.tourelle.TourelleGlace;
import TowerDefense.modele.tourelle.TourelleRoche;
import TowerDefense.modele.ennemis.Cactus;
import TowerDefense.modele.ennemis.Scorpion;
import TowerDefense.modele.ennemis.ScorpionSpeciale;
import TowerDefense.modele.ennemis.Serpent;
import TowerDefense.modele.ennemis.SerpentSpeciale;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CreerSprite {
	
	private Pane plateau;
	private Jeu jeu;
	
	public CreerSprite(Pane plateau,Jeu jeu) {
		this.plateau = plateau;
		this.jeu=jeu;
	}
	
	
	public void tourelleSprite(Acteur acteur, double x, double y) {

		ImageView texture;
		if (acteur instanceof TourelleGlace ) {
			texture = new ImageView("textures/tourelleglace.png");
			texture.setFitWidth(64);
			texture.setPreserveRatio(true);
		}
		else if (acteur instanceof TourelleFeu) {
			texture = new ImageView("textures/tourellefeu.png");
			texture.setFitWidth(64);
			texture.setPreserveRatio(true);
		}
		else if (acteur instanceof TourelleRoche){
			texture = new ImageView("textures/tourelleroche.png");
			texture.setFitWidth(64);
			texture.setPreserveRatio(true);
		}
		
		else if (acteur instanceof TourelleDestructible) {
			texture = new ImageView("textures/tour.png");
			texture.setFitWidth(64);
			texture.setPreserveRatio(true);
		}
		else {
			texture = new ImageView("textures/toursnipe.png");
			texture.setFitWidth(64);
			texture.setPreserveRatio(true);
		}
		
		texture.setId(acteur.getId());
		texture.setTranslateX(x);
		texture.setTranslateY(y);
		plateau.getChildren().add(texture);
	}
	
	
	
	public void retirerSpriteTourelle(Acteur tours) {
		
		for (int i=this.plateau.getChildren().size()-1; i>=0;i--){
			Node c=this.plateau.getChildren().get(i);
			Acteur a = this.jeu.getActeur(c.getId());
			if(a == tours) {
				this.plateau.getChildren().remove(c);
			}
		}
	}
}
