package de.aoc.day21;

import java.io.IOException;
import java.util.List;

public class Runner {
	public static void main(String args[]) throws IOException {
		Runner runner = new Runner();
		runner.part1();
		runner.part2();
	}
	
	private void part1() throws IOException{
//		String input = "abcde";
		String input = "abcdefgh";
		List<String> instructions = InputReader.readInput("resource//day21.csv");
		Scrambler scrambler = new Scrambler(input, instructions);
		System.out.println("Input: "+input);
		System.out.println("Scrambled String: " + scrambler.scramble());
	}
	
	private void part2() throws IOException{
//		String input = "abcdefgh";
		String input = "fbgdceah";
		List<String> instructions = InputReader.readInput("resource//day21.csv");
		Scrambler scrambler = new Scrambler(input, instructions);
		System.out.println("Input: "+input);
//		System.out.println("Scrambled String: " + scrambler.scramble());
		System.out.println("Unscrambled String: " + scrambler.unscramble());				
	}
}
