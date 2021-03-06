package TowerDefense.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import TowerDefense.modele.tourelle.TourelleDestructible;
import TowerDefense.modele.tourelle.TourelleFeu;
import TowerDefense.modele.tourelle.TourelleGlace;
import TowerDefense.modele.tourelle.TourelleRoche;
import TowerDefense.modele.tourelle.TourelleTirMultiple;
import TowerDefense.modele.GrandeTour;
import TowerDefense.vue.AchatTourelleSpeciale;
import TowerDefense.vue.ConstruireMap;
import TowerDefense.vue.CreerSprite;
import TowerDefense.vue.ObservateurListeActeur;
import TowerDefense.vue.ObservateurListeProjectile;
import exceptions.InexistantException;
import exceptions.TourelleExiste;
import TowerDefense.vue.Gameloop;
import javafx.event.ActionEvent;
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
	private Button restartButton;
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
	private Button boutonPause;



	private Gameloop vue;		
	private CreerSprite sprite;	
	private Jeu game;
	private GrandeTour tour;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.monTerrain = new Terrain();
		this.game = new Jeu(monTerrain);
		this.vue = new Gameloop(game, plateau);
		this.sprite = new CreerSprite(plateau,game);
		this.tour = new GrandeTour(monTerrain, game,250);
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
		this.game.ajouterActeur(tour);
	}



	@FXML
	void AcheterTourelleSpeciale(ActionEvent event) {
		if(this.game.achatTourelleSpécialePossible()) {
			this.ajoutTourelleTirMultiple.setVisible(true);
			this.ajoutTourelleDestructible.setVisible(true);
			this.game.acheterTourelleSpeciale();
		}
	}

	@FXML
	void ajouterTourelle(MouseEvent clic) {
		RadioButton selectedToggleButton = (RadioButton) Tourelle.getSelectedToggle();
		message.setText("");
		int x = (int) clic.getX()/16;
		int y = (int) clic.getY()/16;

		if (this.game.listeTourelle().size() >= 10) {
			message.setText("Vous ne pouvez pas ajouter de tourelle !");
		}
		else {

			if(this.game.tourelleProche(x,y) != null) {
				message.setText("Vous êtes dans la zone d'une tourelle !");
			}

			else {
				Acteur acteur = null;
				if(!this.monTerrain.dansChemin(this.monTerrain.getTuile(x, y))) {

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
					else if(selectedToggleButton.equals(ajoutTourelleTirMultiple)){
						acteur = new TourelleTirMultiple(x,y, monTerrain, game);
						this.game.acheterTourelleSpeciale();
						this.ajoutTourelleTirMultiple.setVisible(false);
						this.ajoutTourelleDestructible.setVisible(false);
					}
					else {
						message.setText("Aucune tourelle à enlever");
					}
				}
				if (acteur != null) {
					this.game.ajouterActeur(acteur);
					this.sprite.tourelleSprite(acteur, x*16-16, y*16-32);
				}
			}
		}
	}

	@FXML
	void start(ActionEvent event) {
		boolean siTourelleSurMap = true;
		try {
			this.game.tourellesPlus0();
		}catch(InexistantException ie) {
			siTourelleSurMap = false;
		}
		if (siTourelleSurMap) {
			vue.getGameLoop().play();
		}
	}

	@FXML
	void restart(ActionEvent event) {
		if( this.game.partieEnCours()){	

			for(int i = 0; i < this.game.getListeActeurs().size(); i++) {
				this.sprite.retirerSpriteTourelle(this.game.getListeActeurs().get(i));
			}
			this.game.getListeActeurs().clear();
			this.game.getListeProjectile().clear();
			this.game.setNbVagues(0);
			vue.getGameLoop().stop();
			this.tour = new GrandeTour(monTerrain, game,250);
			this.game.ajouterActeur(tour);
		}
	}

	@FXML
	void mettreEnPause(ActionEvent event) {
		vue.getGameLoop().pause();

	}
}
