package de.aoc.day13;

public class Position {
	private int x, y, length;

	public Position(int x, int y, int length) {
		this.x = x;
		this.y = y;
		this.length = length;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getLength() {
		return length;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + ", length=" + length + "]";
	}
}
