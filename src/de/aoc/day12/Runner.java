package de.aoc.day12;

import java.io.IOException;
import java.util.List;

public class Runner {

	public static void main(String[] args) throws IOException {
		List<BaseInstruction> instructions = InputReader
				.readInput("resource//day12.csv");
		Executor executor = new Executor(instructions);
		executor.exectute();
		System.out.println("Value for Register a is... "
				+ executor.getValueFor("a"));
		
		executor = new Executor(instructions);
		executor.setRegister("c", 1);
		executor.exectute();
		System.out.println("Value for Register a is... "
				+ executor.getValueFor("a"));

	}
}
