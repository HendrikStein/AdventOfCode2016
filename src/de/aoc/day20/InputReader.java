package de.aoc.day20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;


public class InputReader {
	private InputReader() {
		// Static Access only
	}

	public static List<Range> readInput(String path)
			throws IOException {
		InputStream is = new FileInputStream(new File(path));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		RangeFactory instructionFactory = new RangeFactory();
		List<Range> instructions = br.lines()
				.map(instructionFactory::toObject).collect(Collectors.toList());
		br.close();
		return instructions;
	}
}
