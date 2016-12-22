package de.aoc.day22;

public class GridEntry {
	private Node node;
	int x;
	int y;

	public GridEntry(Node node, int x, int y) {
		this.node = node;
		this.x = x;
		this.y = y;
	}

	public Node getNode() {
		return node;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "GridEntry [node=" + node + ", x=" + x + ", y=" + y + "]";
	}

	
}
