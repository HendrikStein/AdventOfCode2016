package de.aoc.day1;

import java.io.IOException;
import java.util.List;

public class Runner {

	public static void main(String[] args) throws IOException {
		List<Instruction> instructions = InputReader.readInput("resource//day1.csv");
		Navigator navigator = new Navigator(instructions);
		Point currentPoint = navigator.navigate();
		System.out.println("Your current point is " + currentPoint.toString());
	}
}
