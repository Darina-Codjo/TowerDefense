package TowerDefense.vue;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;

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
		for (int i = 0; i < 225; i++) {
			ImageView texture = new ImageView("textures/" +game.getMonTerrain().codeTuile(i) + ".png");
			this.map.getChildren().add(texture);
		}
	}
	

//	public void refreshPlateau() {
//		for(Acteur acteur :this.game.getListeActeurs()) {
//			Circle c = (Circle) this.plateau.lookup("#" + acteur.getId());
//			c.setTranslateX(acteur.getX());
//			c.setTranslateY(acteur.getY());
//		}
//	}
}
