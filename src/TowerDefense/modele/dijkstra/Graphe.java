package TowerDefense.modele.dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Graphe {
	
	private Set<Node> listeNodes;
	/*utilisation d'un hashset pour eviter les doublons :
	pour eviter qu'un sommet adjacent soit mit 2 fois dans la liste
	si on print l'ajout le .add renvoie true si il a pu etre ajouter 
	et donc il n'etait pas deja present dans le set, s'il est deja present il renvoie false
	*/
	public Graphe() {
		this.listeNodes = new HashSet<Node>();
	}
	
	public void ajouterNode(Node node) {
		listeNodes.add(node);
	}


	
//	public Set<Node> getNodes() {
//		return nodes;
//	}
//	
//	public void setNodes(Set<Node> nodes) {
//		this.nodes = nodes;
//	}
	

}

