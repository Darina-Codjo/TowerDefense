package TowerDefense.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import TowerDefense.modele.Cactus;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tourelle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;

public class Controleur implements Initializable{

	private Terrain monTerrain;
	private Timeline gameLoop;
	private int temps;


	@FXML
	private TilePane map;

	//	@FXML
	//		private Button ajouterEnnemis;

	@FXML
	private Button startButton;

	@FXML
	private Pane plateau;

	@FXML
	private Label nbrEnnemis;

	@FXML
	private RadioButton buttonTourelle;

	@FXML
	private RadioButton buttonRien;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.monTerrain = new Terrain();
		afficherMap();
		this.monTerrain.tourDeJeu();
		initAnimation();

	}

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
		Cactus c = new Cactus(monTerrain);
		this.monTerrain.ajouterActeur(c);
		creerSprite(c);
		//System.out.println("AJOUTER");
		//}
	}

	@FXML
	void ajouterTourelle(ActionEvent event) {
		Tourelle t = new Tourelle(monTerrain);
		this.monTerrain.ajouterActeur(t);
		creerSpriteTourelle(t);
	}


	@FXML
	void start(ActionEvent event) {
		//	this.monTerrain.tourDeJeu();
		//		//System.out.println("AVANT");
		//		this.refreshPlateau();
		//		//System.out.println("APRES");
		gameLoop.play();
	}

	public void refreshPlateau() {
		//System.out.println(this.monTerrain.getActeurs().size());
		for(int i = 0; i < this.monTerrain.getListeActeurs().size(); i++) {
			Circle c = (Circle) this.plateau.lookup("#" + this.monTerrain.getListeActeurs().get(i).getId());
			c.setTranslateX(this.monTerrain.getListeActeurs().get(i).getX());
			c.setTranslateY(this.monTerrain.getListeActeurs().get(i).getY());
		}
	}

	private void creerSpriteTourelle(Tourelle tourelle) {
		Circle circle = new Circle(7);
		circle.setFill(Color.RED);
		circle.setId(tourelle.getId());
		circle.setTranslateX(tourelle.getX());
		circle.setTranslateY(tourelle.getY());
		plateau.getChildren().add(circle);
	}

	private void creerSprite(Ennemis ennemis) {
		Circle circle = new Circle(5);
		circle.setFill(Color.GREEN);
		circle.setId(ennemis.getId());
		circle.setTranslateX(ennemis.getX());
		circle.setTranslateY(ennemis.getY());
		plateau.getChildren().add(circle);
	}


	private void initAnimation() {
		gameLoop = new Timeline();
		temps=0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.017), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					if(temps==100){
						//System.out.println("fini");
						gameLoop.stop();
					}
					else if (temps%5==0){
						//System.out.println("un tour");
						this.monTerrain.tourDeJeu();
						this.refreshPlateau();
					}
					temps++;
				})
		);
		gameLoop.getKeyFrames().add(kf);
	}

}
