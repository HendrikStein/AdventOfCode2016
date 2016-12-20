package de.aoc.day12;


public class InstructionFactory implements IInstructionFactory {

	@Override
	public BaseInstruction toObject(String inst) {
		BaseInstruction instruction = null;
		if (inst != null && !inst.isEmpty()) {
			String[] input = inst.split(" ");
			switch (input[0]) {
			case "cpy":
				try {
					instruction = new CopyInstruction(input[0],
							Integer.parseInt(input[1]), input[2]);
				} catch (NumberFormatException nfe) {
					instruction = new CopyInstruction(input[0], input[2],
							input[1]);
				}
				break;
			case "inc":
			case "dec":
				instruction = new IncDecInstruction(input[0], input[1]);
				break;
			case "jnz":
				instruction = new JumpInstruction(input[0], input[1],
						Integer.parseInt(input[2]));
				break;
			}
		}
		System.out.println(instruction.toString());
		return instruction;
	}
}
