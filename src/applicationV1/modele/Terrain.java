package applicationV1.modele;

import java.util.ArrayList;

public class Terrain {
	private int width;
	private int height;
	private ArrayList<Acteur> acteurs;
	private int[][] tab;

	public Terrain(int width, int height) {
		this.width = width;
		this.height = height;
		this.acteurs = new ArrayList<Acteur>();
		this.tab = new int[15][15];
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ArrayList<Acteur> getActeurs() {
		return acteurs;
	}
	
	public Acteur getActeur(String id) {
		
	for(Acteur acteur : this.acteurs){
		if(acteur.getId().equals(id))return acteur;
	}
	return null;
	}
	
	public void ajouter(Acteur acteur){
		acteurs.add(acteur);
	}
}
