package applicationV1.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import applicationV1.modele.Terrain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;

public class Controleur implements Initializable{
	
	private Terrain monTerrain;
	    @FXML
	    private TilePane TilePane;

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			this.monTerrain = new Terrain();
			afficherTerrain();
		}

		private int afficherTerrain() {
			int codeTuile = 0;
			for(int i = 0; i < 15*15; i++) {
				codeTuile = monTerrain.getNumeroTuile(i);
			}
			return codeTuile;
		}
		
		

}
