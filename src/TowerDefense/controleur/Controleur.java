package TowerDefense.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Scorpion;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.Tourelle;
import TowerDefense.modele.TourelleFeu;
import TowerDefense.modele.TourelleGlace;
import TowerDefense.modele.TourelleRoche;
import TowerDefense.vue.ConstruireMap;
import TowerDefense.vue.CreerSprite;
import TowerDefense.vue.VueTerrain;
import TowerDefense.modele.Cactus;
import TowerDefense.modele.CactusSpeciale;
import TowerDefense.modele.ScorpionSpeciale;
import TowerDefense.modele.Serpent;
import TowerDefense.modele.SerpentSpeciale;
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
    private Button ajoutCactus;
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
		
		Acteur cactus = new Cactus(monTerrain);
		Acteur serpent= new Serpent(monTerrain);
		Acteur scorpion= new Scorpion(monTerrain);
		Acteur scorpionSpeciale= new ScorpionSpeciale(monTerrain);
		Acteur serpentSpeciale= new SerpentSpeciale(monTerrain);
		Acteur cactusSpeciale=new CactusSpeciale(monTerrain);
		
		this.game.ajouterActeur(cactus);
		this.game.ajouterActeur(serpent);
		this.game.ajouterActeur(scorpion);
		this.game.ajouterActeur(scorpionSpeciale);
		this.game.ajouterActeur(serpentSpeciale);
		this.game.ajouterActeur(cactusSpeciale);
		
		this.sprite.acteurSprite(scorpionSpeciale);		
		this.sprite.acteurSprite(cactus);	
		this.sprite.acteurSprite(scorpion);	
		this.sprite.acteurSprite(serpent);	
		this.sprite.acteurSprite(serpentSpeciale);		
		this.sprite.acteurSprite(cactusSpeciale);    
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
