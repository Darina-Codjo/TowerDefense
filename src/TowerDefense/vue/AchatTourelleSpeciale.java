package TowerDefense.vue;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;


public class AchatTourelleSpeciale implements ChangeListener<Number> {
	
	private Label message;
	
	public AchatTourelleSpeciale(Label message2) {
		super();
		this.message=message2;
	}
	

	//Regarde si la somme d'argent posséder par le jouer est supérieur au seuil donné
	//Si c'est la cas alors un message s'affiche sur l'écran indiquant au joueur qu'il peut acheter une tourelle spéciale
	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		
		if(newValue.intValue()>=50) {
			message.setText("Vous avez assez d'argent pour acheter une tourelle \n spéciale . \n Choisissez!");
		}
		
	}




	
	
	
	

	


	

}
