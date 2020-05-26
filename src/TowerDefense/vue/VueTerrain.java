package TowerDefense.vue;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class VueTerrain {
		
	@SuppressWarnings("unused")
	private Terrain monTerrain;
	private Timeline gameLoop;
	private int temps;
	private Jeu game;
	private Pane plateau;

	public VueTerrain(Jeu game, ConstruireMap construction, Pane plateau) {
		super();
		this.monTerrain = game.getMonTerrain();
		this.game = game;
		this.plateau = plateau;
		}

	//gameloop: methode qui rafraichit le plateau et fait un tour de jeu à l'infini
	public void initAnimation() {
		this.gameLoop = new Timeline();
		temps = 0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on definit le FPS (nbre de frame par seconde)
				Duration.seconds(0.017), 
				// on definit ce qui se passe Ã  chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					if (temps%5==0){
						//System.out.println("un tour");
						this.refreshPlateau();
						this.game.tourDeJeu();
//						this.refreshPlateau();
					}
					temps++;
				})
		);
		gameLoop.getKeyFrames().add(kf);
	}


	public Timeline getGameLoop() {
		return gameLoop;
	}
	
	//parcour la liste d'acteur et donne aux sprites les coordonnées de sa nouvelle position
	public void refreshPlateau() {
		for(Acteur acteur :this.game.getListeActeurs()) {
			Circle c = (Circle) this.plateau.lookup("#" + acteur.getId());
			if(acteur instanceof Ennemis) {
				c.setTranslateX(acteur.getX());
				c.setTranslateY(acteur.getY());
			}
		}		 
	}
}
