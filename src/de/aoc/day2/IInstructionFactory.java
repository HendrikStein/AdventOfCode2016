package de.aoc.day2;

@FunctionalInterface
public interface IInstructionFactory {
	InstructionChain toObject(String inst);
}
