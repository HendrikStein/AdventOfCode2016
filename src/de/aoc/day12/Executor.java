package de.aoc.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Executor {
	List<BaseInstruction> instructions = new ArrayList<>();
	Map<String, Integer> register = new HashMap<>();

	public Executor(List<BaseInstruction> instructions) {
		this.instructions = instructions;
	}

	public void exectute() {
		for (int i = 0; i < this.instructions.size(); i++) {
			switch (this.instructions.get(i).getCommand()) {
			case "cpy":
				this.copy((CopyInstruction) this.instructions.get(i));
				break;
			case "inc":
				this.inc((IncDecInstruction) this.instructions.get(i));
				break;
			case "dec":
				this.dec((IncDecInstruction) this.instructions.get(i));
				break;
			case "jnz":
				i = this.jump((JumpInstruction) this.instructions.get(i), i);
			}
		}
	}

	private void copy(CopyInstruction instruction) {
		if (instruction.getCopyFromRegister() != null) {
			int value = 0;
			if (this.register.get(instruction.getCopyFromRegister()) != null) {
				value = this.register.get(instruction.getCopyFromRegister());
			}
			this.register.put(instruction.getTargetRegister(), value);
		} else {
			this.register.put(instruction.getTargetRegister(),
					instruction.getValue());
		}
//		System.out.println(instruction);
//		this.displayRegister();
	}

	private void inc(IncDecInstruction instruction) {
		if (this.register.get(instruction.getTargetRegister()) != null) {
			int value = this.register.get(instruction.getTargetRegister());
			this.register.put(instruction.getTargetRegister(), ++value);
		}
//		System.out.println(instruction);
//		this.displayRegister();
	}

	private void dec(IncDecInstruction instruction) {
		if (this.register.get(instruction.getTargetRegister()) != null) {
			int value = this.register.get(instruction.getTargetRegister());
			this.register.put(instruction.getTargetRegister(), --value);
		}
//		System.out.println(instruction);
//		this.displayRegister();
	}

	private int jump(JumpInstruction instruction, int index) {
		if (this.canJump(instruction)) {
			if (index + instruction.getStep() < this.instructions.size()) {
				return index + -1 + instruction.getStep();
			} else {
				return instructions.size();
			}
		}
		return index;
	}

	private boolean canJump(JumpInstruction instruction) {
		try {
			if (Integer.parseInt(instruction.getRegister()) != 0) {
				return true;
			}
		} catch (NumberFormatException nfe) {
			if (this.register.get(instruction.getRegister()) != null
					&& this.register.get(instruction.getRegister()).intValue() != 0) {
				return true;
			}

		}
		return false;
	}

	public int getValueFor(String register) {
		return this.register.get(register);
	}
	
	public void setRegister(String register, int value){
		this.register.put(register, value);
	}
	
}
