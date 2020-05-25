package TowerDefense.modele;

import TowerDefense.modele.Terrain;

public class TourelleBasique extends Tourelle {
	
//private char direction;
		

public TourelleBasique(int x, int y, Terrain terrain /*char direction*/) {
	super(x, y, terrain);
	//this.direction='N';
	
}

public TourelleBasique(Terrain terrain,int pv) {
	super(terrain,pv);
	//this.direction='N';
	
}

//public char getDirection() {
//	return direction;
//}
//public void setDirection(char direction) {
//	this.direction = direction;
//}

}
