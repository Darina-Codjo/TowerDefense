package exceptions;

import TowerDefense.modele.Jeu;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TourelleExiste {
	private Jeu jeu ;

	public TourelleExiste(Jeu jeu) {
		this.jeu = jeu;
	}
	public TourelleExiste() {

	}

	public static void tourellsPlus0()throws InexistantException {
		try {
			if( Jeu.listeTourelle().size()==1)
				throw new InexistantException();


		}catch ( InexistantException i) {
			Alert alert= new Alert(AlertType.INFORMATION);
			alert.setTitle("Tourelle");
			alert.setHeaderText(null);
			alert.setContentText("veuillez mettre au moins une Tourelle!");

			alert.showAndWait();

			throw i;

		}
	}
}
