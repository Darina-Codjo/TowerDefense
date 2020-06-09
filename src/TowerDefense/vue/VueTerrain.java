package TowerDefense.vue;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
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

		KeyFrame kf = new KeyFrame(Duration.seconds(0.017), (ev -> {

			this.game.tourDeJeuProjectile();
			if (temps % 30 == 0) {
				this.game.tourDeJeuActeur();
			}
			temps++;
		}));

		gameLoop.getKeyFrames().add(kf);
	}

	public Timeline getGameLoop() {
		return gameLoop;
	}

}
