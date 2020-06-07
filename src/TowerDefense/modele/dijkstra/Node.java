package TowerDefense.modele.dijkstra;

public class Node {
	private double x;
	private double y;
	private int distance;
	
	public Node(int x, int y, int distance) {
		this.distance = distance;
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
