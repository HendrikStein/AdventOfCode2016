package de.aoc.day1;

public class InstructionFactory implements IInstructionFactory {

	@Override
	public Instruction toObject(String inst) {
		Instruction instruction = null;
		if (inst != null && !inst.isEmpty()) {
			inst = inst.trim();
			Character direction = inst.charAt(0);
			Integer blocks = Integer.valueOf(inst.substring(1, inst.length()));
			instruction = new Instruction(direction, blocks);
		}
		return instruction;
	}
}
