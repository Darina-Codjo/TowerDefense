package TowerDefense.modele;
import java.util.ArrayList;

public class Terrain {
	private int width = 480;
	private int height = 480;
	//private ArrayList<Integer> indicesTuilesSpawn;


	private int[] map = {5, 5, 5, 5, 5, 5, 5, 5, 5, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5, 5, 5, 5, 5, 5, 
			4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 5, 5, 5, 5, 5, 5, 5, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 
			3, 3, 3, 3, 3, 3, 3, 1, 5, 5, 5, 5, 5, 5, 4, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 51, 5, 5, 5, 5, 5, 4, 
		 	3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 51, 5, 5, 5, 5, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2,
			 2, 2, 2, 2, 2, 2, 2, 2, 2, 51, 6, 7, 8, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 5, 9, 4, 3,
			 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 5, 10, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 3,
			 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 3, 3, 
			3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 3, 3, 3, 3, 11, 12, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 3,
			 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 3, 3, 3, 3, 13, 14, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 3, 3,
			 3, 3, 15, 3, 3, 3, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 49, 3, 3, 3, 3, 3, 3, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 3, 3, 3, 3, 3, 3, 
			3, 3, 3, 46, 47, 48, 3, 3, 3, 3, 3, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 45, 44, 43, 3, 3, 3, 3, 3, 1, 1, 3, 
			3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 
			3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 3, 3, 3,
			 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 3, 3, 3, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
			 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 3, 3, 3, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 3, 3, 3, 2, 2,
			 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 41, 42, 3, 3, 3, 3, 1, 1, 3, 3, 3, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 40, 
			39, 38, 37, 36, 3, 3, 3, 1, 50, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 31, 32, 33, 35, 34, 3, 3, 3, 1, 50, 2, 2, 2, 2, 2,
			 2, 3, 3, 3, 3, 19, 20, 21, 3, 3, 3, 3, 3, 3, 3, 29, 30, 3, 26, 3, 3, 3, 3, 1, 50, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 18, 17, 16, 3, 3, 3, 3, 3, 3, 
			3, 28, 27, 3, 25, 3, 3, 3, 3, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 24, 23, 3, 3, 3, 1, 1, 3, 3, 3, 3, 3, 
			3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 22, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			 1, 1, 1, 1, 1, 1};
	
	

	
	public Terrain() {
		
	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	public int getNumeroTuile(int indice) {
		return this.map[indice];
		//TODO coordonnées en X Y %15 ou tab[][] pour faire la grille
	}

	public int[] getMap() {
		return map;
	}
	
	public int codeTuile(int indice) {
		return this.getNumeroTuile(indice);
	}
	
//	public ArrayList<Integer> getTuilesChemin() {
//		//Si on clique de ces tuiles impossibles de poser une tourelle
//		ArrayList<Integer> listeTuilesChemin= new ArrayList<Integer>();
//		for(int i= 0; i<map.length; i++){
//			if(map[i]>=11 && map[i]<=24) {
//				listeTuilesChemin.add(map[i]);
//			}
//		}	
//		return listeTuilesChemin;
//	}
	
	public int getTuileSansClic(double x, double y) {
		double valeurX = x;
		double valeurY = y;
		int indice = 0;
		while (valeurX >= 16) {
			valeurX-=16;
			indice ++;
		}
		while (valeurY >= 16) {
			valeurY-=16;
			indice += 30;
		}
		return indice;
	}
	
	public boolean dansTerrain(double d, double e) {
		return (0 <= d && d<this.width && 0<=e && e< this.height);
	}
	
	public boolean dansChemin(int indice) {
		if(this.codeTuile(indice)==2 || this.codeTuile(indice) == 50 || this.codeTuile(indice) == 51) {
			return true;
		}
		else {
			return false;
		}
	}

	
	
	/*public void tuileSpawn() {
		this.indicesTuilesSpawn = new ArrayList<Integer>();
		
		int i = 0;
		
		while(i < 900) {
			if (this.codeTuile(i)==50) {
				indicesTuilesSpawn.add(i);
			}
			i++;
		}
	}
	
	public ArrayList<Integer> getTuileSpawn(){
		tuileSpawn();
		return this.indicesTuilesSpawn;
	}
	
	public int getXTuile(int indice) {
		int valeurIndice = indice;
		int x = 0;
		
		x = 16 * (valeurIndice % 30);
		
		return x;
	}
	
	
	public int getYTuile(int indice) {
		int valeurIndice = indice;
		int y = 0;
		
		while(valeurIndice >= 30) {
			valeurIndice -= 30;
			y++;
		}
		
		y *= 16;
		return y;
	}*/
	
	
}


