package de.aoc.day20;

@FunctionalInterface
public interface IRangeFactory {
	Range toObject(String inst);
}
