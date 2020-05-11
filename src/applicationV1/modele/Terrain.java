package applicationV1.modele;

public class Terrain {
	private int width = 15;
	private int height = 15;

	private int[] map= {256, 257, 258, 259, 5, 5, 5, 5, 5, 5, 5, 5, 5, 179, 178,
						260, 261, 262, 263, 1, 1, 97, 1, 87, 94, 94, 94, 88, 177, 
						174, 3, 264, 265, 1, 1, 1, 1, 1, 11, 92, 93, 13, 86, 173, 
						180, 3, 1, 1, 1, 1, 1, 1, 1, 11, 86, 1, 11, 12, 176, 172, 
						3, 97, 1, 1, 87, 94, 94, 94, 91, 86, 1, 14, 93, 175, 171, 
						3, 1, 1, 1, 11, 92, 93, 93, 93, 89, 181, 182, 1, 1, 2, 3, 
						1, 1, 1, 11, 86, 1, 98, 1, 1, 1, 1, 1, 1, 2, 3, 1, 1, 1, 
						11, 12, 94, 94, 94, 94, 94, 88, 1, 1, 2, 90, 94, 94, 88, 
						14, 93, 93, 93, 93, 93, 13, 86, 1, 1, 2, 95, 93, 13, 86, 
						1, 1, 1, 1, 1, 1, 11, 86, 1, 1, 10, 3, 184, 11, 86, 1, 1, 
						1, 1, 1, 1, 11, 86, 1, 1, 2, 3, 1, 11, 86, 96, 1, 1, 1, 1,
						1, 11, 86, 1, 1, 2, 3, 1, 11, 12, 94, 94, 94, 94, 94, 94, 
						91, 86, 1, 1, 2, 3, 1, 14, 93, 93, 93, 93, 93, 93, 93, 93, 
						89, 1, 97, 2, 9, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8};
	
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
