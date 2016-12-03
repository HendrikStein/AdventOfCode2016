package de.aoc.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

	private String path;
	
	public InputReader(String path) {
		this.path = path;
	}

	public List<Triangle> readInput() throws IOException {
		InputStream is = new FileInputStream(new File(this.path));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		TriangleFactory instructionFactory = new TriangleFactory();
		List<Triangle> triangles = br.lines().map(instructionFactory::toObject).collect(Collectors.toList());
		br.close();
		return triangles;
	}

	public List<Triangle> readVerticalInput() throws IOException {
		InputStream is = new FileInputStream(new File(this.path));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		List<Triangle> triangles = new ArrayList<>();
		List<Integer> v1 = new ArrayList<>(), v2 = new ArrayList<>(), v3 = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			String[] vectors = line.trim().split("\\s+");
			v1.add(Integer.parseInt(vectors[0]));
			v2.add(Integer.parseInt(vectors[1]));
			v3.add(Integer.parseInt(vectors[2]));
		}
		br.close();
		TriangleVerticalFactory factory = new TriangleVerticalFactory();
		triangles.addAll(factory.toList(v1));
		triangles.addAll(factory.toList(v2));
		triangles.addAll(factory.toList(v3));
		return triangles;
	}
}
