package de.aoc.day13;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Maze {
	int favoriteNumber;
	String[][] matrix;
	boolean[][] wasHere;
	int steps, distinctPos;
	int endX, endY, width, height, length;

	public Maze(int favoriteNumber, int x, int y) {
		this.favoriteNumber = favoriteNumber;
		this.height = x;
		this.width = y;
		this.matrix = new String[y][x];
		this.wasHere = new boolean[y][x];
		this.init();
		this.print();
	}

	public int getDistinctCount() {
		return this.distinctPos;
	}

	public int run(int startX, int startY, int endX, int endY) {
		Queue<Position> queue = new LinkedBlockingQueue<Position>();
		// Start Position
		Position startPosition = new Position(startX, startY, 0);
//		this.countLoc(startPosition);
		queue.add(startPosition);

		while (queue.peek() != null) {
			Position pos = queue.poll();
			Position newPosition = null;
			if (pos.getLength() <= 50 && !this.hasVisited(pos)) {
				this.distinctPos++;
			}
			// Reached the end
			if (pos.getX() == endX && pos.getY() == endY) {
				return pos.getLength();
			}
			if (pos.getX() != 0) { // Check left edge
				newPosition = new Position(pos.getX() - 1, pos.getY(),
						pos.getLength() + 1);
				if (!this.isWall(newPosition) && !this.hasVisited(newPosition)) {
					queue.add(newPosition);
				}
			}

			if (pos.getX() != this.height - 1) { // Check right edge
				newPosition = new Position(pos.getX() + 1, pos.getY(),
						pos.getLength() + 1);
				if (!this.isWall(newPosition) && !this.hasVisited(newPosition)) {
					queue.add(newPosition);
				}
			}
			if (pos.getY() != 0) {
				newPosition = new Position(pos.getX(), pos.getY() - 1,
						pos.getLength() + 1);
				if (!this.isWall(newPosition) && !this.hasVisited(newPosition)) {
					queue.add(newPosition);
				}
			}
			if (pos.getY() != this.width - 1) { // Check right edge
				newPosition = new Position(pos.getX(), pos.getY() + 1,
						pos.getLength() + 1);
				if (!this.isWall(newPosition) && !this.hasVisited(newPosition)) {
					queue.add(newPosition);
				}
			}
			this.wasHere[pos.getY()][pos.getX()] = true;
		}
		return 0;
	}

	private boolean hasVisited(Position position) {
		return this.wasHere[position.getY()][position.getX()];
	}

	private boolean isWall(Position position) {
		if (this.matrix[position.getY()][position.getX()].equals("#")) {
			return true;
		}
		return false;
	}

	private boolean isSpace(int x, int y) {
		int prod = x * x + 3 * x + 2 * x * y + y + y * y + this.favoriteNumber;
		return Integer.bitCount(prod) % 2 == 0;
	}

	public void print() {
		for (int y = 0; y < this.matrix.length; y++) {
			System.out.println(y + "." + Arrays.toString(this.matrix[y]));
		}
	}

	private void init() {
		for (int y = 0; y < this.matrix.length; y++) {
			for (int x = 0; x < this.matrix[y].length; x++) {
				this.wasHere[y][x] = false;
				if (this.isSpace(x, y)) {
					this.matrix[y][x] = ".";
				} else {
					this.matrix[y][x] = "#";
				}
			}
		}
	}
}
