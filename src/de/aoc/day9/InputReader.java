package de.aoc.day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputReader {
	private InputReader() {
		// Static Access only
	}

	public static String readInput(String path)
			throws IOException {
		InputStream is = new FileInputStream(new File(path));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String input = br.readLine();
		br.close();
		return input;
	}

}
