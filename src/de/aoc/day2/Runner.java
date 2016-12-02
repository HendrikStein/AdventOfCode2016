package de.aoc.day2;

import java.io.IOException;
import java.util.List;

public class Runner {
	public static void main(String[] args) throws IOException {
		List<InstructionChain> instructions = InputReader
				.readInput("resource//day2.csv");
		System.out.println("You need to enter " + instructions.size()
				+ " numbers to enter the bathroom");

		Runner runner = new Runner();

		Character[][] surface = new Character[][] { 
				{ '1', '2', '3' },//
				{ '4', '5', '6' },//
				{ '7', '8', '9' },//
		};
		Keypad keypad = new Keypad(surface, 1, 1);
		System.out.println("Simple Keybord: ");
		runner.typeKeypad(keypad, instructions);

		surface = new Character[][] {
				{ null, null, '1', null, null }, //
				{ null, '2', '3', '4', null },//
				{ '5', '6', '7', '8', '9' },//
				{ null, 'A', 'B', 'C', null },//
				{ null, null, 'D', null, null } //
		};
		
		keypad = new Keypad(surface, 0, 2);
		System.out.println("\nComplex Keybord: ");
		runner.typeKeypad(keypad, instructions);
	}

	public void typeKeypad(Keypad keypad, List<InstructionChain> instructions) {
		for (InstructionChain instructionChain : instructions) {
			System.out.println("Current Pin for iteration: "
					+ keypad.enterInstructionChain(instructionChain));
		}
	}
}
