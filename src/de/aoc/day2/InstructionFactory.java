package de.aoc.day2;

import java.util.ArrayList;
import java.util.List;

public class InstructionFactory implements IInstructionFactory {

	@Override
	public InstructionChain toObject(String instructionLine) {
		List<Character> instructions = new ArrayList<>();
		for (Character c : instructionLine.toCharArray()) {
			instructions.add(c);
		}
		return new InstructionChain(instructions);
	}
}
