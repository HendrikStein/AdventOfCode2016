package de.aoc.day12;

public class JumpInstruction extends BaseInstruction {

	private String register;
	private int step;

	public JumpInstruction(String command, String register, int step) {
		super(command);
		this.register = register;
		this.step = step;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	@Override
	public String toString() {
		return "JumpInstruction [register=" + register + ", step=" + step
				+ ", command=" + command + "]";
	}
}
