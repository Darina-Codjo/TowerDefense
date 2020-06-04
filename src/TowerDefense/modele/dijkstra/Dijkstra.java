package TowerDefense.modele.dijkstra;

import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import javafx.scene.layout.TilePane;

public class Dijkstra {
	
	private Jeu jeu;
	private Terrain terrain;
	private Graphe graph;
	private Node noeud;
	private TilePane map;
	
	public Dijkstra(Jeu jeu, Terrain terrain, Node noeud, TilePane map) {
		this.jeu = jeu;
		this.terrain = terrain;
		this.noeud = noeud;
		this.map = map;
	}
	
	//this.map.getChildren().add(noeud.ajouterDestination(newNode, 16));
	
	//Graph
	
	//associer chaque tuile du tilePane a un node
	//ajouterNode(ajouter un Node au set) 
	//ajouterDestination(node de destination + int de destance)
//	public void associerNodeTuile() {
//		int comte = 0;
//		for(int i = 0; i < this.terrain.getMap().length; i++) {
//			if(i == terrain.getIndiceTuileChemin()) {
//				Node newNode = new Node();
//				graph.ajouterNode(newNode);
//				comte++;
//				if(terrain.getMap()[i] == terrain.getIndiceTuileDebutChemin()) {
//					noeud.ajouterDestination(newNode, 0);
//				}
//				else {
//					noeud.ajouterDestination(newNode,16);
//				}
//			}
//		}
//		if(comte == terrain.nbrTuileChemin()) {
//			System.out.println("meme nombre");
//		}

//		for(int i = 0; i < terrain.getMap().length; i++) {
//			System.out.println("done1");
//			Node newNode = new Node();
//			graph.ajouterNode(newNode);
//			if(terrain.getMap()[i] == terrain.getIndiceTuileDebutChemin()) {
//				noeud.ajouterDestination(newNode, 0);
//			}
//			else {
//				noeud.ajouterDestination(newNode,16);
//			}
//		}
//
//	}
	
	public Node getNodeDepart() {
		Node nodeDepart = new Node();
		for(int i = 0; i < noeud.getListeNodeAdjacent().size(); i++) {
			if(noeud.getListeNodeAdjacent().containsValue(0)) {
				nodeDepart = noeud.getNodeAdjacent(i);
			}
		}
		return nodeDepart;
	}
	
	//construire le chemin 
	public void chemin() {
		
		Graphe graph = new Graphe();
		graph = noeud.calculBFS(graph, getNodeDepart());
	}
	
	
	//Node
	
	
	//calculBFS(prend un graphe(ensemble de node) + node de depart)
	//pluspetitedistance(Set<node> nodeavisiter) 
	//comparedistance(node a comparer + int poids de chemin + node de depart 
	//...aka point A --> poids --> point B
	
	
	//methode pour set les tuiles de depart
	//add.terrain.indiceTuileDebut
	
	//methode pour set les tuile d'arrivée
	//add.terrain.indiceTuileFin aka destination 
	
	
	
	
	
	
	 
	
	//BFS plus court chemin
	//DFS parcours en profondeur aka arbre
	
	//reccuperer les coordonnes de spawn 
		
	//case de départ = getX/Y de l'ennemi 
	//X --> (terrain.indiceTuileDebutChemin()%30)*16+8,
	//Y --> (terrain.indiceTuileDebutChemin()/30)*16+8,
	
	//distace entre les tuiles = de 16 en 16 pixels les pixel seront au centre de la tuile
	
	//ajouter toute les tuiles/node qui composent le chemin exepter la source aka tuile de départ
	
	//affecter la valeur 0 au noeud A car la distance entre A et A est bien evidement 0
	//Ainsi, chaque nœud du reste du graphique sera distingué par un prédécesseur et une distance
	
	
	
	
	
	
	
	
		
		

		
		
}
