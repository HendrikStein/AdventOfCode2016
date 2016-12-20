package de.aoc.day12;

@FunctionalInterface
public interface IInstructionFactory {
	BaseInstruction toObject(String inst);
}
