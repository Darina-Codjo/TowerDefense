package TowerDefense.modele.dijkstra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bfsNode {
	
	private String name;
	static private int compteur = 0;
	private List<bfsNode> cheminLePlusCourt;
	//list calculé a partir du noeud de depart
	private Integer distance;
	//simulation d'une distance infinie entre le noeud de depart et le noeud suivant
	private Map<bfsNode,Integer> nodeAdjacent;
	//			<key, value> 
	//posibilité de le faire avec une matrice d'adjacence mais peut-etre moins adapter pur l'instant 
	
	
	public bfsNode() {
		this.name = "N"+compteur;
		this.cheminLePlusCourt = new LinkedList<bfsNode>();
		this.distance = Integer.MAX_VALUE;
		this.nodeAdjacent = new HashMap<>();
	}
	
	
	
	
	public void ajouterDestination(bfsNode destination, int distance) {
		nodeAdjacent.put(destination, distance);
	}
	
	public Graphe calculBFS(Graphe graph, bfsNode depart) {
		depart.setDistance(0);
		
		Set<bfsNode> nodeDejaVisiter = new HashSet<>();
		Set<bfsNode> nodeAVisiter = new HashSet<>();
		
		nodeAVisiter.add(depart);
		
		while(nodeAVisiter.size() != 0) {
			bfsNode node = PlusPetiteDistanceNode(nodeAVisiter);
			nodeAVisiter.remove(node);
			
			for(Entry<bfsNode,Integer> nodeAdjacent : node.getListeNodeAdjacent().entrySet()) {
				bfsNode estAdjacent = nodeAdjacent.getKey();
				int poids = nodeAdjacent.getValue(); //16 aka distance en pixel
				
				if(!nodeDejaVisiter.contains(nodeAdjacent)) {
					compareDistance((bfsNode) nodeAdjacent, poids, node);
					nodeAVisiter.add(node);
				}
			}
			nodeDejaVisiter.add(node);
		}
		return graph;
	}
	
	private bfsNode PlusPetiteDistanceNode(Set<bfsNode> nodeAVisiter) {
		bfsNode nodeLePlusPres = null;
		int plusPetiteDistance = Integer.MAX_VALUE;
		
		for(bfsNode node : nodeAVisiter) {
			int nodeDistance = node.getDistance();
			if(nodeDistance < plusPetiteDistance) {
				plusPetiteDistance = nodeDistance;
				nodeLePlusPres = node;
			}
		}
		return nodeLePlusPres;
	}
	
	private void compareDistance(bfsNode nodeAComparer, int poids, bfsNode nodeDepart) {
		int distanceAudepart = nodeDepart.getDistance();
		if(distanceAudepart + poids < nodeAComparer.getDistance()) {
			nodeAComparer.setDistance(distanceAudepart + poids);
			LinkedList<bfsNode> cheminCourt = new LinkedList<bfsNode>(nodeDepart.getCheminLePlusCourt());
			cheminCourt.add(nodeDepart);
			nodeAComparer.setCheminLePlusCourt(cheminCourt);
		}
	}
	
	
	
	public String getName() {
		return this.name;
	}
	
	public List<bfsNode> getCheminLePlusCourt() {
		return this.cheminLePlusCourt;
	}
	public void setCheminLePlusCourt(List<bfsNode> cheminLePlusCourt) {
		this.cheminLePlusCourt = cheminLePlusCourt;
	}
	
	public Integer getDistance() {
		return this.distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	public Map<bfsNode, Integer> getListeNodeAdjacent() {
		return this.nodeAdjacent;
	}
	
	public bfsNode getNodeAdjacent(int indice){
		bfsNode node = new bfsNode();
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

