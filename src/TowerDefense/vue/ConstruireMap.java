package TowerDefense.vue;

import TowerDefense.modele.Jeu;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class ConstruireMap {
	
	private TilePane map;
	private Jeu game;
	private Pane plateau;
	
	public ConstruireMap (TilePane map, Jeu game, Pane plateau) {
		this.map = map;
		this.game = game;
		this.plateau = plateau;
	}
	
	public void remplirTileMap() {//rempli la TileMap
		for (int i = 0; i < 900; i++) {
			ImageView texture = new ImageView("textures/" +game.getMonTerrain().codeTuile(i) + ".png");
			this.map.getChildren().add(texture);
		}
	}
	
}
