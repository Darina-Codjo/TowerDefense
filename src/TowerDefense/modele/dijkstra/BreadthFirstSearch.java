package TowerDefense.modele.dijkstra;

import TowerDefense.modele.Terrain;

public class BreadthFirstSearch {
	private Terrain terrain;
	private Node currentNode;
	
	public BreadthFirstSearch(Terrain terrain) {
		this.terrain = terrain;
	}


	public void setDistanceNode() {
		//recuperation coordonnees de la tuile finChemin
		double xFin = (this.terrain.getIndiceTuileFinChemin()%30)*16+8;
		double yFin = (this.terrain.getIndiceTuileFinChemin()/30)*16+8;
		double xDebut = (this.terrain.getIndiceTuileDebutChemin()%30)*16+8;
		double yDebut = (this.terrain.getIndiceTuileDebutChemin()/30)*16+8;
		int indice;
		int distanceArrivee = 0;
		
		//parcourir la liste de node et trouver le nodeFinchemin  (x,y)
		//ici current est le node d'une tuile de fin
		for(int i = 0; i < this.terrain.getListeNode().size(); i++) {
			if(this.terrain.getNode(i).getX() == xFin && this.terrain.getNode(i).getY() == yFin) {
				this.terrain.getNode(i).setDistance(distanceArrivee);
				this.currentNode = this.terrain.getNode(i);
			}
		}
		System.out.println("sortie for 1");
		distanceArrivee++;
		//parcour pour set les distances des node voisin du node de debutChemin
		for(int i = 0; i < this.terrain.getListeNode().size(); i++) {
			if(this.currentNode.getX()-16 == i && this.currentNode.getDistance() == 0) {
				this.terrain.getNode(i).setDistance(distanceArrivee);
			}
			if(this.currentNode.getY()+16 == i && this.currentNode.getDistance() == 0) {
				this.terrain.getNode(i).setDistance(distanceArrivee);
			}
			if(this.currentNode.getY()-16 == i && this.currentNode.getDistance() == 0)
				this.terrain.getNode(i).setDistance(distanceArrivee);
		}
		System.out.println("sortie for 2");
		//parcourir la liste de node et trouver le nodeDebutchemin  (x,y)
		//ici currentNode est le node d'une tuile de depart
		for(int i = 0; i < this.terrain.getListeNode().size(); i++) {
			if(this.terrain.getNode(i).getX() == xDebut && this.terrain.getNode(i).getY() == yDebut) {
				this.currentNode = this.terrain.getNode(i);
			}
		}
		System.out.println("sortie for 3");
		distanceArrivee++;
		int compteurWhile = 0;
		//parcours pour set les distances des node du voisin et des nodes voisins des voisin...
		do {
			for(indice = 0; indice < this.terrain.getListeNode().size(); indice++) {
				if(this.terrain.getNode(indice).getDistance() == distanceArrivee) {
					if(this.currentNode.getX()-16 == indice && this.currentNode.getDistance() == 0) {
						this.terrain.getNode(indice).setDistance(distanceArrivee);
					}
					if(this.currentNode.getY()+16 == indice && this.currentNode.getDistance() == 0) {
						this.terrain.getNode(indice).setDistance(distanceArrivee);
					}
					if(this.currentNode.getY()-16 == indice && this.currentNode.getDistance() == 0)
						this.terrain.getNode(indice).setDistance(distanceArrivee);
				}
				distanceArrivee++;
			}
			compteurWhile++;
			System.out.println(compteurWhile);
		}while(this.currentNode.getDistance() != 0);
		System.out.println("sortie while");
		
	}


//	public Node unVoisinADroite(Node origin, Node suivant){
//		if(origin.getX()+16 == suivant.getX()) {
//			return suivant ; 
//		}
//		return null;
//	}
//	public Node unVoisinAGauche(Node origin, Node suivant) {
//		if(origin.getX()-16 == suivant.getX()) {
//			return suivant;
//		}
//		return null;
//	}
//	public Node unVoisinEnHaut(Node origin, Node suivant){
//		if(origin.getY()+16 == suivant.getY()) {
//			return suivant;
//		}
//		return null;
//	}
//	public Node unVoisinEnBas(Node origine, Node suivant) {
//		if(origine.getY()-16 == suivant.getY()) {
//			return suivant;
//		}
//		return null;
//	}

}
