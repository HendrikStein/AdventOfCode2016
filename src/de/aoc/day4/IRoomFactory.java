package de.aoc.day4;

@FunctionalInterface
public interface IRoomFactory {
	Room toObject(String line);
}
