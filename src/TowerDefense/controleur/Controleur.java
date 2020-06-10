package TowerDefense.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.GrandeTour;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.ennemis.Cactus;
import TowerDefense.modele.ennemis.CactusSpeciale;
import TowerDefense.modele.ennemis.Scorpion;
import TowerDefense.modele.tourelle.TourelleDestructible;
import TowerDefense.modele.tourelle.TourelleFeu;
import TowerDefense.modele.tourelle.TourelleGlace;
import TowerDefense.modele.tourelle.TourelleRoche;
import TowerDefense.modele.tourelle.TourelleTirMultiple;
import TowerDefense.vue.AchatTourelleSpeciale;
import TowerDefense.vue.ConstruireMap;
import TowerDefense.vue.CreerSprite;
import TowerDefense.vue.ObservateurListeActeur;
import TowerDefense.vue.ObservateurListeProjectile;
import TowerDefense.vue.VueTerrain;
import TowerDefense.modele.ennemis.ScorpionSpeciale;
import TowerDefense.modele.ennemis.Serpent;
import TowerDefense.modele.ennemis.SerpentSpeciale;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
    @FXML
    private RadioButton ajoutTourelleRoche; 
    @FXML
    private RadioButton retirerTourelle;
	private VueTerrain vue;	
	private static Timeline gameLoop;	
	private CreerSprite sprite;	
	private Jeu game;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.monTerrain = new Terrain();
		this.game = new Jeu(monTerrain);
		this.vue = new VueTerrain(game, plateau);
		this.sprite = new CreerSprite(plateau,game);
		ConstruireMap construireMap = new ConstruireMap(map, game, plateau, monTerrain);
		construireMap.remplirTileMap();

		this.vue.initAnimation();
		this.game.getListeActeurs().addListener(new ObservateurListeActeur(this.plateau)) ;
		this.game.getListeProjectile().addListener(new ObservateurListeProjectile(this.plateau));
		this.game.NbArgentProperty().addListener(new AchatTourelleSpeciale(this.message));
		this.nbArgent.textProperty().bind(this.game.NbArgentProperty().asString()) ;		
		this.ajoutTourelleTirMultiple.setVisible(false);
		this.ajoutTourelleDestructible.setVisible(false);
		this.monTerrain.placerNode();
	}

//	@FXML
//	void ajouterActeur(ActionEvent event) {
//		Acteur cactus = new Cactus(monTerrain);
//		Acteur grandeTour = new GrandeTour(monTerrain, game);
//		Acteur serpent = new Serpent(monTerrain);
//		Acteur scorpion = new Scorpion(monTerrain);
//		Acteur scorpionSpeciale = new ScorpionSpeciale(monTerrain);
//		Acteur serpentSpeciale = new SerpentSpeciale(monTerrain);
//		Acteur cactusSpeciale = new CactusSpeciale(monTerrain);
//		
//		this.game.ajouterActeur(cactus);
//		this.game.ajouterActeur(grandeTour);
//		this.game.ajouterActeur(serpent);
//		this.game.ajouterActeur(scorpion);
//		this.game.ajouterActeur(scorpionSpeciale);
//		this.game.ajouterActeur(serpentSpeciale);
//		this.game.ajouterActeur(cactusSpeciale);
//	}

	@FXML
	void AcheterTourelleSpeciale(ActionEvent event) {
		if(this.game.achatTourelleSpécialePossible()) {
			this.ajoutTourelleTirMultiple.setVisible(true);
			this.ajoutTourelleDestructible.setVisible(true);
		}
	}
	
	@FXML
    void ajouterTourelle(MouseEvent clic) {
		RadioButton selectedToggleButton = (RadioButton) Tourelle.getSelectedToggle();
		int x = (int) clic.getX()/16;
		int y = (int) clic.getY()/16;
		
		
		//x=this.monTerrain.placerTourelleMilieuTuileCoordonnee(x%16+16);
		//y=this.monTerrain.placerTourelleMilieuTuileCoordonnee(y/16+16);
		
//		if(this.game.tuileDejaPrise(this.monTerrain.getTuileSansClic(x,y))) {
//			message.setText("Une tourelle a déjà été posé ici !!");
//		}
//		else if(this.game.tourelleProche(x,y) != null) {
//		message.setText("Vous êtes dans la zone d'une tourelle !");
//		}
//		else {

			if(!this.monTerrain.dansChemin(this.monTerrain.getTuileSansClic(x, y))) {
				Acteur acteur;
				if(selectedToggleButton.equals(ajoutTourelleGlace)) {
					acteur = new TourelleGlace(x,y, monTerrain, game);					
				}
				else if(selectedToggleButton.equals(ajoutTourelleFeu)) {
					acteur = new TourelleFeu(x,y, monTerrain, game);
				}
				else if (selectedToggleButton.equals(ajoutTourelleRoche)){
					acteur = new TourelleRoche(x,y, monTerrain, game);
				}
				else if (selectedToggleButton.equals(ajoutTourelleDestructible)) {
					acteur = new TourelleDestructible(x,y, monTerrain, game,100);
					this.game.acheterTourelleSpeciale();
					this.ajoutTourelleTirMultiple.setVisible(false);
					this.ajoutTourelleDestructible.setVisible(false);
				}
				else {
					acteur = new TourelleTirMultiple(x,y, monTerrain, game);
					this.game.acheterTourelleSpeciale();
					this.ajoutTourelleTirMultiple.setVisible(false);
					this.ajoutTourelleDestructible.setVisible(false);
	
				}
				this.game.ajouterActeur(acteur);
				this.sprite.tourelleSprite(acteur, x*16-16, y*16-16);

			}
		//}
	}
	
	@FXML
    void retirerTourelle(MouseEvent event) {
		RadioButton selectedToggleButton =(RadioButton) Tourelle.getSelectedToggle();
		 
		 this.plateau.setOnMouseClicked(clic -> {
				int x = (int) clic.getX();
				int y = (int) clic.getY();
				
				x=this.monTerrain.placerTourelleMilieuTuileCoordonnee(x);
				y=this.monTerrain.placerTourelleMilieuTuileCoordonnee(y);
				
		 if(selectedToggleButton.equals(retirerTourelle)) {					
				Acteur tours=this.game.tourelleProche(x, y);
				if(this.game.tourelleProche(x,y) != null) {
					this.sprite.retirerSpriteTourelle(tours);
					this.game.getListeActeurs().remove(tours);
				}
				else {
					message.setText("Aucune tourelle à enlever");
				}
				
		}
	});	
    }

	@FXML
	void start(ActionEvent event) {
		if( this.game.partieEnCours()){	
			for(int i=0;i<this.game.getListeActeurs().size();i++) {
				this.sprite.retirerSpriteTourelle(this.game.getListeActeurs().get(i));
				
			}
			this.game.getListeActeurs().clear();
			this.game.getListeProjectile().clear();
			
			
		}
		vue.getGameLoop().play();
	}

}
