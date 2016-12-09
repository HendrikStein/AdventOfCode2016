package de.aoc.day8;

import java.io.IOException;
import java.util.List;

public class Runner {
	public static void main(String[] args) throws IOException {
		List<InstructionChain> instructions = InputReader
				.readInput("resource//day8.csv");
	
		Screen screen = new Screen();
		instructions.stream().forEach(chain -> screen.executeInstruction(chain));
		screen.display();
		System.out.println("Pixles to lit: "+screen.countPixlesToLit());
	}
}
