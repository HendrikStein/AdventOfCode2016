package de.aoc.day4;

import java.io.IOException;
import java.util.List;

public class Runner {
	public static void main(String[] args) throws IOException {
		InputReader parser = new InputReader("resource//day4.csv");
		List<Room> rooms = parser.readInput();
		System.out.println("Of the real rooms from the input, the sum of their sector IDs is:"+
				rooms.stream()
					 .filter(room -> room.isValid())
					 .mapToInt(room -> room.getSectorId())
					 .sum());
	}
}
