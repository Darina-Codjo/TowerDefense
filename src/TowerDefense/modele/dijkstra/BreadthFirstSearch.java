package TowerDefense.modele.dijkstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	private Node nodeDebut;
	private Node nodeFin;
	
	public BreadthFirstSearch(Node debut, Node fin) {
		this.nodeDebut = debut;
		this.nodeFin = fin;
	}
	
	public void construireBFS() {
		Queue<Node> queue = new LinkedList<>();
		ArrayList<Node> explore = new ArrayList<>();
        queue.add(this.nodeDebut);
        explore.add(nodeDebut);
        
        while(!queue.isEmpty()){
            Node current = queue.remove();
//            if(current.equals(this.nodeFin)) {
//                return true;
//            }
//            else {
//                if(current.getChildren().isEmpty())
//                    return false;
//                else
//                    queue.addAll(current.getChildren());
//            }
            explore.add(current);
        }
       // return false;
	}
}
