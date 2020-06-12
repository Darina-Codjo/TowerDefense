package TowerDefense.modele;

import java.util.ArrayList;
import java.util.Random;

import TowerDefense.modele.dijkstra.Node;

public class Terrain {
	private int width = 480;
	private int height = 480;
	private double x;
	private double y;
	private ArrayList<Node> listeNode;


	private int[] mapDesert = {	5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5,  4 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1,
								5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1, 
								5 , 5 , 5 , 5 , 5 , 5 , 5 , 4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1, 
								5 , 5 , 5 , 5 , 5 , 5 , 4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 51, 
								5 , 5 , 5 , 5 , 5 , 4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 51, 
								5 , 5 , 5 , 5 , 4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 51, 
								6 , 7 , 8 , 4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1, 
								5 , 9 , 4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								5 , 10, 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1, 
								4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1, 
								1 , 3 , 3 , 3 , 3 , 11, 12, 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1, 
								1 , 3 , 3 , 3 , 3 , 13, 14, 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 3 , 15, 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 49, 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 46, 47, 48, 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 45, 44, 43, 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2,  3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1, 
								1 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 41, 42, 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 40, 39, 38, 37, 36, 3 , 3 , 3 , 1,
								50, 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 31, 32, 33, 35, 34, 3 , 3 , 3 , 1,
								50, 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 19, 20, 21, 3 , 3 , 3 , 3 , 3 , 3 , 3 , 29, 30, 3 , 26, 3 , 3 , 3 , 3 , 1,
								50, 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 18, 17, 16, 3 , 3 , 3 , 3 , 3 , 3 , 3 , 28, 27, 3 , 25, 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 24, 23, 3 , 3 , 3 , 1, 
								1 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 22, 3 , 3 , 3 , 1,
								1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1};




	public Terrain() {
		this.x = 0;
		this.y = 0;
		this.listeNode = new ArrayList<>();
	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	public int getNumeroTuile(int indice) {
		return this.mapDesert[indice];
	}

	public int[] getMap() {
		return mapDesert;
	}
	
	public int codeTuile(int indice) {
		return this.getNumeroTuile(indice);
	}

	public int getTuile(double x, double y) {
		return (int) (y*30+x);
	}
	
	
	//Ces 2 méthodes empêchent les ennemis de sortir du chemin et de se balader sur la carte
	public boolean dansTerrain(double d, double e) {
		return (0 <= d && d<this.width && 0<=e && e< this.height);
	}

	public boolean dansChemin(int indice) {
		if(this.codeTuile(indice) == 2 || this.codeTuile(indice) == 50 || this.codeTuile(indice) == 51) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean dansCheminV2(int indice) {
		if(this.codeTuile(indice)%2 == 0) {
			return true;
		}
		return false;
	}

	
	//Ces 2 méthode permettent de récupérer une des 3 tuiles du début et fin de chemin 
	//ce qui nous permet de placer les ennemis et la frande Tour au bonne endroit 
	public int getIndiceTuileDebutChemin() {

		int indice = 0;
		//compte nombre d'occurence de 50
		int compteurCase50 = 0;

		//recupere l'indice du 1ere, 2eme et 3eme occurence de 50
		int indiceTuile1 = 0;
		int indiceTuile2 = 0;
		int indiceTuile3 = 0;
		for(int i = 0; i < mapDesert.length; i++) {
			if(mapDesert[i] == 50) {
				compteurCase50++;
			}
			if(mapDesert[i] == 50 && compteurCase50 == 1) {
				indiceTuile1 = i;
			}
			if(mapDesert[i] == 50 && compteurCase50 == 2) {
				indiceTuile2 = i;
			}
			if(mapDesert[i] == 50 && compteurCase50 == 3) {
				indiceTuile3 = i;
			}
		}
				Random random = new Random();
				int alea = random.nextInt(3);
				if (alea == 0) {
					indice = indiceTuile1;
				}
				if (alea == 1) {
					indice = indiceTuile2;
				}
				if (alea == 2) {
					indice = indiceTuile3;
				}
		return indice; 
	}

	public int getIndiceTuileFinChemin() {

		int indice = 0;
		//compte nombre d'occurence de 51 
		int compteurCase51 = 0;

		//recupere l'indice du 1ere, 2eme et 3eme occurence de 50
		int indiceTuile1 = 0;
		int indiceTuile2 = 0;
		int indiceTuile3 = 0;

		for(int i = 0; i < mapDesert.length; i++) {
			if(mapDesert[i] == 51) {
				compteurCase51++;
			}
			if(mapDesert[i] == 51 && compteurCase51 == 1) {
				indiceTuile1 = i;
			}
			if(mapDesert[i] == 51 && compteurCase51 == 2) {
				indiceTuile2 = i;
			}
			if(mapDesert[i] == 51 && compteurCase51 == 3) {
				indiceTuile3 = i;
			}
		}
				Random random = new Random();
				int alea = random.nextInt(3);
		
				if (alea == 0) {
					indice = indiceTuile1;
				}
				if (alea == 1) {
					indice = indiceTuile2;
				}
				if (alea == 2) {
					indice = indiceTuile3;
				}
		return indice;
	}
	
	
	//Cette méthode est peut être à placeer dans la classe tourelle
	public int placerTourelleMilieuTuileCoordonnee(int coordonnee) {
		
		int newX;		
		if(coordonnee %16 > 8) {		
			newX = coordonnee-(coordonnee%16 - 8);
		}
		else if(coordonnee%16 < 8) {
			newX = coordonnee+(8 - coordonnee%16);
		}
		else {
			newX = coordonnee;
		}
		return newX;
	}

	public boolean dansTerrain(int x, int y) {
		return (0 <= x && x<this.width && 0<=y && y< this.height);
	}

	public double getX() {
		return this.x;
	}	
	public double getY() {
		return this.y;
	}

	//parcourir les tuile du chemin et creer et ajouter un node pour chaque tuile dans l'attribut listeNode
	public void placerNode() {
		//recuperation coordonnees de la tuile finChemin
		int xFin = (this.getIndiceTuileFinChemin()%30);
		int yFin = (this.getIndiceTuileFinChemin()/30);

		Node noeudFin = new Node(xFin, yFin, 0);
		this.listeNode.add(noeudFin);

		int coordonneesNodeX = 0;
		int coordonneesNodeY = 0;

		//pour chaque i dans la liste de node on recupere les coordonnes X et Y
		for(int indiceNode = 0; indiceNode < this.listeNode.size(); indiceNode++) {
			coordonneesNodeX = this.listeNode.get(indiceNode).getX();
			coordonneesNodeY = this.listeNode.get(indiceNode).getY();
			
			//gauche
			if(this.dansChemin(coordonneesNodeY*30+coordonneesNodeX-1)) {
				if(this.getIfContainsNodeXY(coordonneesNodeX-1, coordonneesNodeY) == false) {
					Node noeud = new Node(coordonneesNodeX-1, coordonneesNodeY, this.listeNode.get(indiceNode).getDistance()+1);
					this.listeNode.add(noeud);
				}
			}
			//droit
			if(this.dansChemin(coordonneesNodeY*30+coordonneesNodeX+1)) {
				if(this.getIfContainsNodeXY(coordonneesNodeX+1, coordonneesNodeY) == false) {
					Node noeud = new Node(coordonneesNodeX+1, coordonneesNodeY, this.listeNode.get(indiceNode).getDistance()+1);
					this.listeNode.add(noeud);
				}
			}
			//bas
			if(this.dansChemin(coordonneesNodeY*30+coordonneesNodeX-30)) {
				if(this.getIfContainsNodeXY(coordonneesNodeX, coordonneesNodeY-1) == false) {
					Node noeud = new Node(coordonneesNodeX, coordonneesNodeY-1, this.listeNode.get(indiceNode).getDistance()+1);
					this.listeNode.add(noeud);
				}
			}
			//haut
			if(this.dansChemin(coordonneesNodeY*30+coordonneesNodeX+30)) {
				if(this.getIfContainsNodeXY(coordonneesNodeX, coordonneesNodeY+1) == false) {
					Node noeud = new Node(coordonneesNodeX, coordonneesNodeY+1, this.listeNode.get(indiceNode).getDistance()+1);
					this.listeNode.add(noeud);
				}
			}
		}
	}

	public ArrayList<Node> getListeNode() {
		return listeNode;
	}

	public boolean getIfContainsNodeXY(int x, int y) {
		for(int i = 0; i < this.listeNode.size(); i++) {
			if(this.listeNode.get(i).getX() == x && this.listeNode.get(i).getY() == y) {
				return true;
			}
		}
		return false;
	}

	public Node getNode(int indice) {
		for(int i = 0; i < this.listeNode.size(); i++) {
			if(i == indice) {
				return listeNode.get(i);
			}
		}
		return null;
	}
	
	public Node getNodeInXY(int x, int y) {
		for(int i = 0; i < this.listeNode.size(); i++) {
			if(this.listeNode.get(i).getX() == x && this.listeNode.get(i).getY() == y) {
				return listeNode.get(i);
			}
		}
		return null;
	}

}


