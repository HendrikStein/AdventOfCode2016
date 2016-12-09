package de.aoc.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
	private InputReader() {
		// Static Access only
	}

	public static List<InstructionChain> readInput(String path)
			throws IOException {
		InputStream is = new FileInputStream(new File(path));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		List<InstructionChain> instructions = new ArrayList<>();
		String line;
		InstructionChain chain = null;
		while ((line = br.readLine()) != null) {
			// rect 1x1
			if (line.startsWith("rect")) {
				String[] pnts = line.substring(5, line.length()).split("x");
				chain = new InstructionChain(Integer.parseInt(pnts[0]),
						Integer.parseInt(pnts[1]));
				instructions.add(chain);
				// rotate row y=2 by 24
			} else if (line.startsWith("rotate row y=")) {
				int step = Integer.parseInt(line.substring(
						line.indexOf("by ") + 3, line.length()));
				int rotationEntry = Integer.parseInt(line.substring(
						line.indexOf("=") + 1, line.indexOf("by") - 1));
				chain.addRotationInstruction('x', rotationEntry, step);
				// rotate column x=5 by 1
			} else if (line.startsWith("rotate column x=")) {
				int step = Integer.parseInt(line.substring(
						line.indexOf("by ") + 3, line.length()));
				int rotationEntry = Integer.parseInt(line.substring(
						line.indexOf("=") + 1, line.indexOf("by") - 1));
				chain.addRotationInstruction('y', rotationEntry, step);
			}
		}
		br.close();
		return instructions;
	}

}
