package de.aoc.day3;

public class TriangleFactory implements ITriangleFactory {

	@Override
	public Triangle toObject(String input) {
		String[] sides = input.trim().split("\\s+");
		return new Triangle(Integer.parseInt(sides[0].trim()),
				Integer.parseInt(sides[1].trim()),
				Integer.parseInt(sides[2].trim()));
	}
}
