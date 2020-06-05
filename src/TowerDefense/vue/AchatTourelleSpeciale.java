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
	

	//Regarde si la somme d'argent poss�der par le jouer est sup�rieur au seuil donn�
	//Si c'est la cas alors un message s'affiche sur l'�cran indiquant au joueur qu'il peut acheter une tourelle sp�ciale
	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		
		if(newValue.intValue()>=50) {
			message.setText("Vous avez assez d'argent pour acheter une tourelle \n sp�ciale . \n Choisissez!");
		}
		
	}




	
	
	
	

	


	

}
