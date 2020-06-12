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
import TowerDefense.vue.AchatTourelleSpeciale;
import TowerDefense.vue.ConstruireMap;
import TowerDefense.vue.CreerSprite;
import TowerDefense.vue.ObservateurListeActeur;
import TowerDefense.vue.ObservateurListeProjectile;
import TowerDefense.vue.VueTerrain;
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
    @FXML
    private Button boutonPause;
	private VueTerrain vue;		
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

	@FXML
	void AcheterTourelleSpeciale(ActionEvent event) {
		if(this.game.achatTourelleSpécialePossible()) {
			this.ajoutTourelleTirMultiple.setVisible(true);
			this.ajoutTourelleDestructible.setVisible(true);
		}
	}
	
	
	@FXML
    void ajouterTourelle(MouseEvent event) {
		RadioButton selectedToggleButton = (RadioButton) Tourelle.getSelectedToggle();
		this.plateau.setOnMouseClicked(clic -> {
		int x = (int) clic.getX()/16;
		int y = (int) clic.getY()/16;
		
		if (this.game.listeTourelle().size()>=10) {
			message.setText("Vous ne pouvez pas ajouter de tourelle!");
		}
		else {
			if(this.game.tourelleProche(x,y) != null) {
				message.setText("Vous êtes dans la zone d'une tourelle !");
			}
			else {
				Acteur acteur=null;
				if(!this.monTerrain.dansChemin(this.monTerrain.getTuileSansClic(x, y))) {
					
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
				if (acteur!= null) {
					this.game.ajouterActeur(acteur);
					this.sprite.tourelleSprite(acteur, x*16-8, y*16-8);
				}
			}
		}
		});
	}

	@FXML
    void retirerTourelle(MouseEvent event) {
		RadioButton selectedToggleButton =(RadioButton) Tourelle.getSelectedToggle();
		 
		 this.plateau.setOnMouseClicked(clic -> {

				int x = (int) clic.getX()/16;
				int y = (int) clic.getY()/16;
				
		 if(selectedToggleButton.equals(retirerTourelle)) {					
				Acteur tours=this.game.tourelleProche(x, y);
				if(this.game.tourelleProche(x,y) != null) {
					this.sprite.retirerSpriteTourelle(tours);
					this.game.getListeActeurs().remove(tours);
				}				
		}
	});	
    }

	@FXML
    void mettreEnPause(ActionEvent event) {
		vue.getGameLoop().pause();
    }
	@FXML
	void start(ActionEvent event) {
//		if( this.game.partieEnCours()){	
//			for(int i=0;i<this.game.getListeActeurs().size();i++) {
//				this.sprite.retirerSpriteTourelle(this.game.getListeActeurs().get(i));
//				
//			}
//			this.game.getListeActeurs().clear();
//			this.game.getListeProjectile().clear();
//
//			this.game.setNbVagues(0);
//
//		}
		vue.getGameLoop().play();
		
	}

}
