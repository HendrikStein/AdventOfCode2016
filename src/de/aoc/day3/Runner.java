package de.aoc.day3;

import java.io.IOException;
import java.util.List;

public class Runner {
	public static void main(String[] args) throws IOException {
		InputReader parser = new InputReader("resource//day3.csv");
		List<Triangle> triangles = parser.readInput();

		System.out.println("Valid triangles:" + 
		triangles.stream()
			     .filter(triangle -> triangle.isValid()).count());
		
		triangles = parser.readVerticalInput();
		System.out.println("Valid vertical triangles:" + 
		triangles.stream()
			     .filter(triangle -> triangle.isValid()).count());
	}
}
