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
	


	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		
		if(newValue.intValue()>=50) {
			message.setText("Vous avez assez d'argent pour acheter une tourelle \n spéciale . \n Choisissez!");
		}
		
	}




	
	
	
	

	


	

}
