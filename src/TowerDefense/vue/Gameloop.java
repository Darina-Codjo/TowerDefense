package TowerDefense.vue;

import TowerDefense.modele.Jeu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Gameloop {

	private Timeline gameLoop;
	private int temps;
	private Jeu game;

	public Gameloop(Jeu game, Pane plateau) {
		super();
		this.game = game;
	}

	public void initAnimation() {
		this.gameLoop = new Timeline();
		temps = 0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(Duration.seconds(0.005), 
				(ev ->{
			
					if(temps%10==0) {
						this.game.tourDeJeuProjectile();
						this.game.rechargement();
					}
					if (temps%45==0){
						this.game.tourDeJeuActeur();						

					}
					if(temps%500==0) {
						this.game.vagueEnnemis();
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
