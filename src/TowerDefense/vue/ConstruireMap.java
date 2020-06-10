package TowerDefense.vue;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class ConstruireMap {
	
	private TilePane map;
	private Jeu game;
	@SuppressWarnings("unused")
	private Pane plateau;
	private Terrain terrain;
	
	public ConstruireMap (TilePane map, Jeu game, Pane plateau, Terrain terrain) {
		this.map = map;
		this.game = game;
		this.plateau = plateau;
		this.terrain = terrain;
	}
	
	//rempli la TileMap par des blocs de texture
	public void remplirTileMap() {
		for (int i = 0; i < 900; i++) {
			ImageView texture = new ImageView("textures/" +game.getMonTerrain().codeTuile(i) + ".png");
			this.map.getChildren().add(texture);
		}
	}
	
	
	
	
}
