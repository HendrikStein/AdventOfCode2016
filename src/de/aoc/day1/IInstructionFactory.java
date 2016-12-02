package de.aoc.day1;

@FunctionalInterface
public interface IInstructionFactory {
	Instruction toObject(String inst);
}
