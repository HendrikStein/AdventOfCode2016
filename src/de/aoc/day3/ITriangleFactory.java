package de.aoc.day3;

@FunctionalInterface
public interface ITriangleFactory {
	Triangle toObject(String inst);
}
