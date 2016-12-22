package de.aoc.day22;

@FunctionalInterface
public interface IGridEntryFactory {
	GridEntry toObject(String inst);
}
