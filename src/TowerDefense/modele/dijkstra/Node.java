package TowerDefense.modele.dijkstra;

import java.util.ArrayList;

import TowerDefense.modele.Terrain;

public class Node {
	private Terrain terrain;
	private String name;
	static private int compteur = 0;
	
	private Node voisin1;
	private Node voisin2;
	
	
	public Node(Node voisin1, Node voisin2) {
		this.name = "N"+compteur;
		this.voisin1 = voisin1;
		this.voisin2 = voisin2;
	}
	
	public ArrayList<Node> getVoisins(){
		ArrayList<Node> listeNode = new ArrayList<>();
		for(int i = 0; i < this.terrain.getMap().length; i++) {
			if(terrain.dansChemin(i)) {
				listeNode.add(voisin1);
				listeNode.add(voisin2);
			}
		}
		return listeNode;
	}

	
}
