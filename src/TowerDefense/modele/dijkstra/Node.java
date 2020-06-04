package TowerDefense.modele.dijkstra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Node {
	
	private String name;
	static private int compteur = 0;
	private List<Node> cheminLePlusCourt;
	//list calculé a partir du noeud de depart
	private Integer distance;
	//simulation d'une distance infinie entre le noeud de depart et le noeud suivant
	private Map<Node,Integer> nodeAdjacent;
	//			<key, value> 
	//posibilité de le faire avec une matrice d'adjacence mais peut-etre moins adapter pur l'instant 
	
	
	public Node() {
		this.name = "N"+compteur;
		this.cheminLePlusCourt = new LinkedList<Node>();
		this.distance = Integer.MAX_VALUE;
		this.nodeAdjacent = new HashMap<>();
	}
	
	public void ajouterDestination(Node destination, int distance) {
		nodeAdjacent.put(destination, distance);
	}
	
	public Graphe calculBFS(Graphe graph, Node depart) {
		depart.setDistance(0);
		
		Set<Node> nodeDejaVisiter = new HashSet<>();
		Set<Node> nodeAVisiter = new HashSet<>();
		
		nodeAVisiter.add(depart);
		
		
		while(nodeAVisiter.size() != 0) {
			Node node = PlusPetiteDistanceNode(nodeAVisiter);
			nodeAVisiter.remove(node);
			
			for(Entry<Node,Integer> nodeAdjacent : node.getListeNodeAdjacent().entrySet()) {
				Node estAdjacent = nodeAdjacent.getKey();
				int poids = nodeAdjacent.getValue(); //16 aka distance en pixel
				
				if(!nodeDejaVisiter.contains(nodeAdjacent)) {
					compareDistance((Node) nodeAdjacent, poids, node);
					nodeAVisiter.add(node);
				}
			}
			nodeDejaVisiter.add(node);
		}
		return graph;
	}
	
	private Node PlusPetiteDistanceNode(Set<Node> nodeAVisiter) {
		Node nodeLePlusPres = null;
		int plusPetiteDistance = Integer.MAX_VALUE;
		
		for(Node node : nodeAVisiter) {
			int nodeDistance = node.getDistance();
			if(nodeDistance < plusPetiteDistance) {
				plusPetiteDistance = nodeDistance;
				nodeLePlusPres = node;
			}
		}
		return nodeLePlusPres;
	}
	
	private void compareDistance(Node nodeAComparer, int poids, Node nodeDepart) {
		int distanceAudepart = nodeDepart.getDistance();
		if(distanceAudepart + poids < nodeAComparer.getDistance()) {
			nodeAComparer.setDistance(distanceAudepart + poids);
			LinkedList<Node> cheminCourt = new LinkedList<Node>(nodeDepart.getCheminLePlusCourt());
			cheminCourt.add(nodeDepart);
			nodeAComparer.setCheminLePlusCourt(cheminCourt);
		}
	}
	
	
	
	public String getName() {
		return this.name;
	}
	
	public List<Node> getCheminLePlusCourt() {
		return this.cheminLePlusCourt;
	}
	public void setCheminLePlusCourt(List<Node> cheminLePlusCourt) {
		this.cheminLePlusCourt = cheminLePlusCourt;
	}
	
	public Integer getDistance() {
		return this.distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	public Map<Node, Integer> getListeNodeAdjacent() {
		return this.nodeAdjacent;
	}
	
	public Node getNodeAdjacent(int indice){
		Node node = new Node();
		for(int i = 0; i < nodeAdjacent.size(); i++) {
			 node = getNodeAdjacent(i);
		}
		return node;
	}
	

//	for(Entry<Node,Integer> nodeAdjacent : node.getListeNodeAdjacent().entrySet()) {
//		Node estAdjacent = nodeAdjacent.getKey();

//	public void setNodeAdjacent(Map<Node, Integer> nodeAdjacent) {
//		this.nodeAdjacent = nodeAdjacent;
//	}
}

