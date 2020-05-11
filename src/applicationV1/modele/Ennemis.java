package applicationV1.modele;

public class Ennemis extends Acteur {

	private int pointsDeVie;
	private int vitesse;
	private int xSuivant;
	private int ySuivant;
	
	public Ennemis(int x, int y, Terrain terrain, int pv, int v) {
		super(x, y, terrain);
		this.pointsDeVie = pv;
		this.vitesse = v;
	}

	public Ennemis(Terrain terrain, int pv, int v) {
		super(terrain);
		//random position dans tab[][][][]
		this.pointsDeVie = pv;
		this.vitesse = v;
	}
	
	public int getPointsDeVie() {
		return pointsDeVie;
	}

	public int getVitesse() {
		return vitesse;
	}

	public int getxSuivant() {
		return xSuivant;
	}

	public int getySuivant() {
		return ySuivant;
	}

	public void setPointsDeVie(int pv) {
		this.pointsDeVie = pv;
	}

	public void setVitesse(int v) {
		this.vitesse = v;
	}

	public void seDeplacer() {
		//coder case suivante tab[][][][]
	}
}
