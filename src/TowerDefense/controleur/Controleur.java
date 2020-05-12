package TowerDefense.controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import TowerDefense.modele.Terrain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class Controleur implements Initializable{

    private Terrain monTerrain;

        @FXML
        private TilePane TilePane;


// cette méthode ne m'a pas servie
//        private int afficherTerrain() {
//
//            int codeTuile = 0;
//            for(int i = 0; i < 15*15; i++) {
//                codeTuile = monTerrain.getNumeroTuile(i);
//            }
//            return codeTuile;
//        }

        private int codeTuile(int indice) {

            return monTerrain.getNumeroTuile(indice);

        }

        public void afficherMap() {

            for (int i = 0; i < 225; i++) {
                ImageView texture = new ImageView("textures/" + codeTuile(i) + ".png");
                TilePane.getChildren().add(texture);
            }
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            this.monTerrain = new Terrain();
            afficherMap();
        }


}
