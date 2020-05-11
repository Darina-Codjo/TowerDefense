package applicationV1.modele;

public class Terrain {
	private int width = 15;
	private int height = 15;

	private int[] map= {42, 43, 44, 45, 5, 5, 5, 5, 5, 5, 5, 5, 5,
	                     36, 35, 46, 47, 48, 49, 26, 1, 1, 1, 16, 23, 23,
	                     23, 17, 34, 31, 3, 50, 51, 1, 1, 1, 1, 1, 11, 21,
	                     22, 13, 15, 30, 37, 3, 1, 1, 1, 1, 1, 1, 1, 11, 15, 1,
	                     11, 12, 33, 29, 3, 26, 1, 1, 16, 23, 23, 23, 20, 15, 1, 
	                     14, 22, 32, 28, 3, 1, 1, 1, 11, 21, 22, 22, 22, 18, 38, 
	                     39, 1, 1, 2, 3, 1, 1, 1, 11, 15, 1, 27, 1, 1, 1, 1, 1, 1,
	                     2, 3, 1, 1, 1, 11, 12, 23, 23, 23, 23, 23, 17, 1, 1, 2, 19, 
	                     23, 23, 17, 14, 22, 22, 22, 22, 22, 13, 15, 1, 1, 2, 24, 22,
	                     13, 15, 1, 1, 1, 1, 1, 1, 11, 15, 1, 1, 10, 3, 41, 11, 15, 1,
	                     1, 1, 1, 1, 1, 11, 15, 1, 1, 2, 3, 1, 11, 15, 25, 1, 1, 1, 1, 
	                     1, 11, 15, 1, 1, 2, 3, 1, 11, 12, 23, 23, 23, 23, 23, 23, 20, 
	                     15, 1, 1, 2, 3, 1, 14, 22, 22, 22, 22, 22, 22, 22, 22, 18, 1, 
	                     25, 2, 9, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8};
	
	private int[][] grille;
	

//	public Terrain(int width, int height) {
//		this.width = width;
//		this.height = height;
//	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public int getNumeroTuile(int indice) {
		return map[indice]; //TODO coordonnées en X Y %15 ou tab[][] pour faire la grille
	}
}
