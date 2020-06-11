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

	// Gameloop: le tour de jeu des projectile est fait systématiquement
	// tandis que celui des acteur se fait tous les modulo 30
	// permet d'avoir des projectiles plus rapides que les ennemis
	public void initAnimation() {
		this.gameLoop = new Timeline();
		temps = 0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(Duration.seconds(0.017), 
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
