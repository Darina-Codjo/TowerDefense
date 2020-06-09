package TowerDefense.modele.dijkstra;

public class Node {
	private int x;
	private int y;
	private int distance;
	
	public Node(int x, int y, int distance) {
		this.distance = distance;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDistance() {
		return distance;
	}
	
}
