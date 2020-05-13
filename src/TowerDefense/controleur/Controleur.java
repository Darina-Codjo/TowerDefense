package TowerDefense.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Cactus;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Terrain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Controleur implements Initializable{

	private Terrain monTerrain;

	  @FXML
	    private TilePane map;
	
	@FXML
    private Pane plateau;
	
	@FXML
    private Label nbrEnnemis;

	

	private int codeTuile(int indice) {
		return monTerrain.getNumeroTuile(indice);
	}

	public void afficherMap() {
		for (int i = 0; i < 225; i++) {
			ImageView texture = new ImageView("textures/" + codeTuile(i) + ".png");
			map.getChildren().add(texture);
			
		}
	}
	
	
	@FXML
    void ajouterEnnemis(ActionEvent event) {
		//for(int i = 0; i < 10; i++) {
			Cactus c = new Cactus(this.monTerrain);
			this.monTerrain.ajouterEnnemis(c);
			creerSprite(c);
			System.out.println("AJOUTER");
		//}
    }
	
	@FXML
    void start(ActionEvent event) {
		this.monTerrain.tourDeJeu();
		//System.out.println("AVANT");
		this.refreshPlateau();
		//System.out.println("APRES");
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.monTerrain = new Terrain();
		afficherMap();
		this.monTerrain.tourDeJeu();
		this.plateau.setMaxWidth(240); 
		this.plateau.setMaxHeight(240);
		this.monTerrain.init();
	}

	private void creerSprite(Ennemis ennemis) {
		
		Circle circle = new Circle(5);
		circle.setFill(Color.GREEN);
		
		circle.setId(ennemis.getId());
		circle.setTranslateX(ennemis.getX());
		circle.setTranslateY(ennemis.getY());
		plateau.getChildren().add(circle);
	}
	
	public void refreshPlateau() {
		 for(Acteur acteur: this.monTerrain.getActeurs()){
			 Circle c = (Circle) this.plateau.lookup("#" + acteur.getId());
			 c.setTranslateX(acteur.getX());
			 c.setTranslateY(acteur.getY());
	}
		
//		
//		for(int i = 0; i < this.monTerrain.getActeurs().size(); i++) {
//			 Circle c = (Circle) this.plateau.lookup("#" + this.monTerrain.getActeurs().get(i).getId());
//				 c.setTranslateX(this.monTerrain.getActeurs().get(i).getX());
//				 c.setTranslateY(this.monTerrain.getActeurs().get(i).getY());
//		 }
	 }


}
