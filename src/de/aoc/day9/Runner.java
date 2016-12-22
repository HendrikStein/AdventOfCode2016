package de.aoc.day9;

import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws IOException {
		String input = InputReader
				.readInput("resource//day9.csv");
		Uncompress uncompress = new Uncompress();
		uncompress.run(input);
		System.out.println(uncompress.getDecompressedInput());
		System.out.println(uncompress.getDecompressedInput().length());
		
		uncompress = new Uncompress();
		uncompress.run("ADVENT");
		System.out.println(uncompress.getDecompressedInput());
		System.out.println(uncompress.getDecompressedInput().length());

		uncompress = new Uncompress();
		uncompress.run("A(1x5)BC");
		System.out.println(uncompress.getDecompressedInput());
		System.out.println(uncompress.getDecompressedInput().length());

		uncompress = new Uncompress();
		uncompress.run("(3x3)XYZ");
		System.out.println(uncompress.getDecompressedInput());
		System.out.println(uncompress.getDecompressedInput().length());

		uncompress = new Uncompress();
		uncompress.run("A(2x2)BCD(2x2)EFG");
		System.out.println(uncompress.getDecompressedInput());
		System.out.println(uncompress.getDecompressedInput().length());

		uncompress = new Uncompress();
		uncompress.run("(6x1)(1x3)A");
		System.out.println(uncompress.getDecompressedInput());
		System.out.println(uncompress.getDecompressedInput().length());

		uncompress = new Uncompress();
		uncompress.run("X(8x2)(3x3)ABCY");
		System.out.println(uncompress.getDecompressedInput());
		System.out.println(uncompress.getDecompressedInput().length());

	}
}
