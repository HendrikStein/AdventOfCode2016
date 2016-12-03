package de.aoc.day3;

import java.util.ArrayList;
import java.util.List;

public class TriangleVerticalFactory {

	public List<Triangle> toList(List<Integer> vector) {
		List<Triangle> triangles = new ArrayList<>();
		for (int i = 0; i < vector.size(); i += 3){
			triangles.add(new Triangle(vector.get(i),vector.get(i+1),vector.get(i+2)));
		}
		return triangles;
	}
}
