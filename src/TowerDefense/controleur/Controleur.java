package TowerDefense.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tourelle;
import TowerDefense.vue.ConstruireMap;
import TowerDefense.vue.CreerSprite;
import TowerDefense.vue.VueTerrain;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class Controleur implements Initializable{

	private Terrain monTerrain;
	
	@FXML
	private TilePane map;

	@FXML
	private Button startButton;

	@FXML
	private Pane plateau;

	@FXML
	private Label nbrEnnemis;

	@FXML
	private RadioButton buttonTourelle;
	
	private VueTerrain vue;
	
	private static Timeline gameLoop;
	
	private CreerSprite sprite;
	
	private Jeu game;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.monTerrain = new Terrain();
		game = new Jeu(monTerrain);
		ConstruireMap construireMap = new ConstruireMap(map, game, plateau);
		construireMap.remplirTileMap();
		this.vue = new VueTerrain(game, construireMap, plateau);
		this.vue.initAnimation();
	}

	@FXML
    void ajouterActeur(ActionEvent event) {
		Acteur acteur = new Ennemis(monTerrain);
		sprite = new CreerSprite(plateau);
		this.game.ajouterActeur(acteur);
		this.sprite.acteurSprite(acteur);
    }
	@FXML
    void ajouterTourelle(ActionEvent event) {
		if(buttonTourelle.isSelected()) {
			this.plateau.setOnMouseClicked(clic -> {
				double x = clic.getX();
				double y = clic.getY();
				Acteur acteur2 = new Tourelle(monTerrain);
				this.game.ajouterActeur(acteur2);
				this.sprite.tourelleSprite(acteur2, x, y);
			});
			
		}
		
	}

	
	
	@FXML
	void start(ActionEvent event) {
		vue.getGameLoop().play();
	}
	
	
}
