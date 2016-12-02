package de.aoc.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputReader {
	private InputReader() {
		// Static Access only
	}

	public static List<Instruction> readInput(String path) throws IOException {
		InputStream is = new FileInputStream(new File(path));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		// There is supposed to be only one line
		Optional<String> input = br.lines().findFirst();
		br.close();
		if (input.isPresent()) {
			return toInstructions(input.get());
		}
		return null;
	}

	private static List<Instruction> toInstructions(String line) {
		Stream<String> instructions = Stream.of(line.split(","));
		InstructionFactory instructionFactory = new InstructionFactory();
		return instructions.map(instructionFactory::toObject).collect(
				Collectors.toList());
	}

}
