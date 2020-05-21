package TowerDefense.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tourelle;
import TowerDefense.modele.TourelleFeu;
import TowerDefense.modele.TourelleGlace;
import TowerDefense.modele.TourelleRoche;
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
import javafx.scene.control.ToggleGroup;
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
    private ToggleGroup Tourelle;
    @FXML
    private RadioButton ajoutTourelleGlace; 
    @FXML
    private RadioButton ajoutTourelleFeu;  
    @FXML
    private RadioButton ajoutTourelleRoche;  
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
		this.sprite = new CreerSprite(plateau);
	}

	//
	@FXML
    void ajouterActeur(ActionEvent event) {
		Acteur acteur = new Ennemis(monTerrain);
		this.game.ajouterActeur(acteur);
		this.sprite.acteurSprite(acteur);
    }
	
	@FXML
    void ajouterTourelle(ActionEvent event) {
		RadioButton selectedToggleButton =(RadioButton) Tourelle.getSelectedToggle();
		
		this.plateau.setOnMouseClicked(clic -> {
			double x = clic.getX();
			double y = clic.getY();
			
			if(!this.monTerrain.dansChemin(this.monTerrain.getTuileSansClic(x, y))) {
				Acteur acteur;
				if(selectedToggleButton.equals(ajoutTourelleGlace)) {
					acteur = new TourelleGlace(monTerrain);
				}
				else if(selectedToggleButton.equals(ajoutTourelleFeu)) {
					acteur = new TourelleFeu(monTerrain);
				}
				else {
					acteur = new TourelleRoche(monTerrain);
				}
				
				this.game.ajouterActeur(acteur);
				this.sprite.tourelleSprite(acteur, x, y);
				
			}
		});		
	}
	

    @FXML
    int getTuile(MouseEvent clic) {
		
			double x = clic.getX();
			double y = clic.getY();
			int indice = 0;
			while (x >= 16) {
				x-=16;
				indice ++;
			}
			while (y >= 16) {
				y-=16;
				indice += 30;
			}
			return indice;
    }
	
	@FXML
	void start(ActionEvent event) {
		vue.getGameLoop().play();
	}
	
}
