package TowerDefense.vue;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class VueTerrain {
		
	private Terrain monTerrain;
	private Timeline gameLoop;
	private int temps;
	private Jeu game;
	private Pane plateau;

	public VueTerrain(Jeu game, Pane plateau) {
		super();
		this.monTerrain = game.getMonTerrain();
		this.game = game;
		this.plateau = plateau;
	}

	
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

}
