package de.aoc.day13;

import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws IOException {
		 Maze maze = new Maze(1352, 45, 45);
		// Maze maze = new Maze(10, 10, 7);
		// maze.walk(1, 1, 7, 4);

		System.out.println("Required Steps: " + maze.run(1, 1, 31, 39));
		System.out.println("Distinct fields after 50 steps:"
				+ maze.getDistinctCount());
	}
}
