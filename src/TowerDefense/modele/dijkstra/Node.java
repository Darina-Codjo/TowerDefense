package TowerDefense.modele.dijkstra;

import java.util.ArrayList;

import TowerDefense.modele.Terrain;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.TilePane;

public class Node {
	private Terrain terrain;
	private double x ;
	private double y ;
	private String name;
	static private int compteur = 0;
	private Node voisinEnHaut;
	private Node voisinADroite;
	private TilePane map;
	
	
	public Node(Node voisin1, Node voisin2, double X, double Y) {
		this.name = "N"+compteur;
		this.voisinEnHaut = voisin1;
		this.voisinADroite = voisin2;
		this.x = X;
		this.y = Y;
	}
	
	//donne le graph : chaque sommet est une tuile
	public ArrayList<Node> getVoisins(){
		ArrayList<Node> listeNode = new ArrayList<>();
		for(int i = 0; i < this.terrain.getMap().length; i++) {
			if(terrain.dansChemin(i)) {
				//recuperation du voisin
				this.voisinADroite = unVoisinADroite(listeNode.get(i-1),listeNode.get(i));
				this.voisinEnHaut = unVoisinAGauche(listeNode.get(i-1),listeNode.get(i));
				//s'il n'est pas deja dans la liste : on l'ajoute
				if(!listeNode.contains(voisinADroite)) {
					listeNode.add(voisinADroite);
				}
				if(!listeNode.contains(voisinEnHaut)) {
					listeNode.add(voisinEnHaut);
				}
			}
		}
		return listeNode;
	}
	
	public Node unVoisinADroite(Node origin, Node suivant){
		if(origin.getX()+16 == suivant.getX()) {
			return this.voisinADroite = suivant ; 
		}
		return null;
	}
	public Node unVoisinAGauche(Node origin, Node suivant){
		if(origin.getY()+16 == suivant.getY()) {
			return this.voisinEnHaut = suivant;
		}
		return null;
	}
	
	public void nodeDebutchemin() {
		int debut = this.terrain.getIndiceTuileDebutChemin();
		
	}
	
	public double getX() {
		return x;
	}	
	public double getY() {
		return y;
	}
	
	public void associerNodeTuile() {
		for(int i = 0; i < this.terrain.getMap().length; i++) {
			if(terrain.dansChemin(i)) {
				
			}
		}
	}
	
	public void getPositionEnXTuileChemin(int indiceTuile) {
		int indiceDebut = terrain.getIndiceTuileDebutChemin();
		int indiceFin = terrain.getIndiceTuileFinChemin();
		int indiceChemin = terrain.getIndiceTuileCheminSansDebutEtFin();
		int indiceChemincomplet = terrain.getIndiceTuileChemin();
		
		for(int i = 0; i < this.map.getChildren().size(); i++) {
			if(i == indiceDebut) {
				this.x = this.map.getChildren().get(i).getTranslateX();
				
			}
		}
		for(int i = 0; i < this.terrain.getMap().length; i++) {
			if(terrain.dansChemin(i)) {
				if(i == indiceDebut) {
					
				}
			}
		}
		
	}
	
	//this.y = this.map.getChildren().get(i).getTranslateY();
	
//	public double getPositionEnXTuile(int indicetuile) {
//		for(int i = 0; i < this.map.getChildren().size(); i++) {
//			if(this.map.getChildren()instanceof tuile)
//		}
//		for(int i = 0; i < this.mapDesert.length; i++) {
//			this.xProperty = mapDesert[i].;
//		}
//	}
//	
//	public double getPositionEnYTuile(int indiceTuile) {
//		
//	}
	
	
//	public void associerNodeTuile() {
//		for(int i = 0; i < this.terrain.getMap().length; i++) {
//			if(terrain.dansChemin(i)) {
//				bfsNode newNode = new bfsNode();
//				graph.ajouterNode(newNode);
//				if(terrain.getMap()[i] == terrain.getIndiceTuileDebutChemin()) {
//					noeud.ajouterDestination(newNode, 0);
//				}
//				else {
//					noeud.ajouterDestination(newNode,16);
//				}
//			}
//		}
//	}
//		
//		terrain.getIndiceTuileDebutChemin();
//		terrain.getIndiceTuileFinChemin();
//	}

	
}
