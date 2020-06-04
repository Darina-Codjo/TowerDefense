package TowerDefense.controleur;

import java.awt.TextArea;
import java.net.URL;
import java.util.ResourceBundle;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.GrandeTour;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.ennemis.Scorpion;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.tourelle.Tourelle;
import TowerDefense.modele.tourelle.TourelleDestructible;
import TowerDefense.modele.tourelle.TourelleFeu;
import TowerDefense.modele.tourelle.TourelleGlace;
import TowerDefense.modele.tourelle.TourelleRoche;
import TowerDefense.modele.tourelle.TourelleTirMultiple;
import TowerDefense.modele.Tours;
import TowerDefense.vue.AchatTourelleSpeciale;
import TowerDefense.vue.ConstruireMap;
import TowerDefense.vue.CreerSprite;
import TowerDefense.vue.ObservateurListeActeur;
import TowerDefense.vue.ObservateurListeProjectile;
import TowerDefense.vue.VueTerrain;
import TowerDefense.modele.ennemis.Cactus;
import TowerDefense.modele.ennemis.CactusSpeciale;
import TowerDefense.modele.ennemis.ScorpionSpeciale;
import TowerDefense.modele.ennemis.Serpent;
import TowerDefense.modele.ennemis.SerpentSpeciale;
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
	private Label nbArgent;
    @FXML
    private Label message;
    @FXML
    private ToggleGroup Tourelle;
    @FXML
    private RadioButton ajoutTourelleGlace; 
    @FXML
    private RadioButton ajoutTourelleFeu; 
    @FXML
    private RadioButton ajoutTourelleDestructible;
    @FXML
    private RadioButton ajoutTourelleTirMultiple;
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
		this.vue = new VueTerrain(game, plateau);
		this.sprite = new CreerSprite(plateau);
		this.vue.initAnimation();
		this.game.getListeActeurs().addListener(new ObservateurListeActeur(this.plateau)) ;
		this.game.getListeProjectile().addListener(new ObservateurListeProjectile(this.plateau));
		this.game.NbArgentProperty().addListener(new AchatTourelleSpeciale(this.message));
		this.nbArgent.textProperty().bind(this.game.NbArgentProperty().asString()) ;		
		this.ajoutTourelleTirMultiple.setVisible(false);
		this.ajoutTourelleDestructible.setVisible(false);
	}

	//
	@FXML
    void ajouterActeur(ActionEvent event) {
		
		Acteur cactus = new Cactus(monTerrain);
		Acteur grandeTour = new GrandeTour(monTerrain, game);
		Acteur serpent= new Serpent(monTerrain);
		Acteur scorpion= new Scorpion(monTerrain);
		Acteur scorpionSpeciale= new ScorpionSpeciale(monTerrain);
		Acteur serpentSpeciale= new SerpentSpeciale(monTerrain);
		Acteur cactusSpeciale=new CactusSpeciale(monTerrain);
		
		this.game.ajouterActeur(cactus);
		this.game.ajouterActeur(grandeTour);
		this.game.ajouterActeur(serpent);
		this.game.ajouterActeur(scorpion);
		this.game.ajouterActeur(scorpionSpeciale);
		this.game.ajouterActeur(serpentSpeciale);
		this.game.ajouterActeur(cactusSpeciale);
		   
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
					acteur = new TourelleGlace(x,y, monTerrain, game);					
				}
				else if(selectedToggleButton.equals(ajoutTourelleFeu)) {
					acteur = new TourelleFeu(x,y, monTerrain, game);
				}
				else if (selectedToggleButton.equals(ajoutTourelleRoche)){
					acteur = new TourelleRoche(x,y,monTerrain, game);
				}
				else if (selectedToggleButton.equals(ajoutTourelleDestructible)) {
					acteur = new TourelleDestructible(x,y,monTerrain, game,100);
					this.game.acheterTourelleSpeciale();
					this.ajoutTourelleTirMultiple.setVisible(false);
					this.ajoutTourelleDestructible.setVisible(false);
				}
				else {
					acteur = new TourelleTirMultiple(x,y,monTerrain, game);
					this.game.acheterTourelleSpeciale();
					this.ajoutTourelleTirMultiple.setVisible(false);
					this.ajoutTourelleDestructible.setVisible(false);
					
				}
				
				this.game.ajouterActeur(acteur);
				this.sprite.tourelleSprite(acteur, x, y);
				
			}
		});		
	}
	
	
	 @FXML
	 void AcheterTourelleSpeciale(ActionEvent event) {
		 
		 if(this.game.achatTourelleSpécialePossible()) {
				
			 this.ajoutTourelleTirMultiple.setVisible(true);
			 this.ajoutTourelleDestructible.setVisible(true);
		 }
		 

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
