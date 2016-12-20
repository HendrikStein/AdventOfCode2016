package de.aoc.day16;

import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws IOException {
		Disc disc = new Disc("10010000000110000", 272);
		System.out.println(disc.getChecksum());
		
		disc = new Disc("10010000000110000", 35651584);
		System.out.println(disc.getChecksum());
		
	}

}
